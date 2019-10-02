
public class ExpresionNumero extends Expresion {

	Integer dato;
	
	public ExpresionNumero(Integer dato) {
	this.dato=dato;
	}

	@Override
	public String getDato() {
		return this.dato.toString();
	}

	@Override
	public boolean esCompuesto() {
		return false;
	}

	@Override
	public void add(Expresion expresion) {
		return;
		
	}

}
