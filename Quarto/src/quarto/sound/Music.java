package quarto.sound;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Random;


import quarto.constante.Constante;
import quarto.option.Option;

public class Music extends Thread{
	
	Sound [] musics;
	int i;
	
	
	public Music() {

		File repertory = new File(Constante.getPathMusic());
		
		File[] files= repertory.listFiles();
	
		musics = new Sound[files.length];
		
		for(int i=0; i< files.length; i++) {
			musics[i] = new Sound(files[i].getAbsolutePath());
		}		
	}
	
	public void run() {
		
		Random r = new Random();
		i= r.nextInt(musics.length);
				
		while(Option.isPlayMusic()) {
			while(i< musics.length) {
				InputStream stream = new ByteArrayInputStream(musics[i].getSamples());
				musics[i].play(stream);
				i++;
			}
			i=0;
		}
	}
	
	public void stopMusic() {
		musics[i].stop();
	}
	
	public void restart() {
		musics[i].restart();
	}
}
