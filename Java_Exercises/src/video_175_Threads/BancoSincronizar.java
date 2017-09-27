package video_175_Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSincronizar{
	public static void main(String[]args) {
	Banco b=new Banco();
	for(int i=0;i<100;i++) {
		// banco es "b", la "i" es la cuenta de origen, y a cada vuelta de bucle sera distinta y entre "0" y "99". Y 2000 es la cantidad maxima permitida para transferir
		EjecucionTransferencias r=new EjecucionTransferencias(b, i, 2000);
		Thread t=new Thread(r);
		t.start();
		}
	}
}
class Banco{
	public Banco() {
		cuentas=new double[100];
		for(int i=0;i<cuentas.length;i++) {
			cuentas[i]=2000;
		}
	}
	public void transferencias(int cuentaOrigen,int cuentaDestino, double cantidad) {
		cierreBanco.lock();
		try {
		// esto es para controlar que no se pueda hacer una transferencia por un importe superior al que la cuenta tiene.
		if(cuentas[cuentaOrigen]<cantidad) {
			 return;
		 }
		// El programa informa de el hilo que va a hacer la transferencia.
		System.out.println(Thread.currentThread());
		// Aqui se descuenta a la cuenta origen, la cantidad que queremos  transferir. El -= significa restar cuentaOrigen-cantidad=cuentaOrigen
		cuentas[cuentaOrigen]-=cantidad;
		System.out.printf("%10.2f de %d para %d", cantidad,cuentaOrigen,cuentaDestino);
		// Aqui suma la cantidad transferida a la cuentaDestino
		cuentas[cuentaDestino]+=cantidad;
		// Aqui estamos imprimiendo el método getSaldoTotal(), para que nos muestre la suma de todas las cuentas
		System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
		}finally {
			cierreBanco.unlock();
		}
	}
	// este metodo muestra el saldo total de todas nuestras cuentas
	public double getSaldoTotal() {
		double suma_cuentas=0;
		// Este bucle for almacena en la variable "a" cada uno de los indices. Por ejemplo:
		// [0]=2500
		// [1]=1750
		// [2]=1350
		for(double a:cuentas) {
			suma_cuentas+=a;
		}
		// aqui devuelve el resultado de sumar todas las cuentas
		return suma_cuentas;
	}
	private final double[] cuentas;
	private Lock cierreBanco=new ReentrantLock();
}
class EjecucionTransferencias implements Runnable{
	// las cuentas estan numeradas por lo tanto voy a mostrar con "de" la cuenta de origen. Y "max" es la cantidad maxima permitida para transferir
	public EjecucionTransferencias(Banco b,int de,double max) {
		banco=b;
		deLaCuenta=de;
		cantidadMax=max;
	}
	@Override
	public void run() {
		// debido a que la cuentaDestino no siempre va a ser la misma, por lo tanto usaremos random(); para que el programa se invente cual va a ser la cuenta de destino
		while(true) {
			// esto ya lo hemos visto antes. cuando creamos un numero con math, nos sale por ejemplo 0,256987. Y después al multiplicarlo por 100 se nos queda en 25,6987. Y despues al decirle que haga un casting y lo convierta en integer en lugar de double, se queda un numero entero, es dedir 25
			int paraLaCuenta=(int)(100*Math.random());
			// aqui teniendo en cuenta que la cantidad maxima que podemos transferir es 2000, el programa se va a inventar las cantidades a transferir a modo de simulacion.
			// aqui obtenemos con Math.random() un numero aleatorio, por ejemplo 0.7854112 y al multiplicarlo por la cantidad maxima que van a ser 2000, pues nos sale 1570 euros a transferir
			double cantidad=cantidadMax*Math.random();
			banco.transferencias(deLaCuenta, paraLaCuenta, cantidad);
			// esto es para dormir los hilos y ralentizar los procesos, de este modo podemos ver lentamente lo que pasa. No es necesario pero vamos a usar un random() para que parezca mas real y sena operaciones en distintos tiempos de ejecuccion creados aleatoriamente, como 3 segundos, 10 segundos, etc...
			try {
				Thread.sleep((int)(Math.random()*10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private Banco banco;
	private int deLaCuenta; // La cuenta de Origen
	private double cantidadMax; // cantidad maxima permitida para transferir
	
		
	}
