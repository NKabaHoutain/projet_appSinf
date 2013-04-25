package quarto.view.menuView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import quarto.view.GUI;
import quarto.view.button.BackButton;
import quarto.view.button.MenuButton;
import quarto.view.constante.ViewConstante;

public class GameModeView extends PanelFond{
	JPanel panelButton;
	JPanel panelTitle;
	JLabel title;
	Font fontTitle;
	MenuButton vsIA;
	MenuButton vsJ2;
	
	BackButton back;
	
	public GameModeView(GUI gui) {
		
		panelButton = new JPanel();
		panelTitle = new JPanel();
		title = new JLabel("Mode de Jeu");
		title.setForeground(Color.white);
		fontTitle = new Font("Serif",Font.BOLD,36);
		vsIA = new MenuButton(ViewConstante.BUTTON_VSIA, gui, ViewConstante.GAMEMODE );
		vsJ2 = new MenuButton(ViewConstante.BUTTON_VSPLAYER, gui, ViewConstante.GAMEMODE );
		
		back = new BackButton(ViewConstante.BUTTON_RETOUR, gui, ViewConstante.BACK );
		back.setContentAreaFilled(true);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		
		title.setFont(fontTitle);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		panelTitle.setLayout(new BoxLayout(panelTitle,BoxLayout.Y_AXIS));
		panelTitle.setPreferredSize(new Dimension(400,50));
		panelTitle.add(Box.createVerticalStrut(100));
		panelTitle.add(title);
		
		panelButton.setLayout(new BoxLayout(panelButton,BoxLayout.Y_AXIS));
		panelButton.setPreferredSize(new Dimension(500,550));
		
		
		
		panelButton.add(vsJ2);
		panelButton.add(Box.createRigidArea(ViewConstante.space[ViewConstante.GAMEMODE]));
		panelButton.add(vsIA);
		panelButton.add(Box.createHorizontalStrut(20));
		
		panelButton.add(back);
		panelButton.add(Box.createVerticalStrut(25));
		
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new GridLayout(2,1));
		panelTitle.setOpaque(false);
		this.add(panelTitle,Component.CENTER_ALIGNMENT);
		panelButton.setOpaque(false);
		this.add(panelButton,Component.CENTER_ALIGNMENT);
		this.setVisible(true);
	}	
}
