package video_171_Threads;
public class SincronizandoHilos{
	public static void main(String[]args) {
		HilosVarios hilo1=new HilosVarios();
		HilosVarios hilo2=new HilosVarios();
		hilo1.start();
		//esto se llama SINCRONIZACION DE HILOS. Hasta que no termine un hilo no comienza el siguiente.
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hilo2.start();
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Terminadas las tareas");
	}
}
class HilosVarios extends Thread{
	public void run() {
		for(int i=0;i<15;i++) {
			System.out.println("Ejecutando hilo " + getName());
			// aqui simplemente le añadimos SLEEP que sirve para que vaya despacio la ejecucción del los hilos y podamos ver como se van generando uno tras del otro.
			// podemos ver lentamente como incluso se ejecuta por ejemplo el hilo1, y sin haber terminado se ejecuta el hilo2.
			// controlamos la excepcion con try catch pues nos obliga Thread a hacerlo
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}