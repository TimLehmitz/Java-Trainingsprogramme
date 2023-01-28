import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TresorGui {


    public TresorGui() {
        JFrame frame =new JFrame("Tresorspiel");
        Image icon=Toolkit.getDefaultToolkit().getImage("icon.png");
        frame.setIconImage(icon);
        frame.setSize(500,300);
        frame.setLayout( new BorderLayout() );
        
        frame.setResizable(true);
        
    
    
        JTextField Textfeld1 = new JTextField("Zahl1");
        Textfeld1.setBackground(Color.white);
        Textfeld1.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField Textfeld2 = new JTextField("Zahl2");
        Textfeld2.setBackground(Color.white);
        Textfeld2.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField Textfeld3 = new JTextField("Zahl3");
        Textfeld3.setBackground(Color.white);
        Textfeld3.setHorizontalAlignment(SwingConstants.CENTER);

        JButton nextButton = new JButton("NEXT");
        nextButton.setBackground(Color.green);
        JLabel button5 = new JLabel("Tresorspiel Summe: Produkt: ");
        button5.setBackground(Color.white);
        
        frame.add(Textfeld1,BorderLayout.WEST);
        frame.add(Textfeld2,BorderLayout.CENTER);
        frame.add(Textfeld3,BorderLayout.EAST);
        frame.add(button5,BorderLayout.NORTH);
        frame.add(nextButton,BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        TresorGui gui = new TresorGui();
        System.out.println(gui);
    }
    
}
// https://stackoverflow.com/questions/10155654/how-to-embed-a-grid-layout-inside-a-border-layout-in-java
// --> layout in layout

// borderlayout 
//north Flowlaout(3x label) 
//center(Flowlayout(3x textfield!alingment center!))
//south button
// east und west seiten bild