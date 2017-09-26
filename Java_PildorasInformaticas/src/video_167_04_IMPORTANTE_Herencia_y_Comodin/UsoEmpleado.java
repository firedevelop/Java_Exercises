package video_167_04_IMPORTANTE_Herencia_y_Comodin;

public class UsoEmpleado{
	public static void main(String[]args) {
		Pareja<Empleado> Administrativa=new Pareja<Empleado>();
		Pareja<Jefe> DirectoraComercial=new Pareja<Jefe>();
		Pareja.imprimirTrabajador(Administrativa);
		Pareja.imprimirTrabajador(DirectoraComercial);	
	}
}
 class Empleado{
	private String nombre;
	private double sueldo;
	private int edad;

	public Empleado(String nombre, double sueldo, int edad) {
		this.nombre=nombre;
		this.edad=edad;
		this.sueldo=sueldo;
	}
	public String dameDatos() {
		return "El empleado " + nombre + " Y un salario de " + sueldo + ". Tiene" + edad + " años." ;
	}
}
class Jefe extends Empleado{
	public Jefe(String nombre, int edad, double sueldo) {
		super(nombre, sueldo, edad);
	}
	double incentivo(double inc) {
		return inc;
	}
}
 class Pareja<T>{
	public Pareja(){
		primero=null;
	}
	public void setPrimero(T nuevoValor) {
		primero=nuevoValor;
	}
	public static void imprimirTrabajador(Pareja<? extends Empleado> p) {
		Empleado primero=p.getPrimero();
		System.out.println(primero);
	}
	
	public T getPrimero() {
		return primero;
	}
	private T primero;

} 