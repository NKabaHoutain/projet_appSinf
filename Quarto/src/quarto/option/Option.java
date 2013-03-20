package quarto.option;

public class Option {
	private static int volumeMusic;
	private static int volumeEffects;
	private static boolean undo;
	private static int timeByTurn;
	private static boolean chrono;
	private static int gameLevel;
	
	public static int getVolumeMusic() {
		return volumeMusic;
	}
	public static void setVolumeMusic(int volumeMusic) {
		Option.volumeMusic = volumeMusic;
	}
	public static int getVolumeEffects() {
		return volumeEffects;
	}
	public static void setVolumeEffects(int volumeEffects) {
		Option.volumeEffects = volumeEffects;
	}
	public static boolean isUndo() {
		return undo;
	}
	public static void setUndo(boolean undo) {
		Option.undo = undo;
	}
	public static int getTimeByTurn() {
		return timeByTurn;
	}
	public static void setTimeByTurn(int timeByTurn) {
		Option.timeByTurn = timeByTurn;
	}
	public static boolean isChrono() {
		return chrono;
	}
	public static void setChrono(boolean chrono) {
		Option.chrono = chrono;
	}
	public static int getGameLevel() {
		return gameLevel;
	}
	public static void setGameLevel(int gameLevel) {
		Option.gameLevel = gameLevel;
	}
	
}

