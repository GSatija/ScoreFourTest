package ca.unbc.cpsc.caffeine.soundClips;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class SoundClipTest extends JFrame {



    public static Clip clip;
    public static Mixer mixer;

    public SoundClipTest() throws InterruptedException {

        File file = new File("/Users/gauravsatija/IdeaProjects/ScoreFourTest/src/ca/unbc/cpsc/caffeine/soundClips/smb_mariodie.wav");
        playSound(file);
    }

    public static void playSound(File sound){
        try{
            clip=AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            Thread.sleep(1000);
        } catch (Exception e){

        }


    }
}