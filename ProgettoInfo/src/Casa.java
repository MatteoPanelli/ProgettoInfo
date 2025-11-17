//FINALE ZANNA
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * La classe {@code Casa} rappresenta l'interfaccia grafica principale (GUI) del sistema di monitoraggio domotico.
 * <p>
 * Questa classe gestisce la creazione della finestra principale, il disegno dello sfondo
 * (che rappresenta la planimetria della casa) e il posizionamento dei pulsanti interattivi
 * che rappresentano i vari sensori (CO2, Allarme, Idrico, Batteria, Temperatura).
 * </p>
 */
public class Casa {


	/** Dimensione standard (larghezza e altezza) in pixel per le icone dei pulsanti. */
	private static final int ICON_SIZE = 64;
	
	/** Il frame principale dell'applicazione. */
	private JFrame f;
	
	
	/**
     * Costruttore della classe Casa.
     * <p>
     * Inizializza il JFrame, imposta le dimensioni, centra la finestra e
     * chiama i metodi per disegnare i componenti (sfondo e pulsanti).
     * Infine, rende la finestra visibile.
     * </p>
     */
    public Casa() {

    	f = new JFrame();
        f.setSize(800 , 400 );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        
       
        JPanel pannelloSfondo = disegnoComponenti();
        

         disegnoBottoni(pannelloSfondo);
         
     
       
        f.setContentPane(pannelloSfondo); 
        
        f.setVisible(true);
    }




    
    /**
     * Crea e posiziona i pulsanti dei sensori sul pannello di sfondo.
     * <p>
     * Questo metodo imposta il layout a {@code null} per permettere il posizionamento assoluto
     * e aggiunge i pulsanti per CO2, Allarme, Idrico, Batteria e Temperatura
     * in coordinate specifiche.
     * </p>
     *
     * @param pannelloSfondo Il JPanel su cui devono essere aggiunti i pulsanti.
     */
    
	private void disegnoBottoni(JPanel pannelloSfondo) {
		
		pannelloSfondo.setLayout(null);
		
		JButton co2 = creaPulsante("co2.png", 165, 600);
         pannelloSfondo.add(co2);
         
         JButton bAllarme = creaPulsante("allarme.png", 165, 460);
         pannelloSfondo.add(bAllarme);
         
         JButton bIdro = creaPulsante("idro.png", 385, 600);
         pannelloSfondo.add(bIdro);
         

         JButton bBatteria = creaPulsante("batteria.png", 1045, 620);
         pannelloSfondo.add(bBatteria);
         

         JButton bTemperatura = creaPulsante("temperatura.png", 930, 470);
         pannelloSfondo.add(bTemperatura);
	}

    
    
	/**
     * Crea il pannello principale che gestisce il disegno dell'immagine di sfondo.
     * <p>
     * Utilizza una classe anonima che estende {@code JPanel} e sovrascrive il metodo
     * {@code paintComponent} per disegnare l'immagine "imm.png".
     * </p>
     *
     * @return Un oggetto {@code JPanel} con l'immagine di sfondo disegnata.
     */
    
	private JPanel disegnoComponenti() {
		JPanel pannelloSfondo = new JPanel() {
        	 
            private Image sfondo = new ImageIcon(  
                getClass().getResource("imm.png") 
            ).getImage();
                        
           
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                                
                g.drawImage(sfondo, 0, 0, getWidth()- 250, getHeight(), this);
                
                             
            }
        };
		return pannelloSfondo;
	}
	
	
	/**
     * Metodo per creare un pulsante personalizzato con icona e gestione eventi.
     * <p>
     * Il pulsante creato è trasparente, mostra solo l'icona.
     * Al click, viene istanziato un nuovo {@code MonitoraggioSensore} e un {@code Sensore},
     * avviando il thread di monitoraggio.
     * </p>
     *
     * @param s Il nome del file immagine (risorsa) da usare come icona (es. "co2.png").
     * @param x La coordinata X dove posizionare il pulsante.
     * @param y La coordinata Y dove posizionare il pulsante.
     * @return Il {@code JButton} configurato e pronto per essere aggiunto al pannello.
     */
	
	public JButton creaPulsante(String s, int x, int y) {
		ImageIcon icon = new ImageIcon(getClass().getResource(s));
		JButton btnIcon = new JButton(icon);
		
		btnIcon.setBounds(x, y, ICON_SIZE, ICON_SIZE);
		
		btnIcon.setBorderPainted(false); 	// Rimuove il bordo del pulsante
		btnIcon.setContentAreaFilled(false);   // Rimuove lo sfondo del pulsante
		
		btnIcon.addActionListener(new ActionListener() {
			
			
            @Override
            public void actionPerformed(ActionEvent e) {
                MonitoraggioSensore monitoraggio = new MonitoraggioSensore();
                Sensore sensore = new Sensore(s, monitoraggio);
                
                sensore.start();
                
                new Thread(() -> {
					try {
						
						Thread.sleep(10);
						monitoraggio.setAttivo(true);
						
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					
				}).start();
                
                
            }
        });
		
		return btnIcon;
	}
	
	/**
     * Punto di ingresso dell'applicazione (Main).
     * <p>
     * Crea un'istanza della classe {@code Casa}, avviando l'interfaccia grafica.
     * </p>
     */
	
    public static void main(String[] args) {
    		
			Casa casa = new Casa();
			
		}
    } 
