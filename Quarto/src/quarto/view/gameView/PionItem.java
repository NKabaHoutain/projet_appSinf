package quarto.view.gameView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import quarto.model.Pion;

public class PionItem extends JButton implements Observer{
	
	Pion pion;
	
	public PionItem (Pion pion) {
		super();
		this.pion = pion;
	}

	public static void drawPiece(Pion pion, Graphics g, int w, int h,Color fond) {
		//g.drawImage(new ImageIcon(pion.getUrlImage()).getImage(), 0,0, null);
		
	
		int s=((w<h)?w:h)/2;
		
		if(pion.isBlack())
			g.setColor(Color.BLACK);
		else
			g.setColor(Color.WHITE);
		if(pion.isSmall())
			s=s/2;
		if(pion.isCercle())
			g.fillOval((w-s)/2, (h-s)/2, s, s);
		else
			g.fillRect((w-s)/2, (h-s)/2, s, s);
		if(pion.isHollow()) {
			g.setColor(fond);
			s/=3;
			if(pion.isCercle())
				g.fillOval((w-s)/2, (h-s)/2, s, s);
			else
				g.fillRect((w-s)/2, (h-s)/2, s, s);			
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		if(pion.isSelected()){
			g.setColor(Color.RED);
			g.fillRect(0, 0, getWidth(), getHeight());
			//g.drawOval(1,1, getWidth()-2, getHeight()-2);
		}
		
		//if(pion != null)
		drawPiece(pion, g, getWidth(), getHeight(),Color.LIGHT_GRAY);
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
