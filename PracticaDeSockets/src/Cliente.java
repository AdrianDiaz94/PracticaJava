

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

import com.google.gson.Gson;


public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		}	
	
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente(){
		nick=new JTextField(5);
		JLabel texto=new JLabel("CHAT");
		
		add(nick);
		add(texto);
		ip=new JTextField(8);
		add(ip);
		campoChat=new JTextArea(12,23);
		add(campoChat);
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		EnviaTexto  miEvento=new EnviaTexto();
		miboton.addActionListener(miEvento);
		add(miboton);	
		Thread hilo=new Thread (this);
		hilo.start();
		
	}
	
	private class  EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(campo1.getText());
			campoChat.append("\n"+"yo: "+campo1.getText());
			try {
				//creo el socket con conexion con el servidor
				Socket miSocket=new Socket("192.168.0.55",9999);
				
				//Armo un objeto con los datos a enviar
				PaqueteEnvio datos=new PaqueteEnvio();
				datos.setIp(ip.getText());
				datos.setNick(nick.getText());
				datos.setMensaje(campo1.getText());
				Gson gson=new Gson();
				String miMensaje=gson.toJson(datos);
				
				//enviar un mensaje a traves del socket
					DataOutputStream flujoSalida=new DataOutputStream(miSocket.getOutputStream());  //indica por donde va a circular los datos
				
				flujoSalida.writeUTF(miMensaje);//envia lo que tenga el campo1
				flujoSalida.close();
				 
		
				miSocket.close();
				
			} catch (UnknownHostException e1) {
				// TODO Bloque catch generado automáticamente
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Bloque catch generado automáticamente
				System.out.println(e1.getMessage());
			}
			
			
		}
		
	}
	
		
		
		
	private JTextField campo1,nick,ip;
	private JTextArea campoChat;
	private JButton miboton;
	@Override
	public void run() {
		// se pone a la escucha el cliente
	try {
		ServerSocket servidorCliente= new ServerSocket(9090);
		Socket cliente;
		PaqueteEnvio paqueteRecibido;
		while(true) {
		cliente=servidorCliente.accept();
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
		DataOutputStream flujoSalida=new DataOutputStream(cliente.getOutputStream());
		flujoEntrada.readUTF();
		Thread.sleep(5000);
		flujoSalida.writeUTF("dd");
		
		Gson gson= new Gson();
		
		String mensajeRecibido=flujoEntrada.readUTF();
		paqueteRecibido=gson.fromJson(mensajeRecibido, PaqueteEnvio.class);
		campoChat.append("\n"+paqueteRecibido.getNick()+" dice: "+ paqueteRecibido.getMensaje() );
		cliente.close();
		
		}
		
	} catch (IOException | InterruptedException e) {
		// TODO Bloque catch generado automáticamente
		System.out.println(e.getMessage());
	}
		
	}
	
	
}

class PaqueteEnvio{
	private String nick,ip,mensaje;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}