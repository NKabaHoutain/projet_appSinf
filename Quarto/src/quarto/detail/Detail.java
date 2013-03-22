package quarto.detail;

import java.sql.Time;

public class Detail {

	private static int numberWinGame;
	private static int numberLoseGame;
	private static int numberDrawGame;
	
	private static Time gameTime;
	private static Time minTimeInGame;
	private static Time maxTimeInGame;
	
	private static int minMoveInGame;
	private static int maxMoveInGame;
		
	public static void  addWinGame() {
		numberWinGame++;
	}
	
	public static void  addLoseGame() {
		numberLoseGame++;
	}
	
	public static void  addDrawGame() {
		numberDrawGame++;
	}
	
	public static void moveInGame(int move) {
		if(move<minMoveInGame) {
			minMoveInGame = move;
		}
		if(move>maxMoveInGame) {
			maxMoveInGame = move;
		}
	}
	
	public static void gameTime(Time time) {
		
		
		if(time.compareTo(minTimeInGame)<0) {
			minTimeInGame = time;
		}
	}
}
