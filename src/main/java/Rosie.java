import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * JTEXT - able to append but can only use one font
 * JTEXTPANE - can't append but can use stylized fonts and colors
 */

/**
 * CHECK IF STRING EQUALS THIS " CHOICE"
 * IF IT DOES " DO THIS "
 * wait for actionlistner.
 * <p>
 * after press, call method again and print from one of the choices
 * which means i will create another array of strings for each choice.
 */
public class Rosie {
    static boolean setTrue = true;
    static int valueHolder = 0;
    static int valueHolder2 = 0;
    int whichChoiceUserPicked;
    static int y = 1;
    boolean userChoiceisPicked = false;
    String message;
    String theString;
    String results;
    int i = 0;
    int x = 2;
    int someRandomVal;
    static int rosieArrayIncrement = 0;
    static int dadArrayIncrement = 0;
    creepyMusic song = new creepyMusic();
    typingSoundEffect se = new typingSoundEffect();

    String[] userChoices1 = new String[]{"Sweetheart, what did we say about zombies. *Dad scoops the teabag out of the mug and dumps it in the " +
            "bin* You know if you keep talking about them, daddy's going to get in trouble with mummy again.", "Sweetheart. " +
            "I'm going to ask you a question and I want you to be honest: Have you been playing along the path out back again?", "What do you mean, " +
            "you didn't? You just ran in here a moment ago calling him one."};

    String[] userChoices2 = new String[]{"I know, darling, but I already checked the back garden twice yesterday, and I can " +
            "promise you it's a zombie-free zone.", "Listen to me, sweetheart. I know you didn't go far or anything, but I don't want you–", "*Dad puts down tea* What do you mean, sweetheart? " +
            "You saw someone else in his house?"};

    String[] DadStrings = new String[]{"Oh Yeah?", "*thinking to himself* I really had to be more careful about what I" +
            " watched in the evening.. My daughter has a habit of sneaking downstairs in the night and caught me watching " +
            "the walking dead, of all things. She's had zombies on her brain ever since. ", "choice", "*Dad puts down the mug " +
            "and turns to the girl. Her hair was windswept and her little cheeks were red, as if she'd been running.", "choice", "Dad sighs realizing the " +
            "culprit 'zombie' was Mr.Henderson. Yesterday it was the postman and the day before it was the dog. " +
            "*Dad takes a sip of tea*", "*Dad had stopped listening* Something was on his mind. His mind was stuck" +
            " on something she'd said a moment before.\n\n \"Mr Henderson really wanted me to come in and have tea\" ", "Rosie, " +
            "I'm not going to stop you playing in the garden. But you must make me a couple of promises, too. First, promise me " +
            "you will stop going round calling people zombies. Mr. Henderson may be old, but he is not one of the living dead.", "choice", "*Dad puts down tea*\n What do you mean, " +
            "sweatheart?", "*Dads voice was shaking now* What?", "choice"};

    String[] daughterStrings = new String[]{"Yeah, I did! Its face was all pale and messed up! It was gross, dad!", "choice", "Dad, I did see one!", "choice", "Mr Henderson really " +
            "wanted me to come in and have some tea!", "Dad I-\n -Rosie interrupts-\n Daddy, please don't stop me playing in the garden! I promise I won't sneak out " +
            "again. I don't want the zombies to get me!", "*Rosie frowning*\n I didn't!", "choice", "Yeah, the zombie, dad! I could see it pressed " +
            "against his little basement window while I was talking to Mr Henderson. Cold finders run up the fathers spine. " +
            "Yeah, it was really scary. Its face was all bashed up and bloody, and its mouth was open. Like it was screaming " +
            "at me. But do you know what confused me most, dad?", "Well I didn't realize kids could be zombies too, I thought it was " +
            "only grownups. But I guess I must have been wrong, cuz' the one in Mr Henderson's basement looked just like a little " +
            "girl.", "choice"};

    String[] daughterResponses1 = new String[]{"Yeah, but I saw one!", "Dad I only went a little way down, I promise. I was chatting to Mr Henderson, " +
            "because I saw him in his back garden. I said hello and made him jump!", "No, I didn't. Mr Henderson's not a zombie. " +
            "I saw the zombie in his house, but it wasn't him."};
    String[] daughterResponses2 = new String[]{"No, not in the back garden! I didn't see it in the back garden!", "*Staring up, blue eyes large and pleading* I came right " +
            "back up after too, dad! I promise! And I even said no when Mr. Henderson offered me an ice cream, because I know " +
            "you don't like me taking stuff from strangers!", "Yeah, the zombie, dad! I could see it pressed against his little basement window while I was talking to him."};

    public Rosie() {

    }

    public void startGame() throws BadLocationException {
        startText();
        song.playMusic();
        se.playTypingSoundEffect();


    }


    private void startText() throws BadLocationException {
        timer.start();
        setSpeaker(x++);
        setMessage("DAD, DAD, I SAW A ZOMBIE!!");


    }

    private void checkMessage() throws BadLocationException {
        if (!timer.isRunning()) {
            checkForSpeaker();

        }

    }


    private void checkForSpeaker() throws BadLocationException {
        Style style = myJframe.mainTextArea.addStyle("", null);
        StyledDocument doc = myJframe.mainTextArea.getStyledDocument();
        StyleConstants.setForeground(style, Color.green);


        if (someRandomVal == 1 && !daughterStrings[rosieArrayIncrement].equals("choice")) {
            timer.start();
            setMessage(daughterStrings[rosieArrayIncrement++]);
        } else if (someRandomVal == 2 && !DadStrings[dadArrayIncrement].equals("choice")) {
            timer.start();
            setMessage(DadStrings[dadArrayIncrement++]);

        } else {
            choicePrompt(y++);

            doc.insertString(doc.getLength(), getString(), style);
            se.stopSong();
        }
    }

