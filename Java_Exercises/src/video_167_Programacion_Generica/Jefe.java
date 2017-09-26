package video_167_Programacion_Generica;
class Jefe extends Empleado{
	public Jefe(String nombre, int edad, double salario) {
		super(nombre, edad, salario);
	}
	double incentivo(double inc) {
		return inc;
	}
}
