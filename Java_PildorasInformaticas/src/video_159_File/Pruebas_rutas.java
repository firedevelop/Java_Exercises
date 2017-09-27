package video_159_File;

import java.io.File;import java.io.FileWriter;
import java.io.IOException;

public class Pruebas_rutas{
	public static void main(String[]args) {
		System.out.println("*********** EXAMPLE: String getAbsolutePath() and Boolean exists()  ***********");
		// aqui lo que hace es mirar si en la ruta absoluta (getAbsoluPath) existe una carpeta que se llama bin. Y si existe entonces saldrá true
		File archivo=new File("video_159_File");
		System.out.println(archivo.getAbsolutePath());
		System.out.println(archivo.exists());
		
		System.out.println("*********** EXAMPLE: String[] list() and String  ***********");
		// asi podemos establecer cual es la  ruta absoluta
		// con File.separator logramos que la ruta funcione en sistemas operativos donde usan separadores asi / o así \
		File ruta=new File(File.separator+"Users"+File.separator+"Production"+File.separator+"Tharpa"+File.separator+"VARIOS"+File.separator+"Github"+File.separator+"Java_Exercises"+File.separator+"video_159_File");
		System.out.println(ruta.getAbsolutePath());
		//aqui guardamos todo el listado de nombres y directorios de la ruta, en "nombres_archivos"
		String[] nombres_archivos=ruta.list();
		//aqui imprimimos archivos y carpetas de la ruta, pero los archivos que hay dentro de las carpetas no salen
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
					System.out.println(archivos_subcarpeta[j]);
				}
			}
		}
		System.out.println("*********** EXAMPLE : Crear directorios y archivos ***********");
		File ruta2=new File(File.separator+"Users"+File.separator+"Production"+File.separator+"Tharpa"+File.separator+"VARIOS"+File.separator+"Github"+File.separator+"Java_Exercises"+File.separator+"video_159_File"
		+File.separator+"nuevo_directorio");
		ruta2.mkdir();
		// anadimos un try catch por que si vemos el metodo en la API de Java: createNewFile() lanza una Excepcion de tipo IOException.
		File ruta3=new File(File.separator+"Users"+File.separator+"Production"+File.separator+"Tharpa"+File.separator+"VARIOS"+File.separator+"Github"+File.separator+"Java_Exercises"+File.separator+"video_159_File"
		+File.separator+"texto_nuevo.txt");
		String archivo_destino=ruta3.getAbsolutePath();
		try {
			ruta3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Escribiendo accede_es=new Escribiendo();
		accede_es.escribir(archivo_destino);
} }
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
		File ruta=new File(File.separator+"Users"+File.separator+"Production"+File.separator+"Tharpa"+File.separator+"VARIOS"+File.separator+"Github"+File.separator+"Java_Exercises"+File.separator+"video_159_File"
				+File.separator+"texto_nuevo.txt");
		ruta.delete();
	}
}