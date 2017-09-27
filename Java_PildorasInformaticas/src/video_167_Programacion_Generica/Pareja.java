package video_167_Programacion_Generica;
public class Pareja<T>{
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