package test;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class test{
	static int figura;
	public static void main(String[]args) {
		Scanner entrada=new Scanner(System.in);
		System.out.println("1.square 2. rectangle 3. triangle 4 circl 5 division");
		try {
			figura=entrada.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("tiene que ser int");
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getName());
			e.printStackTrace();
		}
		
	}
	
}