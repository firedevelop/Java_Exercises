package video_162_Progarmacion_Generica_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

class UsoEmpleado{
public static void main(String[]args) {
ArrayList<Empleado> misEmpleados=new  ArrayList<Empleado>();
// ensureCapacity se usa si sabes el numero fijo de elementos del array
misEmpleados.ensureCapacity(11);
misEmpleados.add(new Empleado("Ana",45,2500));
misEmpleados.add(new Empleado("Antonio",55,2000));
misEmpleados.add(new Empleado("María",25,2600));
misEmpleados.add(new Empleado("Jose",35,2200));
misEmpleados.add(new Empleado("Josep",45,2500));
misEmpleados.add(new Empleado("Antonio",55,2000));
misEmpleados.add(new Empleado("María",25,2600));
misEmpleados.add(new Empleado("Jose",35,2200));
misEmpleados.add(new Empleado("Ana",45,2500));
misEmpleados.add(new Empleado("Antonio",55,2000));
misEmpleados.add(new Empleado("María",25,2600));

misEmpleados.trimToSize();
misEmpleados.add(new Empleado("Olga",25,2600));
System.out.println("********* Ejemplo con Bucle for mejorado\n");

	for(Empleado e:misEmpleados) {
		System.out.println(e.toString());
	}

System.out.println("********* En la Posicion 4 esta: " + misEmpleados.get(4));
System.out.println("********* Cantidad de elementos del Array: "+misEmpleados.size());
// como los Arrayslist no tienen indices, tenemos que usar size() para recorrer el array.
System.out.println("********* Ejemplo con Bucle convencional \n");
	for(int i=0; i<misEmpleados.size();i++) {
		Empleado e=misEmpleados.get(i);
		System.out.println(e.toString());
	}
System.out.println("********* Ejemplo copiando lo que hay en el ArryaList y luego recorrerlo \n");
	Empleado array[]=new Empleado[misEmpleados.size()];
	misEmpleados.toArray(array);
	for(int i=0;i<array.length;i++) {
		System.out.println(array[i].toString());
		// otra forma de imprimir el array:
		System.out.print(misEmpleados.get(i)+"\n");
	}
	System.out.println("********* Ejemplo iterator \n");
	//Iterator es el encargado de recorrer elemento a elemento el array
	// <Empleado> muestra el tipo de objeto que va a manejar el Iterador
	// misEmpleados es el ArrayList
	// .iterator() es el metodo que nos devuelve un objeto de tipo iterator. Y este objeto de tipo iterator, lo estamos guardando en la variable misEmpleados
	Iterator<Empleado> mi_iterador=misEmpleados.iterator();
	//hasNext() nos devuelve true mientras que el iterador "mi_iterator" tenga elementos
	while(mi_iterador.hasNext()) {
		System.out.println("El iterator es: " + mi_iterador.next());
		// next() va recorriendo cada indice del array
		System.out.println(mi_iterador.next());

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