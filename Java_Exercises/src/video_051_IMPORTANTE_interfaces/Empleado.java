package video_051_IMPORTANTE_interfaces;
import java.util.*;



class Empleado implements Comparable<Object>, Trabajadores{
	// si pruebas  ponerle final a "sueldo" te va a dar un error por que sueldo durante la ejecucción del programa si que es modificado, pues se incremente en un 5%
	// poniendo la constante "final" en esta variable o campo de clase "nombre" estamos garantizando que nadie va a cambiar el nombre de un empleado.
	private final String nombre;
	private double sueldo;
	private Date altaContrato;
	private int Id;
	private static int IdSiguiente=1;
	
            public Empleado(String nom, double sue, int agno, int mes, int dia){
			nombre=nom;
			sueldo=sue;
			GregorianCalendar calendario=new GregorianCalendar(agno, mes-1, dia);
			altaContrato=calendario.getTime();
			Id=IdSiguiente;
			IdSiguiente++;
		}
		// Ejemplo Sobrecarga de constructores con diferente numero de argumentos
		public Empleado(String nom, double sue){
			nombre=nom;
			sueldo=sue;
		}
		// Ejemplo Sobrecarga de constructores con parametros por defecto
		public Empleado(String nom){
			this(nom, 30000, 2000, 01, 01);
		}
		public String dameNombre(){ // getter 
			return "Id: " + Id + " Nombre: " + nombre;
		}
		public double dameSueldo(){
			return sueldo;
		}
		public Date dameFechaContrato(){
			return altaContrato;
		}
		public void subeSueldo(double porcentaje){ //setter
			double aumento=sueldo*porcentaje/100;
			sueldo+=aumento;
		}
		// El método de la interfaz comparable tiene que ser publico y abastracto. Si no ponías el public en la interfaz no pasaba nada, pues se daba por hecho que era publica, pero una cosa es crear el método de la interfaz y otra cosa es sobreescribirlo. Cuando lo sobreescribes en una clase si que debes poner el public
		// acorde con la API de Java debe de devolver un tipo Objeto, por eso ponemos Object. y devuelve "0" si son iguales, un positivo si es mayor, y negativo si es menor
		// Creo que aqui obtenemos el caracter unicoide de cada id, por ejemplo el numero 1 es 49, el 2 es 50. Después el Array.sort se encargara de ordenarlos
		public int compareTo(Object miObjeto){
			// aqui hago una refundicion o casting por que necesito convertir el Objeto en tipo empleado para poder compararlos
			// Ejemplo de casting:
			// double num1=7.5;
			// int num2=(int) num1;
			Empleado otroEmpleado=(Empleado) miObjeto;
			if(this.Id<otroEmpleado.Id){
				return -1;
			}
			if(this.Id>otroEmpleado.Id){
				return 1;
			}
			return 0;
		}
		public double establece_bonus(double gratificacion){
			return Trabajadores.bonus_base+gratificacion;
		}
	}
// si no pusieramos nada dentro de la class Jefatura, tomaría los datos del constructor por defecto llamado public Empleado(). Logicamente siempre que este constructor exista. En este caso por ejemplo no existe, pues el constructor existente si que espera que le pasemos parametros
// EJEMPLO DE CLASES CON FINAL: Si ha jefatura le pusieramos "final" impediría que se crearan clases como Director (ver abajo). Estaría cortando la cadena de herencia
class Jefatura extends Empleado implements Jefes{
	private double incentivo;
	public Jefatura(String nom, double sue, int agno, int mes, int dia){
		// si a este super le pasamos 5 parametros, llamara al Primer constructor
		// si le pasamos 2 parametros, llamara al Segundo constructor
		// si le pasamos ningún parametro, dará error, pues no tenemos ningun constructor establecido cero parametros, aunque lo podríamos crear.
		super(nom, sue, agno, mes, dia);
	}
	public void estableceIncentivo(double b){
		incentivo=b;
	}
	public double dameSueldo(){
		// super significa que llama al metodo heredado, el de la clase padre y no al dameSueldo de la clase jefatura
		double sueldoJefe=super.dameSueldo();
		return sueldoJefe + incentivo;
	}
	
	public String tomar_decisiones(String decision){
		return "Un miembro de la dirección ha tomado la decisión de: " + decision;
	}
	public double establece_bonus(double gratificacion){
		double prima=2000;
		return Trabajadores.bonus_base + gratificacion + prima;
}
}
// EJEMPLO DE CLASES FINAL: esto da error si la clase Jefatura lleva "final" (ver arriba)
class Director extends Jefatura{
	public Director(String nom, double sue, int agno, int mes, int dia){
		super(nom, sue, agno, mes, dia);
	}
}