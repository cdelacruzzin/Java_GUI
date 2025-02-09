import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class ButtonClick extends JFrame {
    public static void main(String[] args) {
        //create a JFrame (main window)
        JFrame frame = new ButtonClick();
    }
    public ButtonClick(){
        super("Button Click Example");


        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        Container c = getContentPane();

        //create a button
        JButton button = new JButton("Click Me");

        //add event listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // this runs when clicked
                JOptionPane.showMessageDialog(ButtonClick.super.getContentPane(),"Button Clicked");
            }
        });

        c.add(button);
        setVisible(true);

    }
}