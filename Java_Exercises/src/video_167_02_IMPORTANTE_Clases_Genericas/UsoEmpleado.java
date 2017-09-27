// Esto es un ejemplo de como crear Clases Propias en Programacion Generica
package video_167_02_IMPORTANTE_Clases_Genericas;

public class UsoEmpleado{
	public static void main(String[]args) {
		Empleado<String> misEmpleados=new Empleado<String>();
		misEmpleados.set("Juan");
		System.out.println(misEmpleados.dameNombre().getClass().getSimpleName()+ ": "+misEmpleados.dameNombre());
		
		Persona misPersonas=new Persona("Ana");
		System.out.println(misPersonas.toString().getClass().getSimpleName()+ ": "+misPersonas.toString());

		Empleado<Persona> misPersonas2=new Empleado<Persona>();
		misPersonas2.set(misPersonas);
		System.out.println(misPersonas2.dameNombre().getClass().getSimpleName()+ ": "+misPersonas2.dameNombre());
	}
}
 class Empleado<T>{
	private T nombre;
	public Empleado(){
		nombre=null;
	}
	public void set(T nom) {
		nombre=nom;
	}
	public T dameNombre() {
		return nombre;
	}
} 
class Persona{
	private String nombre;
	public Persona(String nom) {
		nombre=nom;
	}
	public String toString() {
		return nombre;
	}
}