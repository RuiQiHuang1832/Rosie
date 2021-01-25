import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class creepyMusic {


    public void playMusic() {
        playSong("src\\main\\resources\\Music.wav");
    }

    public void playSong(String soundFile) {
        try {
            File f = new File(soundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println(ex + " handled");
        }

    }
}
