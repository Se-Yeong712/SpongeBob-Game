package audios;

import java.io.File;
import java.io.IOException;


import javax.activity.InvalidActivityException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import handlers.BurgerHandler1;
import views.Stage1;
import views.TutorialView;

public class BGMusic1 {

	public BGMusic1() {
		
		Sequence sequence;
			
		try {

			//Create a sequencer for the Sequence
			sequence = MidiSystem.getSequence(new File("audio/stage1.mid"));
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			
			
			//start playing
			sequencer.start();
			
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}//class
