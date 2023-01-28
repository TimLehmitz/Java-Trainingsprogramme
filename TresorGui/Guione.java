import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Image;

public class Guione{

public Guione() {
    JFrame frame =new JFrame("Nicht-klick-Spiel");
    Image icon=Toolkit.getDefaultToolkit().getImage("icon.png");
    frame.setIconImage(icon);
    frame.setSize(500,500);
    frame.setLayout( new BorderLayout() );
    frame.setVisible(true);
    frame.setResizable(true);
    


    JButton button1 = new JButton("Auf keinen Fall klicken");
    button1.setBackground(Color.red);
    JButton button2 = new JButton("Auf keinen Fall klicken");
    button2.setBackground(Color.GREEN);
    JButton button3 = new JButton("Auf keinen Fall klicken");
    button3.setBackground(Color.yellow);
    JButton button4 = new JButton("Auf keinen Fall klicken");
    button4.setBackground(Color.yellow);
    JButton button5 = new JButton("Auf keinen Fall klicken");
    button5.setBackground(Color.yellow);


    frame.add(button1,BorderLayout.CENTER);
    frame.add(button2,BorderLayout.WEST);
    frame.add(button3,BorderLayout.NORTH);
    frame.add(button4,BorderLayout.SOUTH);
}



public static void main(String[] args) {
    Guione gui = new Guione();
    System.out.println(gui);
}
}