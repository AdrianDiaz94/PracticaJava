package grafo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Grafo {

	private MatrizSimetrica distancias;
	
	public Grafo(int cantidadNodos) {
		distancias = new MatrizSimetrica(cantidadNodos);
	}

	public void addArista(int nodo1, int nodo2, boolean valor) {
		distancias.setValor(nodo1, nodo2, valor);
	}

	@Override
	public String toString() {
		return "Grafo [distancias=" + distancias + "]";
	}

	public int getMaximaCantidadDeAristasPosibles() {
		return distancias.getSize();
	}

	public boolean getDistancia(int i, int j) {
		return distancias.getValor(i, j);
	}
	
	public int getCantidadDeNodos(){
		return distancias.getOrdenMatriz();
	}
	
	public int getCantidadDeAristas(){
		int cantAristas=0;
		int cantidadDeNodos = getCantidadDeNodos();
		for(int i=0; i<cantidadDeNodos; i++)
			for(int j= i+1; j < cantidadDeNodos; j++)
				if(getDistancia(i, j))
				cantAristas++;	
		return cantAristas;
	}
	
	public int getGradoMin() {
		int gradoMin=Integer.MAX_VALUE;
		int cantidadDeNodos = getCantidadDeNodos();
		
		for (int i = 0; i < cantidadDeNodos; i++) {
			int g=0;
			for(int j = 0; j < cantidadDeNodos; j++)
				if(i!=j && getDistancia(i,j))
					g++;
			if(g<gradoMin)
				gradoMin = g;
		}
		
		return gradoMin;
	}

	public int getGradoMax() {
		int gradoMax=0;
		int cantidadDeNodos = getCantidadDeNodos();
		
		for (int i = 0; i < cantidadDeNodos; i++) {
			int g=0;
			for(int j = 0; j < cantidadDeNodos; j++)
				if(i!= j && getDistancia(i,j))
					g++;
			if(g>gradoMax)
				gradoMax = g;
		}
		
		return gradoMax;
	}

	public void escribirComoEntrada(String path) throws IOException {
		FileWriter archivo = new FileWriter(path);
		PrintWriter fichero = new PrintWriter(archivo);
		int cantidadDeAristas = getCantidadDeAristas() ;
		fichero.println(getCantidadDeNodos() + " " + cantidadDeAristas + " " + (double)cantidadDeAristas/getMaximaCantidadDeAristasPosibles() + " " + getGradoMax() + " " + getGradoMin());
		for (int i = 0; i < getCantidadDeNodos(); i++)
			for (int j = i; j < getCantidadDeNodos(); j++)
				if (i != j && getDistancia(i, j) == true)
					fichero.println(i + " " + j);					
		archivo.close();
	}

	
}
