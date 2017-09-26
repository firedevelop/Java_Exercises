package video_166_Programacion_Generica;
import java.util.GregorianCalendar;

public class MetodosGenericos{
	public static void main(String[]args) {
		String nombres[]= {"Maria","Pepe","Jose"};
		System.out.println(MisMatrices.getMenor(nombres));
		GregorianCalendar fechas[]= {new GregorianCalendar(2015,07,12),
				new GregorianCalendar(2015,05,12),
				new GregorianCalendar(2015,04,12),
		};
		System.out.println(MisMatrices.getMenor(fechas));
	}
}
class MisMatrices{
	public static <T extends Comparable> T getMenor(T[]a) {
		if(a==null || a.length==0) {
			return null;
		}
		T elementoMenor=a[0];
		for(int i=1;i<a.length;i++) {
			if(elementoMenor.compareTo(a[i])>0) {
				elementoMenor=a[i];
			}
		}
		return elementoMenor;
	}
}
class Empleado{
	private String nombre;
	public Empleado(String nombre) {
		this.nombre=nombre;
	}
	public String dameNombre() {
		return nombre;
	}
}