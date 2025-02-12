import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelDemo extends JFrame  {
    private JPanel panel;
    private JButton button[];

    //setup gui
    public PanelDemo(){
        super("panel demo");
        Container c = getContentPane();

        button = new JButton[5];
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, button.length, 10, 0));

        for (int i = 0; i < button.length; i++){
            button[i] = new JButton("button " + (i + 1));
            c.add(button[i]);
            panel.add(button[i]);
        }

        c.add(panel, BorderLayout.SOUTH);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        new PanelDemo();
    }
}
