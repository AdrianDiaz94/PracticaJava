
public class Avion extends Transporte {
	protected 	boolean despego;
	public Avion(int cantidad) {
		super("Avion",cantidad);
		this.despego=false;
	}
	
	public boolean despegar() {
		if(this.moviendo==false) {
			System.out.println("Se necesita moverse para poder despegar el Avion");
			return false;
		}

		System.out.println("El avion despego");
		this.despego=true;
		return true;
		
	}
	public boolean aterrizar() {
		if(this.despego==false) {
			System.out.println("No se puede aterrizar porque no se despego");
			return false;
		}
		System.out.println("EL avion aterrizo");
		this.despego=false;
		return true;
	}
}
