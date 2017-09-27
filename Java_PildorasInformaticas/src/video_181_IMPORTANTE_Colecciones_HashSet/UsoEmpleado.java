package video_181_IMPORTANTE_Colecciones_HashSet;
import java.util.HashSet;
import java.util.Set;

public class UsoEmpleado{
	public static void main(String[]args) {
		Empleado misEmpleados1=new Empleado("Ana", 1000);
		Empleado misEmpleados2=new Empleado("Juan", 2000);
		Empleado misEmpleados3=new Empleado("Maria", 3000);
		Empleado misEmpleados4=new Empleado("Jose", 4000);
		Empleado misEmpleados5=new Empleado("Jose", 4000);
		Set<Empleado> h=new HashSet<Empleado>();
		h.add(misEmpleados1);
		h.add(misEmpleados2);
		h.add(misEmpleados3);
		h.add(misEmpleados4);
		h.add(misEmpleados5);
		
		for(Empleado e:h) {
			System.out.println("Nombre: "+e.dameNombre() + " Sueldo: "+e.dameSueldo() +" hashCode: "+ e.hashCode());
		}
	}
}