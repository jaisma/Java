import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class ButtonColor {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Changer");
        //frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(3,4));
        int nob = 12; //number of buttons
        JButton[] list = new JButton[nob];
        for (int i = 0; i < list.length; i++) {
            JButton temp = new JButton("click");
            Random r = new Random();
            temp.setBackground(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            temp.addActionListener(new ButtonPress());
            list[i] = temp;
        }
        for (int i = 0; i < list.length; i++) {
            panel.add(list[i]);
        }
        frame.pack();
    }
}

class ButtonPress implements ActionListener{
    public void actionPerformed(ActionEvent action) {
        //JPanel panel = (JPanel)action.getSource();
        JButton button = (JButton)action.getSource();
        Random r = new Random();
        button.setBackground(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
    } 
}
