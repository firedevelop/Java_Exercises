package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UsoEmpleado{
	public static void main(String[]args) {
		Empleado misEmpleados1=new Empleado("Juan", "2000");
		Empleado misEmpleados2=new Empleado("Maria", "3000");
		Set<Empleado> h=new HashSet<Empleado>();
		h.add(misEmpleados1);
		h.add(misEmpleados2);
		Iterator<Empleado> it1=h.iterator();
		while(it1.hasNext()) {
			String nombre=it1.next().dameNombre();
			if(nombre.equals("Maria")) {
				it1.remove();
			}
		}
		for(Empleado e:h) {
			System.out.println(e.dameNombre()+e.dameSueldo());
		}
		
	}
}