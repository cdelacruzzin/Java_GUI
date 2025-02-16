import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Game extends JFrame implements ActionListener{
    private JTextField txtField;
    private JButton[] keysBtn;
    private JPanel keyboard;
    private JPanel deck;
    private final String ans = "Carlos";
    private String correct = "You Got It!!";
    private String wrong = "Incorrect! Try Again!";

    public static void main(String[] args){
        new Game();
    }

    //set GUI
    public Game(){
        super("Guessing Game");

        Container c = getContentPane();
        deck = new JPanel(new BorderLayout());
        keyboard = new JPanel(new GridLayout(5,6));

        txtField = new JTextField();
        txtField.setEditable(false);

        keysBtn = new JButton[28];
        for (char ch = 'a', i =0; ch <= 'z'; ch++, i++){
            keysBtn[i] = new JButton(String.valueOf(ch));
            keysBtn[i].addActionListener(this);
            keyboard.add(keysBtn[i]);
        }

        JPanel interactBtns = new JPanel(new GridLayout(1,2));
        keysBtn[keysBtn.length -2] = new JButton("OK");
        keysBtn[keysBtn.length -2].addActionListener(this);
        keysBtn[keysBtn.length -1] = new JButton("Clear");
        keysBtn[keysBtn.length -1].addActionListener(this);
        interactBtns.add(keysBtn[keysBtn.length -2]);
        interactBtns.add(keysBtn[keysBtn.length -1]);

        deck.add(txtField, BorderLayout.NORTH);
        deck.add(keyboard, BorderLayout.CENTER);
        deck.add(interactBtns, BorderLayout.SOUTH);
        c.add(deck);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setResponse(ActionEvent e){
        if (txtField.getText().equalsIgnoreCase(txtField.getText())) {
            txtField.setText("You Got It!!");
        } else {
            txtField.setText("Incorrect! Try Again!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (txtField.getText().equalsIgnoreCase(correct) || txtField.getText().equalsIgnoreCase(wrong)){
            txtField.setText("");
        }
        if (e.getActionCommand().equalsIgnoreCase("ok")){
            setResponse(e);
        }
        else if (e.getActionCommand().equalsIgnoreCase("Clear"))
            txtField.setText("");
        else{
            txtField.setText(txtField.getText() + e.getActionCommand());
        }


    }
}


