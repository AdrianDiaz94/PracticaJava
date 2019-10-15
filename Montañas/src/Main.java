import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Montaña m1 = ArchivoMontaña.abrirArchivo("como.in");
		System.out.println(m1.resolver());
	
	}

}
