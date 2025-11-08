
public class MonitoraggioSensore {
		
	private boolean pronto = false;
	
	
	public synchronized boolean isAttivo() {
		return pronto;
	}
	
	
	public synchronized void attendiSegnale() {
		while(!pronto) {
			try {
				wait();					
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		pronto = false;
	}
	
	
	public synchronized void setAttivo(boolean stato) {
		this.pronto= stato;
		if(stato) {
			notifyAll();
		}
		
	}
	
	
}
