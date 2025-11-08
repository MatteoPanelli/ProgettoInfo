
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Casa {


	private static final int ICON_SIZE = 64;
	private JFrame f;
	
	
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
	
    public static void main(String[] args) {
    		
			Casa casa = new Casa();
			
		}
    } 
