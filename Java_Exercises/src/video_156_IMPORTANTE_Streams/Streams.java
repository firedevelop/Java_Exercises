// ejecicios de Streams, Serializacion y CRUD de archivos y directorios
package video_156_IMPORTANTE_Streams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Streams{
	public static void main(String[] args) throws ClassNotFoundException {
		leeByte accedeByte=new leeByte();
		leeCaracter accedeCaracter=new leeCaracter();
		leeLinea accedeLinea=new leeLinea();
		escribe accedeescribe=new escribe();
		imagen accedeimagen=new imagen();
		accedeByte.setter_leeByte();
		accedeCaracter.setter_leeCaracter();
		accedeLinea.setter_leeLinea();
		accedeescribe.setter_escribe();
		accedeimagen.setter_leeImagen();
		
		Empleado[] misEmpleados=new Empleado[3];
		misEmpleados[0]=new Empleado("Ana",1000);
		misEmpleados[1]=new Empleado("Maria",2000);
		misEmpleados[2]=new Empleado("Juan",3000);
		
		// Method File: CRUD
		try {
			ObjectOutputStream escribe=new ObjectOutputStream(new FileOutputStream("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_156_Streams_IMPORTANTE/empleado.dat"));
			escribe.writeObject(misEmpleados);
			escribe.close();
			ObjectInputStream lee=new ObjectInputStream(new FileInputStream("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_156_Streams_IMPORTANTE/empleado.dat"));
			Empleado[] empleado_recuperado;
			empleado_recuperado = (Empleado[])lee.readObject();
			lee.close();
				for(Empleado e: empleado_recuperado) {
					System.out.println(e);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("*********** EXAMPLE: String getAbsolutePath() and Boolean exists()  ***********");
		File archivo=new File("video_159_File");
		System.out.println(archivo.getAbsolutePath());
		System.out.println(archivo.exists());
		
		System.out.println("*********** EXAMPLE: String[] list() and String  ***********");
		File ruta=new File(File.separator+"Users"+File.separator+"Production"+File.separator+"Tharpa"+File.separator+"VARIOS"+File.separator+"Github"+File.separator+"Java_Exercises"+File.separator+"video_156_Streams_IMPORTANTE");
		System.out.println(ruta.getAbsolutePath());
		String[] nombres_archivos=ruta.list();
		for(int i=0;i<nombres_archivos.length;i++) {
			System.out.println(nombres_archivos[i]);
		}	
		
		System.out.println("*********** EXAMPLE: Boolean isDirectory()  ***********");
		for(int i=0;i<nombres_archivos.length;i++) {
			System.out.println(nombres_archivos[i]);
			File f=new File(ruta.getAbsolutePath(),nombres_archivos[i]);
			if(f.isDirectory()) {
				String[] archivos_subcarpeta=f.list();
				for(int j=0;j<archivos_subcarpeta.length;j++) {
					System.out.println("archivos subcarpetas: " + archivos_subcarpeta[j]);
				}
			}
		}
		System.out.println("*********** EXAMPLE : Crear directorios y archivos ***********");
		File ruta2=new File(File.separator+"Users"+File.separator+"Production"+File.separator+"Tharpa"+File.separator+"VARIOS"+File.separator+"Github"+File.separator+"Java_Exercises"+File.separator+"video_156_Streams_IMPORTANTE"
		+File.separator+"nuevo_directorio");
		ruta2.mkdir();
		File ruta3=new File(File.separator+"Users"+File.separator+"Production"+File.separator+"Tharpa"+File.separator+"VARIOS"+File.separator+"Github"+File.separator+"Java_Exercises"+File.separator+"video_156_Streams_IMPORTANTE"
		+File.separator+"texto_nuevo.txt");
		String archivo_destino=ruta3.getAbsolutePath();
		try {
			ruta3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Escribiendo accede_es=new Escribiendo();
		accede_es.escribir(archivo_destino);
	}
}



class leeByte{
	public void setter_leeByte() {
		try {
			FileReader archivo=new FileReader("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_156_Streams_IMPORTANTE/texto1.txt");
			int c=archivo.read();
			while(c!=-1) {
				c=archivo.read();
				System.out.println("leeByte: " + c);
			}
		} catch (IOException e) {
			System.out.println("No se ha entrado el archivo");
		}
	}
}
class leeCaracter{
	public void setter_leeCaracter() {
		try {
		FileReader archivo=new FileReader("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_156_Streams_IMPORTANTE/texto1.txt");
		int c=0;
		while(c!=-1) {
			c=archivo.read();
			char caracter=(char)c;
			System.out.print(caracter);
		}archivo.close();
		}catch (IOException e) {
			System.out.println("No se ha entrado el archivo");
		}
	}
}
class leeLinea{
	public void setter_leeLinea() {
		try {
		FileReader archivo=new FileReader("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_156_Streams_IMPORTANTE/texto2.txt");
		BufferedReader mibuffer=new BufferedReader(archivo);
		String linea="";
		System.out.println("\n");
		while(linea!=null) {
			linea=mibuffer.readLine();
			System.out.println(linea);
		}archivo.close();
		}catch (IOException e) {
			System.out.println("No se ha entrado el archivo");
		}
	}
}
class escribe{
	public void setter_escribe() {
		String frase="Esto es una prueba de escritura2";	
		try {
			FileWriter archivo=new FileWriter("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_156_Streams_IMPORTANTE/texto3.txt", true);
			for(int i=0;i<frase.length();i++) {
				archivo.write(frase.charAt(i));
			}
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class imagen{
	public void setter_leeImagen() {
		int contador=0;
		int array[]=new int [7448];
		try {
			FileInputStream archivo=new FileInputStream("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_156_Streams_IMPORTANTE/imagen.jpg");
			boolean c=false;
			while(!c) {
				int bytes=archivo.read();
				if(bytes!=-1)
					array[contador]=bytes;
				else
					c=true;
					contador++;
			}
			System.out.println("leeImagen: OK");
			archivo.close();
		}catch(IOException e) {
			System.out.println("Error al acceder a la imagen");
			
		}
		System.out.println("Contador: " + contador + " bytes");
		setter_duplicaImagen(array);
	}


		public void setter_duplicaImagen(int array[]) {
			try {
				FileOutputStream archivo=new FileOutputStream("/Users/Production/Tharpa/VARIOS/Github/Java/Java/src/video_156_Streams_IMPORTANTE/imagen_copia.jpg");
				for(int i=0;i<array.length;i++) {
					archivo.write(array[i]);
				}
				archivo.close();
				System.out.println("duplicaImagen: OK");
			}catch (IOException e) {
				System.out.println("Error al crear el archivo");
			}
		}
}
class Empleado implements Serializable{
	private static final long serialVersionUID = 388758269013393354L;
	private String nombre;
	private double sueldo;
		
	public Empleado(String nom,double sue) {
		nombre=nom;
		sueldo=sue;
		}
		public String toString() {
			return "Nombre:" + nombre + " Sueldo: " + sueldo;
			}
}
class Escribiendo{
	public void escribir(String ruta_archivo) {
		String frase="Esto es un ejemplo";
		try {
			FileWriter escritura=new FileWriter(ruta_archivo);
			for(int i=0;i<frase.length();i++) {
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		} catch (IOException e) {
		}
	}
}

class Eliminar{
	public static void main(String[]args) {
		File ruta=new File(File.separator+"Users"+File.separator+"Production"+File.separator+"Tharpa"+File.separator+"VARIOS"+File.separator+"Github"+File.separator+"Java_Exercises"+File.separator+"video_156_Streams_IMPORTANTE"
				+File.separator+"texto_nuevo2.txt");
		ruta.delete();
	}
	
}