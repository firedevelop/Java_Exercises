package video_163_Progarmacion_Generica_ArrayList;
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
Iterator<Empleado> mi_iterador=listaEmpleados.iterator();
while(mi_iterador.hasNext()) {
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