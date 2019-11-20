
public class Arista {
	private Nodo origen;
	private Nodo destino;
	private int costo;
	
	public Arista(Nodo origen,Nodo destino,int costo) {
		this.origen=origen;
		this.destino=destino;
		this.costo=costo;
	}

	public Nodo getOrigen() {
		return origen;
	}

	public void setOrigen(Nodo origen) {
		this.origen = origen;
	}

	public Nodo getDestino() {
		return destino;
	}

	public void setDestino(Nodo destino) {
		this.destino = destino;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	
	
}
