package paquete;

public final class MiClase extends OtraClase {
	private static String name;
	protected MiClase() {
		System.out.println("constructor MiClase");
		name="por defecto";
	}
	public static String GetName() {
		return name;
	}
	public  String GetName2() {
		return name;
	}
	public static void SetName(String nombre) {
		name=nombre;
	}
}
