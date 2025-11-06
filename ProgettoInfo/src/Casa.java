
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Casa {


	private JFrame f;
	
	
    public Casa() {

    	f = new JFrame();
        f.setSize(800 , 400 );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);


       
        JPanel pannelloSfondo = disegnoComponenti();
   

       
        f.setContentPane(pannelloSfondo); 
        
        f.setVisible(true);
    }

    
    
    
    
    
	private JPanel disegnoComponenti() {
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
            
            private Image temperatura = new ImageIcon(  
    				getClass().getResource("temperatura.png") 
    			).getImage();
            
            //private Image co2 = new ImageIcon(  
    				//getClass().getResource("co2.png") 
    			//).getImage();
            private JButton co2 = creaPulsante("co2", 165, 600); //bottone immagine co2
            
            private Image idro = new ImageIcon(  
    				getClass().getResource("idro.png") 
    			).getImage();
                       
                       
           

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int bordoBianco = 250;
                
                
                g.drawImage(sfondo, 0, 0, getWidth()- bordoBianco, getHeight(), this);
                
                g.drawImage(allarme, 165 , 460,  64,64, this);
                
                g.drawImage(batteria, 1045 , 620,  64,64, this);
                
                g.drawImage(temperatura, 930 , 470,  64,64, this);
                
                //g.drawImage(co2, 165 , 600,  64,64, this);
                
                g.drawImage(idro, 385 , 600,  64,64, this);
                
            }
        };
		return pannelloSfondo;
	}
    
	public JButton creaPulsante(String s, int x, int y) {
		ImageIcon icon = new ImageIcon(getClass().getResource(s));
		JButton btnIcon = new JButton(icon);
		
		btnIcon.setBounds(x, y, 64, 64);
		
		btnIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(JFrame.EXIT_ON_CLOSE);
            }
        });
		
		return btnIcon;
	}
	
    public static void main(String[] args) {
    		
			Casa casa = new Casa();
			
		}
    } 
