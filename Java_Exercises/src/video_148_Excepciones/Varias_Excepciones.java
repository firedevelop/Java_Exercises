package video_148_Excepciones;
//en este app vemos como se puden usar varios catch y además tambien mostrar errores
import java.util.jar.JarOutputStream;
import javax.swing.JOptionPane;
public class Varias_Excepciones{
	public static void main(String[] args) {
		try {
		division();
		}catch(ArithmeticException e) {
			System.out.println("Estas dividiendo por 0");
		}catch(NumberFormatException e) {
			System.out.println("No has introducido un numero entero");
			// esta excepcion te mostrara un mensaje de error que ayudara al programador. Concretamente si introduces un string te dirá "For input string"
			System.out.print("Mensaje de Excepcion: " + e.getMessage() + "\n");
			System.out.print("Clase que ha generado la Excepcion: " + e.getClass().getName());
		}
		
	}
	static void division() {
		int num1=Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
		int num2=Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));
		System.out.println("El resultado es:" + num1/num2); 
	}
}