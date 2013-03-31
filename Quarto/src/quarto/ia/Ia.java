package quarto.ia;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import quarto.model.Board;
import quarto.model.Case;
import quarto.model.Pion;

public class Ia {
	private final static int HORIZON = 4;
	private static Move bestMove;
	
	public static Move playIa(Board board) {
		if(board.sizeHistoric() < 3) {
			return randomMove(board);
		}
		play(board, HORIZON, Integer.MIN_VALUE, Integer.MAX_VALUE, null);
		
		return bestMove;
	}
	
	private static int play(Board board, int horizon, int alpha, int beta, Case c) {
		if(winGame(board, c) || horizon <= 0) {
			return heuristic(board, horizon);
		}
		else {
			Move meilleurCoup = null;
			
			for(Move m : allMove(board)) {
				board.playMove(m);
				int score = - play( board, horizon-1, -beta, -alpha, m.getCase());
				board.undoMove(m);
				
				if(score >=beta) return score;
				if(score > alpha) {
					alpha = score;
					meilleurCoup = m;
				}
			}
			
			if(horizon == HORIZON) {
				bestMove = meilleurCoup;
			}
			return alpha;
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
			if(((HORIZON-horizon)%2) == 1)
				return - (1+horizon);
			else
				return 1+horizon;
					
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
