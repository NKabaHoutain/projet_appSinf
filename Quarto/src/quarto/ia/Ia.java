package quarto.ia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import quarto.model.Board;
import quarto.model.Case;
import quarto.model.Game;
import quarto.model.Pion;
import quarto.view.GUI;

public class Ia extends Thread{
	private static int HORIZON = 3;
	private static Move bestMove;
	
	private Game game;
	private Board board;
	private GUI gui;
	
	public Ia(Game g, Board b, GUI gu) {
		game = g;
		board = b;
		gui = gu;
	}
	public void run() {
		game.getBoard().setIa(true);
		game.getBoard().change(game.getBoard());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Move m = playIa(board);
		game.getBoard().setIa(false);
		
		if(game.move(m.getCase())) {
			game.addDetail();
			gui.startEndView(false);
			
		}
		else {
			board.selectPion(m.getSelectedPion());
			game.pionSelected();
		}
	}
	public static Move playIa(Board board) {
		if(board.sizeHistoric() < 3) {
			return randomMove(board);
		}
		else if(board.sizeHistoric() <7) {
			HORIZON = 2;
			nega(board, HORIZON, null);
		}
		else if (board.sizeHistoric() <17) {
			HORIZON = 3;
			nega(board, HORIZON, null);
		}
		else {
			HORIZON = 4;
			nega(board, HORIZON, null);
		}
		
		return bestMove;
	}
	
	private static int nega(Board board, int horizon, Case c) {
		if(winGame(board, c) || horizon <= 0) {
			return heuristic(board, horizon);
		}
		else {
			Move meilleurCoup = null;
			int max = Integer.MIN_VALUE;
			
			for(Move m : allMove(board)) {
				
				board.playMove(m);
				int score = - nega( board, horizon-1,  m.getCase());
				board.undoMove(m);
				
				if(score>=max){
					max=score;
					meilleurCoup = m;
				}
			}
			
			if(horizon == HORIZON) {
				bestMove = meilleurCoup;
			}
			
			return max;
		}
	}
	
	private static List<Move> allMove(Board board) {
		List<Move> allMove = new ArrayList<Move>();
		Pion select = board.getSelectedPion();
		List<Pion> pionAvailable = board.getAvailablePions();
		pionAvailable.remove(select);
		
		for(Case c : board.getAvailableCase()) {
			for(Pion p : pionAvailable) {
				allMove.add(new Move(c, select, p));
			}
		}
		
		pionAvailable.add(select);
		return allMove;
	}
	
	private static boolean winGame(Board board, Case c) {
			return c!=null && board.winGame(c);
	}

	private static int heuristic(Board board, int horizon) {
		if(board.getWinCase() == null) {
			return 0;
		}
		else {
				return -(1+horizon);
		}
	}
	
	private static Move randomMove(Board board) {
		Pion select = board.getSelectedPion();
		List<Pion> pionAvailable = board.getAvailablePions();
		pionAvailable.remove(select);
		List<Case> caseAvailable = board.getAvailableCase();
		
		Random r = new Random();
		
		int randomCase = r.nextInt(caseAvailable.size());
		int randomPion = r.nextInt(pionAvailable.size());
		
		pionAvailable.add(select);
		
		return new Move(caseAvailable.get(randomCase), select, pionAvailable.get(randomPion));
		
	}
}
