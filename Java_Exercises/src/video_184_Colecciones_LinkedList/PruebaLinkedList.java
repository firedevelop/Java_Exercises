package video_184_Colecciones_LinkedList;
import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaLinkedList{
	public static void main(String[]args) {
		LinkedList<String> personas=new LinkedList<String>();
		personas.add("Pepe");
		personas.add("Sandra");
		personas.add("Ana");
		personas.add("Laura");
		System.out.println("Elementos hasta el momento: "+personas.size());
		
		// esta interfaz que hereda de iterator nos permite movernos libremente por los nodos.
		ListIterator<String> it=personas.listIterator();
		// con este next() lo que hacemos es que cuando llegue aqui, el iterador se mueva de la posicio 0 en la que estaba cuando comienza a la posicion 1
		it.next();
		// esta nueva persona "Juan" la vamos a añadir en la posicion 1
		it.add("Juan (movido a la posicion [1] con next)");
		for(String persona:personas) {
			System.out.println(persona);
		}
		
	}
}