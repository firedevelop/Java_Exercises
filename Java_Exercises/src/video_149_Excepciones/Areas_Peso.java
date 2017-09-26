package video_149_Excepciones;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Areas_Peso{
	static int figura;
	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Elige una opción \n1. Cuadrado \n2. Rectangulo \n3. Triangulo \n4. Circulo");
		try {
		figura=entrada.nextInt();

		}catch (Exception e) {
			// aqui capturamos la Excepcion por si alguien en lugar de introducir un numero en las opciones, introduce un String
			System.out.println("Ha ocurrido un error");
		}finally {
			// aqui cerramos la conexion con Scanner por que no la vamos a necesitar mas, pues si no la cerramos consume recursos del sistema.
			// Lo que introduzcas en FINALLY siempre se ejecuta. Si no lo hiciésemos así y pusieramos el entradaclose() dentro del TRY, la conexion no se cerraría en el caso de que en lugar del TRY se ejecutase el CATCH
			entrada.close();
		}
		
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
		default:
			System.out.println("La opcion no es correcta");
	}
		int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura en cm"));
		System.out.println("Si eres hombre tu peso ideal es: " + (altura-110) + " kg");
		System.out.println("Si eres mujer tu peso ideal es: " + (altura-120) + " kg");
}
}