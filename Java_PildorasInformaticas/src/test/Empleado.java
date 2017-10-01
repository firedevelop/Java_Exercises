public test;
public class Empleado{
	private String nombre;
	public Empleado(String nom) {
		nombre=nom;
	}
	public String dameNombre() {
		return nombre;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Empleado) {
			Empleado otro=(Empleado)obj;
			if(this.nombre==otro.nombre) {
				return true;
			}
			else {
				return false;
			}
		
		}else {
			return false;
		}
	}
}