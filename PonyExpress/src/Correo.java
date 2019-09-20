
public class Correo {
	/*public int jinetes(int[] estaciones) { 
		int cantJinetes=1;
		int recorridoJinete=0;
		
		for (int distanciaEstacion : estaciones) {
			if(recorridoJinete+distanciaEstacion>100) {
				cantJinetes++;
				recorridoJinete=distanciaEstacion;
			}
			else
				recorridoJinete+=distanciaEstacion;
		}
		return cantJinetes;
	}*/

	public static int jinetes(int[] estaciones) {
		int jinete=0,Cant=0,i=0;
		int t=estaciones.length;
		while(i<t){
		jinete=0;
		while(i<t && (jinete+estaciones[i])<100) //mientras este dentro del vector y las millas sean menor a 100 sumo;
		{
		jinete+=estaciones[i++];
		}
		System.out.println(jinete);
		Cant++;
		}
		return Cant;
		}
}