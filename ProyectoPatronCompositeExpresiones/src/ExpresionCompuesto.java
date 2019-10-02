import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExpresionCompuesto extends Expresion {
	List<Expresion > expresiones=new LinkedList<Expresion>();
	String cadena="";
	@Override
	public String getDato() {
	for (Expresion expresion : expresiones) {
		cadena+=expresion.getDato();
	}
	return cadena;
	}

	@Override
	public boolean esCompuesto() {
	
		return true;
	}

	@Override
	public void add(Expresion expresion) {
		expresiones.add(expresion);
		
	}

}
