package video_164_Programacion_Generica;
import java.io.File;
public class UsoArrayList2{
	public static void main(String[]args) {
		ArrayList archivos=new ArrayList(5);
			archivos.add(new File("gestion_Pedidos.accdb"));
			File nombrePersona2=(File)archivos.get(0);
			System.out.println("EJEMPLO CASTING FILE"+nombrePersona2);

	}
}