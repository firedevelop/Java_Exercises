package video_146_Excepciones;
import java.io.EOFException;
import javax.swing.JOptionPane;

public class Comprueba_mail{
	public static void main(String[] args) {
		String el_mail=JOptionPane.showInputDialog("Introduce mail");
		// esta no es una buena práctica de programacion, pero lo hacemos asi por que queremos forzar la captura de una excepcion controlada.
		// debido a que es un error controlado, estamos obligados a declara el try catch	
		try {
				examina_email(el_mail);
			}
			catch(EOFException e) {
				 System.out.print("email incorrecto");
			}
		}
	// este throws es una declaración del método para indicar que lanza una excepcion.
	// Además aqui declaramos este throws para indicar a los programadores que podría lanzarse una excepción
	static void examina_email(String mail) throws EOFException{
		int arroba=0;
		boolean punto=false;
		if(mail.length()<=3) {
			// este throw lanza una excepción de forma manual en un punto concreto del programa
			throw new EOFException();
		}
		else {
			for(int i=0; i<mail.length();i++) {
				if(mail.charAt(i)=='@') {
					arroba++;
				}
				if(mail.charAt(i)=='.') {
					punto=true;
				}
			}
			if(arroba==1 && punto==true) {
				System.out.println("Es correcto");
			}
			else {
				System.out.println("No es correcto");
			}
		}
	}
}
public class ExceptionLessOne extends Exception {

}