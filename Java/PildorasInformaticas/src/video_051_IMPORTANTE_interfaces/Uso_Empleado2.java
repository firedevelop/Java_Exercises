package video_051_IMPORTANTE_interfaces;
import java.util.Arrays;
public class Uso_Empleado2{
	public static void main(String[] args){
		Empleado[] misEmpleados=new Empleado[8];
		misEmpleados[0]=new Empleado("Ana");
		misEmpleados[1]=new Empleado("Ana", 3000);
		misEmpleados[2]=new Empleado("Ana", 3000, 2000, 01, 01);
		misEmpleados[3]=new Empleado("Ana", 3000, 2000, 01, 01);
		misEmpleados[4]=new Jefatura("Ana", 3000, 2000, 01, 01);
		
		Jefatura jefe_RRHH=new Jefatura("Juan", 3000, 2000, 01, 01);
		jefe_RRHH.estableceIncentivo(4000);
		misEmpleados[5]=jefe_RRHH;
		
		misEmpleados[6]=new Jefatura("Eli", 3000, 2000, 01, 01);
		Jefatura jefa_Finanzas=(Jefatura) misEmpleados[6];
		jefa_Finanzas.estableceIncentivo(5000);
		
		Comparable<Object> jefe_marketing=new Empleado("Eli", 3000, 2000, 01, 01);
		Empleado director_comercial=new Jefatura("Sandra", 3000, 2000, 01, 01);
		if(jefe_marketing instanceof Comparable){
			System.out.println("jefe_marketing es Comparable");}
		if(director_comercial instanceof Jefatura){
			System.out.println(director_comercial.dameNombre() + " es de tipo Jefatura");}
		
		
		System.out.println("La jefa: " + jefa_Finanzas.dameNombre() + " recibe bonus de: " + jefa_Finanzas.establece_bonus(500) + " y decide: " + jefa_Finanzas.tomar_decisiones(" dar mas vacas"));
		System.out.println(misEmpleados[4].dameNombre() + " recibe un bonus de: " + misEmpleados[4].establece_bonus(200));
		
		for(Empleado e: misEmpleados){
			e.subeSueldo(5);}
		Arrays.sort(misEmpleados);
		for(Empleado e: misEmpleados){
			System.out.println(e.dameNombre() + " Sueldo: " + e.dameSueldo() + " Fecha contrato: " + e.dameFechaContrato());}
	}
}