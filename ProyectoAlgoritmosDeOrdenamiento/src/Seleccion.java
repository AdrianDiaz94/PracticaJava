
public class Seleccion {

	public static void ordenar(int vec[]) {
		
		
		for(int i=0;i<vec.length-1;i++) {
			
			int menor=i;
			for(int j=i;j<vec.length;j++) {
				
				if(vec[menor]>vec[j]) {
					menor=j;
				}
			}
			int aux=vec[menor];
			vec[menor]=vec[i];
			vec[i]=aux;
			
		}
		
		
	}
}
