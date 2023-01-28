import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.Random;

public class Schiffeversenken extends JFrame implements ActionListener{
	
	public Schiffeversenken() {
        
		setSize(500,500);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(10,10));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i = 0; i < 100; i++){
			JButton button = new JButton();
			button.setActionCommand(String.valueOf(i));
			button.addActionListener(this);
            int[] schiffposis = createschiffposis();

            if (contains(schiffposis, i)){ // wenn i in der liste der siffposis enthalten ist
                button.setForeground(Color.red);
            }
            else{
                button.setForeground(null);
            }

			add(button);
			
		}
	}
	
	
	public static void main(String[] args) {
		new Schiffeversenken().setVisible(true);
    /* 
        > 1 Schiff  der L�nge 5
        > 2 Schiffe der L�nge 4
        > 3 Schiffe der L�nge 3
        > 4 Schiffe der L�nge 2
    */


	}


	public void actionPerformed(ActionEvent e) {

        System.out.println("Button geklickt!");
        System.out.println(e.getActionCommand());


        if(((JButton) e.getSource()).getForeground() == Color.red){
            ((JButton) e.getSource()).setBackground(Color.RED);
            ((JButton) e.getSource()).setForeground(null);
        }
        else{
            ((JButton) e.getSource()).setBackground(Color.gray);
        }
		
	}


    public int[] createschiffposis(){
        int[] schiffposis = {1,5,10,25,50,30};
        Random randint = new Random();
    
        int int_random = randint.nextInt(10);
        System.out.println(int_random);


        return schiffposis;
    }


    public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }
}
