package quarto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;

import quarto.model.Case;
import quarto.model.Game;
import quarto.model.Pion;
import quarto.model.Player;
import quarto.view.GUI;
import quarto.view.gameView.BoardGameItem;
import quarto.view.gameView.CaseItem;
import quarto.view.gameView.PionItem;

public class Controller implements ActionListener{
	
	private GUI gui;
	private Game game;
	
	public Controller() throws IOException {
		gui = new GUI(this);
	}
	
	public void startGame(){
		
		game = new Game(new Player("Nico"), new Player("Kaba"));
		
		gui.startGame(game.getBoard());
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
			if(s instanceof CaseItem) {
				if (game.move(((CaseItem) s).getCase())) {
					try {
						gui.startMenu();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
			
			if ( s instanceof PionItem) {
				game.selectPion(((PionItem) s).getPion());
			}
		
	}

	public void undo() {
		game.getBoard().undo();
	}

}
