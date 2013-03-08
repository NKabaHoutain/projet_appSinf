package quarto.view.gameView;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import quarto.model.Board;
import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class BoardSideItem extends JPanel implements Observer{
	
	JButton end;
	JButton rules;
	JButton restart;
	JButton undo ;
	JButton fullScreen;

	JTextField msg;
	JButton selectPion;


	public BoardSideItem(GUI gui){
		end = new JButton(ViewConstante.BUTTON_END_OF_GAME);
		rules = new JButton(ViewConstante.BUTTON_REGLE);
		restart = new JButton(ViewConstante.BUTTON_RESTART);
		undo = new JButton(ViewConstante.BUTTON_UNDO);
		fullScreen =  new JButton(ViewConstante.BUTTON_FULLSCREEN);
		msg = new JTextField(ViewConstante.TEXTFIELD_MESSAGE);
		selectPion = new JButton(ViewConstante.BUTTON_SELECT_PION);
		
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(120,600));

		
	


		initButton(end, gui);
		initButton(rules, gui);
		initButton(restart, gui);
		initButton(undo, gui);
		initButton(fullScreen, gui);
		initButton(selectPion,gui);
		msg.setPreferredSize(new Dimension(110,70));
		msg.setEditable(false);
		selectPion.setPreferredSize(new Dimension(110,40));

		
		this.add(Box.createVerticalStrut(15));
		this.add(rules);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(undo);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(fullScreen);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(end);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(restart);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(msg);
		this.add(Box.createRigidArea(ViewConstante.space[ViewConstante.BOARDSIDE]));
		this.add(selectPion);
		this.add(Box.createVerticalStrut(15));
		this.setVisible(true);
		
	}

	
	private void initButton(JButton c, GUI gui) {
		GUI.adjustSize(c ,ViewConstante.BOARDSIDE);
		c.addActionListener(gui);
		GUI.initElement(c);		
	}

	@Override
	public void update(Observable ob, Object arg) {
		if (arg instanceof Board) {
			undo.setEnabled(((Board) arg).isHistoric());
		}
		


	}

}
