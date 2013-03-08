package quarto.view.gameView;
import java.awt.Dimension;

import javax.swing.*;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class BoardSideItem extends JPanel {
	
	JButton end;
	JButton rules;
	JButton restart;
	JButton undo;
	JButton fullScreen;
	

	
	
	public BoardSideItem(GUI gui){
		end = new JButton(ViewConstante.BUTTON_END_OF_GAME);
		rules = new JButton(ViewConstante.BUTTON_REGLE);
		restart = new JButton(ViewConstante.BUTTON_RESTART);
		undo = new JButton(ViewConstante.BUTTON_UNDO);
		fullScreen =  new JButton(ViewConstante.BUTTON_FULLSCREEN);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(120,600));
		
		GUI.initElement(end);
		GUI.initElement(rules);
		GUI.initElement(restart);
		GUI.initElement(undo);
		GUI.initElement(fullScreen);
		
		GUI.adjustSize(end, ViewConstante.BOARDSIDE);
		GUI.adjustSize(rules, ViewConstante.BOARDSIDE);
		GUI.adjustSize(restart, ViewConstante.BOARDSIDE);
		GUI.adjustSize(undo, ViewConstante.BOARDSIDE);
		GUI.adjustSize(fullScreen, ViewConstante.BOARDSIDE);
		
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
		this.add(Box.createVerticalStrut(15));
		this.setVisible(true);
		
	}

}
