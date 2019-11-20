package coloreo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Maint {

	public static void main(String[] args) {
		Coloreo coloreo= new Coloreo("grafo.txt");
		System.out.println(coloreo.obtenerCantidadColores(Coloreo.ALEATORIO));
	}

}
