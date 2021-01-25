import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class TitleScreenHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        myJframe frame = new myJframe();
        try {
            frame.createGameScreen();
        } catch (BadLocationException badLocationException) {
            badLocationException.printStackTrace();
        }

    }
}