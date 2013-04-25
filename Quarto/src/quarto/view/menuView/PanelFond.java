package quarto.view.menuView;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import quarto.constante.Constante;

public class PanelFond extends JPanel{

	private ImageIcon img;
	private ImageIcon back;
	
	public PanelFond() {
		super();
		
		img = new ImageIcon(Constante.getPathMenu() +  Constante.MENU);
		//back = new ImageIcon(Constante.getPathMenu() +  Constante.BACKMENU);
		setBackground(Color.BLACK);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawImage(back.getImage(), 0,0, getWidth(), getHeight(), this);
		
		g.drawImage(img.getImage(), (getWidth()-img.getIconWidth())/2,
									(getHeight()-img.getIconHeight())/2, 
									img.getIconWidth(), 
									img.getIconHeight(), this);	
		
	}
}
