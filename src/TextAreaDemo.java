import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TextAreaDemo extends JFrame{
    protected JTextArea t1, t2;
    protected JButton copy;
    public static void main(String[] args){
        new TextAreaDemo();
    }
    public TextAreaDemo(){
        super("Text Area Demo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        Box b = Box.createHorizontalBox();
        String s = "This is a demo" + "illustrate copying text \n" + "from one TextArea to \n";

        t1 = new JTextArea(s, 10, 15);
        b.add(new JScrollPane(t1));
        copy = new JButton("Copy >>>");
        copy.addActionListener(new CopyHandler());
        b.add(copy);
        t2 = new JTextArea(10, 15);
        t2.setEditable(false);
        b.add(new JScrollPane(t2));
        Container c = getContentPane();
        c.add(b);
        setVisible(true);
    }
    class CopyHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t2.setText(t1.getText());
        }
    }
}