    private void choicePrompt(int prompt) {
        switch (prompt) {
            case 1:
                setString("\n\n\t           CHOICE: 1. Scold? // 2. Dismiss? ");
                myJframe.choiceButtonPanel.setVisible(true);

                break;
            case 2:
                setString("\n\n\t           CHOICE: 1. Question? // 2. Reprimand? ");
                myJframe.choiceButtonPanel.setVisible(true);

                break;
            case 3:
                setString("\n\n\t           CHOICE: 1. Worry? // 2. Put off? ");
                myJframe.choiceButtonPanel.setVisible(true);
                break;
            case 4:
                setConsequences(valueHolder);

                setString(returnResultofConsequences());
                break;
        }
    }

    private String returnResultofConsequences() {

        return results;
    }

    private void setResults(String theResults) {
        results = theResults;
    }

    private void setConsequences(int userChoices) {
        if (userChoices > 0) {
            setResults("\n\n\n\t You paid attention to your daughter. She will no longer  visit Mr Hendersons. " +
                    "She lives.\n");
        } else {
            setResults("\n\n\n\t You were dismissive of your daughter. She continues to  visit Mr Hendersons House. " +
                    "She dies.\n");
        }
        myJframe.choiceButtonPanel.setVisible(true);
        myJframe.choice1.setVisible(false);
        myJframe.choice2.setVisible(false);
        myJframe.choice3.setVisible(true);

    }


    private String getString() {
        return theString;
    }

    private void setString(String valOfString) {
        theString = valOfString;
    }

    public void setSpeaker(int number) throws BadLocationException {
        StyledDocument doc = myJframe.mainTextArea.getStyledDocument();
        Style style = myJframe.mainTextArea.addStyle("", null);

        if (number % 2 == 0 && !daughterStrings[rosieArrayIncrement].equals("choice")) {

            //even
            if (setTrue) {
                doc.insertString(doc.getLength(), "Rosie: ", null);
                setTrue = false;
            } else {
                doc.insertString(doc.getLength(), "\nRosie: ", null);

            }
            someRandomVal = 1;

        } else if (!(number % 2 == 0) && !DadStrings[dadArrayIncrement].equals("choice")) {
            StyleConstants.setForeground(style, Color.red);

            doc.insertString(doc.getLength(), "\nFather: ", style);
            someRandomVal = 2;
        }


    }


    Timer timer = new Timer(50, new ActionListener() {
        @Override

        public void actionPerformed(ActionEvent e) {

            Style style = myJframe.mainTextArea.addStyle("", null);
            StyleConstants.setForeground(style, Color.white);
            StyledDocument doc = myJframe.mainTextArea.getStyledDocument();
            char character[] = getMessage().toCharArray();
            String addedCharacter = "";
            String blank = "";

            addedCharacter = blank + character[i];
            try {
                doc.insertString(doc.getLength(), addedCharacter, style);
            } catch (BadLocationException badLocationException) {
                badLocationException.printStackTrace();
            }
            i++;


            if (i == character.length) {
                i = 0;
                timer.stop();

                try {
                    setSpeaker(x++);

                    if (!userChoiceisPicked) {
                        checkMessage();
                    } else {
                        startTimer();
                    }

                } catch (BadLocationException badLocationException) {
                    badLocationException.printStackTrace();
                }

            }

        }
    });

    private String getMessage() {
        return message;
    }

    public void setMessage(String m) {
        message = m;
    }

    public void startTimer() {
        timer.start();
        if (whichChoiceUserPicked == 1) {
            setMessage(daughterResponses1[valueHolder2++]);
        } else {
            setMessage(daughterResponses2[valueHolder2++]);
        }
        userChoiceisPicked = false;
    }

    public void addmore() {
        rosieArrayIncrement++;
        dadArrayIncrement++;
        userChoiceisPicked = true;

    }

    public void valueHolderadd() {
        valueHolder++;
    }

    public void valueHoldersubtract() {
        valueHolder--;
    }

    public void playTypingNoise() {
        se.playTypingSoundEffect();

    }

    // how to improve code below:
    // call a function instead
    //set string with get message
    // do if have free time
    public void eventBasedOnUserChoice(int num) throws BadLocationException {
        Style style = myJframe.mainTextArea.addStyle("", null);
        StyleConstants.setForeground(style, Color.orange);
        StyledDocument doc = myJframe.mainTextArea.getStyledDocument();
        switch (num) {
            case 1:
                if (whichChoiceUserPicked == 1) {
                    doc.insertString(doc.getLength(), "\nYOU PICKED: SCOLD", style);

                } else {
                    doc.insertString(doc.getLength(), "\nYOU PICKED: DISMISS", style);

                }
                break;
            case 2:
                if (whichChoiceUserPicked == 1) {
                    doc.insertString(doc.getLength(), "\nYOU PICKED: QUESTION", style);

                } else {
                    doc.insertString(doc.getLength(), "\nYOU PICKED: REPRIMAND", style);

                }
                break;
            case 3:
                if (whichChoiceUserPicked == 1) {
                    doc.insertString(doc.getLength(), "\nYOU PICKED: WORRY", style);

                } else {
                    doc.insertString(doc.getLength(), "\nYOU PICKED: PUT OFF", style);

                }
                break;


        }
    }
}
