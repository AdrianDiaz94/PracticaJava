

public class Jugador {
//	@SerializedName("nombre")
	String nombre;
	//@SerializedName("puntos")
	int puntos;
//	@SerializedName("posicionX")
	int posicionX;
	//@SerializedName("posicionY")
	int posicionY;
	
	@Override
	public String toString() {
		return "el nombre es: "+this.nombre+" con posicionX e Y : "+ this.posicionX+" "+this.posicionY+ " y "+this.puntos+" puntos";
	}

	public Jugador(String nombre,int puntos,int posicionX,int posicionY) {
		this.puntos=puntos;
		this.posicionX=posicionX;
		this.posicionY=posicionY;
		this.nombre=nombre;
	}

}
