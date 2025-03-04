package grafo;

import java.util.Arrays;

public class MatrizSimetrica {
	private boolean[] vec;
	
	public MatrizSimetrica(final int cantNodos){
		this.vec = new boolean[ordenMatriz(cantNodos)];
	}

	public boolean getValor(int fila, int columna){
		if(fila == columna)
			throw new ExceptionMatrizSimetrica("No se admite ciclos");
		
		if(fila > columna){
			int aux = fila;
			fila = columna;
			columna = aux;
		}	
		return this.vec[convertir2Da1D(fila, columna)];
	}
	
	public void setValor(int fila, int columna, boolean valor){
		if(fila == columna)
			throw new ExceptionMatrizSimetrica("No se admite ciclos");
		
		if(fila > columna){
			int aux = fila;
			fila = columna;
			columna = aux;
		}
		
		this.vec[convertir2Da1D(fila, columna)] = valor;
	}
	
	private int convertir2Da1D(int fila, int columna) {
		return (fila*getOrdenMatriz()+columna-(int)(fila*fila+3*fila+2)/2);
	}
	
	public int getOrdenMatriz() {
		return (int)(1+Math.sqrt((1+8*vec.length))/2);
	}

	private static int ordenMatriz(final int cantNodos) {
		return cantNodos*(cantNodos-1)/2;
	}

	@Override
	public String toString() {
		return "MatrizSimetrica [vec=" + Arrays.toString(vec) + "]";
	}

	public int getSize() {
		return vec.length;
	}
	
	
}
