package video_051_IMPORTANTE_interfaces;
// Jefes al heredar de Trabajadores, quiere decir que todas aquellas clases que implementen la interfaz jefes, estarán implementando tambien tomar_decisiones y establece_bonus de la interfaz Trabajadores
public interface Jefes extends Trabajadores{
	public abstract String tomar_decisiones(String decision);
}