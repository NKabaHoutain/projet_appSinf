package quarto.model;

import quarto.detail.Detail;
import quarto.ia.Ia;
import quarto.ia.Move;

public class Game {
	
	private Board board;
	private Player playerOne;
	private Player playerTwo;
	
	/*
	 * INITIALISATION
	 **************** 
	 */
	/**
	 * Constructeur
	 * @param p1
	 * @param p2
	 */
	public Game(Player p1, Player p2) {
		board = new Board();
		playerOne = p1;
		playerTwo = p2;

		playerOne.setInGame(true);
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void addDetail() {
		Detail.addDetail(isVsIa(), board.getGameStat(), board.getGameTime(), board.getNumberMove());
	}
	
	public boolean isVsIa() {
		return playerTwo.isIa();
	}
	
	/*
	 * METHODE SUR LES PLAYER
	 ************************ 
	 */
	private Player PlayerInGame() {
		if(playerOne.isInGame()) {
			return playerOne;
		}
		return playerTwo;
	}
	
	private void changeGamer()
	{
		playerOne.setInGame(!playerOne.isInGame());
		playerTwo.setInGame(!playerTwo.isInGame());
	}
	
	private String nextPlayer() {
		changeGamer();
		
		if(playerOne.isInGame()) {
			return playerOne.getNom();
		}
		return playerTwo.getNom();
	}
	
	public Player selectPlayer(String nom) {
		if(playerOne.getNom().equals(nom)) {
			return playerOne;
		}
		return playerTwo;
	}

	/*
	 * METHODE SUR LA BOARD
	 ********************** 
	 */
	public void move(Case c) {
		board.move(c);
		int statement = board.getGameStat();
		
		
		//TODO start dialogue pour recommencer
		
	}

	public void pionSelected() {
		board.pionSelected(nextPlayer());
		if(PlayerInGame().isIa()) {
			playIa(Ia.playIa(board));
		}
	}
	
	public void selectPion(Pion p) {
		board.selectPion(p);
	}

	public void undo() {
		if(board.lastMoveisCase()) {
			board.undo(PlayerInGame().getNom());	
		}
		else {
			board.undo(nextPlayer());
		}
	}
	
	public void playIa(Move m) {
		move(m.getCase());
		board.selectPion(m.getSelectedPion());
		pionSelected();
	}
	


}
