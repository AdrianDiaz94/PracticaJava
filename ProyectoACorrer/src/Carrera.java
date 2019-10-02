import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Carrera {

	public void obtenerGanadores(String fileIn, String fileOut) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileIn));
		int cantidadCorredores = sc.nextInt();
		Corredor[] corredoresInscriptos = new Corredor[cantidadCorredores];
		int categoriasFemeninas = sc.nextInt();
		int categoriasMasculinas = sc.nextInt();
		int cantidadLLegaron = sc.nextInt();
		int[] categoriasMin = new int[categoriasFemeninas + categoriasMasculinas];
		int[] categoriasMax = new int[categoriasFemeninas + categoriasMasculinas];
		int[][] podio = new int[categoriasMasculinas + categoriasFemeninas][4];
		int i = 0;
		// guardo los minimos y maximos de cada categoria
		while (i < categoriasFemeninas + categoriasMasculinas) {
			categoriasMin[i] = sc.nextInt();
			categoriasMax[i] = sc.nextInt();
			i++;
		}
		i = 0;
		boolean encontrado = false;

		// guardo a los corredores en un vector de corredores con su edad,sexo y la
		// categoria a la que pertenece
		while (i < cantidadCorredores) {
			corredoresInscriptos[i] = new Corredor(sc.nextInt(), sc.next());
			int j = 0;
			while (j < categoriasFemeninas && corredoresInscriptos[i].getSexo().equals("F")) {
				if (corredoresInscriptos[i].getEdad() >= categoriasMin[j]
						&& corredoresInscriptos[i].getEdad() <= categoriasMax[j]) {
					corredoresInscriptos[i].setCategoria(j + 1);
					encontrado = true;
				}
				j++;
			}
			j = categoriasFemeninas;
			while (encontrado == false && j < categoriasFemeninas + categoriasMasculinas
					&& corredoresInscriptos[i].getSexo().equals("M")) {
				if (corredoresInscriptos[i].getEdad() >= categoriasMin[j]
						&& corredoresInscriptos[i].getEdad() <= categoriasMax[j])
					corredoresInscriptos[i].setCategoria(j - categoriasFemeninas + 1);
				j++;
			}
			encontrado = false;
			i++;
		}

		// lleno posicion [j][0] con el numero de categoria
		for (int j = 0; j < categoriasFemeninas; j++) {
			podio[j][0] = j + 1;
		}
		for (int j = categoriasFemeninas; j < categoriasFemeninas + categoriasMasculinas; j++) {
			podio[j][0] = j + 1 - categoriasFemeninas;
		}

		// coloco al corredor en el lugar que le corresponde en el podio
		int h = 0;
		while (h < cantidadLLegaron) {
			int numCorredor = sc.nextInt();
			int categoria = corredoresInscriptos[numCorredor - 1].getCategoria();
			String sexo = corredoresInscriptos[numCorredor - 1].getSexo();
			int lugar = 1;
			while (sexo.equals("F") && lugar < 4 && podio[categoria - 1][lugar] != 0) {
				lugar++;
			}

			if (lugar != 4 && sexo.equals("F")) {
				podio[categoria - 1][lugar] = numCorredor;
			}
			lugar = 1;
			while (sexo.equals("M") && lugar < 4 && podio[categoriasFemeninas + categoria - 1][lugar] != 0) {
				lugar++;
			}

			if (lugar != 4 && sexo.equals("M")) {
				podio[categoriasFemeninas + categoria - 1][lugar] = numCorredor;
			}
			h++;
		}

		PrintWriter salida = new PrintWriter(fileOut);
		for (int k = 0; k < categoriasFemeninas + categoriasMasculinas; k++) {
			for (int m = 0; m < 4; m++) {
				salida.print(podio[k][m] + " ");
			}
			salida.print("\n");
		}
		salida.close();
		sc.close();

	}
}
