
public class MonitoraggioSensore {
		
	private boolean attivo = false;
	
	
	public synchronized boolean inviaSegnale() {
		return attivo;
	}
	
	
	public synchronized void attendiSegnale() {
		while(!attivo) {
			try {
				wait();
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
