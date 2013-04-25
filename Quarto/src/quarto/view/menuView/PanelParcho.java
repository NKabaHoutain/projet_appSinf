package quarto.view.menuView;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import quarto.constante.Constante;

public class PanelParcho extends JPanel {

	private ImageIcon img;
	
	public PanelParcho() {
		
		img = new ImageIcon(Constante.getPathMenu() +  Constante.PARCHO);
		
		setBackground(Color.BLACK);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		g.drawImage(img.getImage(), (getWidth()-img.getIconWidth())/2 -80,
				(getHeight()-img.getIconHeight())/2, 
				img.getIconWidth()+160, 
				img.getIconHeight(), this);
		
	}
}
