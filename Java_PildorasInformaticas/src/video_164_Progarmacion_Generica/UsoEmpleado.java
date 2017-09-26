package video_164_Progarmacion_Generica;

import java.util.ArrayList;
import java.util.Iterator;

class UsoEmpleado{
public static void main(String[]args) {
ArrayList<Empleado> listaEmpleados=new  ArrayList<Empleado>();
// ensureCapacity se usa si sabes el numero fijo de elementos del array
listaEmpleados.ensureCapacity(11);
listaEmpleados.add(new Empleado("Ana",45,2500));
listaEmpleados.add(new Empleado("Antonio",55,2000));
listaEmpleados.add(new Empleado("María",25,2600));
listaEmpleados.add(new Empleado("Jose",35,2200));
listaEmpleados.add(new Empleado("Josep",45,2500));
listaEmpleados.add(new Empleado("Antonio",55,2000));
listaEmpleados.add(new Empleado("María",25,2600));
listaEmpleados.add(new Empleado("Jose",35,2200));
listaEmpleados.add(new Empleado("Ana",45,2500));
listaEmpleados.add(new Empleado("Antonio",55,2000));
listaEmpleados.add(new Empleado("María",25,2600));

listaEmpleados.trimToSize();
listaEmpleados.add(new Empleado("Olga",25,2600));
System.out.println("********* Ejemplo con Bucle for mejorado\n");

	for(Empleado e:listaEmpleados) {
		System.out.println(e.toString());
	}

System.out.println("********* En la Posicion 4 esta: " + listaEmpleados.get(4));
System.out.println("********* Cantidad de elementos del Array: "+listaEmpleados.size());
// como los Arrayslist no tienen indices, tenemos que usar size() para recorrer el array.
System.out.println("********* Ejemplo con Bucle convencional \n");
	for(int i=0; i<listaEmpleados.size();i++) {
		Empleado e=listaEmpleados.get(i);
		System.out.println(e.toString());
	}
System.out.println("********* Ejemplo copiando lo que hay en el ArryaList y luego recorrerlo \n");
	Empleado arrayEmpleados[]=new Empleado[listaEmpleados.size()];
	listaEmpleados.toArray(arrayEmpleados);
	for(int i=0;i<arrayEmpleados.length;i++) {
		System.out.println(arrayEmpleados[i].toString());
	}
	System.out.println("********* Ejemplo iterator \n");
	Iterator<Empleado> mi_iterador=listaEmpleados.iterator();
	while(mi_iterador.hasNext()) {
		System.out.println("El iterator es: " + mi_iterador.next());
	}
}
}
class Empleado{
	private String nombre;
	private int edad;
	private double sueldo;
	public Empleado(String nom, int ed,double sue) {
		nombre=nom;
		edad=ed;
		sueldo=sue;
	}
	public String toString() {
		return "Nombre:" + nombre + " Sueldo: " + sueldo;
		}
}