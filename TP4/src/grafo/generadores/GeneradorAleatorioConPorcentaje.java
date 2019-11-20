package grafo.generadores;

import java.util.Arrays;
import java.util.Random;

import grafo.Arista;
import grafo.Grafo;

public class GeneradorAleatorioConPorcentaje {
	public static Grafo generar(int cantidadDeNodos, double porcentajeAdy){
		Grafo grafo = new Grafo(cantidadDeNodos);// creo el grafo con su matriz adyacencia
		int maxCantArista = grafo.getMaximaCantidadDeAristasPosibles();
		Random random = new Random();		
		Arista[] aristas = new Arista[maxCantArista];
		
		//completo el vector de aristas con numeros aleatorios, esta tiene la cantidad maxima de aristas (n(n-1)/2)
		for(int fila=0 ;fila<cantidadDeNodos; fila++)
			for(int columna=fila+1; columna<cantidadDeNodos; columna++)
				aristas[(fila*cantidadDeNodos+columna-(int)(fila*fila+3*fila+2)/2)] = new Arista(fila, columna, random.nextInt());//Arista(origen,destino,valor)
		
		Arrays.sort(aristas);//ordeno el vector de aristas
		
		int cantAristasTomar = (int)(porcentajeAdy*maxCantArista/100);// la cantidad de aristas pedidas
		
		//Agrego al grafo algunas aristas
		for(int i=0; i<cantAristasTomar; i++)
			grafo.addArista(aristas[i].getOrigen(),aristas[i].getDestino(),true);
		return grafo;
	}
}
