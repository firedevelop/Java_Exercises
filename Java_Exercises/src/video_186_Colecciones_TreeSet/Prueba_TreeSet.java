package video_186_Colecciones_TreeSet;

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
		Articulo tercer=new Articulo(3, "Tercer articulo");
		TreeSet<Articulo> ordenaArticulos=new TreeSet<Articulo>();
		ordenaArticulos.add(tercer);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		System.out.println("\nEJEMPLO 2: los ordenamos por numero_articulo");
		for(Articulo art:ordenaArticulos) {
			System.out.println(art.getDescription());
		}
	}
}
class Articulo implements Comparable<Articulo>{
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
}