package video_187_Colecciones_TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class Prueba_TreeSet{
	public static void main(String[]args) {
		TreeSet<String> ordenaPersonas=new TreeSet<String>();
		ordenaPersonas.add("Sandra");
		ordenaPersonas.add("Amanda");
		ordenaPersonas.add("Diana");
		// el resultado saldra ordenado alfabeticamente debido a que String implementa la interfaz Comparable la cual tiene el metodo ComparteTo en su interior
		System.out.println("EJEMPLO 1: los ordena automaticamente por orden alfabetico.");
		for(String s:ordenaPersonas) {
			System.out.println(s);
		}
		Articulo primero=new Articulo(1, "Primer articulo");
		Articulo segundo=new Articulo(200, "Segundo articulo");
		Articulo tercer=new Articulo(3, "Este es el Tercer articulo");
		TreeSet<Articulo> ordenaArticulos=new TreeSet<Articulo>();
		ordenaArticulos.add(tercer);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		System.out.println("\nEJEMPLO 2: los ordenamos por numero_articulo");
		for(Articulo art:ordenaArticulos) {
			System.out.println(art.getDescription());
		}
		System.out.println("\nEJEMPLO 3: los ordenamos por descripcion alfabeticamente");
		Articulo comparadorArticulos=new Articulo();
		TreeSet<Articulo> ordenaArticulos2=new TreeSet<Articulo>(comparadorArticulos);
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercer);
		for(Articulo art:ordenaArticulos2) {
			System.out.println(art.getDescription());
		}
	}
}
// como sabes en Java no se permite la herencia multiple, pero si que puedes implementar varias interafces, que es lo que haremos aqui
class Articulo implements Comparable<Articulo>, Comparator<Articulo>{
	// este metodo lo creamos simplemente para no tener que pasarle ningun parametro al objeto comparadorArticulos, ya que solo queremos que compare
	public Articulo() {	
	}
	
	public Articulo(int num,String desc) {
		numero_articulo=num;
		description=desc;
	}
	public int compareTo(Articulo o) {
		return numero_articulo - o.numero_articulo;
	}
	public String getDescription() {
		return description;
	}
	private int numero_articulo;
	private String description;
	@Override
	// aqui al igual que CompareTo, el metodo Compare nos devolverá un positivo, negativo o un cero en base a si es mayor, menor o igual. 
	public int compare(Articulo arg0, Articulo arg1) {
		String descripcionA=arg0.getDescription();
		String descripcionB=arg1.getDescription();
		return descripcionA.compareTo(descripcionB);
	}
}