package quarto.controller;

import quarto.model.Case;
import quarto.model.Game;
import quarto.model.Pion;
import quarto.model.Player;

public class Controller {
	
	private Game game;
	
	public Controller() {
		
	}
	
	public void startGame(){
		Player p1 = new Player("Nico");
		Player p2 = new Player("Kaba");
		
		game = new Game();
		game.addPlayer(this, p1, p2);
		game.beginGame();
	}
	
	public void givePion(Pion p, String nom) {
		game.givePion(p, nom);
	}
	
	public void giveCase(Case c, String nom) {
		game.giveCase(c, nom);
	}

}
