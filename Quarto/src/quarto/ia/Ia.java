package quarto.ia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import quarto.model.Board;
import quarto.model.Case;
import quarto.model.Game;
import quarto.model.Pion;
import quarto.option.Option;
import quarto.view.GUI;

/**
 * Classe abstract qui englobe les differents level de l'IA
 */
public abstract class Ia extends Thread{
	protected int HORIZON = 3;
	protected Move bestMove;
	protected Game game;
	protected Board board;
	protected GUI gui;
	
	/**
	 * Methode abstract a implementer
	 * @param board
	 * @return
	 */
	abstract public Move playIa(Board board);
	
	/**
	 * @return Une Ia du level correspondant au option
	 */
	public static Ia createIa(Game g, Board b, GUI gu) {
		switch(Option.getGameLevel()) {
		case(0) : return new IaEasy(g,b,gu);
		case(1) : return new IaMedium(g,b,gu);
		default : return new IaHard(g,b,gu);
		}
	}
	
	/**
	 * Constructeur
	 */
	public Ia(Game g, Board b, GUI gu) {
		game = g;
		board = b;
		gui = gu;
	}
	
	public void run() {
		// Bloque la board
		game.getBoard().setIa(true);
		game.getBoard().change(game.getBoard());
		
		//Attend 1sec pour éviter un bug de l'interface
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Lance l'IA
		Move m = playIa(board);
		game.getBoard().setIa(false);
		
		// Soit l'IA a gagné, soit il selectionne le prochain pion
		if(game.move(m.getCase())) {
			game.addDetail();
			gui.startEndView(false);
			
		}
		else {
			board.selectPion(m.getSelectedPion());
			game.pionSelected();
		}
	}

	/**
	 * Joue un coup de negaMax avec la board et l'horizon reçu
	 * @param board
	 * @param horizon
	 * @param c
	 * @return
	 */
	protected int nega(Board board, int horizon, Case c) {
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
			
			if(horizon == HORIZON) 
				bestMove = meilleurCoup;
			
			return max;
		}
	}
	
	/**
	 * @param board
	 * @return La liste des mouvements possibles pour la board
	 */
	private List<Move> allMove(Board board) {
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
	
	/**
	 * @param board
	 * @param c
	 * @return true si le jeu est gagné
	 */
	private boolean winGame(Board board, Case c) {
			return c!=null && board.winGame(c);
	}

	/**
	 * @param board
	 * @param horizon
	 * @return La valeur de la board
	 */
	private int heuristic(Board board, int horizon) {
		if(board.getWinCase() == null) {
			return 0;
		}
		else {
				return -(1+horizon);
		}
	}
	
	/**
	 * @param board
	 * @return Un mouvement aleatoire
	 */
	protected Move randomMove(Board board) {
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
