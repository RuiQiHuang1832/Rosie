import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class typingSoundEffect {
    Clip clip;

    public void playTypingSoundEffect() {

        playSong("src\\main\\resources\\typing.wav");
    }

    public void playSong(String soundFile) {
        try {
            File f = new File(soundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println(ex + " handled");
        }

    }

    public void stopSong() {
        clip.stop();
    }


}
