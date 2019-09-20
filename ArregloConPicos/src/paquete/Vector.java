package paquete;

public class Vector {
	/*public int  BuscarPico(int [] vector) {
		int n=vector.length;
		int pico=1;
		while(pico<n && vector[pico]< vector[pico+1] )
			pico++;
		
		return pico;
	}
	*/
		
	public static Integer buscarPico(int[] v) {
		
			int p = 1, i;
			for (i = 0; i < v.length - 1; i++) {
				if (v[i] >= v[i + 1]) {
					p = i;
					break;
				}
			}
			return p;
		}
}
