import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InspeccionandoReserva {
	private Grafo g;
	
	
	public InspeccionandoReserva(String nombreArchivo) {
		try {
			Scanner sc= new Scanner(new File(nombreArchivo));
			int cantidadNodo=sc.nextInt();
			int cantidadArista=sc.nextInt();
			g= new Grafo(cantidadNodo,Integer.MAX_VALUE);
			for (int i = 0; i < cantidadNodo; i++) {
				g.addNodos(new Nodo(i));
			}
			
			for (int i = 0; i <cantidadArista; i++) {
				g.addAristas(new Arista(new Nodo(sc.nextInt()),new Nodo(sc.nextInt()),1));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int obtenerCantidadCaminos(Nodo inicial,Nodo fin) {
		Queue<Nodo> cola = new LinkedList<Nodo>();
		boolean []visitados= new boolean[g.cantidadNodos()];
		
		for (boolean b : visitados) {
			b=false;
		}
		
		visitados[inicial.getNumero()]=true;
		inicial.setCaminosEntrantes(1);
		cola.add(inicial);
		g.getNodos().get(inicial.getNumero()).setCaminosEntrantes(1);
		int cantAnterioresCalculados;
		
		while(!cola.isEmpty()){
			cantAnterioresCalculados=0;
			Nodo n1=cola.poll();
			boolean rep=sePuedeCalcularCantCaminos(n1);
			if(rep==false) {
				cola.add(n1);
			}
			else {
				g.getNodos().get(n1.getNumero()).setCaminosEntrantes(g.sumarCaminosEntrantes(n1));
				//visitados[n1.getNumero()]=true;
				agregarAdyacentesNoVisitados(n1,cola,visitados);
			}
			
			
		}
		
		return g.getNodos().get(fin.getNumero()).getCaminosEntrantes();		
	}

	private void agregarAdyacentesNoVisitados(Nodo n1, Queue<Nodo> cola, boolean[] visitados) {
		for(int i=0;i<visitados.length;i++) {
			if(visitados[i]==false && g.getAristas(n1, new Nodo(i))) {
				cola.add(g.getNodos().get(i));
				visitados[i]=true;
			}
		}
	}

	private boolean sePuedeCalcularCantCaminos(Nodo n1) {
		int cant=0;
		for(int i=0; i< g.cantidadNodos();i++) {
			Nodo n2= new Nodo(i);
			if(g.getAristas(n2, n1) && g.getNodos().get(n2.getNumero()).getCaminosEntrantes()!=0) {
				cant++;
			}
		}
		if(cant== g.getCantEntrantes(n1))
			return true; 
		return false;
	}
	
}
