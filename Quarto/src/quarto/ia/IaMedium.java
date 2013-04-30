package quarto.ia;

import quarto.model.Board;
import quarto.model.Game;
import quarto.view.GUI;

public class IaMedium extends Ia {
	public IaMedium(Game g, Board b, GUI gu) {
		super(g, b, gu);
	}
	
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
