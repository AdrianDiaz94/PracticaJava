
public class Tecla{
	private String tipo;
	private int posicionEnTeclado;
	private int numero;
	private String letra;
	private String nota;
	private int posicionHastaDondeSepuedeTocar;

	public Tecla(String nota) {
		this.asignarValores(nota);		
	}
	
	private void asignarValores(String nota) {
		this.nota=nota;
		this.numero=Integer.parseInt(nota.substring(1,2));
		this.letra=nota.substring(0, 1);
		if(nota.length()==3)
			this.tipo="negra";
		else 
			this.tipo="blanca";
		this.posicionEnTeclado=calcularPosicionTeclado(this.letra, this.numero,this.tipo);
		this.posicionHastaDondeSepuedeTocar=calcularPosicionHastaDondeSePuedeTocar(this.posicionEnTeclado, this.letra,this.tipo);
		
	}
	

	
	private int calcularPosicionTeclado(String letra, int numero, String tipo) {
		int posicionTecla=-1;
		String [] teclas= {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
						//  0   1    2   3    4   5   6    7   8    9   10   11
		int i=0;
		if(tipo.equals("blanca")) {
			
				while(posicionTecla==-1) {
					if(teclas[i].equals(letra))
						posicionTecla=i;
					i++;
				}
			
		}
		else {
			
				while(posicionTecla==-1) {
					if(teclas[i].equals(letra+"#"))
						posicionTecla=i;
					i++;
				}
			
		}
		posicionTecla=posicionTecla+(numero-1)*12;
		return posicionTecla;
	}
	
	private int calcularPosicionHastaDondeSePuedeTocar(int posicionEnTeclado,String letra,String tipo) {
		if(tipo.equals("negra"))
			return 0;
		int posicionMaxima=posicionEnTeclado;
	  //"C","C#","D","D#","E","F","F#","G","G#","A","A#","B",
	 //  0   1    2   3    4   5   6    7   8    9   10   11
	 // "C","C#","D","D#","E","F","F#","G","G#","A","A#"};
	//  12	13	14    15  16  17   18   19  20   21  22
		
		if(letra.equals("C") ||letra.equals("D") || letra.equals("E") || letra.equals("F") || letra.equals("G")) {
			posicionMaxima+=7;
		}
		else if(letra.equals("A")) {
			posicionMaxima+=8;
		}
		else{
			posicionMaxima+=6;
		}
		if(posicionMaxima>95) {
			posicionMaxima=95;
		}
		return posicionMaxima;
	}
	
	
	public boolean puedeTocar(Tecla tecla2) {
		if(tecla2.posicionEnTeclado>=this.posicionEnTeclado && tecla2.posicionEnTeclado <=this.posicionHastaDondeSepuedeTocar) {
			return true;
		}
		return false;
	}
	
	public String notaBlancaAnterior() {
		  //"C","C#","D","D#","E","F","F#","G","G#","A","A#","B",
		 //  0   1    2   3    4   5   6    7   8    9   10   11
		 return this.letra+this.numero;
		
	}
	
	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.asignarValores(nota);
	}
	
	public String getTipo() {
		return this.tipo;
	}

}