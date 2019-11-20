
import javax.swing.*;

import com.google.gson.Gson;

import java.awt.*;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoServidor mimarco = new MarcoServidor();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class MarcoServidor extends JFrame implements Runnable {

	public MarcoServidor() {

		setBounds(500, 300, 280, 350);

		JPanel milamina = new JPanel();

		milamina.setLayout(new BorderLayout());

		areatexto = new JTextArea();

		milamina.add(areatexto, BorderLayout.CENTER);

		add(milamina);

		setVisible(true);
		Thread miHilo = new Thread(this);
		miHilo.start();

	}

	@Override
	public void run() {

		try {
			ServerSocket servidor = new ServerSocket(9999);
			String nick, ip, mensaje;
			while (true) {
				Socket miSocket = servidor.accept(); // cuando le lleguen conexiones al servidor se crea un socket

				DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream()); // se le indica por donde
																								// ingresa los msj
				// leo
				String textoRecibido = flujoEntrada.readUTF();
				// paso de un Json a un PaqueteEnvio
				Gson gson = new Gson();
				PaqueteEnvio datos = gson.fromJson(textoRecibido, PaqueteEnvio.class);
				//

				nick = datos.getNick();
				mensaje = datos.getMensaje();
				ip = datos.getIp();

				// escribe en el area de texto
				areatexto.append("\n" +nick+": "+mensaje+" para "+ip);
				//para reenviar la info
				
				Socket enviaDestinatario=new Socket(ip,9090);
				
				// le aviso que le envio algo 
				DataOutputStream flujoSalida= new DataOutputStream(enviaDestinatario.getOutputStream());
				DataInputStream flujoConfirmacion= new DataInputStream(enviaDestinatario.getInputStream());
				flujoSalida.writeUTF("te mande msj");
				
				flujoConfirmacion.readUTF();
				
				flujoSalida.writeUTF(textoRecibido);
				flujoSalida.close();
				enviaDestinatario.close();
				miSocket.close();
			}
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

	private JTextArea areatexto;
}
