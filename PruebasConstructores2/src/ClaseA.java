import paquete.OtraClase;

public class ClaseA extends OtraClase {
	//private ClaseA() { System.out.print(10); } // al ser private solo se puede llamar dentro de la misma clase
	protected ClaseA() {System.out.print("10 \t");}  //al ser protected puede ser utilazado por una clase "hijo" 
	
}
