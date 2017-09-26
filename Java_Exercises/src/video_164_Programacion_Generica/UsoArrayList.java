package video_164_Programacion_Generica;
public class UsoArrayList{
	public static void main(String[]args) {
		ArrayList archivos=new ArrayList(5);
	 	archivos.add("Juan");
		archivos.add("Maria");
		archivos.add("Ana");
		archivos.add("Sandra");
		String nombrePersona=(String)archivos.get(2); 
		System.out.println("EJEMPLO CON CASTING TIPO STRING: "+nombrePersona);	
	} 
}