package quarto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Timer;

import quarto.model.Case;
import quarto.model.Game;
import quarto.model.Pion;
import quarto.model.Player;
import quarto.sound.Audio;
import quarto.sound.Music;
import quarto.view.GUI;
import quarto.view.gameView.BoardGameItem;
import quarto.view.gameView.CaseItem;
import quarto.view.gameView.PionItem;

public class Controller implements ActionListener, MouseListener{
	
	private GUI gui;
	private Game game;
	private Music music;
	
	/* CONSTRUCTEUR
	 ************** 
	 */
	/**
	 * Constructeur de base
	 * @throws IOException
	 */
	public Controller() throws IOException {
		gui = new GUI(this);
		music = new Music();
		music.start();
	}
	
	/* METHODE DE L'INTERFACE
	 ************************ 
	 */
	/**
	 * Démarre une partie
	 */
	public void startGame(){
		
		game = new Game(new Player("Nico"), new Player("Kaba"));
		
		gui.startGame(game.getBoard());
		
		
	}
	/**
	 * Joue un coup en arrière dans la board
	 */
	public void undo() {
		game.undo();
	}
	
	public void pionSelected() {
		if(game.getBoard().getSelectedPion() != null) {
			game.pionSelected();
		}
	}
	
	/**
	 * Gere les actions de l'interface relative au model
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
			if(s instanceof CaseItem) {
				if (game.move(((CaseItem) s).getCase())) {
					
				}
				
			}
			
			if ( s instanceof PionItem) {
				game.selectPion(((PionItem) s).getPion());
			}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount() > 1) {
			game.pionSelected();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
