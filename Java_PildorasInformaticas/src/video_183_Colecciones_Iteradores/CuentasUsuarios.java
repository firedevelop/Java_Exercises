package video_183_Colecciones_Iteradores;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class CuentasUsuarios{
	public static void main(String[]args) {
		Cliente cl1=new Cliente("Antonio Banderas","00001",200000);
		Cliente cl2=new Cliente("Rafael Nadal","00002",250000);
		Cliente cl3=new Cliente("Penelope Cruz","00003",300000);
		Cliente cl4=new Cliente("Julio Iglesias","00004",500000);
		Cliente cl5=new Cliente("Antonio Banderas","00001",200000);
		Set<Cliente> clientesBanco=new HashSet<Cliente>();
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		clientesBanco.add(cl5);
		
		System.out.println("NOTAS: EL CLIENTE 5 NUNCA SE IMPRIME POR QUE EL METODO SET NO IMPRIME DUPLICADOS");	
		System.out.println("\nEJEMPLO 1: FUNCIONA CON UN SIMPLE BUCLE FOR");	
		for(Cliente cliente:clientesBanco) {
			System.out.println("hashCode: "+cliente.hashCode()+" "+cliente.getNombre()+" "+cliente.getN_cuenta()+" "+cliente.getSaldo());
		}

		// esto es como un bucle for-each, pero en java no tiene "each" como otros lenguajes de programacion y se escribe asi.
		// por convencion al objeto que estamos aqui creando se le suele llamar "it" pero puedes usar cualquiera.
		//aqui tenemos entonces un iterador que es capaz de recorres los clientesBanco.
		System.out.println("\nEJEMPLO 2: FUNCIONA PERO SOLO PARA IMPRIMIR 1 CAMPO \n(debido a que si usamos 2 veces next no vuelve atras sino que muestra la siguiente posicion).");
		Iterator<Cliente> it2=clientesBanco.iterator();
		while(it2.hasNext()) {
			//next() lo que hace es dar un salto cada vez que lo llamar, y despues lee lo que haya en la posicion que acaba de saltar.
			String nombre_cliente=it2.next().getNombre();
			System.out.println(nombre_cliente);
		}
		System.out.println("\nEJEMPLO 3: NO FUNCIONA \n(para imprimir 2 campos mejor usar un bucle for).");
		Iterator<Cliente> it3=clientesBanco.iterator();
		while(it3.hasNext()) {
			//next() lo que hace es dar un salto cada vez que lo llamar, y despues lee lo que haya en la posicion que acaba de saltar.
			String nombre_cliente3=it3.next().getNombre();
			System.out.println(nombre_cliente3);
			String n_cuenta3=it3.next().getN_cuenta();
			System.out.println(n_cuenta3);
		}
		System.out.println("\nEJEMPLO 4: FUNCIONA \n(eliminar un objeto de la coleccion.)");		
		Iterator<Cliente> it4=clientesBanco.iterator();
		while(it4.hasNext()){
			String nombre_clientes=it4.next().getNombre();
			if(nombre_clientes.equals("Julio Iglesias")) {
				it4.remove();
			}	
		}
		for(Cliente cliente4:clientesBanco) {
			System.out.println(cliente4.getNombre()+cliente4.getN_cuenta()+cliente4.getSaldo());
		}
		
		System.out.println("\nEJEMPLO 5: NO FUNCIONA \n(Intentamos eliminar un objeto. Pero si lo probamos aislado este ejercicio veremos que nos lanza una Excepcion llamada ConcurrentModificationException por que no podemos modificar una coleccion al mismo tiempo que la recorremos, es un problema de concurrencia.");
		for(Cliente cliente5:clientesBanco) {
			if(cliente5.getNombre().equals("Julio Iglesias")) {
				clientesBanco.remove(cliente5);
			}
		}
		for(Cliente cliente5:clientesBanco) {
			System.out.println(cliente5.getNombre()+cliente5.getN_cuenta()+cliente5.getSaldo());
		}	
	}
}