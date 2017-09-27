package video_151_Streams;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Acceso_Fichero{
	public static void main(String[] args) {
		Leer_Fichero accediendo=new Leer_Fichero();
		// accediendo es una variable de instancia.
		accediendo.lee();
	}
}
class Leer_Fichero{
	public void lee() {
		try {
		FileReader entrada=new FileReader("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_151_Streams/ejemplo.txt");
		int c=entrada.read();
		// el método .read() devuelve -1 cuando llega al final, por lo tanto no va a parar de leer caracteres hasta que no se lance un -1
		while(c!=-1) {
			//aqui almacenamos dentro de c los caracteres
			c=entrada.read();
			// convertimos los numero a caracteres por sino como humanos no podemos leerlo.
			// prueba a comentar esta linea si deas ver los caracteres
			// hacemos un casting para que se pueda entender el texto
			char letra=(char)c;
			System.out.print(letra);
		}
		}catch (IOException e) {
			System.out.println("No se ha entrado el archivo");
		}
	}
}