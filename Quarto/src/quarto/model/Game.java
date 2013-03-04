package quarto.model;

import quarto.controller.Controller;
import quarto.view.gameView.BoardGameItem;
import quarto.view.gameView.PlayerItem;

public class Game {
	
	private Board board;
	private BoardGameItem boardGameItem;
	private Player playerOne;
	private Player playerTwo;
	
	
	public Game() {
		
		board = new Board();
		boardGameItem = new BoardGameItem(board);
		
		boardGameItem.startDisplay();
		
	}
	
	public void addPlayer(Controller controller, Player p1, Player p2){
		PlayerItem j1 = new PlayerItem(p1.getNom(), controller);
		PlayerItem j2 = new PlayerItem(p2.getNom(), controller);
		
		boardGameItem.addListener(j1);
		boardGameItem.addListener(j2);
		
		playerOne = p1;
		playerTwo = p2;
		
		j1.setInGame(true);
	}
	
	public void beginGame() {

		System.out.println(playerOne.choicePion());
		
	}
	public void givePion(Pion p, String player) {
		getPlayer(player).setPionChoice(p);
	}
	
	public void giveCase(Case c, String player) {
		getPlayer(player).setCaseChoice(c);
	}
	
	public Player getPlayer(String nom) {
		if(playerOne.getNom().equals(nom)) {
			return playerOne;
		}
		return playerTwo;
	}


}
