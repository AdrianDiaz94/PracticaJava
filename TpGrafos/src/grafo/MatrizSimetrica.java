package grafo;

public class MatrizSimetrica {

	protected int vector[];
	protected int cantNodos;
	protected int aristasMax;
	
	public MatrizSimetrica(int cantNodos) {
		this.cantNodos = cantNodos;
		this.aristasMax = ((int)Math.pow(cantNodos, 2) - cantNodos ) / 2;;
		this.vector = new int[aristasMax];
	}
		
	public void setMatrizS(int fila, int columna, int costo) {
		this.vector[calcularIndice(fila, columna)] = costo;
	}
	
	public void esArista(int fila , int columna) {
		this.vector[calcularIndice(fila, columna)]=1;	
	}
	public int getValor(int fila, int columna) {
		return this.vector[calcularIndice(fila, columna)];
	}
	
	public boolean esAdyacente(int fila, int columna) {
		if(fila==columna)
			return false;
		return this.vector[calcularIndice(fila, columna)]!=0;
	}
	public int determinarGrado(int nodo) {
		int grado=0;
		
	
			for(int i=0; i<cantNodos;i++) {
			if(i!=nodo && vector[calcularIndice(nodo, i)]==1) {
				grado++;
			}
			}
		
		return grado;
	}
	
	private int calcularIndice(int fila, int columna) {
		
		int aux;
		//si la fila es mayor que la columna intercambio los valores
		if(fila > columna) {
			aux = fila;
			fila=columna;
			columna=aux;
		}
		
		return fila*this.cantNodos + columna - ( (int)Math.pow(fila, 2)+ 3*fila +2 )/2;
	}
	
	
	public int getAristasMax() {
		return this.aristasMax;
	}
	
	public int getValorIndiceVector(int i) {
		return this.vector[i];
	}
	
	public int getCantNodos() {
		return this.cantNodos;
	}

	public void ponderarArista(int fila, int columna) {
		this.vector[calcularIndice(fila, columna)] = 1;
	}
}
