
public class Shell {
public static void ordenar(String vector[]){
	
	int h=1;
	while((h*3+1)<vector.length) {
		h=h*3+1;
	}
	while(h>1) {
		
		int i=0;
		int j=i;
		while(j<h && i+h<vector.length) {
			String aux;
			if(vector[i].compareToIgnoreCase(vector[i+h])>0) {
				aux=vector[i];
				vector[i]=vector[i+h];
				vector[i+h]=aux;
			}
			i+=h;
			if(i+h>=vector.length) {
				j++;
				i=j;
			}
		}
		
		h=(h-1)/3;
	}
	boolean cambio=true;
	while(cambio==true) {
		cambio=false;
		for(int i=0;i<vector.length-1;i++) {
			String aux;
			if(vector[i].compareToIgnoreCase(vector[i+1])>0) {
				aux=vector[i];
				vector[i]=vector[i+1];
				vector[i+1]=aux;
				cambio=true;
			}
		}
		
		
	}
	
}
}
