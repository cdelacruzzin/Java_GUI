import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorderLayoutDemo extends JFrame implements ActionListener{
    private JButton buttons[];
    private String[][] names = {{"hide north", BorderLayout.NORTH},{"hide south", BorderLayout.SOUTH}, {"hide east", BorderLayout.EAST}, {"hide west", BorderLayout.WEST},{"hide center", BorderLayout.CENTER}};
    private BorderLayout layout;

    //set up GUI
    public BorderLayoutDemo(){
        super("border layout demo");

        Container c = getContentPane();

        layout = new BorderLayout(10,10);
        c.setLayout(layout);

        //instantiate buttons
        buttons = new JButton[names.length];
        for (int i =0; i < buttons.length; i++) {
            buttons[i] = new JButton(names[i][0]);
            buttons[i].addActionListener(this);
            c.add(buttons[i], names[i][1]);
        }

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String args[]){
        BorderLayoutDemo app = new BorderLayoutDemo();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++){
            if (e.getSource() == buttons[i])
                buttons[i].setVisible(false);
            else
                buttons[i].setVisible(true);
        }
    }
}
