import javax.swing.*;
import java.awt.*;

public class Casa {

	private JPanel p;
	private JFrame f;
    public Casa() {
    	
    	f = new JFrame();
        f.setSize(800 , 400 );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);


        // Pannello personalizzato per disegnare lo sfondo
        JPanel pannelloSfondo = new JPanel() {
            private Image sfondo = new ImageIcon(
                getClass().getResource("imm.png") //  carica dal package corrente
            ).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int bordoBianco = 250;
                
                
                g.drawImage(sfondo, 0, 0, getWidth()- bordoBianco, getHeight(), this);
            }
        };
   

       
        f.setContentPane(pannelloSfondo); 
        
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
    		
			Casa casa = new Casa();
			
		}
    } 
