package quarto.view.gameView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import quarto.model.Case;

public class CaseItem extends JButton implements Observer{
	
	private final Case c;
	
	public CaseItem(Case caase) {
		super();
		c=caase;
		
	}
	
	
	
	public void paintComponent(Graphics g) {
		
		Color col;
		if(c.isWin())
			col=Color.red;
		else
			col=Color.getHSBColor(25, 156, 200);

		g.setColor(col);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		
		if(c.getPion()!=null) {
			PionItem.drawPiece(c.getPion(), g, getWidth(), getHeight(),col);
		}
	}
	
	public Case getCase() {
		return c;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.setEnabled(false);	
		repaint();
	}
	
	public boolean isPion() {
		return c.isPion();
	}

}
