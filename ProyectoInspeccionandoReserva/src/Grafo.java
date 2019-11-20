import java.util.ArrayList;
import java.util.List;

public class Grafo {
	int [][] matrizAdyacencia;
	List<Nodo> nodos;
	List<Arista> aristas;
	private int valorInfinito;
	
	public Grafo(int cantidadNodo,int valorinfinito) {
		this.matrizAdyacencia= new int[cantidadNodo][cantidadNodo];
		this.valorInfinito= valorinfinito;
		this.nodos = new ArrayList<Nodo>();
		this.aristas = new ArrayList<Arista>();
	}
	public int getCantEntrantes(Nodo n1) {
		int entrantes=0;
		for(int i=0;i<cantidadNodos();i++) {
			if(this.matrizAdyacencia[i][n1.getNumero()]!=0)
				entrantes++;
		}
		return entrantes;
	}
	public int sumarCaminosEntrantes(Nodo n1) {
		int suma=0;
		for(int i=0;i<cantidadNodos();i++) {
			if(this.matrizAdyacencia[i][n1.getNumero()]!=0)
				suma+=nodos.get(i).getCaminosEntrantes();
		}
		return suma;
	}
	
	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public void addNodos(Nodo nodo) {
		nodos.add(nodo);
	}

	public boolean getAristas(Nodo nodo1, Nodo nodo2) {
		return this.matrizAdyacencia[nodo1.getNumero()][nodo2.getNumero()]!=0;
	}

	public void addAristas(Arista arista){
		matrizAdyacencia[arista.getOrigen().getNumero()][arista.getDestino().getNumero()]=arista.getCosto();
		aristas.add(arista);
	}

	public int getValorInfinito() {
		return valorInfinito;
	}
	
	public int cantidadNodos() {
		return nodos.size();
	}

}
