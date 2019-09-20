
public class Chicos implements Comparable{
String nombre;
int apariciones;
public Chicos(String nombre, int apariciones) {
	this.nombre=nombre;
	this.apariciones=apariciones;
}
@Override
public int compareTo(Object o) {
	Chicos c;
	c=(Chicos)o;
	
	if(this.apariciones<c.apariciones)
		return 1;
	if(this.apariciones>c.apariciones)
		return -1;
	
	return this.nombre.compareTo(c.nombre);
	
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Chicos other = (Chicos) obj;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	return true;
}
@Override
public String toString() {
	return "Chicos [nombre=" + nombre + ", apariciones=" + apariciones + "]";
}
public void incrementarApariciones() {
	this.apariciones++;
}
}
