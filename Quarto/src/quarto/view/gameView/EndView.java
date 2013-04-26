package quarto.view.gameView;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;

import javax.swing.*;

import quarto.view.GUI;
import quarto.view.button.DialogButton;
import quarto.view.constante.ViewConstante;

public class EndView extends JDialog {
	JPanel panelGiveUp;
	JPanel panelResume;
	JPanel panelReset;
	DialogButton giveUp;
	DialogButton resume;
	DialogButton reset;
	
	public EndView(GUI gui, Point locationFrame) {
		
		
		panelGiveUp = new JPanel();
		panelResume = new JPanel();
		panelReset = new JPanel();
		
		giveUp = new DialogButton(ViewConstante.BUTTON_GIVE_UP,gui);
		resume = new DialogButton(ViewConstante.BUTTON_RETOUR_GAME,gui);
		reset = new DialogButton(ViewConstante.BUTTON_RESTART,gui);
		Box dialog = new Box(BoxLayout.Y_AXIS);
		
		panelGiveUp.add(giveUp, BorderLayout.CENTER);
		panelResume.add(resume, BorderLayout.CENTER);
		panelReset.add(reset, BorderLayout.CENTER);
		
		panelGiveUp.setBackground(Color.black);
		panelResume.setBackground(Color.black);
		panelReset.setBackground(Color.black);
		
		dialog.add(panelResume);
		dialog.add(panelReset);
		dialog.add(panelGiveUp);
		
		add(dialog);
		
		
		pack();
		setVisible(true);
		setAlwaysOnTop(true); 
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		setLocation((int)(locationFrame.getX()+ViewConstante.SIZE_MAIN_FRAME/2- this.getSize().getHeight()/2),
				(int)(locationFrame.getY()+ViewConstante.SIZE_MAIN_FRAME/2 - this.getSize().getWidth()/2));
		
		
	}

}
