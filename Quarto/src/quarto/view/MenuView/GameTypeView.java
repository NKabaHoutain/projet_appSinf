package quarto.view.MenuView;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class GameTypeView extends JPanel {
		
		JFrame frame;
		JPanel panelTitle;
		JLabel title;
		Font fontTitle;
		JPanel panelButton;
		JButton againstPlayer;
		JButton againstAI;
		JButton back;
		

		Dimension preferredSize = new Dimension(350,50);
		Dimension minSize = new Dimension(350,50);
		Dimension maxSize = new Dimension(400,50);
		Dimension space = new Dimension(0,5);
		
		public GameTypeView(){
			
			frame = new JFrame("Quarto-Type de Partie");
			panelTitle = new JPanel();
			title = new JLabel("Type de Partie");
			fontTitle = new Font("Sherif",Font.BOLD,36);
			panelButton = new JPanel();
			againstPlayer= new JButton("Vs J2");
			againstAI = new JButton("Vs IA");
			back = new JButton("Retour");
			
			frame.setPreferredSize(new Dimension(600,600));
			frame.setLayout(new GridLayout(2,1));
			
			panelTitle.setLayout(new BoxLayout(panelTitle,BoxLayout.Y_AXIS));
			panelTitle.setPreferredSize(new Dimension(400,50));
			
			title.setFont(fontTitle);
			title.setAlignmentX(Component.CENTER_ALIGNMENT);
			title.setAlignmentY(Component.CENTER_ALIGNMENT);
			panelTitle.add(Box.createVerticalStrut(100));
			panelTitle.add(title);
			
			panelButton.setLayout(new BoxLayout(panelButton,BoxLayout.Y_AXIS));
			panelButton.setPreferredSize(new Dimension(500,550));
			
			adjustSize(againstPlayer,minSize,maxSize,preferredSize);
			againstPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
			againstPlayer.setAlignmentY(Component.CENTER_ALIGNMENT);
			panelButton.add(againstPlayer);
			panelButton.add(Box.createRigidArea(space));
			
			adjustSize(againstAI,minSize,maxSize,preferredSize);
			againstAI.setAlignmentX(Component.CENTER_ALIGNMENT);
			againstAI.setAlignmentY(Component.CENTER_ALIGNMENT);
			panelButton.add(againstAI);
			panelButton.add(Box.createHorizontalStrut(20));
			
			back.setPreferredSize(new Dimension(35,20));
			back.setAlignmentX(Component.CENTER_ALIGNMENT);
			back.setAlignmentY(Component.CENTER_ALIGNMENT);
			panelButton.add(back);
			panelButton.add(Box.createVerticalStrut(15));
			

			frame.getContentPane().add(panelTitle,Component.CENTER_ALIGNMENT);
			frame.getContentPane().add(panelButton,Component.CENTER_ALIGNMENT);
			frame.setVisible(true);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
		}
		
		
		void adjustSize(Component c, Dimension min, Dimension max, Dimension pref) {
			c.setMinimumSize(min);
			c.setMaximumSize(max);
			c.setPreferredSize(pref);
		}
}
