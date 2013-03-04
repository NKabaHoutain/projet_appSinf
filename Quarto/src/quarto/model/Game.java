package quarto.model;

import quarto.controller.Controller;
import quarto.view.gameView.BoardGameItem;
import quarto.view.gameView.PlayerItem;

public class Game {
	
	private Board board;
	private BoardGameItem boardGameItem;
	private Controller controller;
	
	
	public Game(Controller controller, Player p1, Player p2) {
		
		board = new Board();
		boardGameItem = new BoardGameItem(board);
		
		boardGameItem.startDisplay();
		
		PlayerItem j1 = new PlayerItem(p1.getNom());
		PlayerItem j2 = new PlayerItem(p2.getNom());
		
		boardGameItem.addListener(j1);
		boardGameItem.addListener(j2);
		
	}


}
