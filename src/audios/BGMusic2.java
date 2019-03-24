package audios;

import java.io.File;
import java.io.IOException;


import javax.activity.InvalidActivityException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import views.Stage2;

public class BGMusic2 {

	public BGMusic2() {
		Sequence sequence;
		 
			
		try {
			sequence = MidiSystem.getSequence(new File("audio/stage2.mid"));
				
			//Create a sequencer for the Sequence
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			
			
			//start playing
				
			sequencer.start();
			
			System.out.println("BG2Ω√¿€");
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		
		
	}
}//class
