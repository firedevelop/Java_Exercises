package video_155_Streams;

import java.io.FileInputStream;
import java.io.IOException;

public class Lectura_Escritura{
	public static void main(String[]args) {
		// este contador nos permitira saber cuantos bytes forman la imagen
		int contador=0;
		// ARRAY PARA ALMACENAR LOS BYTES y luego ser capaces de construir una replica de la imagen almacenada en el array
		int datos_entrada[]=new int [7448];
		try {
			FileInputStream archivo_lectura=new FileInputStream("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_155_Streams/imagen.jpg");
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
		}catch(IOException e) {}
		System.out.println(contador);
	}}