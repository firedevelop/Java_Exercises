package video_147_IMPORTANTE_Excepciones_CompruebaEmail;
import java.io.EOFException;
import javax.swing.JOptionPane;
// Source: https://youtu.be/poq50T99T6o?list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
// en este app vemos como crear excepciones propias
public class Comprueba_mail{
	public static void main(String[] args) {
		String mail=JOptionPane.showInputDialog("Introduce mail");
			try {
				examina_mail(mail);
				}
			catch (Exception e) {
				System.out.println("email debe ser superior a 3 caracteres");
				//util para los programadores quieran mostrar los errores de esta Excepción
				e.printStackTrace();
			}
		}
	static void examina_mail(String mail) throws Longitud_mail_erronea{
		int arroba=0;
		boolean punto=false;
		if(mail.length()<=3) {
			// aqui tienes 2 opciones, llamar al constructor por defecto y saldrá msj_error, o bien personalizar tu mensaje.
			throw new Longitud_mail_erronea();
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
class Longitud_mail_erronea extends Exception{
	// se recomienda que tenga 2 constructores, uno con argumentos y otro sin ellos.
	public Longitud_mail_erronea() {}
	public Longitud_mail_erronea(String msj_error) {
		super(msj_error);
	
	}
}