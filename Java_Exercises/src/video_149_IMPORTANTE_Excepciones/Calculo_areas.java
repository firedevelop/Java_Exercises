// Source: https://youtu.be/ywNucPv6flI?list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
package video_149_IMPORTANTE_Excepciones;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Calculo_areas{
	static int figura;
	public static void main(String[] args){
		Scanner entrada=new Scanner(System.in);
		System.out.println("Elige una opción \n1. Cuadrado \n2. Rectangulo \n3. Triangulo \n4. Circulo \n5. Division");
		try {
		figura=entrada.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("ERROR: debes introducir un numero entero.\n");
			// helpfull to show Exceptions information for developers
			System.out.print("______________________________________________\n");
			System.out.print("Mensaje de Excepcion: " + e.getMessage() + "\n");
			System.out.print("Clase que ha generado la Excepcion: " + e.getClass().getName() + "\n");
			e.printStackTrace();
		}finally {
			entrada.close();
		}
		try {		
		switch (figura) {
		case 1:	
			int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
			System.out.println(Math.pow(lado, 2));
			break;

		case 2:
			int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
			int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			System.out.println("El area del rectangulo es: " + base*altura);
			break;
		
		case 3:
			base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			System.out.println("El area del triangulo es: " + (base*altura/2));
			break;
		
		case 4:
			int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
			System.out.println("El area del circulo es: ");
			System.out.println(Math.PI*(Math.pow(radio, 2)));
			break;
		case 5:
			try {
			int num1=Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
			int num2=Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));
			System.out.println("El resultado es:" + num1/num2); 
			break;
			}catch (ArithmeticException e) {
				System.out.println("ERROR: introduce divisor mayor que 0. ");
				break;
			}
		default:
			System.out.println("ERROR: debes de escoger una de las opciones.");
		}
		}catch (NumberFormatException e) {
			System.out.println("ERROR: debes introducir un numero entero.");
		}
	}
}