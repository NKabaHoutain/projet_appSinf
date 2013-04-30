package quarto.option;


import quarto.constante.Constante;

//import quarto.sound.Audio;


public class Option {
	private static boolean playMusic = true;
	private static boolean playSfx = true;
	private static boolean undo = true;
	private static int gameLevel=0;
	private static int theme=0;
	
	
	public static boolean isPlayMusic() {
		return playMusic;
	}
	public static void setPlayMusic(boolean playMusic) {
		Option.playMusic = playMusic;
	}
	public static boolean isPlaySfx() {
		return playSfx;
	}
	public static void setPlaySfx(boolean playSfx) {
		Option.playSfx = playSfx;
	}
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
	public static int getGameLevel() {
		return gameLevel;
	}
	public static void setGameLevel(int gameLevel) {
		Option.gameLevel = gameLevel;
	}

	public static String getThemeName() {
		return Constante.PATH_THEME[theme];
	}
}


