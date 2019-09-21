import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Scanner;

import javax.management.Query;

public class Piano {

	public static void buscarPosicionesOptimas(String fileInput, String fileOutput) throws FileNotFoundException {
		Scanner sc=new Scanner(new File(fileInput));
		PrintWriter salida = new PrintWriter(fileOutput);

		
		
		sc.close();
		salida.close();
		
		
	}
}

