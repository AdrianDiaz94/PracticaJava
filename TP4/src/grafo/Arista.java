package grafo;

public class Arista implements Comparable<Arista> {

	private int origen;
	private int destino;
	private int valor;
	
	public Arista(int origen, int destino, int valor) {
		this.origen = origen;
		this.destino = destino;
		this.valor = valor;
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}

	@Override
	public int compareTo(Arista o) {
		return valor > o.valor ? 1 : valor == o.valor ? 0 : -1;
	}

}
