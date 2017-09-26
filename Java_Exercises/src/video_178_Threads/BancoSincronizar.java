package video_178_Threads;

public class BancoSincronizar{
	public static void main(String[]args) {
	Banco b=new Banco();
	for(int i=0;i<100;i++) {
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
	public synchronized void transferencias(int cuentaOrigen,int cuentaDestino, double cantidad) throws InterruptedException {
		while(cuentas[cuentaOrigen]<cantidad) {
			System.out.println("-------- SALDO INSUFICIENTE:" + cuentaOrigen + "....SALDO: " + cuentas[cuentaOrigen] + "..." + "cantidad");
			wait();
		 }
		System.out.println(Thread.currentThread());
		cuentas[cuentaOrigen]-=cantidad;
		System.out.printf("%10.2f de %d para %d", cantidad,cuentaOrigen,cuentaDestino);
		cuentas[cuentaDestino]+=cantidad;
		System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
		notifyAll();
	}
	public double getSaldoTotal() {
		double suma_cuentas=0;
		for(double a:cuentas) {
			suma_cuentas+=a;
		}
		return suma_cuentas;
	}
	private final double[] cuentas;
}
class EjecucionTransferencias implements Runnable{
	public EjecucionTransferencias(Banco b,int de,double max) {
		banco=b;
		deLaCuenta=de;
		cantidadMax=max;
	}
	@Override
	public void run() {
		try {
		while(true) {
			int paraLaCuenta=(int)(100*Math.random());
			double cantidad=cantidadMax*Math.random();
			banco.transferencias(deLaCuenta, paraLaCuenta, cantidad);
				Thread.sleep((int)(Math.random()*10));
		}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	private Banco banco;
	private int deLaCuenta; 
	private double cantidadMax;
	}
