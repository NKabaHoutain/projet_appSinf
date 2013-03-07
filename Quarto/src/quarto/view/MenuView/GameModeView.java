package quarto.view.MenuView;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import quarto.view.GUI;

public class GameModeView extends JPanel{
	JPanel panelButton;
	JPanel panelTitle;
	JLabel title;
	Font fontTitle;
	JButton classic;
	JButton tournament;
	JButton back;
	
	Dimension preferredSize = new Dimension(350,50);
	Dimension minSize = new Dimension(350,50);
	Dimension maxSize = new Dimension(400,50);
	Dimension space = new Dimension(0,5);
	
	public GameModeView() {
		panelButton = new JPanel();
		panelTitle = new JPanel();
		title = new JLabel("Mode de Jeu");
		fontTitle = new Font("Serif",Font.BOLD,36);
		classic = new JButton("Classique");
		tournament = new JButton("Tournoi");
		back = new JButton("Retour");
		
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new GridLayout(2,1));
		
		panelTitle.setLayout(new BoxLayout(panelTitle,BoxLayout.Y_AXIS));
		panelTitle.setPreferredSize(new Dimension(400,50));
		
		title.setFont(fontTitle);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelTitle.add(Box.createVerticalStrut(100));
		panelTitle.add(title);
		
		panelButton.setLayout(new BoxLayout(panelButton,BoxLayout.Y_AXIS));
		panelButton.setPreferredSize(new Dimension(500,550));
		
		GUI.adjustSize(classic,minSize,maxSize,preferredSize);
		classic.setAlignmentX(Component.CENTER_ALIGNMENT);
		classic.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelButton.add(classic);
		panelButton.add(Box.createRigidArea(space));
		
		GUI.adjustSize(tournament,minSize,maxSize,preferredSize);
		tournament.setAlignmentX(Component.CENTER_ALIGNMENT);
		tournament.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelButton.add(tournament);
		panelButton.add(Box.createHorizontalStrut(20));
		
		back.setPreferredSize(new Dimension(35,20));
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelButton.add(back);
		panelButton.add(Box.createVerticalStrut(15));
		

		this.add(panelTitle,Component.CENTER_ALIGNMENT);
		this.add(panelButton,Component.CENTER_ALIGNMENT);
		this.setVisible(true);
	}	
}
