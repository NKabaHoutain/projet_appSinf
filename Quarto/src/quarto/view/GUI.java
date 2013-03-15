package quarto.view;

import java.awt.Component;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import quarto.controller.Controller;
import quarto.model.Board;
import quarto.view.constante.ViewConstante;
import quarto.view.gameView.BoardGameItem;
import quarto.view.gameView.CaseItem;
import quarto.view.gameView.GameItem;
import quarto.view.menuView.GameModeView;
import quarto.view.menuView.GameTypeView;
import quarto.view.menuView.MenuItem;
import quarto.view.menuView.RulesView;
import quarto.view.gameView.BoardSideItem;


public class GUI implements ActionListener{
	
	private Controller controller;
	private JFrame mainFrame = new JFrame("Quarto");
	private Component c;
	
	/* CONSTRUCTEUR
	 ************** 
	 */
	/**
	 * Constructeur
	 * @param controller
	 * @throws IOException
	 */
	public GUI(Controller controller) throws IOException {
		this.controller = controller;
		c = new MenuItem(this);
		mainFrame.add(c);
		
		endOfFrame();
	}
	
	/* DEMARRAGE DES INTERFACES
	 ************************** 
	 */
	public void startGame(Board board) {
		GameItem game = new GameItem(board,controller,this); 
		replace(game , "Quarto - Game");
	}
	
	public void startGameMode() {
		replace(new GameModeView(this), "Quarto - Mode de Jeu");
	}
	
	public void startMenu() throws IOException {
		replace(new MenuItem(this), "Quarto");
	}
	
	public void startGameType() {
		replace(new GameTypeView(this), "Quarto - Type de partie");
	}
	
	public void startRules() {
		replace(new RulesView(this),"Quarto-R�gle du jeu");
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
	
	public JFrame getFrame() {
		return mainFrame;
	}
	
	public static void adjustSize(Component c, int constante) {
		c.setMinimumSize(ViewConstante.minSize[constante]);
		c.setMaximumSize(ViewConstante.maxSize[constante]);
		c.setPreferredSize(ViewConstante.preferredSize[constante]);
	}
	
	public static void initElement(JComponent c) {
		c.setAlignmentX(Component.CENTER_ALIGNMENT);
		c.setAlignmentY(Component.CENTER_ALIGNMENT);
	}
	
	/**
	 * Gere les actions relatives uniquement à l'interface
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		
		if(s instanceof JButton) {
			if( ((JButton) s).getText().equals(ViewConstante.BUTTON_STARTMENU)) {
				startGameMode();
			}
			else if(((JButton) s).getText().equals(ViewConstante.BUTTON_CLASSIC)  ) {
				startGameType();
			}
			else if(((JButton) s).getText().equals(ViewConstante.BUTTON_VSPLAYER) ) {
				controller.startGame();
			}
			else if(((JButton) s).getText().equals(ViewConstante.BUTTON_RETOUR) ) {
				try {
					startMenu();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if(((JButton) s).getText().equals(ViewConstante.BUTTON_UNDO) ) {
				controller.undo();
			}
			else if(((JButton) s).getText().equals(ViewConstante.BUTTON_SELECT_PION)) {
				controller.pionSelected();
			}
			else if(((JButton)s).getText().equals(ViewConstante.BUTTON_REGLE) ) {
				startRules();
				
			}
		}
		
	}
	
	

}
