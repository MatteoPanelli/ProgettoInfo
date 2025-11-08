
public class Sensore extends Thread {
	
	private MonitoraggioSensore monitoaggio;
	private String sensore;
	private String messaggio;
	
	public Sensore(String sensore, MonitoraggioSensore monitoraggio) {
		super("Sensore-" + sensore);
		this.monitoaggio = monitoraggio;
		this.sensore = sensore;
		
		
	}
	
	
	@Override 
	public void run() {
		try {
				
			monitoaggio.attendiSegnale();
								
			System.out.println(Thread.currentThread().getName() + " -> SBLOCCATO! Misura unica.");
							
			Thread.sleep(1000);			
			int misura = (int) (Math.random() * 100);		
			messaggio = "Sensore " + sensore + " ha misurato il valore: " + misura;
							
		}catch(Exception e) {
				
			e.printStackTrace();
			
		}
			
		System.out.println(messaggio);
		System.out.println(Thread.currentThread().getName() + " -> BLOCCATO in attesa del prossimo segnale.");		}

	
}



