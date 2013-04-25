package quarto.view.gameView;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import quarto.constante.Constante;
import quarto.model.Board;
import quarto.option.Option;
import quarto.view.GUI;
import quarto.view.button.GameButton;
import quarto.view.constante.ViewConstante;
import quarto.view.menuView.InfoPlayerGame;

public class BoardSideItem extends JPanel implements Observer{
	
	GameButton end;
	GameButton rules;
	GameButton help;
	GameButton undo ;

	InfoPlayerGame msg;
	GameButton selectPion;
	
	ImageIcon img ;

	public BoardSideItem(GUI gui, boolean isIa, String p1, String p2){
		
		end = new GameButton(ViewConstante.BUTTON_END_OF_GAME, gui, ViewConstante.BOARDSIDE, Constante.END);
		rules = new GameButton(ViewConstante.BUTTON_REGLE, gui, ViewConstante.BOARDSIDE, Constante.RULES);
		help = new GameButton(ViewConstante.BUTTON_HELP, gui, ViewConstante.BOARDSIDE, Constante.HELP);
		undo = new GameButton(ViewConstante.BUTTON_UNDO, gui, ViewConstante.BOARDSIDE, Constante.UNDO);
		selectPion = new GameButton(ViewConstante.BUTTON_SELECT_PION, gui, ViewConstante.BOARDSIDE, Constante.HAND);
		
		msg = new InfoPlayerGame(isIa, p1, p2);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(120,600));
		
		undo.setEnabled(false);
		selectPion.setEnabled(false);

		
		msg.setPreferredSize(new Dimension(110,70));
		selectPion.setPreferredSize(new Dimension(110,40));

		
		this.add(Box.createVerticalStrut(15));
		this.add(rules);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(undo);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(end);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(help);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(msg);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(selectPion);
		this.add(Box.createVerticalStrut(15));
		this.setVisible(true);
		
		setBorder(BorderFactory.createEmptyBorder(0, 
				ViewConstante.SIZE_BORDER_GAME, 
				0,
				ViewConstante.SIZE_BORDER_GAME));
		
		img = new ImageIcon(Constante.getPathTheme(Option.getTheme())+Constante.DEGRAD);
	}

	@Override
	public void update(Observable ob, Object arg) {
		if (arg instanceof Board) {
			undo.setEnabled(Option.isUndo() && ((Board) arg).isHistoric() );
			selectPion.setEnabled(((Board) arg).canSelectedPion());
		}
		if (arg instanceof String) {
			msg.change(((String)arg));
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	       
		g.drawImage(img.getImage(), 0,0, getWidth(), getHeight(), this);	
	}

}
