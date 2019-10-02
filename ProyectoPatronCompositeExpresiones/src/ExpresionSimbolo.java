
public class ExpresionSimbolo extends Expresion{
	String simbolo;
	public ExpresionSimbolo(String simbolo) {
	this.simbolo=simbolo;
	}
	@Override
	public String getDato() {
		return this.simbolo;
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
