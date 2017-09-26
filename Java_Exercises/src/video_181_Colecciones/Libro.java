package video_181_Colecciones;

public class Libro{
	public Libro(String titulo, String autor,int ISBN) {
		this.titulo=titulo;
		this.autor=autor;
		this.ISBN=ISBN;
	}
	public String getDatos() {
		return "El titulo es: " + titulo + ". El autor es: "+ autor + ". Y el ISBN es:" + ISBN;
		
	}
	// aqui vamos a redefinir el metodo equals para que se ajuste a nuestras necesidades. Por que tal y como viene por defecto no es capaz de hacer lo que necesitamos.
	public boolean equals(Object obj) {
		// aqui le digo: si el objeto que te estoy pasando pertenece a la case libro
		if(obj instanceof Libro) {
			// ISBN es de tipo Libro, y sin embargo equals es de tipo obj por lo tanto necesitare hacer un casting
			// ahora obj es de tipo Libro, gracias a este casting
			Libro otro=(Libro)obj;
			// aqui comparamos el obj es igual que ISBN
			if(this.ISBN==otro.ISBN) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	private String titulo;
	private String autor;
	// esto deberia ser private, pero es para que se pueda ver el ejemplo del Libro2.java
	public int ISBN;
}