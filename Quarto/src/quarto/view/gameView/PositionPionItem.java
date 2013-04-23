package quarto.view.gameView;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import quarto.constante.Constante;
import quarto.option.Option;
import quarto.view.constante.ViewConstante;

public class PositionPionItem extends JPanel{
	private ImageIcon img;

	public PositionPionItem() {
		
		setBorder(BorderFactory.createEmptyBorder(ViewConstante.SIZE_BORDER_GAME, 
													ViewConstante.SIZE_BORDER_GAME, 
													ViewConstante.SIZE_BORDER_GAME,
													ViewConstante.SIZE_BORDER_GAME));
		setLayout(new GridLayout(2,8));
		
		img = new ImageIcon(Constante.getPathTheme(Option.getTheme())+Constante.BACKGROUND);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(img.getImage(), 0,0, getWidth(), getHeight(), this);

	}
}
