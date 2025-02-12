import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Sum2GridLayout extends JFrame implements ActionListener {
    private JTextField[] t;
    private JButton b;

    public static void main(String[] args){
        Sum2GridLayout app = new Sum2GridLayout();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Sum2GridLayout(){
        super("Grid Layout");

        t = new JTextField[3];


        Container c = getContentPane();
        c.setLayout(new GridLayout(2,2));

        for (int i = 0; i < t.length; i++){
            t[i] = new JTextField(10 );
            c.add(t[i]);
        }

        b = new JButton("Calculate the sum");
        c.add(b);

        b.addActionListener(this);


        setSize(500, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] s = new String[2];
        double[] d = new double[2];
        for (int i = 0; i < t.length - 1; i++) {
            s[i] = t[i].getText();
            d[i] = Double.parseDouble(s[i]);
        }
        t[2].setText("Sum = " + (d[0] + d[1]));
    }
}
