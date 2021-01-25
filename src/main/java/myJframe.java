import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import java.awt.*;

/***
 * @author Rui Qi Huang
 * Date: 1/24/2021
 */


public class myJframe {
    JFrame window;
    static Container con;
    static JButton startButton, choice1, choice2, choice3;
    static JTextPane mainTextArea;
    static JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, endScreenPanel;
    static JLabel titleNameLabel, endScreenLabel;
    Rosie r = new Rosie();
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    choiceHandler cHandler = new choiceHandler();


    public void start() {
        window = new JFrame("ROSIE");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        window.setLocationRelativeTo(null);


        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);


        titleNameLabel = new JLabel("ROSIE");
        titleNameLabel.setForeground(Color.RED);
        titleNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 100));

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(250, 400, 300, 100);
        startButtonPanel.setBackground(Color.black);
        // startButtonPanel.setLayout(null);
        startButton = new JButton("START");

        startButton.setFont(new Font("Times Roman", 0, 24));
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
        // startButton.setBounds(300, 300, 150, 90);

        // How to allow startButton.setBounds to work: (VERY BAD PRACTICE)
        //comment out window set layout, and starbuttonpanel set bounds
        // undo startbutton setbounds and startbuttonpanel set layout


        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    public void createGameScreen() throws BadLocationException {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);


        mainTextPanel = new JPanel();
        mainTextPanel.setLayout(null);
        mainTextPanel.setBounds(130, 80, 600, 250);
        mainTextPanel.setBackground(Color.black);

        mainTextArea = new JTextPane();

        mainTextArea.setBorder(new LineBorder((Color.red)));
        mainTextArea.setBackground(Color.black);
        mainTextArea.setFont(new Font("Times Roman", 0, 11));
        mainTextArea.setForeground(Color.BLUE);
        mainTextArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(mainTextArea);
        scroll.setBackground(Color.black);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 3, 400, 250);
        mainTextPanel.add(scroll);
        //  mainTextArea.add(GirlTextarea);
        //mainTextPanel.add(mainTextArea);   <- EVIL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        con.add(mainTextPanel);


        r.startGame();

        createButtons();


    }

    public static void endScreen() {
        mainTextPanel.setVisible(false);


        endScreenPanel = new JPanel();
        endScreenPanel.setBounds(100, 100, 600, 150);
        endScreenPanel.setBackground(Color.black);

        endScreenLabel = new JLabel("THANKS FOR PLAYING!");
        endScreenLabel.setForeground(Color.RED);
        endScreenLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));

        choice3.setVisible(false);
        endScreenPanel.add(endScreenLabel);
        con.add(endScreenPanel);
    }


    public void createButtons() {


        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 375, 350, 70);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(1, 3));
        choiceButtonPanel.setVisible(false);

        /**
         * delay choice
         */
        /*
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                choiceButtonPanel.setVisible(true);

            }
        },5000);
*/


        con.add(choiceButtonPanel);


        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);


        choice3 = new JButton("(--->)");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choice3.setVisible(false);
        choiceButtonPanel.add(choice3);

        choice1.setFocusPainted(false);
        choice2.setFocusPainted(false);
        choice3.setFocusPainted(false);


    }


}
