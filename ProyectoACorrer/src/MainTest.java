import java.io.FileNotFoundException;

public class MainTest {
public static void main(String[] args) throws FileNotFoundException {
	Carrera c=new Carrera();
	c.obtenerGanadores(".\\entrada.txt", "salida.txt");
}
}
