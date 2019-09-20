import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Cadenas {
/*public void SuprimirCadenas(File archivo) throws FileNotFoundException {
	Scanner sc = new Scanner(archivo);
	
	String cadena="";
	int posAnulador,posRetroceso,fin=-1;
	//leo el archivo mientras haya otra linea y no aparezca el *
	while(sc.hasNext() && fin==-1) {
		cadena+=sc.next();
		fin=cadena.lastIndexOf("*");
		
	}
	if(fin == -1) {
		System.out.println("el archivo no contiene el caracter de fin de tira de caracteres '*' ");
		return ;
	}
	//me quedo con lo que esta antes del *
	cadena=cadena.substring(0, fin);
	posAnulador=cadena.lastIndexOf("&"); //busco la ultima aparicion de &
	// si aparece el anulador me quedo con lo que le sigue
	if(posAnulador!=-1) 
		cadena=cadena.substring(posAnulador+1, cadena.length()); 
	
	//mientras aparezca el caracter de retroceso elimino el caracter anterior
	posRetroceso=cadena.indexOf("/");
	while(posRetroceso != -1) {
		if(posRetroceso-1<0)
			cadena=cadena.substring(posRetroceso+1,cadena.length());
		else 
		cadena=cadena.substring(0,posRetroceso-1)+cadena.substring(posRetroceso+1,cadena.length());
		
		posRetroceso=cadena.indexOf("/");
		
	}
	System.out.println("cadena resultante: "+cadena);
	sc.close();
}
*/
	public static String SuprimirCadenas(String nombreArchivo) throws FileNotFoundException {
		Scanner scannerArchivo = new Scanner(new File(nombreArchivo));
		String cadena;
		String cadenaRes = "";
		while (scannerArchivo.hasNextLine()) {

			cadena = scannerArchivo.nextLine();
			int largo = cadena.length();
			for (int i = 0; i < largo; i++) {
				if (cadena.charAt(i) == '&') {
					cadenaRes ="";
				} else if (cadena.charAt(i) == '/') {
					if (cadenaRes.isEmpty())
						continue;
					else
						cadenaRes = cadenaRes.substring(0, i - 1);
				} else if (cadena.charAt(i) == '*') {
					System.out.println(cadena);
					return cadenaRes;
				} else {
					cadenaRes += cadena.charAt(i);
				}
			}
		}
		scannerArchivo.close();
		return null;
	}
}
