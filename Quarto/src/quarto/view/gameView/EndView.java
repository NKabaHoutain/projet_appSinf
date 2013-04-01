package quarto.view.gameView;


import java.awt.BorderLayout;

import javax.swing.*;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class EndView extends JDialog {
	JPanel panelGiveUp;
	JPanel panelResume;
	JPanel panelReset;
	JButton giveUp;
	JButton resume;
	JButton reset;
	
	public EndView(GUI gui) {
		
		
		panelGiveUp = new JPanel();
		panelResume = new JPanel();
		panelReset = new JPanel();
		
		giveUp = new JButton(ViewConstante.BUTTON_GIVE_UP);
		resume = new JButton(ViewConstante.BUTTON_RETOUR_GAME);
		reset = new JButton(ViewConstante.BUTTON_RESTART);
		Box dialog = new Box(BoxLayout.Y_AXIS);
		
		panelGiveUp.add(giveUp, BorderLayout.CENTER);
		panelResume.add(resume, BorderLayout.CENTER);
		panelReset.add(reset, BorderLayout.CENTER);
		
		giveUp.addActionListener(gui);
		resume.addActionListener(gui);
		reset.addActionListener(gui);
		
		dialog.add(panelResume);
		dialog.add(panelReset);
		dialog.add(panelGiveUp);
		
		add(dialog);
		
		pack();
		setVisible(true);
		setAlwaysOnTop(true); 
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		
	}

}
