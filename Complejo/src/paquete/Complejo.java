package paquete;



public class Complejo implements Comparable <Complejo> {
	private double entero;
	 private double imaginario;
	 //constructor defecto
	 public Complejo() {
		 this.entero=0.0;
		 this.imaginario=0.0;
		 	 
	 }
	 //constructor parametrizado
	public Complejo(double entero, double imaginario) {
		 this.entero=entero;
		 this.imaginario=imaginario;
		 
	 }
	//Metodos
	public Complejo suma(Complejo obj) {
		return new Complejo(entero+obj.entero,imaginario+obj.imaginario);
	}
	public static Complejo suma(Complejo obj1 , Complejo obj2) {
		return new Complejo(obj1.entero+obj2.entero,obj1.imaginario+obj2.imaginario);
	}
	
	public Object clone() {
		return new Complejo (this.entero, this.imaginario);
	}
	
	
	@Override
	public String toString() {
		return "Complejo [entero=" + entero + ", imaginario=" + imaginario + "]";
	}
	@Override
	public int compareTo(Complejo c) {
		if (entero > c.entero)
			return 1 ;
		else if (entero < c.entero)
			 return -1;
		else if ( imaginario > c.imaginario)
			return 1;
		else if (imaginario < c.imaginario)
			return -1;
		else
			return 0;
	}
	public Complejo modulo() {
		double modEntero;
		double modImaginario;
		modEntero=entero;
		modImaginario=imaginario;
		if(modEntero < 0)
			modEntero=modEntero*(-1);
		if(modImaginario < 0)
			modImaginario=modImaginario*(-1);			
			
		 return new Complejo (modEntero,modImaginario);
	}
}
