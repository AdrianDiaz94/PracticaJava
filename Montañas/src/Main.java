import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Monta�a m1 = ArchivoMonta�a.abrirArchivo("como.in");
		System.out.println(m1.resolver());
	
	}

}
