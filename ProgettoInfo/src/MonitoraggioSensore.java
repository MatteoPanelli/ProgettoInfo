/**
 * La classe {@code MonitoraggioSensore} funge da monitor per la sincronizzazione tra thread.
 * <p>
 * Questa classe gestisce un flag di stato condiviso ({@code pronto}) in modo 
 * <strong>thread-safe</strong> (sincronizzato). Permette a un thread consumatore 
 * (es. il sensore) di mettersi in attesa di un segnale, e a un thread produttore 
 * (es. la GUI o il main) di inviare tale segnale di attivazione.
 * </p>
 */
public class MonitoraggioSensore {
		
	/** * Flag interno che indica lo stato di attivazione o disponibilità del segnale. 
	 * Se true, il segnale è pronto per essere consumato.
	 */
	private boolean pronto = false;
	
	/**
	 * Verifica lo stato attuale del monitoraggio.
	 * <p>
	 * L'accesso a questo metodo è sincronizzato per garantire la consistenza 
	 * della lettura in un ambiente multi-thread.
	 * </p>
	 * * @return {@code true} se il segnale è attivo (pronto), {@code false} altrimenti.
	 */
	public synchronized boolean isAttivo() {
		return pronto;
	}
	
	/**
	 * Mette il thread chiamante in attesa finché il segnale non diventa attivo.
	 * <p>
	 * Questo metodo utilizza un ciclo {@code while} per evitare "spurious wakeups".
	 * Il thread rimane bloccato in {@code wait()} finché la variabile {@code pronto} è false.
	 * <br>
	 * Una volta che il thread viene risvegliato (da {@code setAttivo}) e la condizione è soddisfatta,
	 * il flag {@code pronto} viene resettato a {@code false} (consumo del segnale) e il metodo termina.
	 * </p>
	 */
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
	
	/**
	 * Imposta lo stato del monitoraggio e notifica i thread in attesa.
	 * <p>
	 * Se il parametro {@code stato} è {@code true}, viene invocato {@code notifyAll()}
	 * per risvegliare tutti i thread attualmente bloccati nel metodo {@code attendiSegnale()}.
	 * </p>
	 * * @param stato Il nuovo stato da impostare (tipicamente {@code true} per attivare).
	 */
	public synchronized void setAttivo(boolean stato) {
		this.pronto= stato;
		if(stato) {
			notifyAll();
		}
		
	}
	
	
}
