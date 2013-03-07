package quarto.view;

import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import quarto.controller.Controller;
import quarto.model.Board;
import quarto.view.MenuView.GameModeView;
import quarto.view.MenuView.MenuItem;
import quarto.view.gameView.BoardGameItem;

public class GUI {
	
	private Controller controller;
	private JFrame mainFrame = new JFrame("Quarto");
	private Component c;
	
	public GUI(Controller controller) throws IOException {
		this.controller = controller;
		c = new MenuItem();
		mainFrame.add(c);
		
		endOfFrame();
	}
		
	public void startGame(Board board) {
		BoardGameItem bg = new BoardGameItem(board, controller);
		board.addObserver(bg);
		replace(bg , "Quarto - Game");
	}
	
	public void startGameMode() {
		replace(new GameModeView(), "Quarto - Mode de Jeu");
	}
	
	public void startMenu() throws IOException {
		replace(new MenuItem(), "Quarto");
	}
	
	private void replace(Component actuel, String newName) {
		mainFrame.remove(c);
		c=actuel;
		mainFrame.add(c);
		
		endOfFrame();
	}
	
	private void endOfFrame(){
		
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void adjustSize(Component c, Dimension min, Dimension max, Dimension pref) {
		c.setMinimumSize(min);
		c.setMaximumSize(max);
		c.setPreferredSize(pref);
	}
	
	

}
