package test;

import java.util.LinkedList;

public class UsoEmpleado{
	public static void main(String[]args) {
		LinkedList<String> l=new LinkedList<String>();
		l.add("1");
		l.add("2");
		l.add("3");
		System.out.println(l);
		
		l.addFirst("first");
		l.addLast("last");
		System.out.println(l);
	}
}