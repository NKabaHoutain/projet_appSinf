package quarto.detail;

import java.io.File;

import quarto.constante.Constante;
import quarto.option.Option;



public class Detail {

	private static int[][] numberGame;
	
	private static long gameTime;
	private static long minTimeInGame;
	private static long maxTimeInGame;
	
	private static int minMoveInGame;
	private static int maxMoveInGame;
		
	public static void addDetail(boolean isVsIa, int resultGame, long time, int move) {
		if(isVsIa) {
			numberGame[resultGame][Option.getGameLevel()] ++;
		}
		moveInGame(move);
		gameTime(time);
		
		saveDetail();
	}
	
	private static void moveInGame(int move) {
		if(move<minMoveInGame) {
			minMoveInGame = move;
		}
		if(move>maxMoveInGame) {
			maxMoveInGame = move;
		}
	}
	
	private static void gameTime(long time) {
		if(time < minTimeInGame) {
			minTimeInGame = time;
		}
		
		if(time > maxTimeInGame) {
			maxTimeInGame = time;
		}
		
		gameTime+= time;
	}
	
	public static void loadDetail() {
		File file = new File(Constante.getPathDetail());
		
	}
	
	private static void saveDetail() {
		
	}
}
