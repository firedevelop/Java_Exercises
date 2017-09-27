// ejemplo de metodo generico. Primero devuelve el menor valor del array misEmpleados, que es un String. Y después muestra el menor valor de un objeto Date, no importa que salga un poco raro al hacer print. 
package video_167_03_IMPORTANTE_Metodos_Genericos;
import java.util.GregorianCalendar;

public class UsoEmpleado{
	public static void main(String[]args) {
		String misEmpleados[]= {"Maria","Asun","Jose"};
		System.out.println(Empleado.menor(misEmpleados));
		GregorianCalendar altaContrato[]= {new GregorianCalendar(2015,9,7),
				new GregorianCalendar(2015,0,21),
				new GregorianCalendar(2015,1,11)
		};
		System.out.println(Empleado.menor(altaContrato).getTime());
	}
}

class Empleado{
	public static <T extends Comparable>  T menor(T[]array) {
		if(array==null || array.length==0) {
			return null;
		}
		T elementoMenor=array[0];
		for(int i=1;i<array.length;i++) {
			if(elementoMenor.compareTo(array[i])>0) {
				elementoMenor=array[i];
			}
		}
		return elementoMenor;
	}
}