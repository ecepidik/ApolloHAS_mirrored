package view;

import java.io.*;
import javax.sound.sampled.*;

public class PlayMusic {
	public PlayMusic(){
		
	}
	public static void playSample(){
		try {
		    File yourFile = new File("SOUND_EFFECT-_Harp_Strum.wav");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;

		    stream = AudioSystem.getAudioInputStream(yourFile);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
		    //whatevers
		}
	}

}
