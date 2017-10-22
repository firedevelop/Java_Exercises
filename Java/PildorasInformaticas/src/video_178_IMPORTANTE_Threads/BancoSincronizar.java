package video_178_IMPORTANTE_Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSincronizar{
	public static void main(String[]args) {
	Banco entidad=new Banco();
	for(int cuentaOrigen=0;cuentaOrigen<100;cuentaOrigen++) {
		ejecucionTransferencias r=new ejecucionTransferencias(entidad, cuentaOrigen, 2000);
		Thread t=new Thread(r);
		t.start();
		}
	}
}
class Banco{
	private final double[] cuentas;
	private Lock cierreBanco=new ReentrantLock();
	private Condition saldoSuficiente;
	public Banco() {
		cuentas=new double[100];
		for(int i=0;i<cuentas.length;i++) {
			cuentas[i]=2000;
		}
		saldoSuficiente=cierreBanco.newCondition();
	}
	public void transferencias(int cuentaOrigen,int cuentaDestino, double cantidad) throws InterruptedException {
		cierreBanco.lock();
		try {
		while(cuentas[cuentaOrigen]<cantidad) {
			System.out.printf("SALDO INSUFICIENTE %s cuentaOrigen %d intenta transferir %10.2f EUR a cuentaDestino %d pero solo dispones de %10.2f EUR%n",Thread.currentThread(),cuentaOrigen,cantidad,cuentaDestino,cuentas[cuentaOrigen]);		
			saldoSuficiente.await();
		 }
		cuentas[cuentaOrigen]-=cantidad;
		cuentas[cuentaDestino]+=cantidad;
		System.out.printf("%s getSaldoTotal %10.2f cuentaOrigen %d transfiere %10.2f EUR a cuentaDestino %s%n",Thread.currentThread(),getSaldoTotal(),cuentaOrigen,cantidad,cuentaDestino);		
		saldoSuficiente.signalAll();
		}finally {
			cierreBanco.unlock();
		}
	}
	public double getSaldoTotal() {
		double suma_cuentas=0;
		for(double a:cuentas) {
			suma_cuentas+=a;
		}
		return suma_cuentas;
	}
}
class ejecucionTransferencias implements Runnable{
	private Banco entidad;
	private int cuentaOrigen;
	private double cantidadMaxima;
	
	public ejecucionTransferencias(Banco entidad,int cuentaOrigen,double cantidadMaxima) {
		this.entidad=entidad;
		this.cuentaOrigen=cuentaOrigen;
		this.cantidadMaxima=cantidadMaxima;
	}
	@Override
	public void run() {
		try {
		while(true) {
			int cuentaDestino=(int)(100*Math.random());
			double cantidad=cantidadMaxima*Math.random();
			entidad.transferencias(cuentaOrigen, cuentaDestino, cantidad);
				Thread.sleep((int)(Math.random()*10));
		}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}	
}
