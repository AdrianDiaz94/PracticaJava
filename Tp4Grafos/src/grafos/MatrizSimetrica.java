package grafos;

public class MatrizSimetrica {

	protected int vector[];
	protected int nodos;
	protected int aristasMax;
	
	public MatrizSimetrica(int nodos) {
		this.nodos = nodos;
		this.aristasMax = ((int)Math.pow(nodos, 2) - nodos ) / 2;;
		this.vector = new int[aristasMax];
	}
		
	public void setMatrizS(int fila, int columna, int costo) {
		this.vector[getIndice(fila, columna)] = costo;
	}
	// antes se llamaba setArista
	public void esArista(int fila , int columna) {
		this.vector[getIndice(fila, columna)]=1;	
	}
	public int getValor(int fila, int columna) {
		return this.vector[getIndice(fila, columna)];
	}
	
	public boolean getEnlace(int fila, int columna) {
		return this.vector[getIndice(fila, columna)]!=0;
	}
	
	
	public int getIndice(int fila, int columna) {
		
		int aux;
		//si la fila es mayor que la columna intercambio los valores
		if(fila > columna) {
			aux = fila;
			fila=columna;
			columna=aux;
		}
		
		return fila*this.nodos + columna - ( (int)Math.pow(fila, 2)+ 3*fila +2 )/2;
	}
	
	
	public int getAristasMax() {
		return this.aristasMax;
	}
	
	public int getValorIndiceVector(int i) {
		return this.vector[i];
	}
	
	public int getCantNodos() {
		return this.nodos;
	}

	public void ponderarArista(int fila, int columna) {
		this.vector[getIndice(fila, columna)] = 1;
	}
}