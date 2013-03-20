package quarto.option;

public class Option {
	private int volumeMusic;
	private int volumeEffects;
	private boolean undo;
	private int timeByTurn;
	private boolean chrono;
	private int gameLevel;
	
	public int getVolumeMusic() {
		return volumeMusic;
	}
	
	public void setVolumeMusic(int volumeMusic) {
		this.volumeMusic = volumeMusic;
	}
	
	public int getVolumeEffects() {
		return volumeEffects;
	}
	
	public void setVolumeEffects(int volumeEffects) {
		this.volumeEffects = volumeEffects;
	}
	
	public boolean isUndo() {
		return undo;
	}
	
	public void setUndo(boolean undo) {
		this.undo = undo;
	}
	
	public int getTimeByTurn() {
		return timeByTurn;
	}
	
	public void setTimeByTurn(int timeByTurn) {
		this.timeByTurn = timeByTurn;
	}
	
	public boolean isChrono() {
		return chrono;
	}
	
	public void setChrono(boolean chrono) {
		this.chrono = chrono;
	}
	
	public int getGameLevel() {
		return gameLevel;
	}
	
	public void setGameLevel(int gameLevel) {
		this.gameLevel = gameLevel;
	}
}

