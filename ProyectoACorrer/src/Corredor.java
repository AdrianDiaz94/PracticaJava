
public class Corredor {
	private int edad;
	private String sexo;
	private int categoria;
	public Corredor() {
		
	}
public Corredor(int edad, String sexo) {
	this.edad=edad;
	this.sexo=sexo;
}
public int getEdad() {
	return this.edad;
}
public String getSexo() {
	return this.sexo;
}
@Override
public String toString() {
	return this.edad+" "+this.sexo +" "+this.categoria;
}
public int getCategoria() {
	return this.categoria;
}
public void setCategoria(int categoria) {
	this.categoria=categoria;
}
}
