
public class Transporte {
protected boolean conductor;
protected String tipo;
protected int pasajeros;
protected int capacidad;
protected boolean moviendo;
public Transporte(String tipo,int capacidad) {
	this.conductor=false;
	this.pasajeros=0;
	this.tipo=tipo;
	this.moviendo=false;
	this.capacidad=capacidad;
	
}

public void moverse() {
	if( this.conductor==false) {
		System.out.println("no se puede mover porque no hay conductor en "+this.tipo );
		return;
	}
	this.moviendo=true;
	System.out.println(this.tipo+" se esta moviendo");
		
}
public void detenerse() {
	if(this.moviendo==false) {
		System.out.println(this.tipo + " ya estaba detenido");
		return ;
	}
	System.out.println(this.tipo +" se detuvo");
	this.moviendo=false;
}
public boolean agregarConductor() {
	if(this.conductor==true) {
		System.out.println("ya existe un conductor en "+this.tipo);
		return false;
	}
	this.conductor=true;
	this.capacidad--;
	System.out.println("se agrego un conductor en "+ this.tipo);
	return true;
}
public boolean eliminarConductor() {
	if(this.conductor==false) {
		System.out.println("no hay conductor en "+this.tipo);
		return false;
	}
	if(this.moviendo==true) {
		System.out.println("no se puede quitar al conductor en " + this.tipo+" mientras se mueve" );
		return false;
	}
	
	this.conductor=false;
	this.capacidad++;
	System.out.println("se elimino un conductor en "+ this.tipo);
	return true;
}
public boolean agregarPasajeros(int cantidad) {
	if(this.moviendo==true) {
		System.out.println("no se puede agregar pasajeros mientras se esta moviendo: " + this.tipo);
		return false;
	}
	if(this.tipo=="Bicicleta" && (this.conductor==false || this.capacidad<cantidad))
	{
		System.out.println("no se puede agregar pasajeros en "+this.tipo);
		return false;
	}
	if((this.tipo=="Colectivo" || this.tipo=="Avion") && this.capacidad<cantidad) {
		System.out.println("no se puede agregar pasajeros en "+this.tipo);
		return false;
	}
	System.out.println("se agrego "+cantidad+" pasajeros en "+this.tipo);
	this.capacidad-=cantidad;
	this.pasajeros++;
	return true;
}
public boolean quitarPasajeros( int cantidad) {
if(this.moviendo==true) {
	System.out.println("no se puede quitar pasajeros de " + this.tipo+" se esta moviendo ");
	return false;
}
if(this.pasajeros <cantidad) {
	System.out.println("no existen " + cantidad + " pasajeros en " + this.tipo);
	return false;
}
System.out.println( " se elimino un pasajero de "+this.tipo);
this.capacidad+=cantidad;
this.pasajeros-=cantidad;
return true;
}	
}


