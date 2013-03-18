package quarto.sound;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;


import quarto.constante.Constante;

public class Music extends Thread{
	
	Sound [] musics;
	
	
	public Music() {
		
		File repertory = new File(Constante.PATHFILE+Constante.MUSIQUE);
		File[] files= repertory.listFiles();
	
		musics = new Sound[files.length];
		
		for(int i=0; i< files.length; i++) {
			musics[i] = new Sound(files[i].getAbsolutePath());
		}		
	}
	
	public void run() {
		
		Audio.setMasterOutputVolume(0.5f);
		
		while(Constante.PlayMusic) {
			for(int i=0;  i< musics.length; i++) {
				InputStream stream = new ByteArrayInputStream(musics[i].getSamples());
				musics[i].play(stream);
			}
		}
	}
}
