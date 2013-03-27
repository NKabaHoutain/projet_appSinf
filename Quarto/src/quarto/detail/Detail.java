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



public class Detail {

	private static int[][] numberGame= new int[3][3];
	private static long[] times = new long[3];
	private static int[] moves = new int[2];
	
	public static String getStringLevel(int lvl) {
		return numberGame[lvl][Constante.WINGAME] + "/" + 
				numberGame[lvl][Constante.LOSEGAME] + "/" + 
				numberGame[lvl][Constante.DRAWGAME];
	}
	
	public static String getStringTime() {
		return convertLongToTime(times[Constante.MAX_TIME]) + "/" + 
				convertLongToTime(times[Constante.MIN_TIME]);
	}
	
	public static String getStringMove() {
		return moves[Constante.MAX_MOVE] + "/" + 
				moves[Constante.MIN_MOVE];
	}
	
	public static String getStringTotalTime() {
		return convertLongToTime(times[Constante.TOTAL_TIME]);
	}
		
	private static String convertLongToTime(long time) {
		int seconde = (int) (time /1000) % 60;
		int minute = (int) ((time/60000) %60) ;
		int heure = (int) ((time/3600000));
		return heure+"h "+minute+"min "+seconde+"sec";
	}
		
	public static void addDetail(boolean isVsIa, int resultGame, long time, int move) {
		if(isVsIa) {
			numberGame[resultGame][Option.getGameLevel()] ++;
		}
		
		moveInGame(move);
		gameTime(time);
		
		try {
			saveDetail();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void moveInGame(int move) {
		if(move<moves[Constante.MIN_MOVE]) {
			moves[Constante.MIN_MOVE] = move;
		}
		if(move>moves[Constante.MAX_MOVE]) {
			moves[Constante.MAX_MOVE] = move;
		}
	}
	
	private static void gameTime(long time) {
		if(time < times[Constante.MIN_TIME]) {
			times[Constante.MIN_TIME] = time;
		}
		
		if(time > times[Constante.MAX_TIME]) {
			times[Constante.MAX_TIME] = time;
		}
		
		times[Constante.TOTAL_TIME]+= time;
	}
	
	private static void saveDetail() throws IOException {
		File file = new File(Constante.getPathDetail());
		BufferedWriter in = null;
		
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try{
		      in  = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
		      
		      
		      
		      for(int i=0; i<Constante.GAMELEVEL.length; i++) {
					in.write(Constante.GAMELEVEL[i]);
					in.newLine();
					writeLevel(i, in);
					in.newLine();
				}
		      
		      in.write(DetailField.MOVE);
		      in.newLine();
		      writeMove(in);
		      in.newLine();
		      in.write(DetailField.TIME);
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
	
	private static void writeLevel(int lvl, BufferedWriter in) throws IOException {
		for(int i=0; i<Constante.GAMESTAT.length; i++) {
			in.write(Constante.GAMESTAT[i] + "=" + numberGame[lvl][i]);
			in.newLine();
		}
	}
	private static void writeMove(BufferedWriter in) throws IOException {
		for(int i=0; i<Constante.GAMEMOVES.length; i++) {
			in.write(Constante.GAMEMOVES[i] + "=" + moves[i]);
			in.newLine();
		}
	}
	private static void writeTime(BufferedWriter in) throws IOException {
		for(int i=0; i<Constante.GAMETIME.length; i++) {
			in.write(Constante.GAMETIME[i] + "=" + times[i]);
			in.newLine();
		}
	}
	
	public static void loadDetail() throws IOException {
		File file = new File(Constante.getPathDetail());
		
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
		
			List<String> details = takeDetails(file);
			
			if(details.size()!=0) {
			
				for(int i=0; i<details.size(); i++) {
					if(details.get(i).equals(DetailField.TIME)) {
						addTime(details.subList(i+1, i+1+Constante.GAMETIME.length));
					}
					else if(details.get(i).equals(DetailField.MOVE)) {
						addMove(details.subList(i+1, i+1+Constante.GAMEMOVES.length));
					}
					else if(details.get(i).contains(DetailField.NIVEAU)) {
						int lvl = details.get(i).charAt(details.get(i).length()-1) - '0';
						addNumber(details.subList(i+1, i+1+Constante.GAMELEVEL.length), lvl);
					}
				}
			}
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
	
	
	private static void addNumber(List<String> list, int lvl) {
		numberGame[lvl-1][Constante.DRAWGAME] = Integer.parseInt(list.get(Constante.DRAWGAME).substring(Constante.GAMESTAT[Constante.DRAWGAME].length() +1));
		numberGame[lvl-1][Constante.WINGAME] = Integer.parseInt(list.get(Constante.WINGAME).substring(Constante.GAMESTAT[Constante.WINGAME].length() +1));
		numberGame[lvl-1][Constante.LOSEGAME] = Integer.parseInt(list.get(Constante.LOSEGAME).substring(Constante.GAMESTAT[Constante.LOSEGAME].length() +1));
	}

	private static void addMove(List<String> list) {
		moves[Constante.MAX_MOVE] = Integer.parseInt(list.get(Constante.MAX_MOVE).substring(Constante.GAMEMOVES[Constante.MAX_MOVE].length() +1));
		moves[Constante.MIN_MOVE] = Integer.parseInt(list.get(Constante.MIN_MOVE).substring(Constante.GAMEMOVES[Constante.MIN_MOVE].length() + 1));
	}

	private static void addTime(List<String> list) {		
		times[Constante.MAX_TIME] = Long.parseLong(list.get(Constante.MAX_TIME).substring(Constante.GAMETIME[Constante.MAX_TIME].length() +1));
		times[Constante.MIN_TIME] = Long.parseLong(list.get(Constante.MIN_TIME).substring(Constante.GAMETIME[Constante.MIN_TIME].length() +1));
		times[Constante.TOTAL_TIME] = Long.parseLong(list.get(Constante.TOTAL_TIME).substring(Constante.GAMETIME[Constante.TOTAL_TIME].length() +1));
	}
	

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
