package quarto.model;

import quarto.controller.Controller;
import quarto.view.gameView.BoardGameItem;
import quarto.view.gameView.PlayerItem;

public class Game {
	
	private Board board;
	private Player playerOne;
	private Player playerTwo;
	private BoardGameItem boardGameItem;
	
	
	public Game() {
		
		board = new Board();
		boardGameItem = new BoardGameItem(board);
		board.addObserver(boardGameItem);
		
		boardGameItem.startDisplay();
		
	}
	
	public void addPlayer(Controller controller, Player p1, Player p2){
		PlayerItem j1 = new PlayerItem(p1, controller);
		PlayerItem j2 = new PlayerItem(p2, controller);
		
		boardGameItem.addListener(j1);
		boardGameItem.addListener(j2);
		
		playerOne = p1;
		playerTwo = p2;
		
	}
	
	public void beginGame() {

		playerOne.setInGame(true);
		Pion p = (playerOne.choicePion());
		board.selectPion(p);
		changeGamer();
		Case c = (playerTwo.choiceCase());
		
		board.move(c);
		
	}
	
	private void changeGamer()
	{
		playerOne.setInGame(!playerOne.isInGame());
		playerTwo.setInGame(!playerTwo.isInGame());
	}
	public void givePion(Pion p, String player) {
		selectPlayer(player).setPionChoice(p);
	}
	
	public void giveCase(Case c, String player) {
		selectPlayer(player).setCaseChoice(c);
	}
	
	public Player selectPlayer(String nom) {
		if(playerOne.getNom().equals(nom)) {
			return playerOne;
		}
		return playerTwo;
	}


}
