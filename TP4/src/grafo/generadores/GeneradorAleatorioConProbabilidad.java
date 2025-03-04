package grafo.generadores;

import java.util.Random;
import grafo.Grafo;

public class GeneradorAleatorioConProbabilidad {
	public static Grafo generar(int cantidadNodos, double probabilidad){
		Random random = new Random();// numero random
		Grafo grafo = new Grafo(cantidadNodos);
		for(int nodoOrigen=0 ; nodoOrigen< cantidadNodos; nodoOrigen++)
			for(int nodoDestino=nodoOrigen+1; nodoDestino<cantidadNodos; nodoDestino++)
				grafo.addArista(nodoOrigen, nodoDestino, (100 * random.nextDouble()) < probabilidad);
		return grafo;
	}
}
