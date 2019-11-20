package coloreo;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Nodo implements Comparable<Nodo>{
private int id; // numero de nodo
private int color ;
private int grado;
public Nodo(int id) {
	this.id=id;
	
}
public void setGrado(int grado) {
	this.grado=grado;
}

public int getGrado() {
	return this.grado;
}
public void setColor(int color) {
	this.color=color;
}
public int getColor() {
	return this.color;
}
public boolean estaPintado() {
	return this.color!=0;
}
public int getId() {
	return this.id;
}
public int compareTo(Nodo o) {
// si es Matula
	return this.grado-o.getGrado();
}
public static void ordenWp(List<Nodo> nodos) {
	Collections.sort(nodos, new ComparadorWP());
}
@Override
public String toString() {
	return "Nodo [id=" + id + ", color=" + color + ", grado=" + grado + "]";
}

}
class ComparadorWP implements Comparator<Nodo>{
	@Override
	public int compare(Nodo o1, Nodo o2) {
		return o2.getGrado()-o1.getGrado();
	}
}