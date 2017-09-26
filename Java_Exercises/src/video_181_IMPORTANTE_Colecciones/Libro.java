package video_181_IMPORTANTE_Colecciones;

public class Libro{
	public Libro(String titulo, String autor,int ISBN) {
		this.titulo=titulo;
		this.autor=autor;
		this.ISBN=ISBN;
	}
	public String getDatos() {
		return "El titulo es: " + titulo + ". El autor es: "+ autor + ". Y el ISBN es:" + ISBN;
		
	}
	public boolean equals(Object obj) {
		if(obj instanceof Libro) {
			Libro otro=(Libro)obj;
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
	public int ISBN;
}