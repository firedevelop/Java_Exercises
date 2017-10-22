package video_166_Programacion_Generica;
import java.util.GregorianCalendar;
import sun.util.calendar.Gregorian;

public class MetodosGenericos2{
	public static void main(String[]args) {
		
		String nombre[]= {"Maria","Asun","Jose"};
		System.out.println(MisMatrices2.getMenor(nombre));
		
		// aqui vamos a mostar un ejemplo de como si implementamos GregorianCalendar, no nos da ningun error por que esta clase puede implementar la interfaz comparable. Sin embargo si lo hacemos con la clase Empleados nos daría un error.
		// el formato que nos va a dar la consola no es legible pero esto no es un error, habría que hacer con el metodo get una clase para que saliera legible por consola.
		GregorianCalendar fechas[]= {new GregorianCalendar(2015,9,01),
				new GregorianCalendar(2015,0,01),
				new GregorianCalendar(2015,2,01),
		};
		System.out.println(MisMatrices2.getMenor(fechas).getTime());
		
		}
	}

class MisMatrices2{
	// public para que sea accesible desde otras clases
	// static para convertirlo en un metodo de clase y de esta forma no necesitar una instancia perteneciente a "MisMatrices" para poder utilizar el metodo 
	// getElementos va a recibir por parametros un array, pero tengo que especificar el tipo de este array, pero como le vamos a pasar un array generico se lo indicamos poniendo el argumento de tipo.
	// aqui hacemos extends y no implement. Y esto es por que asi nos obliga a que todos los argumentos que le pasemos al metodo generico getMenor(T.
	// la letra a significa el array que le estamos pasando
	public static <T extends Comparable> T getMenor(T[]a) {
		// aqui usamos el null simplemente para evitar que se le pasen valores nulos.
		if(a==null || a.length==0) {
			return null;
		}
		// esta variable llamada elemento Menor va a almacenar el menor, y es de tipo T por que no sabemos cual es el tipo de parámetro que nos van a pasar.
		// le indicamos que el elemento menor esta en la posicion 0 del array, esto puede que no sea asi, pero para empezar le decimos que es asi.
		// si no pusieramos que elementoMenor es igual al indice cero del array, nos daria un error, por que necesitamos inicializarla, al menos con el valor cero.
		T elementoMenor=a[0];
		// la i es 1 y no cero, por que la posicion 0, ya la tengo almacenada en elementoMenor.
		for(int i=1;i<a.length;i++) {
			// aqui el asistente de eclipse no nos ayuda, por que es de tipo generico.
			if(elementoMenor.compareTo(a[i])>0) {
				elementoMenor=a[i];
			}
		}
		return elementoMenor;
	}
}
class Empleado2{
	private String nombre;
	public Empleado2(String nombre) {
		this.nombre=nombre;
	}
	public String dameNombre() {
		return nombre;
	}
}