
public class Main {
public static void main(String[] args) {
	ExpresionCompuesto exp = new ExpresionCompuesto();	
	exp.add(new ExpresionSimbolo("("));
	exp.add(new ExpresionNumero(1));
	exp.add(new ExpresionSimbolo("+"));
	exp.add(new ExpresionNumero(3));
	exp.add(new ExpresionSimbolo(")"));
	exp.add(new ExpresionSimbolo("*"));
	exp.add(new ExpresionNumero(5));
	
	System.out.println(exp.getDato());
}
	
}
