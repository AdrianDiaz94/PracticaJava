import paquete.OtraClase;

public class PruebasConstructores2 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		System.out.println("Pruebas 2");
		//ClaseC o = new ClaseC(1);
		//ClaseB o2 = new ClaseC(1);
		//ClaseB o2 = new ClaseC(); // no es valido porque al hacer un constructor parametrizado se pierde el por defecto 
		                          // para que funcione se debe crear un constructor sin parametros
		ClaseA o3 = new ClaseA(); // no es valido porque el constructor es private, por lo que solo se puede usar en la misma clase
		 						// si es protected pueder ser utilizado en el main si esta en el mismo paquete 
								//si el constructor fuese publico podria construir un objeto ClaseA
	 
	  	
	}

}
