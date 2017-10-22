package video_183_IMPORTANTE_Colecciones_Iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class UsoEmpleado{
	public static void main(String[]args) {
		Empleado misEmpleados1=new Empleado("Ana","00001");
		Empleado misEmpleados2=new Empleado("Juan","00002");
		Empleado misEmpleados3=new Empleado("Jose","00003");
		Empleado misEmpleados4=new Empleado("Maria","00004");
		Empleado misEmpleados5=new Empleado("Juan","00001");
		Set<Empleado> h=new HashSet<Empleado>();
		h.add(misEmpleados1);
		h.add(misEmpleados2);
		h.add(misEmpleados3);
		h.add(misEmpleados4);
		h.add(misEmpleados5);
		
		System.out.println("NOTAS: EL CLIENTE 5 NUNCA SE IMPRIME POR QUE EL METODO SET NO IMPRIME DUPLICADOS");	
		System.out.println("\nEJEMPLO 1: FUNCIONA CON UN SIMPLE BUCLE FOR");	
		for(Empleado e:h) {
			System.out.println("hashCode: "+e.hashCode()+" "+e.dameNombre()+" "+e.dameSueldo());
		}

		System.out.println("\nEJEMPLO 2: FUNCIONA PERO SOLO PARA IMPRIMIR 1 CAMPO \n(debido a que si usamos 2 veces next no vuelve atras sino que muestra la siguiente posicion).");
		Iterator<Empleado> it2=h.iterator();
		while(it2.hasNext()) {
			String nombre=it2.next().dameNombre();
			System.out.println(nombre);
		}
		System.out.println("\nEJEMPLO 3: NO FUNCIONA \n(para imprimir 2 campos mejor usar un bucle for).");
		Iterator<Empleado> it3=h.iterator();
		while(it3.hasNext()) {
			String nombre=it3.next().dameNombre();
			System.out.println(nombre);
			String sueldo=it3.next().dameSueldo();
			System.out.println(sueldo);
		}
		System.out.println("\nEJEMPLO 4: FUNCIONA \n(eliminar un objeto de la coleccion.)");		
		Iterator<Empleado> it4=h.iterator();
		while(it4.hasNext()){
			String nombre=it4.next().dameNombre();
			if(nombre.equals("Maria")) {
				it4.remove();
			}	
		}
		for(Empleado e:h) {
			System.out.println(e.dameNombre()+e.dameSueldo());
		}
		
		System.out.println("\nEJEMPLO 5: NO FUNCIONA \n(Intentamos eliminar un objeto. Pero si lo probamos aislado este ejercicio veremos que nos lanza una Excepcion llamada ConcurrentModificationException por que no podemos modificar una coleccion al mismo tiempo que la recorremos, es un problema de concurrencia.");
		for(Empleado e:h) {
			if(e.dameNombre().equals("Maria")) {
				h.remove(e);
			}
		}
		for(Empleado e:h) {
			System.out.println(e.dameNombre()+e.dameSueldo());
		}	
	}
}