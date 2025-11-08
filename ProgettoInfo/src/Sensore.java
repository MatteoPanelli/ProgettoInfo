
public class Sensore extends Thread {
	
	private MonitoraggioSensore monitoaggio;
	private String sensore;
	
	public Sensore(String sensore, MonitoraggioSensore monitoraggio) {
		this.monitoaggio = monitoraggio;
		this.sensore = sensore;
	}
	
	
	@Override 
	public void run() {
			
		while(true) {
			
			try {
				monitoaggio.attendiSegnale();
				
				System.out.println(Thread.currentThread().getName() + " -> SBLOCCATO! Misura unica.");
				
				Thread.sleep(1000);
				int misura = (int) (Math.random() * 100);
				
				String messaggio = "Sensore " + sensore + " ha misurato il valore: " + misura;
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}



