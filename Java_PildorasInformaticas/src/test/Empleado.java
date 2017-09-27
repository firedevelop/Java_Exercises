package test;
public class Empleado{
	private String nombre;
	private String sueldo;
	
	public Empleado(String nom, String sue) {
		nombre=nom;
		sueldo=sue;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sueldo == null) ? 0 : sueldo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (sueldo == null) {
			if (other.sueldo != null)
				return false;
		} else if (!sueldo.equals(other.sueldo))
			return false;
		return true;
	}

	public String dameNombre() {
		return nombre;
	}
	public String dameSueldo() {
		return sueldo;
	}
	}
