package coloreo;

import java.util.Collections;
import java.util.List;

public class OrdenWP {
	public static void ordernar(List<Nodo>nodos) {
		Collections.shuffle(nodos);
		Nodo.ordenWp(nodos);
		}
}
