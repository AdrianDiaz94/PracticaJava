
public class Nodo {
	private int numero;
	private int caminosEntrantes;
	private int adyacentesentrantes;
	
	public Nodo(int numero) {
		this.numero=numero;
		this.caminosEntrantes=0;
		this.adyacentesentrantes=0;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCaminosEntrantes() {
		return caminosEntrantes;
	}
	public void setCaminosEntrantes(int caminosEntrantes) {
		this.caminosEntrantes+= caminosEntrantes;
	}

	public int getAdyacentesentrantes() {
		return adyacentesentrantes;
	}

	public void setAdyacentesentrantes(int adyacentesentrantes) {
		this.adyacentesentrantes += adyacentesentrantes;
	}
	
	
}
