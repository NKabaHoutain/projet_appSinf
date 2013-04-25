package quarto.view.button;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import quarto.constante.Constante;
import quarto.option.Option;
import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class GameButton extends JButton {
	ImageIcon img;
	ImageIcon fond;

	public GameButton(String text, GUI gui, int constante, String name) {
		super(text);
		
		img = new ImageIcon(Constante.getPathGame()+ name);
		fond = new ImageIcon(Constante.getPathTheme(Option.getTheme()) + Constante.BACKPION);
		
		setMinimumSize(ViewConstante.minSize[constante]);
		setMaximumSize(ViewConstante.maxSize[constante]);
		setPreferredSize(ViewConstante.preferredSize[constante]);
		
		addActionListener(gui);
		
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setAlignmentY(Component.CENTER_ALIGNMENT);
		
		setContentAreaFilled(false);
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fond.getImage(), 0,0, getWidth(), getHeight(), this);
		g.drawImage(img.getImage(), 10,0, getWidth()-20, getHeight(), this);	
	}
}
