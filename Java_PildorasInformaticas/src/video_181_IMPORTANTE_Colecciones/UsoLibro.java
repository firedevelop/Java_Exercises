// ejercicio que hace comparaciones teniendo encuenta el numero de ISBN en lugar del numero hashCode()
package video_181_IMPORTANTE_Colecciones;

class UsoLibro{
	public static void main(String[]args) {
		Libro libro1=new Libro("P en Java", "Juan",25);
		Libro libro2=new Libro("P en Java II", "Juan",25);
		Libro libro3=new Libro("P en Java", "Juan",27);
		if(libro1.equals(libro2)) {
			System.out.println("Es el mismo libro");
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
		}else {
			System.out.println("No es el mismo libro");
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
		}
		libro1=libro2;
		if(libro1.equals(libro2)) {
			System.out.println("Es el mismo libro");
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
		}else {
			System.out.println("No es el mismo libro");
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
		}
		if(libro1.equals(libro3)) {
			System.out.println("Es el mismo libro");
			System.out.println(libro1.hashCode());
			System.out.println(libro3.hashCode());
		}else {
			System.out.println("No es el mismo libro");
			System.out.println(libro1.hashCode());
			System.out.println(libro3.hashCode());
		}
	}
}
	