import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Montaņa m1 = ArchivoMontaņa.abrirArchivo("como.in");
		System.out.println(m1.resolver());
	
	}

}
