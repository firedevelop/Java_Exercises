package video_154_Streams;
import java.io.BufferedReader;
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
		FileReader entrada=new FileReader("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_154_Streams/ejemplo2.txt");
		//si no igualamos la c a cero, cuando entre en while será igual a 1, y por lo tanto se comería el primer caracter del texto. Ahora cuando entra en while lo hace como 1 y entonces se pone a leer el primer caracter.
		BufferedReader mibuffer=new BufferedReader(entrada);
		String linea="";
		// ya no hace falta.
		//int c=0;
		// el método .read() devuelve -1 cuando llega al final, por lo tanto no va a parar de leer caracteres hasta que no se lance un -1
		// nos aseguramos de que la linea que va a leer no sea nula.
		while(linea!=null) {
			//aqui almacenamos dentro de c los caracteres
			linea=mibuffer.readLine();
			// esto evita que se imprima la palabra null cuando llegue al final
			if(linea!=null) {
			System.out.println(linea);
			}
		}entrada.close();
		}catch (IOException e) {
			System.out.println("No se ha entrado el archivo");
		}
	}
}