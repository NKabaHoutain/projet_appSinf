package quarto.view.gameView;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import quarto.model.Case;

public class CaseItem extends JButton implements Observer{
	
	private final Case c;
	private boolean gagnante;
	
	public CaseItem(Case caase) {
		super();
		c=caase;
		gagnante=false;
		
	}
	
	public void paintComponent(Graphics g) {
		Color col;
		if(gagnante)
			col=Color.red;
		else
			col=Color.GRAY;
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
	}
	
	public boolean isPion() {
		return c.isPion();
	}

}
