package coloreo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import grafo.GrafoNDNP;

public  class Coloreo {
	protected int cantNodos;
	protected GrafoNDNP grafo;
	public static final int WHELLSPOWER=2;
	public static final int MATULA=1;
	public static final int ALEATORIO=0;
	// algoritmo=0 aleatorio
			// algoritmo=1 Matula
			// algoritmo=2 Whells power
	
	

	public Coloreo(String pathGrafo) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(pathGrafo));
			sc.useLocale(Locale.ENGLISH);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		int cantNodos = sc.nextInt();
		int cantAristas = sc.nextInt();
		double porcAd = sc.nextDouble();
		int gradoMax = sc.nextInt();
		int gradoMin = sc.nextInt();
		grafo = new GrafoNDNP(cantNodos, gradoMin, gradoMax, cantAristas, porcAd);
		for (int i = 0; i < cantAristas; i++) {
			// completo la matriz de adyacencia
			int origen = sc.nextInt();
			int destino = sc.nextInt();
			grafo.esArista(origen, destino);

		}
		sc.close();
		// agrego los nodos al grafo
		for (int i = 0; i < cantNodos; i++) {
			grafo.agregarNodo(i); // agrego el nodo y se setea el grado del nodo

		}

	}

	public int obtenerCantidadColores(int algoritmo) {
	
		int pintados = 0;
		
		List<Nodo> nodos = grafo.getNodos();
		if (algoritmo == 0)
			OrdenAleatorio.ordernar(nodos);
		else if (algoritmo == 1)
			OrdenMatula.ordernar(nodos);
		else if (algoritmo == 2)
			OrdenWP.ordernar(nodos);
		int color = 0;
		

		while (pintados != grafo.getCantNodos()) {
			color++; // cambio de color
			for (Nodo nodo : nodos) {
				// pinto con un color mientras se pueda
				if (!nodo.estaPintado() && sePuedePintarConColor(nodo,color) ) {
					nodo.setColor(color);
					pintados++;
				}				
			}			
		}
	
		return color;
 
	}
	private boolean sePuedePintarConColor(Nodo nodo ,int color) {
		List<Nodo>adyacentes=grafo.obtenerListaDeAdyacentes(nodo.getId());
		for (Nodo nodo2 : adyacentes) {
			if(nodo2.getColor()== color) {
				return false;
			}
		}		
		return true;
	}

}
