
public class Burbujeo {
	public static void ordenar(int vec[]) {
		boolean cambio = true;

		while (cambio ==true) {
			cambio=false;
			for (int i = 0; i < vec.length - 1; i++) {
				int aux;
				if (vec[i] > vec[i + 1]) {
					aux = vec[i + 1];
					vec[i + 1] = vec[i];
					vec[i] = aux;
					cambio=true;
				}
				
			}
		}
	}
}
