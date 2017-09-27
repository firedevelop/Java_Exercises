package video_165_Programacion_Generica_Clases_Propias;
// por convención se puede usar T, U, K
// Estos signos <> se llaman corchetes angulares
public class Pareja<T>{
	public Pareja(){
		// esta variable es null, pero el metodo setPrimero se encargara de darle un valor
		primero=null;
	}
	// aqui le decimos que el objeto es de tipo T, esta T es de tipo genérico, es decir que no es String, ni int, etc  ...
	public void setPrimero(T nuevoValor) {
		primero=nuevoValor;
	}
	public T getPrimero() {
		return primero;
	}
	private T primero;
	
} 