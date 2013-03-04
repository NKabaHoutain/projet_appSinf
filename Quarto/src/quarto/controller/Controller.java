package quarto.controller;

import quarto.model.Game;
import quarto.model.Player;

public class Controller {
	
	public Controller() {
		
		
	}
	
	public void startGame(){
		Player p1 = new Player("Nico");
		Player p2 = new Player("Kaba");
		
		Game game = new Game(this, p1, p2);
	}

}
