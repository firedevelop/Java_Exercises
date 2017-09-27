package video_182_IMPORTANTE_Colecciones_equals;
import java.util.HashSet;
import java.util.Set;

public class UsoEmpleado{
	public static void main(String[]args) {
		Empleado misEmpleados1=new Empleado("Ana");
		Empleado misEmpleados2=new Empleado("Juan");
		Empleado misEmpleados3=new Empleado("Maria");
		System.out.println("***** EJEMPLO 1: comparacion basada en metodo equals");
		if(misEmpleados1.equals(misEmpleados2)) {
			System.out.println("misEmpleados1:"+misEmpleados1.dameNombre()+" ES IGUAL A"+" misEmpleados2:"+misEmpleados2.dameNombre());
		}else {
			System.out.println("misEmpleados1:"+misEmpleados1.dameNombre()+" ES DIFERENTE A"+" misEmpleados2:"+misEmpleados2.dameNombre());
		}
		misEmpleados1=misEmpleados2;
		if(misEmpleados1.equals(misEmpleados2)) {
			System.out.println("misEmpleados1:"+misEmpleados1.dameNombre()+" ES IGUAL A"+" misEmpleados2:"+misEmpleados2.dameNombre());
		}else {
			System.out.println("misEmpleados1:"+misEmpleados1.dameNombre()+" ES DIFERENTE A"+" misEmpleados2:"+misEmpleados2.dameNombre());
		}
		System.out.println("\n***** EJEMPLO 2: comparacion basada hashCode");
		if(misEmpleados1==misEmpleados3) {
			System.out.println("misEmpleados1:"+misEmpleados1.dameNombre()+misEmpleados1.hashCode()+" ES IGUAL A"+" misEmpleados3:"+misEmpleados3.dameNombre()+misEmpleados3.hashCode());
		}else {
			System.out.println("misEmpleados1:"+misEmpleados1.dameNombre()+misEmpleados1.hashCode()+" ES DIFERENTE A"+" misEmpleados3:"+misEmpleados3.dameNombre()+misEmpleados3.hashCode());
		}
		misEmpleados1=misEmpleados3;
		if(misEmpleados1==misEmpleados3) {
			System.out.println("misEmpleados1:"+misEmpleados1.dameNombre()+misEmpleados1.hashCode()+" ES IGUAL A"+" misEmpleados3:"+misEmpleados3.dameNombre()+misEmpleados3.hashCode());
		}else {
			System.out.println("misEmpleados1:"+misEmpleados1.dameNombre()+misEmpleados1.hashCode()+" ES DIFERENTE A"+" misEmpleados3:"+misEmpleados3.dameNombre()+misEmpleados3.hashCode());
		}
	}
}