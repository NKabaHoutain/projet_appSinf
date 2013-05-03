package quarto.detail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import quarto.constante.Constante;
import quarto.option.Option;

/**
 * S'occupe de save/load les details
 */
public class Detail {
	
	/**
	 * Constante propre au detail.
	 */
	public static final String NIVEAU = "Niveau";
	public static final String TIME = "Time";
	public static final String MOVE = "Move";
	

	private static int[][] numberGame= new int[3][3];
	private static long[] times = new long[3];
	private static int[] moves = new int[2];
	
	/**
	 * Ajoute les details d'une partie dans cette classe,
	 *  puis sauvegarde ceux ci dans le fichier detail.txt
	 * @param isVsIa
	 * @param resultGame
	 * @param time
	 * @param move
	 */
	public static void addDetail(boolean isVsIa, int resultGame, long time, int move) {
		if(isVsIa) 
			numberGame[Option.getGameLevel()][resultGame] ++;
		
		if(resultGame != Constante.NOWINGAME ) {
			moveInGame(move);
			gameTime(time);
		}
		
		times[Constante.TOTAL_TIME]+= time;
		
		try {
			saveDetail();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ajoute le temps et save
	 * @param time
	 */
	public static void addTotalTime(long time) {
		times[Constante.TOTAL_TIME]+= time;
		
		try {
			saveDetail();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Rajoute les moves dans les details de la classe
	 * @param move
	 */
	private static void moveInGame(int move) {
		if(move<moves[Constante.MIN_MOVE]) {
			moves[Constante.MIN_MOVE] = move;
		}
		if(move>moves[Constante.MAX_MOVE]) {
			moves[Constante.MAX_MOVE] = move;
		}
	}
	
	/**
	 * Rajoute le temps dans les details de la classe
	 * @param time
	 */
	private static void gameTime(long time) {
		if(time < times[Constante.MIN_TIME]) {
			times[Constante.MIN_TIME] = time;
		}
		
		if(time > times[Constante.MAX_TIME]) {
			times[Constante.MAX_TIME] = time;
		}
	}
	
	/* SAVE DETAILS
	 ************************************************************ 
	 */
	
	/**
	 * Save les details
	 * @throws IOException
	 */
	private static void saveDetail() throws IOException {
		File file = new File(Constante.getPathDetail());
		BufferedWriter in = null;
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try{
		      in  = new BufferedWriter(new FileWriter(file.getAbsolutePath()));

		      // Ecrit les levels
		      for(int i=0; i<Constante.GAMELEVEL.length; i++) {
					in.write(Constante.GAMELEVEL[i]);
					in.newLine();
					writeLevel(i, in);
					in.newLine();
		      }
		      
		      // Ecrit les moves
		      in.write(MOVE);
		      in.newLine();
		      writeMove(in);
		      in.newLine();
		      
		      // Ecrit les times
		      in.write(TIME);
		      in.newLine();
		      writeTime(in);
		    }
		catch(Exception e){
		      e.printStackTrace();
		    }
		finally {
			in.close();
		}
	}
	
	/**
	 * Ecris les details des levels dans le BufferedWriter
	 */
	private static void writeLevel(int lvl, BufferedWriter in) throws IOException {
		for(int i=0; i<Constante.GAMESTAT.length; i++) {
			in.write(Constante.GAMESTAT[i] + "=" + numberGame[lvl][i]);
			in.newLine();
		}
	}
	
	/**
	 * Ecris les details des moves dans le BufferedWriter
	 */
	private static void writeMove(BufferedWriter in) throws IOException {
		for(int i=0; i<Constante.GAMEMOVES.length; i++) {
			in.write(Constante.GAMEMOVES[i] + "=" + moves[i]);
			in.newLine();
		}
	}
	
	/**
	 * Ecris les details des times dans le BufferedWriter
	 */
	private static void writeTime(BufferedWriter in) throws IOException {
		for(int i=0; i<Constante.GAMETIME.length; i++) {
			in.write(Constante.GAMETIME[i] + "=" + times[i]);
			in.newLine();
		}
	}
	
	/**
	 * @param lvl
	 * @return Le detail du level correspondant en String
	 */
	public static String getStringLevel(int lvl) {
		return numberGame[lvl][Constante.WINGAME] + "/" + 
				numberGame[lvl][Constante.LOSEGAME] + "/" + 
				numberGame[lvl][Constante.DRAWGAME];
	}
	
	/**
	 * @return Le detail des times en String
	 */
	public static String getStringTime() {
		return convertLongToTime(times[Constante.MAX_TIME]) + "/" + 
				convertLongToTime(times[Constante.MIN_TIME]);
	}
	
	/**
	 * @return Le detail des moves en String
	 */
	public static String getStringMove() {
		return moves[Constante.MAX_MOVE] + "/" + 
				moves[Constante.MIN_MOVE];
	}
	
	/**
	 * @return Le temps de jeu total
	 */
	public static String getStringTotalTime() {
		return convertLongToTime(times[Constante.TOTAL_TIME]);
	}
		
	/**
	 * @param time
	 * @return Converti time en String
	 */
	private static String convertLongToTime(long time) {
		int seconde = (int) (time /1000) % 60;
		int minute = (int) ((time/60000) %60) ;
		int heure = (int) ((time/3600000));
		return heure+"h "+minute+"min "+seconde+"sec";
	}
		
	
	/* LOAD DETAILS
	 ************************************************************
	 */
	/**
	 * Load les details depuis le fichier
	 * @throws IOException
	 */
	public static void loadDetail() throws IOException {
		File file = new File(Constante.getPathDetail());
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			List<String> details = takeDetails(file);
			if(details.size()!=0) {
				// Ajoute les times/moves/level
				for(int i=0; i<details.size(); i++) {
					if(details.get(i).equals(TIME)) {
						addTime(details.subList(i+1, i+1+Constante.GAMETIME.length));
					}
					else if(details.get(i).equals(MOVE)) {
						addMove(details.subList(i+1, i+1+Constante.GAMEMOVES.length));
					}
					else if(details.get(i).contains(NIVEAU)) {
						int lvl = details.get(i).charAt(details.get(i).length()-1) - '0';
						addNumber(details.subList(i+1, i+1+Constante.GAMELEVEL.length), lvl);
					}
				}
			}
			// Si le fichier est vide
			else {
				for(int i=0; i<Constante.GAMELEVEL.length; i++) {
					for(int j=0; i<Constante.GAMESTAT.length; i++) {
						numberGame[i][j] = 0;
					}
				}
				
				for(int i=0; i<Constante.GAMETIME.length; i++) {
					times[i] = 0;
				}
				
				moves[Constante.MAX_MOVE] = 0;
				moves[Constante.MIN_MOVE] = 16;
			}
		}
	}
	
	/**
	 * Ajoute les details des levels
	 * @param list
	 * @param lvl
	 */
	private static void addNumber(List<String> list, int lvl) {
		numberGame[lvl-1][Constante.DRAWGAME] = Integer.parseInt(list.get(Constante.DRAWGAME).substring(Constante.GAMESTAT[Constante.DRAWGAME].length() +1));
		numberGame[lvl-1][Constante.WINGAME] = Integer.parseInt(list.get(Constante.WINGAME).substring(Constante.GAMESTAT[Constante.WINGAME].length() +1));
		numberGame[lvl-1][Constante.LOSEGAME] = Integer.parseInt(list.get(Constante.LOSEGAME).substring(Constante.GAMESTAT[Constante.LOSEGAME].length() +1));
	}

	/**
	 * Ajoute les details des moves
	 * @param list
	 */
	private static void addMove(List<String> list) {
		moves[Constante.MAX_MOVE] = Integer.parseInt(list.get(Constante.MAX_MOVE).substring(Constante.GAMEMOVES[Constante.MAX_MOVE].length() +1));
		moves[Constante.MIN_MOVE] = Integer.parseInt(list.get(Constante.MIN_MOVE).substring(Constante.GAMEMOVES[Constante.MIN_MOVE].length() + 1));
	}

	/**
	 * Ajoute les details des time
	 * @param list
	 */
	private static void addTime(List<String> list) {		
		times[Constante.MAX_TIME] = Long.parseLong(list.get(Constante.MAX_TIME).substring(Constante.GAMETIME[Constante.MAX_TIME].length() +1));
		times[Constante.MIN_TIME] = Long.parseLong(list.get(Constante.MIN_TIME).substring(Constante.GAMETIME[Constante.MIN_TIME].length() +1));
		times[Constante.TOTAL_TIME] = Long.parseLong(list.get(Constante.TOTAL_TIME).substring(Constante.GAMETIME[Constante.TOTAL_TIME].length() +1));
	}
	
	/**
	 * @param file
	 * @return Les details sous forme d'une liste de String ou chaque ligne est un String.
	 * @throws IOException
	 */
	private static List <String> takeDetails(File file) throws IOException {
		List<String> list = new ArrayList<String>();
		BufferedReader in = null;
		
		try{
		      in  = new BufferedReader(new FileReader(file.getAbsolutePath()));
		      String line;
		      while ((line = in.readLine()) != null) {
		    	  list.add(line.trim());
		      }
		    }
		catch(Exception e){
		      e.printStackTrace();
		    }
		finally {
			in.close();
		}
		return list;
	}

}
