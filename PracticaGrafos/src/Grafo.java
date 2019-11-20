import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.management.Query;

public class Grafo {
	private int cantidadNodos;
	private int[][] matrizAdyacencia;

	public Grafo(String path) {
		try {
			Scanner sc = new Scanner(new File(path));
			this.cantidadNodos = sc.nextInt();
			matrizAdyacencia = new int[this.cantidadNodos][this.cantidadNodos];
			int cantidadAristas = sc.nextInt();
			for (int i = 0; i < this.cantidadNodos; i++) {
				for (int j = 0; j < this.cantidadNodos; j++)
					matrizAdyacencia[i][j] = Integer.MAX_VALUE;
			}

			for (int i = 0; i < cantidadAristas; i++) {
				int fila = sc.nextInt();
				int columna = sc.nextInt();
				int costo = sc.nextInt();

				matrizAdyacencia[fila][columna] = costo;
				// matrizAdyacencia[columna][fila]=1;
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public boolean esadyacenteNoVisitado(int nodoOrigen, int nodoDestino, int[] nodosVisitados) {

		if (matrizAdyacencia[nodoOrigen][nodoDestino] == 1 && nodosVisitados[nodoDestino] == 0)
			return true;

		return false;

	}

	public int obtenerAdyacenteNoVisitado(int nodo, int[] nodosVisitados) {
		int i = 0;
		int adyacente = -1;
		boolean resp = false;
		while (i < this.cantidadNodos && !resp) {
			resp = esadyacenteNoVisitado(nodo, i, nodosVisitados);
			i++;
		}
		if (resp)
			adyacente = i - 1;
		else
			adyacente = -1;
		return adyacente;
	}

	public boolean hayNodosNoVisitados(int[] nodosVisitados) {
		int i = 0;
		while (i < this.cantidadNodos) {
			if (nodosVisitados[i] == 0) {
				return true;
			}
			i++;
		}
		return false;
	}

	public int proximoNoVisitado(int[] nodosVisitados) {
		int i = 0;
		while (i < this.cantidadNodos && nodosVisitados[i] == 1) {
			i++;
		}
		return i;
	}

	public int contarAdyacentes(int nodo) {
		int cant = 0;
		for (int i = 0; i < this.cantidadNodos; i++) {
			if (this.matrizAdyacencia[nodo][i] == 1)
				cant++;

		}
		return cant;

	}

	public void algoritmoDfs() {
		int cantidadCamino = 0;
		int[] nodosVisitados = new int[this.cantidadNodos];
		Stack<Integer> pila = new Stack<Integer>();
		List<Integer> nodos = new ArrayList<Integer>();
		int primero = proximoNoVisitado(nodosVisitados);
		pila.push(primero);
		System.out.println(primero + 1);
		nodosVisitados[primero] = 1;
		nodos.add(primero);
		while (hayNodosNoVisitados(nodosVisitados)) {
			int nodo;
			if (!pila.isEmpty()) { // si no esta vacia
				nodo = obtenerAdyacenteNoVisitado(pila.lastElement(), nodosVisitados);
				if (nodo != -1) {
					System.out.println(nodo + 1);
					pila.push(nodo);
					nodos.add(nodo);
				} else {
					int salio = pila.pop();
					System.out.println(salio + 1);
					cantidadCamino++;
					if (obtenerAdyacenteNoVisitado(salio, nodosVisitados) == -1) {
						int cantidadAd = contarAdyacentes(salio);
						// cantidadCamino+=cantidadAd;

					}

				}
			} else { // si esta vacia
				nodo = proximoNoVisitado(nodosVisitados);
			}
			if (nodo != -1)
				nodosVisitados[nodo] = 1;

		}
		// System.out.println(cantidadCamino);
	}

	public void algoritmoBfs() {
		int[] nodosVisitados = new int[this.cantidadNodos];
		int[] distancia = new int[this.cantidadNodos];
		int primero = proximoNoVisitado(nodosVisitados);
		Queue<Integer> cola = new LinkedList<Integer>();
		cola.add(primero);
		distancia[primero] = 0;

		while (!cola.isEmpty()) {
			int nodo = cola.poll();
			// System.out.println(nodo);
			agregarAdyacentesCola(cola, nodo, nodosVisitados, distancia);
		}
		int i = 0;
		for (Integer integer : distancia) {
			System.out.println("d[" + i + "]=" + integer);
			i++;
		}

	}

	private void agregarAdyacentesCola(Queue<Integer> cola, int nodo, int[] nodosVisitados, int[] distancia) {
		int num = 0;
		nodosVisitados[nodo] = 1;
		while (num != -1) {
			num = obtenerAdyacenteNoVisitado(nodo, nodosVisitados);
			if (num != -1) {
				nodosVisitados[num] = 1;
				cola.add(num);
				distancia[num] = distancia[nodo] + 1;
			}
		}
	}

	public void dijkstra(int inicio) {
		List<Integer> s = new ArrayList<Integer>();
		s.add(inicio);
		Nodo w;
		List<Integer> vMenosS = new ArrayList<Integer>();

		PriorityQueue<Nodo> d = new PriorityQueue<Nodo>();
		int i = 0;
		while (i < this.cantidadNodos) {
			if (inicio != i)
				vMenosS.add(i);
			d.add(new Nodo(i, this.matrizAdyacencia[inicio][i]));
			i++;

		}
		while (!vMenosS.isEmpty()) {
			w = d.poll();
			System.out.println(w);
			int index = vMenosS.indexOf(w.nodo);
			vMenosS.remove(index);
			s.add(w.nodo);
			for (Nodo dj : d) {
				dj.costo = costoMenor(dj.costo, w.costo, this.matrizAdyacencia[w.nodo][dj.nodo]);
			}
		}

	}

	private int costoMenor(int costo1, int costo2, int costoWJ) {
		if (costoWJ == Integer.MAX_VALUE)
			return costo1;
		if (costo2 == Integer.MAX_VALUE)
			return costo1;
		if (costo1 < costo2 + costoWJ)
			return costo1;
		else
			return costo2 + costoWJ;
	}

	public void floyd() {
		int F[][] = this.matrizAdyacencia;
		for (int i = 0; i < this.cantidadNodos; i++) {
			F[i][i] = 0;
		}
		for (int k = 0; k < this.cantidadNodos; k++) {

			for (int i = 0; i < this.cantidadNodos; i++) {
				for (int j = i+1; j < this.cantidadNodos; j++) {
					F[i][j] = costoMenor(F[i][j], F[i][k], F[k][j]);
					F[j][i] = costoMenor(F[j][i], F[j][k], F[k][i]);
				}
			}

		}

		for (int i = 0; i < this.cantidadNodos; i++) {
			for (int j = 0; j < this.cantidadNodos; j++) {
				System.out.print(F[i][j]+"\t");
			}
			System.out.println();

		}

	}
	public void algoritmoPrim(int nodo) {
		List<Nodo> s= new ArrayList<Nodo>();
		List<Nodo> nMenosS= new ArrayList<Nodo>();
		s.add(new Nodo(nodo));
		int costo=0;
		for(int i=0;i<this.cantidadNodos;i++) {
			if(nodo!=i)
				nMenosS.add(new Nodo(i));
		}
		while(!nMenosS.isEmpty()) {
			Nodo [] nuevo=buscarNodoConMenorCosto(s,nMenosS);
			// nuevo[0]= origen
			//nuevo[1]=destino
			costo+=this.matrizAdyacencia[nuevo[0].getNodo()][nuevo[1].getNodo()];
			s.add(nuevo[1]);
			nMenosS.remove(nuevo[1]);
		}
		System.out.println(costo);
	}
public Nodo[] buscarNodoConMenorCosto(List<Nodo>s, List<Nodo> nMenosS) {
	Nodo [] resp= new Nodo[2];
	resp[0]= new Nodo(Integer.MAX_VALUE);
	resp[1]= new Nodo(Integer.MAX_VALUE);
	int costoMenor=Integer.MAX_VALUE;
	for (Nodo origen : s) {
		for (Nodo destino: nMenosS) {
			int costo=this.matrizAdyacencia[origen.getNodo()][destino.getNodo()];
			if(costo<costoMenor) {
				resp[0]=origen;
				resp[1]=destino;
				costoMenor=costo;
			}
		}
	}
	
	return resp;
}
	class Nodo implements Comparable<Nodo> {
		int nodo;
		int costo;

		public Nodo(int nodo) {
			this.nodo=nodo;
		}
		public Nodo(int nodo, int costo) {
			this.nodo = nodo;
			this.costo = costo;

		}

		public int getNodo() {
			return nodo;
		}

		public void setNodo(int nodo) {
			this.nodo = nodo;
		}

		public int getCosto() {
			return costo;
		}

		public void setCosto(int costo) {
			this.costo = costo;
		}

		@Override
		public int compareTo(Nodo o) {
			return this.costo - o.costo;
		}

		@Override
		public String toString() {
			return "Nodo [nodo=" + nodo + ", costo=" + costo + "]";
		}

	}

}
