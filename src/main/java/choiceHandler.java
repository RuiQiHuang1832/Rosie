import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class choiceHandler implements ActionListener {
    Rosie rs = new Rosie();
    static int i = 0;
    static int y = 1;

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();
        rs.addmore();
        switch (yourChoice) {
            case "c1":

                try {
                    rs.valueHolderadd();
                    rs.whichChoiceUserPicked = 1;
                    rs.eventBasedOnUserChoice(y++);
                    rs.setSpeaker(3);
                    rs.timer.start();
                    rs.setMessage(rs.userChoices1[i++]);
                    myJframe.choiceButtonPanel.setVisible(false);
                    rs.playTypingNoise();
                } catch (BadLocationException badLocationException) {
                    badLocationException.printStackTrace();
                }
                break;
            case "c2":
                try {
                    rs.valueHoldersubtract();
                    rs.whichChoiceUserPicked = 2;
                    rs.eventBasedOnUserChoice(y++);

                    rs.setSpeaker(3);
                    rs.timer.start();
                    rs.setMessage(rs.userChoices2[i++]);
                    myJframe.choiceButtonPanel.setVisible(false);
                    rs.playTypingNoise();
                } catch (BadLocationException badLocationException) {
                    badLocationException.printStackTrace();
                }

                break;

            case "c3":
                myJframe.endScreen();

        }
    }
}
