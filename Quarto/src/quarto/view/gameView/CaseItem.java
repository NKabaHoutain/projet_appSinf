package quarto.view.gameView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import quarto.constante.Constante;
import quarto.model.Case;
import quarto.view.constante.ViewConstante;

public class CaseItem extends JButton implements Observer{
	
	private final Case c;
	private final ImageIcon img;
	
	public CaseItem(Case caase) {
		super();
		c=caase;
	
		/*
		 * Pour afficher une image par case
		 *
		img = new ImageIcon("./Ressources/Images/Game/text60.jpg");		
		 *
		 */
		
		
		/*
		 * Pour afficher une image pour les 16cases
		 */
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image texture = tk.getImage("./Ressources/Images/Game/text600.jpg");
		img = new ImageIcon(tk.createImage (new FilteredImageSource ( texture.getSource(),
				new CropImageFilter (c.getY()*ViewConstante.CASE_HEIGHT,c.getX()*ViewConstante.CASE_HEIGHT, ViewConstante.CASE_HEIGHT, ViewConstante.CASE_HEIGHT))));
		
	}
	
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
        if (img == null) return;
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
	    
        if(c.getPion()!=null) {	
        	g.drawImage(new ImageIcon(c.getPion().getUrlImage()).getImage(), 0, 0, getWidth(), getHeight(), this);
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
