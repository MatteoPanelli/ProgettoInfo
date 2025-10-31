import javax.swing.*;
import java.awt.*;

public class Casa {
	
	private JFrame f;

    public Casa() {
        f.setTitle("Esempio con sfondo");
        f.setSize(800 , 400 );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        // Pannello personalizzato per disegnare lo sfondo
        JPanel pannelloSfondo = new JPanel() {
            private Image sfondo = new ImageIcon(
                getClass().getResource("imm.png") // ← carica dal package corrente
            ).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };

        pannelloSfondo.setLayout(new BorderLayout());

        JLabel testo = new JLabel("Benvenuto!", SwingConstants.CENTER);
        testo.setFont(new Font("Arial", Font.BOLD, 28));
        testo.setForeground(Color.WHITE);

        pannelloSfondo.add(testo, BorderLayout.CENTER);
        f.setContentPane(pannelloSfondo);
        
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
    		
			Casa casa = new Casa();
			
		}
    } 
