package audios;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class IngredientAudio {

	public IngredientAudio() {
		
		AudioInputStream stream;
		try {
			stream = AudioSystem.getAudioInputStream(new File("audio/ingredient_effect.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
