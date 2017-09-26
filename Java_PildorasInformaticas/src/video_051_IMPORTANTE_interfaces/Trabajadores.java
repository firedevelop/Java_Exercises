package video_051_IMPORTANTE_interfaces;

public interface Trabajadores {
	public abstract double establece_bonus(double gratificacion);
	// da igual que pongas public static final, por que por defecto lo es. 
	// es public para que se pueda acceder desde cualquier clase a ella
	// static por que es perteneciente a la interfaz trabajadores
	// final por que es una constante, y no se puede reasignar o cambiar su valor.
	public static final double bonus_base=1500;
	
}
