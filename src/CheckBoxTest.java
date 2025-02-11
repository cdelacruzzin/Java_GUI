import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxTest extends JFrame{
        private JTextField field;
        private JCheckBox bold, italic;

        public static void main(String args[]){
            CheckBoxTest app = new CheckBoxTest();
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

        //set up GUI
    public CheckBoxTest(){
        super("Check Box Test");

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        //set up JTextField and set its font
        field = new JTextField("watch the font style change", 20);
        field.setFont(new Font("Serif", Font.PLAIN, 14));

        //create checkbox objects
        bold = new JCheckBox("Bold");
        c.add(bold);

        italic = new JCheckBox("Italic");
        c.add(italic);

        //set action handler
        CheckBoxHandler handler = new CheckBoxHandler();

        bold.addItemListener(handler);
        italic.addItemListener(handler);



        c.add(field);
        setSize(500, 500);

        setVisible(true);
    }

    public class CheckBoxHandler implements ItemListener{
            private int valBold = Font.PLAIN;
            private int valItalic = Font.PLAIN;

            //respond to checkbox event
        @Override
        public void itemStateChanged(ItemEvent e) {
            //process bold checkbox events
            if (e.getSource() == bold) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    valBold = Font.BOLD;
                else
                    valBold = Font.PLAIN;
            }

            //process italic checkbox events
            if (e.getSource() == italic)
                if (e.getStateChange() == ItemEvent.SELECTED)
                    valItalic = Font.ITALIC;
                else
                    valItalic = Font.PLAIN;

            //set text field font
            field.setFont(new Font("Serif", valBold + valItalic, 14));

        }
    }
}
