package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import video_181_Colecciones.Cliente;


public class test{
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
		
		
		System.out.println("\nEJEMPLO 5: FUNCIONA \n(eliminar un objeto de la coleccion.");		
		Iterator<Cliente> it5=clientesBanco.iterator();
		while(it5.hasNext()){
			String nombre_clientes=it5.next().getNombre();
			if(nombre_clientes.equals("Julio Iglesias")) {
				it5.remove();
			}	
		}
		for(Cliente cliente5:clientesBanco) {
			System.out.println(cliente5.getNombre()+cliente5.getN_cuenta()+cliente5.getSaldo());
		}
		
		
	}
}