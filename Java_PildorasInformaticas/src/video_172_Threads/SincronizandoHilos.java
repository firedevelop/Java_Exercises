package video_172_Threads;
public class SincronizandoHilos{
	public static void main(String[]args) {
		HilosVarios hilo1=new HilosVarios();
		//al decirle aqui (hilo1) quiere decir que hasta que no termine la ejecucción el hilo1 no empezara el hilo2
		HilosVarios2 hilo2=new HilosVarios2(hilo1);
		hilo1.start();
		hilo2.start();
		//esto se llama SINCRONIZACION DE HILOS. Hasta que no termine un hilo no comienza el siguiente.
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
class HilosVarios2 extends Thread{
	private Thread hilo;
	public HilosVarios2(Thread hilo) {
		this.hilo=hilo;
	}
	public void run() {
	try {
		hilo.join();
	} catch (InterruptedException e1) {
		e1.printStackTrace();
	}
		
		for(int i=0;i<15;i++) {
			System.out.println("Ejecutando hilo " + getName());
			// aqui simplemente le añadimos SLEEP que sirve para que vaya despacio la ejecucción del los hilos y podamos ver como se van generando uno tras del otro.
			// podemos ver lentamente como incluso se ejecuta por ejemplo el hilo1, y sin haber terminado se ejecuta el hilo2.
			// controlamos la excepcion con try catch pues nos obliga Thread a hacerlo
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}