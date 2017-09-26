package video_185_Colecciones_LinkedList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


public class PruebaListaEnlazada{
	public static void main(String[]args) {
		LinkedList<String> paises=new LinkedList<String>();
		paises.add("España");
		paises.add("Colombia");
		paises.add("Mexico");
		paises.add("Peru");
		
		LinkedList<String> capitales=new LinkedList<String>();
		paises.add("Madrid");
		paises.add("Bogota");
		paises.add("DF");
		paises.add("Lima");
		
		System.out.println(paises);
		System.out.println(capitales);
	}
}