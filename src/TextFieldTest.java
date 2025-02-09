import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldTest extends JFrame {
    private JTextField textfield1, textfield2, textfield3;
    private JPasswordField passwordField;

    public static void main(String[] args){
        new TextFieldTest();
    }
    //setGUI
    public TextFieldTest(){
        super("TextField and JPassword Test");

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 0, 50));

        Container c = getContentPane();

        JLabel label = new JLabel("Enter Name:");
        textfield1 = new JTextField(20);
        c.add(label);
        c.add(textfield1);

        JLabel label2 = new JLabel("Enter email:");
        textfield2 = new JTextField("Enter Text Here");
        c.add(label2);
        c.add(textfield2);

        JLabel label3 = new JLabel("Enter password:");
        passwordField = new JPasswordField(20);
        c.add(label3);
        c.add(passwordField);

        JLabel label4 = new JLabel("uneditable:");
        textfield3 = new JTextField("Uneditable textfield",20);
        textfield3.setEditable(false);
        c.add(label4);
        c.add(textfield3);

        JButton button = new JButton("Submit");
        c.add(button);

        //register events
        TextFieldHandler handler = new TextFieldHandler();
        textfield1.addActionListener(handler);
        textfield2.addActionListener(handler);
        textfield3.addActionListener(handler);
        passwordField.addActionListener(handler);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string =
                        "Name: " + textfield1.getText() + "\n" +
                        "Email: " + textfield2.getText() + "\n" +
                        "Password: " + new String(passwordField.getPassword())
                        ;
                JOptionPane.showMessageDialog(null, string);
            }
        });

        setVisible(true);
    }


    private class TextFieldHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String string = "";

            //user pressed Enter in JTextField textfield1
            if (e.getSource() == textfield1){
                string = "textfield1: " + e.getActionCommand();
            } else if (e.getSource() == textfield2) {
                string = "textfield2: " + e.getActionCommand();
            } else if (e.getSource() == textfield3) {
                string = "textfield3: " + e.getActionCommand();
            } else if (e.getSource() == passwordField) {
                string = "passwordField: " + new String(passwordField.getPassword());
            }
            JOptionPane.showMessageDialog(null, string);
        }
    }
}
