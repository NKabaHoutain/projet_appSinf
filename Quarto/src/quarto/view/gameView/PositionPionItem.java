package quarto.view.gameView;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import quarto.view.constante.ViewConstante;

public class PositionPionItem extends JPanel{

	public PositionPionItem() {
		
		setBorder(BorderFactory.createEmptyBorder(ViewConstante.SIZE_BORDER_GAME, 
													ViewConstante.SIZE_BORDER_GAME, 
													ViewConstante.SIZE_BORDER_GAME,
													ViewConstante.SIZE_BORDER_GAME));
		setLayout(new GridLayout(2,8));
	}
}
