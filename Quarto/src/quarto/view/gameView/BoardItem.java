package quarto.view.gameView;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import quarto.constante.Constante;
import quarto.option.Option;
import quarto.view.constante.ViewConstante;

public class BoardItem extends JPanel{
	
	public BoardItem () {
		
		setBorder(BorderFactory.createEmptyBorder(ViewConstante.SIZE_BORDER_GAME, 
													ViewConstante.SIZE_BORDER_GAME, 
													ViewConstante.SIZE_BORDER_GAME,
													ViewConstante.SIZE_BORDER_GAME));
		setLayout(new GridLayout(4,4));
	}

	public void paintComponent(Graphics g) {
		
		ImageIcon img = new ImageIcon(Constante.getPathTheme(Option.getTheme()) + Constante.BORDER);

		super.paintComponent(g);
        if (img == null) return;
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
	}
}
