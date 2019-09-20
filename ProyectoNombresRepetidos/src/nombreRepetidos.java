
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* Preguntas:
 * 1)¿Estan bien utilizadas las colecciones? 
 *2¿Cual de las soluciones es mejor? 
 *3)¿Seria mejor utilizar otro tipo de colecciones?

*/
/******CON ARRAY LIST Y TreeSet********/

/*
public class nombreRepetidos {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc= new Scanner(new File("nombres.txt"));
		int cantidadChicos=sc.nextInt();
		int n=sc.nextInt();
		List<Chicos> conjunto=new ArrayList<Chicos>();
	
		// Leo del archivo y lo agrego al ArrayList(incrementando si ya existe)
	while(sc.hasNext()) {
		String nombre=sc.next();
		Chicos c=new Chicos(nombre,1);
		int index=conjunto.indexOf(c);
		if(index==-1) 
			conjunto.add(c);		
		else {
			conjunto.get(index).incrementarApariciones();
		}
	}
	
	//Busco los N mas Repetidos
	Set <Chicos> ordenados =new TreeSet<Chicos>();
	///Del ArrayList lo paso a un TreeSet
	for (Chicos chicos : conjunto) {
		ordenados.add(chicos);
	}
	conjunto.clear();

	
	for (Chicos chicos : ordenados) {
		if(n>0)
		System.out.println(chicos);
		n--;
	}
	sc.close();
	}
	*/

// CON HashMap y TreeSet

public class nombreRepetidos {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc= new Scanner(new File("nombres.txt"));
		int cantidadChicos=sc.nextInt();
		int n=sc.nextInt();
		Map <String,Integer> conjunto=new HashMap <String,Integer>();
	
	
	
		// Leo del archivo y lo agrego al ArrayList(incrementando si ya existe)
	while(sc.hasNext()) {
		String nombre=sc.next();
		if(conjunto.containsKey(nombre)) 
			conjunto.put(nombre, conjunto.get(nombre)+1);
		else
			conjunto.put(nombre, 1);
		
	}
	
	Set <Chicos> ordenados = new TreeSet<Chicos> ();
	for(Map.Entry<String,Integer> entry : conjunto.entrySet()) {
		Chicos c = new Chicos(entry.getKey(),entry.getValue());
		ordenados.add(c);
	}
	
	for (Chicos chicos : ordenados) {
		if(n>0)
			System.out.println(chicos);
		n--;
	}
	

	sc.close();
	
	}
	
}
