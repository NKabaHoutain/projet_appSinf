package quarto.view.menuView;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class GameModeView extends JPanel{
	JPanel panelButton;
	JPanel panelTitle;
	JLabel title;
	Font fontTitle;
	JButton vsIA;
	JButton vsJ2;
	JButton tournament;
	JButton back;
	
	public GameModeView(GUI gui) {
		
		panelButton = new JPanel();
		panelTitle = new JPanel();
		title = new JLabel("Mode de Jeu");
		fontTitle = new Font("Serif",Font.BOLD,36);
		vsIA = new JButton(ViewConstante.BUTTON_VSIA);
		vsJ2 = new JButton(ViewConstante.BUTTON_VSPLAYER);
		tournament = new JButton(ViewConstante.BUTTON_TOURNOI);
		back = new JButton(ViewConstante.BUTTON_RETOUR);
		
		title.setFont(fontTitle);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		panelTitle.setLayout(new BoxLayout(panelTitle,BoxLayout.Y_AXIS));
		panelTitle.setPreferredSize(new Dimension(400,50));
		panelTitle.add(Box.createVerticalStrut(100));
		panelTitle.add(title);
		
		panelButton.setLayout(new BoxLayout(panelButton,BoxLayout.Y_AXIS));
		panelButton.setPreferredSize(new Dimension(500,550));
		
		
		initButton(vsJ2, gui);
		initButton(vsIA,gui);
		initButton(tournament,gui);
		
		panelButton.add(vsJ2);
		panelButton.add(Box.createRigidArea(ViewConstante.space[ViewConstante.GAMEMODE]));
		panelButton.add(vsIA);
		panelButton.add(Box.createRigidArea(ViewConstante.space[ViewConstante.GAMEMODE]));
		panelButton.add(tournament);
		panelButton.add(Box.createHorizontalStrut(20));
		
		back.setPreferredSize(new Dimension(35,20));
		GUI.initElement(back);
		back.addActionListener(gui);
		panelButton.add(back);
		panelButton.add(Box.createVerticalStrut(15));
		
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new GridLayout(2,1));
		this.add(panelTitle,Component.CENTER_ALIGNMENT);
		this.add(panelButton,Component.CENTER_ALIGNMENT);
		this.setVisible(true);
	}	
	
	private void initButton(JButton c, GUI gui) {
		GUI.adjustSize(c, ViewConstante.GAMEMODE );

		c.addActionListener(gui);
		
		GUI.initElement(c);
	}
}
