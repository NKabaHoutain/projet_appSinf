package quarto.ia;

import quarto.model.Board;
import quarto.model.Game;
import quarto.view.GUI;

/**
 * Level EASY de l'IA
 */
public class IaEasy extends Ia {
	
	/**
	 * Constructeur
	 */
	public IaEasy(Game g, Board b, GUI gu) {
		super(g, b, gu);
	}
	
	/**
	 * Joue un coup
	 */
	public Move playIa(Board board) {
		return super.randomMove(board);
	}
}
