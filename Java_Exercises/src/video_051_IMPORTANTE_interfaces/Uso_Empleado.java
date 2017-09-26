package video_051_IMPORTANTE_interfaces;

import java.util.Arrays;

/* CASTING
 		double num1=7.5;
 		int num2=(int) num1;
 */
public class Uso_Empleado{
	public static void main(String[] args){
		// Los numeros de id se irán otorgando en el mismo orden que estén dispuestos los objetos
		Jefatura jefe_RRHH=new Jefatura("Juan", 55000, 2006, 9, 25);
		jefe_RRHH.estableceIncentivo(2570);
		
		Empleado[] misEmpleados=new Empleado[7];
		misEmpleados[0]=new Empleado("Ana", 30000, 2000, 07, 07);
		misEmpleados[1]=new Empleado("Carlos", 50000, 1995, 06, 15);
		misEmpleados[2]=new Empleado("Paco", 25000, 2005, 9, 25);
		misEmpleados[3]=new Empleado("Antonio", 47500, 2009, 11, 9);
		// Polimorfismo en accion. Principio de sustitucion
		// Aqui instanciamos un objeto que previamente hemos instanciado
		misEmpleados[4]=jefe_RRHH;
		//Aqui instanciamos un objeto directamente
		misEmpleados[5]=new Jefatura("Maria", 95000, 1999, 5, 26);
		// Debido a que un Empleado no siempre "ES UN" Jefe, si intentamos hacer un casting con misEmpleados[1], nos dara error, gracias al diseño de la Herencia
		// Por ejemplo si hacemos esto no funcionaría: Jefatur jefe_compras=(Jefatura)misEmpleados[1];
		
		Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5];
		jefa_Finanzas.estableceIncentivo(55000);
		
		misEmpleados[6]=new Empleado("Petter");
		// Aqui doy de alta un nuevo Jefe. Se puede hace dado que un Jefe va a ser siempre un Empleado
		// Hacemos esto gracias al principio de sustitucion
		//*** INSTANCE OF example ***
		Empleado director_comercial=new Jefatura("Sandra", 85000, 2012, 05, 05);
		Comparable ejemplo=new Empleado("Elisabeth", 95000, 2011, 06, 07);
		if(director_comercial instanceof Empleado){
			System.out.println("director_comercial es de tipo Jefatura");
		}
		if(ejemplo instanceof Comparable){
			System.out.println("director_comercial implementa eclila interfaz Comparable");
		}
		//*** end INSTANCE OF example ***
		//*** INTERFACE JEFES Y TRABAJADOES ***
		System.out.println(jefa_Finanzas.tomar_decisiones("dar mas vacaciones"));
		jefa_Finanzas.establece_bonus(500);
		System.out.println("El Jefe " + jefa_Finanzas.dameNombre() + " tiene un bonus de: " + jefa_Finanzas.establece_bonus(500));
		
		System.out.println(misEmpleados[3].dameNombre() + " tiene un bonus de: " + misEmpleados[3].establece_bonus(200));
		//*** end INTERFACE JEFES Y TRABAJADOES ***
		
		
		
		for(Empleado e: misEmpleados){
			e.subeSueldo(5);
		}
		// Esta interfaz se dedica a ordenar Objetos. En la API de Java podemos ver también como ordenar tipos Int, etc... pero en este caso nosotros somos necesitamos ordenar un objeto.
		Arrays.sort(misEmpleados);
		
		for(Empleado e: misEmpleados){
			System.out.println(e.dameNombre() +
			" Sueldo: " + e.dameSueldo() + 
			" Fecha contrato: " + e.dameFechaContrato()); 
			
		}
	}
}