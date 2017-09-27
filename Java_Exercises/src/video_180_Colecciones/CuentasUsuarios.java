package video_180_Colecciones;

import java.util.HashSet;
import java.util.Set;

public class CuentasUsuarios{
	public static void main(String[]args) {
		Cliente cl1=new Cliente("Antonio Banderas","00001",200000);
		Cliente cl2=new Cliente("Rafael Nadal","00002",250000);
		Cliente cl3=new Cliente("Penelope Cruz","00003",300000);
		Cliente cl4=new Cliente("Julio Iglesias","00004",500000);
		Set<Cliente> clientesBanco=new HashSet<Cliente>();
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		// esto es como un bucle for-each, pero en java no tiene "each" como otros lenguajes de programacion y se escribe asi.
		for(Cliente cliente:clientesBanco) {
			System.out.println(cliente.getNombre()+" "+cliente.getN_cuenta()+" "+cliente.getSaldo());
		}
	}
}