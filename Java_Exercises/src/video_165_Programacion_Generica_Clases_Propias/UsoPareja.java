package video_165_Programacion_Generica_Clases_Propias;
public class UsoPareja{
	public static void main(String[]args) {
		// aqui le decimos que el objeto va a ser de tipo String
		//aqui creamos la primera instancia y la llamamos "una"
		Pareja<String> una=new Pareja<String>();
		una.setPrimero("Juan");
		System.out.println(una.getPrimero());
		//aqui creamos una instancia de tipo persona
		Persona pers1=new Persona("Ana");
		// y aqui creamos una instancia de nuestra clase generica pareja
		Pareja<Persona> otra=new Pareja<Persona>();
		otra.setPrimero(pers1);
		// IMPORTANTE aqui lo que nos devuelve es un valor de tipo Objeto, NO un String, por lo tanto no vamos a ver "Ana"
		System.out.println(otra.getPrimero());
	}
}
class Persona{
	public Persona(String nombre) {
		this.nombre=nombre;
	}
	// Aqui simplemente sobreescribimos el método de la clase object, para evitar que nos salga por consola el objeto, ya que no es legible. Si elimiar este metodo puedes ver por consola como se imprime el objeot, algo como esto: .....Persona@677327b6 
	// toString convierte a tipo string
	public String toString() {
		return nombre;
	}
	private String nombre;
}