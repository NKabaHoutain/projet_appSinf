package quarto.option;

import quarto.constante.Constante;

public class Option {
	private static int soundVolume;
	private static boolean undo = true;
	private static int timeByTurn;
	private static boolean chrono;
	private static int gameLevel;
	private static int theme=0;
	
	
	public static int getTheme() {
		return theme;
	}
	public static void setTheme(int theme) {
		Option.theme = theme;
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
	public static int getSoundVolume() {
		return soundVolume;
	}
	public static void setSoundVolume(int soundVolume) {
		Option.soundVolume = soundVolume;
	}
	public static String getThemeName() {
		return Constante.PATH_THEME[theme];
	}
}

