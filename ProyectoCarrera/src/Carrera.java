import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Carrera {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc=new Scanner(new File("carrera.in"));
		PrintWriter salida = new PrintWriter( new File("carrera.out"));
		int cantCuadras=sc.nextInt(),diferenciaMax=sc.nextInt(),neutralesMax=sc.nextInt(),
			diferencia,sociosA,sociosB,contadorCuadras=0;
	
		for(int i=0;i<cantCuadras;i++) {
			sociosA=sc.nextInt();
			sociosB=sc.nextInt();
			diferencia=Math.abs(sociosA-sociosB);
			if(sc.nextInt()-sociosA-sociosB<=neutralesMax && diferencia<=diferenciaMax) {
				contadorCuadras++;
			}
		}
		salida.print(contadorCuadras);
		salida.close();		
		sc.close();
	}
	/*
	public void contarCuadras(String fileIn, String fileOut) throws IOException
	{
		Scanner scIn = new Scanner(new File(fileIn));
		Integer cantCuadrasTotales = scIn.nextInt();
		Integer maxDifSocios = scIn.nextInt();
		Integer maxCantNeutrales = scIn.nextInt();
		Integer cantCuadrasBuenas = 0;
		while (cantCuadrasTotales > 0)
		{
			cantCuadrasTotales--;
			Integer cantSociosA = scIn.nextInt();
			Integer cantSociosB = scIn.nextInt();
			Integer cantHabitantes = scIn.nextInt();
			if (Math.abs(cantSociosA - cantSociosB) <= maxDifSocios
					&& cantHabitantes - cantSociosA - cantSociosB <= maxCantNeutrales)
			{
				cantCuadrasBuenas++;
			}

		}
		scIn.close();
		FileWriter writerOut = new FileWriter(new File(fileOut));
		writerOut.append(cantCuadrasBuenas.toString());
		writerOut.close();
	}*/

}
