package quarto.view.gameView;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import quarto.model.Pion;

public class PionItem extends JButton implements Observer{
	
	private final Pion pion;
	private final ImageIcon img;
	
	public PionItem (Pion pion) {
		super();
		this.pion = pion;
		
		img = new ImageIcon(pion.getUrlImage());		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        if (img == null) return;
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);

        if(pion.isSelected()) {

        	setBackground(Color.red);
        }
        else {
        	setBackground(Color.LIGHT_GRAY);
        }
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
