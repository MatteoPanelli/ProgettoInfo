import javax.swing.*;
import java.awt.*;

public class Casa {

	private JPanel p;
	private JButton b;
	private JFrame f;
    public Casa() {
 
    	f = new JFrame();
        f.setSize(800 , 400 );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);


        // Pannello personalizzato per disegnare lo sfondo
        JPanel pannelloSfondo = new JPanel() {
        	 
            private Image sfondo = new ImageIcon(  
                getClass().getResource("imm.png") 
            ).getImage();
            
            
            private Image allarme = new ImageIcon(  
				getClass().getResource("allarme.png") 
			).getImage();
            
            private Image batteria = new ImageIcon(  
    				getClass().getResource("batteria.png") 
    			).getImage();
                       
            
        

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int bordoBianco = 250;
                
                
                g.drawImage(sfondo, 0, 0, getWidth()- bordoBianco, getHeight(), this);
                
                g.drawImage(allarme, 165 , 460,  64,64, this);
                
                g.drawImage(batteria, 1045 , 620,  64,64, this);
                
            }
        };
   

       
        f.setContentPane(pannelloSfondo); 
        
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
    		
			Casa casa = new Casa();
			
		}
    } 
