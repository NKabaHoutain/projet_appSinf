package quarto.view.gameView;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import quarto.controller.Controller;
import quarto.model.Board;
import quarto.view.GUI;
import quarto.view.gameView.BoardGameItem;
import quarto.view.gameView.BoardSideItem;

public class GameItem extends JPanel implements Observer{
	
	BoardGameItem boardGame;
	BoardSideItem boardSide;
	GUI gui;
	
	public GameItem(Board board, Controller controller,GUI gui){
		this.gui = gui;
		boardGame = new BoardGameItem(board,controller);
		boardSide = new BoardSideItem(gui);
		board.addObserver(boardGame);
		board.addObserver(boardSide);
		board.addObserver(this);
		this.setLayout(new BorderLayout());
		this.add(boardGame,BorderLayout.WEST);
		this.add(boardSide,BorderLayout.EAST);
		this.setVisible(true);
		
		
	}
	
	public BoardGameItem getBoardGameItem() {
		return boardGame;
	}
	
	/**
	 * Remplace temporairement le contenu d'une frame par un contenu provisoire.
	 * @param frame la frame où l'on doit afficher le contenu provisoire
	 * @param temp le contenu provisoire
	 * @param millis la durée d'affichage du contenu provisoire
	 * @return le contenu temporairement masqué
	 */
	public static void replace(final JFrame frame, final Container temp, final long millis)
	{
	    // Sauvegarde du panel courant
	    final Container pane = frame.getContentPane();
	    
	    // Dimpensionnement à l'identique du panel remplacant
	    temp.setSize(pane.getSize());
	    
	    // Remplacement du panel
	    frame.setContentPane(temp);
	    frame.repaint();
	    
	    // Création d'un délai avant de remettre en place le contenu
	    new Thread()
	    {
	        public void run()
	        {
	            // Attente
	            try {Thread.sleep(millis); } catch (InterruptedException e) {}
	            
	            // Remise en place du panel initial
	            frame.setContentPane(pane);
	            frame.repaint();
	        }
	    }.start();
	    
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof String) {
			JLabel l = new JLabel(((String)arg1));
			JPanel p = new JPanel();
			p.add(l);
			
			replace(gui.getFrame(), p, 1000);
		}
	}


}
