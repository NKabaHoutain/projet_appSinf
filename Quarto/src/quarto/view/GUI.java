package quarto.view;

import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import quarto.constante.Constante;
import quarto.controller.Controller;
import quarto.model.Board;
import quarto.view.constante.ViewConstante;
import quarto.view.gameView.EndView;
import quarto.view.gameView.GameItem;
import quarto.view.gameView.HelpView;
import quarto.view.menuView.DetailsView;
import quarto.view.menuView.GameModeView;
import quarto.view.menuView.MenuItem;
import quarto.view.menuView.OptionsView;
import quarto.view.menuView.PlayersInfoView;
import quarto.view.menuView.RulesView;
import quarto.view.menuView.ThemesView;


public class GUI implements ActionListener{
	
	private Controller controller;
	private JFrame mainFrame = new JFrame("Quarto");
	private PlayersInfoView playerDialog = null;
	private EndView endDialog;
	private Component c;
	private GameItem gameItem;
	
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
	public void startGame(Board board, String p1, String p2) {
		GameItem game = new GameItem(board,controller,this, p1, p2); 
		replace(game , "Quarto - Game");
	}	
	
	public void startGameMode() {
		replace(new GameModeView(this), "Quarto - Mode de Jeu");
	}
	
	public void startMenu(){
		replace(new MenuItem(this), "Quarto");
	}
	
	public void startRules() {
		replace(new RulesView(this),"Quarto-R�gle du jeu");
	}
	
	public void startOptions() {
		replace(new OptionsView(this),"Quarto-Options");
	}
	
	private void startDetail() {
		replace(new DetailsView(this),"Quarto-Details");
	}
	
	public void startPlayersInfo(boolean type) {
		 playerDialog= new PlayersInfoView(this, mainFrame.getLocation(),type);
	}
	
	public void startEndView() {
		endDialog = new EndView(this, mainFrame.getLocation());
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
			else if(((JButton) s).getText().equals(ViewConstante.BUTTON_VSPLAYER) ) {
				mainFrame.setEnabled(false); 
				startPlayersInfo(Constante.VSPLAYER);
				 
			}
			else if (((JButton) s).getText().equals(ViewConstante.BUTTON_VSIA) ) {
				mainFrame.setEnabled(false); 
				startPlayersInfo(Constante.VSIA);
			}
			else if(((JButton )s).getText().equals(ViewConstante.BUTTON_START) ){
				if(playerDialog.isName()) {
					playerDialog.dispose();
					mainFrame.setEnabled(true);
					controller.startGame(playerDialog.isIa(), playerDialog.getNameJ1(), playerDialog.getNameJ2());
				}
				else {
					playerDialog.startShake();
				}
			}
			else if(((JButton) s).getText().equals(ViewConstante.BUTTON_CANCEL)) {
				playerDialog.dispose();
				mainFrame.setEnabled(true);
			}
			else if(((JButton) s).getText().equals(ViewConstante.BUTTON_RETOUR) ||
					((JButton) s).getText().equals(ViewConstante.BUTTON_SAVE) ) {
				
				startMenu();
			}
			else if(((JButton) s).getText().equals(ViewConstante.BUTTON_UNDO) ) {
				controller.undo();
			}
			else if(((JButton) s).getText().equals(ViewConstante.BUTTON_SELECT_PION)) {
				controller.pionSelected();
			}
			else if(((JButton)s).getText().equals(ViewConstante.BUTTON_REGLE) ) {
				if (c instanceof GameItem) {
					JFrame frame = new JFrame();
					frame.add(new RulesView(null));
					frame.setVisible(true);
					frame.setResizable(false);
					frame.pack();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				else {
					startRules();
				}
			}
			else if(((JButton)s).getText().equals(ViewConstante.BUTTON_OPTION) ) {
				startOptions();
			}
			
			else if (((JButton)s).getText().equals(ViewConstante.BUTTON_END_OF_GAME) ) {
				mainFrame.setEnabled(false);
				startEndView();
			}
			else if (((JButton)s).getText().equals(ViewConstante.BUTTON_GIVE_UP) ) {
				controller.endOfGame();
				endDialog.dispose();
				mainFrame.setEnabled(true);
			}
			else if (((JButton)s).getText().equals(ViewConstante.BUTTON_RESTART) ) {
				controller.startGame(playerDialog.isIa(), playerDialog.getNameJ1(), playerDialog.getNameJ2());
				endDialog.dispose();
				mainFrame.setEnabled(true);
			}
			else if(((JButton)s).getText().equals(ViewConstante.BUTTON_HELP)){
				JFrame frame = new JFrame();
				frame.add(new HelpView(null));
				frame.setVisible(true);
				frame.setResizable(false);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			else if(((JButton)s).getText().equals(ViewConstante.BUTTON_CHANGE)){
				JFrame frame = new JFrame();
				frame.add(new ThemesView(this));
				frame.setVisible(true);
				frame.setResizable(false);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			else if (((JButton)s).getText().equals(ViewConstante.BUTTON_DETAIL) ) {
				startDetail();
			}
			else if (((JButton)s).getText().equals(ViewConstante.BUTTON_RETOUR_GAME)) {
				endDialog.dispose();
				mainFrame.setEnabled(true);
			}
		}
	}

	
}
