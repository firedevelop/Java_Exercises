//app que te pregunta cuantos numeros aleatorios deseas y te los muestra en pantalla
package video_150_IMPORTANTE_Debugger;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Aleatorios2{
	public static void main(String[] args) {
		System.out.println("Introduce elementos de la matriz");
		Scanner num=new Scanner(System.in);
		int elementos=num.nextInt();
		
		int matriz[]=new int[elementos];
		for (int i=0;i<matriz.length;i++) {
			matriz[i]=(int)(Math.random()*100);
		}
		for(int elem: matriz) {
			System.out.println(elem);	
		}
	}
}