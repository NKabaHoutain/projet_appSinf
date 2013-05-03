package quarto.ia;

import quarto.model.Board;
import quarto.model.Game;
import quarto.view.GUI;

/**
 * Level MEDIUM de l'IA
 */
public class IaMedium extends Ia {
	/**
	 * Constructeur
	 */
	public IaMedium(Game g, Board b, GUI gu) {
		super(g, b, gu);
	}
	
	/**
	 * Joue un coup
	 */
	public Move playIa(Board board) {
		if(board.sizeHistoric() < 3) {
			return randomMove(board);
		}
		else {
			HORIZON = 2;
			nega(board, HORIZON, null);
		}
		return bestMove;
	}
}
