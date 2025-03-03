import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Imagen {
	public static void procesarImagenes(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));
		String imagenComprimida = comprimirImagen(sc.next());
		String imagenDescomprimida = descomprimirImagen(sc.next());
		System.out.println(imagenComprimida);
		System.out.println(imagenDescomprimida);
		sc.close();
	}

	public static String comprimirImagen(String imagen) {
		int repeticiones = 1;
		String imagenComprimida = "";
		for (int i = 0; i < imagen.length(); i++) {
			String actual = imagen.substring(i, i + 1);
			// si es el ultimo
			if (i + 1 >= imagen.length()) {
				if (repeticiones > 4) {
					imagenComprimida = imagenComprimida + "(" + actual + repeticiones + ")";
				} else {
					imagenComprimida = imagenComprimida + imagen.substring(i - repeticiones + 1, imagen.length());
				}
			}
			// no es el ultimo
			else {
				String siguiente = imagen.substring(i + 1, i + 2);
				if (actual.equals(siguiente)) {
					repeticiones++;
				} else {
					if (repeticiones > 4) {
						imagenComprimida = imagenComprimida + "(" + actual + repeticiones + ")";
					} else {
						imagenComprimida = imagenComprimida + imagen.substring(i - repeticiones + 1, i + 1);
					}
					repeticiones = 1;
				}

			}

		}
		return imagenComprimida;
	}

	public static String descomprimirImagen(String imagenComprimida) {

		String imagenDescomprimida = "";
		/*
		 * while(index!=-1) {
		 * imagenDescomprimida=imagenDescomprimida+imagenComprimida.substring(i,index);
		 * int num=(int)imagenComprimida.charAt(index+2)-48; for(int j=0;j<num;j++) {
		 * imagenDescomprimida=imagenDescomprimida+imagenComprimida.substring(index+1,
		 * index+2); }
		 * 
		 * imagenComprimida=imagenComprimida.substring(index+1,
		 * imagenComprimida.length()); index=imagenComprimida.indexOf("("); }
		 */
		int i = 0;
		while (i < imagenComprimida.length()) {
			if (imagenComprimida.charAt(i) == '(') {
				int num = (int) imagenComprimida.charAt(i + 2) - 48;
				for (int j = 0; j < num; j++) {

					imagenDescomprimida = imagenDescomprimida + imagenComprimida.substring(i + 1, i + 2);

				}
				i += 4;

			} else {
				imagenDescomprimida = imagenDescomprimida + imagenComprimida.substring(i, i +1);
				i++;
			}
		}

		return imagenDescomprimida;
	}
}
