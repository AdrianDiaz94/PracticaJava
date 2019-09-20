package paquete;

public class Luchador {
	private int peso, altura,cantDomina;
	public Luchador(int peso, int altura) {
		this.peso=peso;
		this.altura=altura;
		this.cantDomina=0;
	}

	public boolean Domina(Luchador l) {
		if(this == l)
			return false;
		if( (this.peso >= l.peso && this.altura > l.altura) ||  (this.peso > l.peso && this.altura >= l.altura) )
		return true;
		else
			return false;
		
	} 


	@Override
	public String toString() {
		return "Luchador [peso=" + peso + ", altura=" + altura + ", cantDomina=" + cantDomina + "]";
	}

	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int GetDomina() {
		return this.cantDomina;
	}
	public void SetDomina(int cantDomina) {
		this.cantDomina=cantDomina;
	
	}
}
