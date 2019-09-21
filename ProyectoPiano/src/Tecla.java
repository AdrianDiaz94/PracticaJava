
public class Tecla {
	String letra;
	public Tecla(String letra) {
		this.letra=letra;
		
	}
	public int cantidadEntreTeclas(Tecla otra) {
		String []teclas = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
		int posicionTecla1=-1;
		int posicionTecla2=-1;
		String l,p,o;
		for(int i=0; i<teclas.length;i++) {
		
			if(otra.letra.length()==3 && teclas[i].equals(otra.letra.substring(0,1)+"#")) {
				posicionTecla2=i;
			}
			else if(teclas[i].equals(otra.letra.substring(0,1))){
				posicionTecla2=i;
			}
			if(this.letra.length()==3 && teclas[i].equals(this.letra.substring(0,1)+"#")) {
				posicionTecla1=i;
			}
			else if(teclas[i].equals(this.letra.substring(0,1))){
				posicionTecla1=i;
			}
		
			
			
		}
		
		
		int dif=0;
		dif=Math.abs(posicionTecla2-posicionTecla1)+1;
		String n1=this.letra.substring(1, 2);
		String n2=otra.letra.substring(1,2);
		int num1=Integer.parseInt(n1);
		int num2=Integer.parseInt(n2);
		return  dif+(num2-num1)*12;
		
	}
	public boolean puedeTocar (Tecla otra) {
		int cantidad=this.cantidadEntreTeclas(otra);
		if(cantidad<1 || cantidad >8)
			return false;
		return true;
	}
	public void setLetra(String letra) {
		this.letra=letra;
	}
	public String getLetra() {
		return this.letra;
	}
	@Override
	public String toString() {
		return  letra;
	}
	
}
