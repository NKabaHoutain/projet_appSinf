package quarto.view.gameView;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import quarto.constante.Constante;
import quarto.model.Pion;
import quarto.option.Option;

public class PionItem extends JButton implements Observer{
	
	private final Pion pion;
	private final ImageIcon img;
	private final ImageIcon fond;
	
	public PionItem (Pion pion) {
		super();
		this.pion = pion;
		fond = new ImageIcon(Constante.getPathTheme(Option.getTheme()) + Constante.BACKPION);
		img = new ImageIcon(pion.getUrlImage());		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        if (img == null) return;

        if(pion.isSelected()) {

        	setBackground(Color.red);
        }
        else {
        	g.drawImage(fond.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
        
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
	}
	
	public Pion getPion() {
		return pion;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setVisible(pion.isAvailable());
		repaint();
	}
	
	
}
