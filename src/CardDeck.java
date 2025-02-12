import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CardDeck extends JFrame implements ActionListener {
    private CardLayout cardManager;
    private JPanel deck;
    private JButton controls[];
    private String names[] = {"first card", "next card", "previous card", "last card"};

    //set gui
    public CardDeck(){
        super("Card Deck");
        Container c = getContentPane();

        //creates the JPanel with cardlayout
        deck = new JPanel();
        cardManager = new CardLayout();
        deck.setLayout(cardManager);

        //adds cards to deck
        deck.add(card1Panel(), "c1");
        deck.add(card2Panel(), "c2");
        deck.add(card3Panel(), "c3");


        //initialize layout buttons that wil;l control the deck
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(2,2));
        controls = new JButton[names.length];
        for (int i = 0; i < controls.length; i++){
            controls[i] = new JButton(names[i]);
            controls[i].addActionListener(this);
            buttons.add(controls[i]);
        }
        c.add(buttons, BorderLayout.WEST);
        c.add(deck, BorderLayout.EAST);

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel card1Panel(){
        JLabel lbl1 = new JLabel("Card one", SwingConstants.CENTER);
        JPanel card1 = new JPanel();
        card1.add(lbl1);
        return card1;
    }
    public JPanel card2Panel(){
        JLabel lbl2 = new JLabel("Card two", SwingConstants.CENTER);
        JPanel card2 = new JPanel();
        card2.setBackground(Color.orange);
        card2.add(lbl2);
        return card2;
    }

    public JPanel card3Panel(){
        JLabel lbl3 = new JLabel("card three", SwingConstants.CENTER);
        JPanel card3 = new JPanel();
        card3.setLayout(new BorderLayout());

        card3.add(new JButton("north"), BorderLayout.NORTH);
        card3.add(new JButton("west"), BorderLayout.WEST);
        card3.add(new JButton("east"), BorderLayout.EAST);
        card3.add(new JButton("south"), BorderLayout.SOUTH);
        card3.add(lbl3, BorderLayout.CENTER);

        return card3;
    }


    public static void main(String[] args){
        new CardDeck();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controls[0])
            cardManager.first(deck);
        else if (e.getSource() == controls[1]) {
            cardManager.next(deck);
        } else if (e.getSource() == controls[2]) {
            cardManager.previous(deck);
        }else if (e.getSource() == controls[3]) {
            cardManager.last(deck);
        }
    }
}
