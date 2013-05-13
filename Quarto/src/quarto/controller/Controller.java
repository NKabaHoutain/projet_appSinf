package quarto.controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.JFrame;

import quarto.detail.Detail;
import quarto.ia.Ia;
import quarto.model.Game;
import quarto.model.Player;
import quarto.sound.Music;
import quarto.view.GUI;
import quarto.view.gameView.CaseItem;
import quarto.view.gameView.EndView;
import quarto.view.gameView.PionItem;

public class Controller implements ActionListener, MouseListener{
	
	private GUI gui;
	private Game game;
	public static Music music;

	private Ia t;
	
	/* CONSTRUCTEUR
	 ************** 
	 */
	/**
	 * Constructeur de base
	 * @throws IOException
	 */
	public Controller() throws IOException {
		Detail.loadDetail();
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
	public void startGame(boolean vsIa, String J1, String J2){
		
		game = new Game(new Player(J1, false), new Player(J2, vsIa));
		
		gui.startGame(game.getBoard(), J1, J2);
	}
	/**
	 * Joue un coup en arrière dans la board
	 */
	public void undo() {
		game.undo();
	}
	
	/**
	 * Selectionne un pion pour le joueur suivant
	 * Si celui ci est l'IA, elle joue.
	 */
	public void pionSelected() {
		if(game.getBoard().getSelectedPion() != null) {
			game.pionSelected();
			
			if(game.PlayerInGame().isIa()) {
				t = Ia.createIa(game, game.getBoard(), gui);
				game.getBoard().change(null);
				t.start();
			}
		}
	}
	
	/**
	 * Termine la partie
	 */
	public void endOfGame() {
		gui.startMenu();
		Detail.addTotalTime(game.getBoard().getGameTime());
	}
	
	/**
	 * 
	 * @return true si le joueur joue contre une IA
	 */
	public boolean isIa() {
		return game.isVsIa();
	}
	
	/**
	 * Gere les actions de l'interface relative au model
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		
			// Effectue un mouvement
			if(s instanceof CaseItem) {
				if(game.move(((CaseItem) s).getCase())) {
					game.addDetail();
					gui.startEndView(false);
				}
			}
			
			// Selectionne momentanment un pion
			if ( s instanceof PionItem) {
				game.selectPion(((PionItem) s).getPion());
			}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount() > 1) {
			pionSelected();
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
