package quarto.view.menuView;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class GameTypeView extends JPanel {
		JPanel panelTitle;
		JLabel title;
		Font fontTitle;
		JPanel panelButton;
		JButton againstPlayer;
		JButton againstAI;
		JButton back;
		
		public GameTypeView(GUI gui){
			
			panelTitle = new JPanel();
			title = new JLabel("Type de Partie");
			fontTitle = new Font("Sherif",Font.BOLD,36);
			panelButton = new JPanel();
			againstPlayer= new JButton(ViewConstante.BUTTON_VSPLAYER);
			againstAI = new JButton(ViewConstante.BUTTON_VSIA);
			back = new JButton(ViewConstante.BUTTON_RETOUR);
			
			title.setFont(fontTitle);
			GUI.initElement(title);
			
			panelTitle.setLayout(new BoxLayout(panelTitle,BoxLayout.Y_AXIS));
			panelTitle.setPreferredSize(new Dimension(400,50));
			panelTitle.add(Box.createVerticalStrut(100));
			panelTitle.add(title);
			
			panelButton.setLayout(new BoxLayout(panelButton,BoxLayout.Y_AXIS));
			panelButton.setPreferredSize(new Dimension(500,550));
			
			initButton(againstPlayer, gui);
			initButton(againstAI,gui);
			
			panelButton.add(againstPlayer);
			panelButton.add(Box.createRigidArea(ViewConstante.space[ViewConstante.GAMETYPE]));
						
			panelButton.add(againstAI);
			panelButton.add(Box.createHorizontalStrut(20));
			
			back.setPreferredSize(new Dimension(35,20));
			GUI.initElement(back);
			back.addActionListener(gui);
			panelButton.add(back);
			panelButton.add(Box.createVerticalStrut(15));
			
			
			
			this.setPreferredSize(new Dimension(600,600));
			this.setLayout(new GridLayout(2,1));
			this.add(panelTitle);
			this.add(panelButton);
			this.setVisible(true);
		}
		
	private void initButton(JButton c, GUI gui) {
		GUI.adjustSize(c ,ViewConstante.GAMETYPE);
		c.addActionListener(gui);
		GUI.initElement(c);		
	}
}
