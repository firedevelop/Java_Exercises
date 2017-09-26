package video_156_Streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lectura_Escritura{
	public static void main(String[]args) {
		// este contador nos permitira saber cuantos bytes forman la imagen
		int contador=0;
		// ARRAY PARA ALMACENAR LOS BYTES y luego ser capaces de construir una replica de la imagen almacenada en el array
		int datos_entrada[]=new int [7448];
		try {
			FileInputStream archivo_lectura=new FileInputStream("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_156_Streams/imagen.jpg");
			boolean final_ar=false;
			while(!final_ar) {
				// este metodo cuando llega al final devuelve -1
				int byte_entrada=archivo_lectura.read();
				// si el byte es -1, es decir el último byte, le decimos que no lo meta dentro del array para que no forme parte de la imagen
				if(byte_entrada!=-1)
					datos_entrada[contador]=byte_entrada;
				//if(byte_entrada==-1)
				else
					// asi le indicamos que el archivo a llegado al final y asi se para el while
					final_ar=true;
					System.out.println(datos_entrada[contador]);
					contador++;
			}
			archivo_lectura.close();
		}catch(IOException e) {
			System.out.println("Error al acceder a la imagen");
			
		}
		System.out.println(contador);
		crea_fichero(datos_entrada);
	}
	static void crea_fichero(int datos_nuevo_fichero[]) {
		try {
			//FileOutputStream construye un flujo de datos a traves del cual es posible que viaje un objeto
			FileOutputStream fichero_nuevo=new FileOutputStream("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_156_Streams/imagen_copia.jpg");
			for(int i=0;i<datos_nuevo_fichero.length;i++) {
				fichero_nuevo.write(datos_nuevo_fichero[i]);
			}
			fichero_nuevo.close();
		}catch (IOException e) {
			System.out.println("Error al crear el archivo");
		}
	}
}