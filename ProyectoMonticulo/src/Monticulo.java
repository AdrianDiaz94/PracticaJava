import java.util.ArrayList;
import java.util.List;

public class Monticulo {
	private int [] monticulo;
	// la posicion 0 tiene la primer posicion libre
	public Monticulo(int vector[]) {
		
		monticulo=new int[vector.length+1];
		monticulo[0]=1;
		for(int i=0;i<vector.length;i++)
			insertarEnMonticulo(vector[i]);
	}
	
	public int verMaximo() {
		return monticulo[1];
	}
	public void insertarEnMonticulo(int num) {
	
		// inserto el numero en la primer posicion libre
		int pos=monticulo[0];
		monticulo[pos]=num;
		monticulo[0]+=1;
		//me fijo si es mayor a su padre
		int padre=pos/2;
		int i=pos;
		 while(i !=1 && monticulo[i]>monticulo[padre]) {
			int aux=monticulo[i];
			monticulo[i]=monticulo[padre];
			monticulo[padre]=aux;
			i=padre;
			padre=padre/2;
		}	
	}
	
	public int sacarMayor() {
		int aux=monticulo[monticulo[0]-1];
		monticulo[0]-=1;
		monticulo[monticulo[0]]=monticulo[1];
		monticulo[1]=aux;
		int i=1;
		while(i*2<monticulo[0] &&  i*2+1<monticulo[0] && (
				monticulo[i]<monticulo[i*2] || monticulo[i]< monticulo[i*2+1])) {
			// hijo izquierdo mayor
			int hijoIzq=monticulo[i*2];
			int hijoDer=monticulo[i*2+1];
			//si el mayor es el hijo izquierda
			if(hijoIzq>hijoDer) {
			aux=monticulo[i];
			monticulo[i]=monticulo[i*2];
			monticulo[i*2]=aux;
			i=i*2;
			}
			//si el mayor es el hijo derecho
			else{
				aux=monticulo[i];
				monticulo[i]=monticulo[i*2+1];
				monticulo[i*2+1]=aux;
				i=i*2+1;
			}
		}
			
		return monticulo[monticulo[0]];
		
	}

}
