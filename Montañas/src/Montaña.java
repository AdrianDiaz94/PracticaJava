
public class Monta�a {
	int cantCimaMonta�a;
	int cimaYvalle[];
	int posXCarrito;
	
	public Monta�a(int cantCimaMonta�a, int[] cimaYvalle, int posXCarrito) {
		this.cantCimaMonta�a = cantCimaMonta�a;
		this.cimaYvalle = cimaYvalle;
		this.posXCarrito = posXCarrito;
	}
	
	public String resolver() {
		int acumX = 0;
		int flag = 0;
		int i = 1;
		int capacidadAscenso = 0;
		if(cimaYvalle[0]<cimaYvalle[1]) {
			return acumX + " " + capacidadAscenso;
		}
		else
			capacidadAscenso = cimaYvalle[0] - posXCarrito; //Guardo la altura de la primer cima
		
		while(flag==0)
		{
			acumX += Math.abs(cimaYvalle[i-1] - cimaYvalle[i]);
			
			if(i%2 != 0) {
				capacidadAscenso--;
				if((i < cimaYvalle.length) && (cimaYvalle[i+1] >= capacidadAscenso)) {
					flag = 1;
				}
			}	
			i++;
		}
		acumX += capacidadAscenso - posXCarrito;
		
		return acumX + " " + capacidadAscenso;
	}

}
