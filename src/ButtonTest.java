import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest extends JFrame{
    JButton plainButton, fancyButton;

    public static void main(String[] args){
        new ButtonTest();
    }

    //set up GUI
    public ButtonTest(){
        super("Button Test");

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //get content pane and set its layouts
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        //create buttons
        plainButton = new JButton("Plain Button");
        c.add(plainButton);

        Icon umaru = new ImageIcon("src/assets/umaru.gif");
        Icon umaru2 = new ImageIcon("src/assets/umaru2.gif");
        fancyButton = new JButton("fancy button", umaru);
        fancyButton.setRolloverIcon(umaru2);
        c.add(fancyButton);

        //set event handler
        ButtonHandler handler = new ButtonHandler();
        fancyButton.addActionListener(handler);
        plainButton.addActionListener(handler);

        setVisible(true);
    }
}

class ButtonHandler implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "you pressed: " + e.getActionCommand());
    }
}
