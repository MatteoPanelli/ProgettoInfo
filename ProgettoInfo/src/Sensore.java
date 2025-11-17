/**
 * La classe {@code Sensore} rappresenta un dispositivo di rilevamento (es. Temperatura, CO2).
 * <p>
 * Questa classe estende {@code Thread} per permettere l'esecuzione concorrente delle misurazioni.
 * Il sensore rimane in attesa passiva (bloccato) finché non riceve un segnale di attivazione
 * tramite l'oggetto condiviso {@code MonitoraggioSensore}.
 * <br>
 * Una volta sbloccato, simula un tempo di elaborazione, genera un valore casuale e termina.
 * </p>
 */
public class Sensore extends Thread {
	/** Riferimento al monitor per la sincronizzazione (wait/notify). */
	private MonitoraggioSensore monitoaggio;
	/** Identificativo o nome del file immagine del sensore (es. "co2.png"). */
	private String sensore;
	/** Stringa contenente il risultato formattato della misurazione. */
	private String messaggio;
	
	/**
	 * Costruttore della classe Sensore.
	 * <p>
	 * Inizializza il thread assegnandogli un nome specifico per facilitare il debugging
	 * e associa il monitor di controllo.
	 * </p>
	 *
	 * @param sensore Il nome o l'identificativo del sensore (usato anche per il nome del thread).
	 * @param monitoraggio L'istanza del monitor condiviso per gestire l'attesa del segnale.
	 */
	public Sensore(String sensore, MonitoraggioSensore monitoraggio) {
		super("Sensore-" + sensore);
		this.monitoaggio = monitoraggio;
		this.sensore = sensore;
		
		
	}
	
	/**
	 * Logica di esecuzione del thread del sensore.
	 * <p>
	 * Il flusso di esecuzione è il seguente:
	 * <ol>
	 * <li>Il thread chiama {@code attendiSegnale()} sul monitor e si blocca.</li>
	 * <li>Quando viene risvegliato (dalla GUI), stampa un messaggio di sblocco.</li>
	 * <li>Attende 1000ms (1 secondo) per simulare il tempo di misurazione hardware.</li>
	 * <li>Genera un valore casuale tra 0 e 99.</li>
	 * <li>Costruisce e stampa il messaggio finale con il valore rilevato.</li>
	 * </ol>
	 * </p>
	 */
	@Override 
	public void run() {
		try {
			// 1. Fase di attesa: il sensore aspetta l'input dell'utente
			monitoaggio.attendiSegnale();
								
			// 2. Simulazione del tempo necessario alla misurazione fisica
			System.out.println(Thread.currentThread().getName() + " -> SBLOCCATO! Misura unica.");
			
			// 3. Generazione del dato simulato
			Thread.sleep(1000);			
			int misura = (int) (Math.random() * 100);		
			messaggio = "Sensore " + sensore + " ha misurato il valore: " + misura;
							
		}catch(Exception e) {
				
			e.printStackTrace();
			
		}
		// 4. Output del risultato
		System.out.println(messaggio);
		System.out.println(Thread.currentThread().getName() + " -> BLOCCATO in attesa del prossimo segnale.");		}

	
}



