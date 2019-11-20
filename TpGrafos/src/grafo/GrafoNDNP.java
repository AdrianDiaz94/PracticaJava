package grafo;

import java.util.ArrayList;
import java.util.List;

import coloreo.Nodo;

public class GrafoNDNP extends MatrizSimetrica{
	
	private int gradoMin;
	private int gradoMax;
	private int cantArista;
	private double porcentajeAdy;
	private List<Nodo> nodos= new ArrayList<Nodo>();
	
	public List<Nodo> getNodos() {
		return nodos;
	}



	public GrafoNDNP(int nodos, int gradoMin, int gradoMax, int cantArista,
			double porcentajeAdy) {
		super(nodos);
		this.gradoMin = gradoMin;
		this.gradoMax = gradoMax;
		this.cantArista = cantArista;
		this.porcentajeAdy = porcentajeAdy;
	}

		
	
	public int cantidadAristas() {
		int aristas = 0;
		int maxAristas = getAristasMax();
		for(int i = 0; i < maxAristas; i++)
			if(this.vector[i] == 1)
				aristas++;
		return aristas;
	}

	public int getGradoMin() {
		return gradoMin;
	}

	public void setGradoMin(int gradoMin) {
		this.gradoMin = gradoMin;
	}

	public int getGradoMax() {
		return gradoMax;
	}

	public void setGradoMax(int gradoMax) {
		this.gradoMax = gradoMax;
	}

	public int getCantArista() {
		return cantArista;
	}

	public void setCantArista(int cantArista) {
		this.cantArista = cantArista;
	}

	public double getPorcentajeAdy() {
		return porcentajeAdy;
	}

	public void setPorcentajeAdy(double porcentajeAdy) {
		this.porcentajeAdy = porcentajeAdy;
	}

	public void agregarNodo(int idNodo) {
		if( !puedeAgregarNodo(idNodo))
			return;
		Nodo nodo= new Nodo(idNodo);
		cambiarGrado(nodo);
		nodos.add(nodo);
		
		
	}
	private boolean puedeAgregarNodo(int idNodo) {
		for (Nodo nodo : nodos) {
			if(nodo.getId()==idNodo)
				return false;
		}
		return true;
	}
	public void cambiarGrado(Nodo nodo) {		
		nodo.setGrado(determinarGrado(nodo.getId()));
	}
	public List<Nodo> obtenerListaDeAdyacentes(int idNodo) {
		List<Nodo> adyacentes= new ArrayList<Nodo>();
		for (Nodo nodo : nodos) {
			if(esAdyacente(idNodo, nodo.getId())) {
				adyacentes.add(nodo);
			}
		}
		return adyacentes;
	}
}
