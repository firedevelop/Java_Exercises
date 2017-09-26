package video_167_Programacion_Generica;
public class HerenciaGenericos{
	public static void main(String[]args) {
		/*
		Empleado Administrativa=new Empleado("Elena", 45, 1500);
		Jefe DirectoraComercial=new Jefe("Ana", 27, 3500);
		Empleado nuevoEmpleado=DirectoraComercial;
		*/
		Pareja<Empleado> Administrativa=new Pareja<Empleado>();
		Pareja<Jefe> DirectoraComercial=new Pareja<Jefe>();
	    //Pareja<Empleado>nuevoEmpleado=DirectoraComercial; 
		//primero uso el metodo de la clase pues es static
		Pareja.imprimirTrabajador(Administrativa);
		// si en el archivo Pareja.java no le hubieramos dicho este comodin (Pareja<? extends Empleado>p) aqui nos marcaria un error
		Pareja.imprimirTrabajador(DirectoraComercial);
		
	}
}