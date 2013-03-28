package quarto.option;

import quarto.sound.Audio;

public class Option {
	private static int soundVolume = 50;
	private static boolean playMusic = true;
	private static boolean playSfx = true;
	private static boolean undo = true;
	private static int timeByTurn;
	private static boolean chrono = true;
	private static int gameLevel;
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
		Audio.setMasterOutputVolume((float) soundVolume/100);
	}
	}

