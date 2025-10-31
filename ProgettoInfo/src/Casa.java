import javax.swing.*;
import java.awt.*;

public class Casa {
	
	
	private JFrame f;

    public Casa() {
    	//ciao
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
                       
            
        

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int bordoBianco = 250;
                
                
                g.drawImage(sfondo, 0, 0, getWidth()- bordoBianco, getHeight(), this);
                
                g.drawImage(allarme,500 , 500,  getWidth(), getHeight(), this);
            }
        };
   

       
        f.setContentPane(pannelloSfondo); 
        
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
    		
			Casa casa = new Casa();
			
		}
    } 
