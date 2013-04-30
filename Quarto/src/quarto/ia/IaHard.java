package quarto.ia;

import quarto.model.Board;
import quarto.model.Game;
import quarto.view.GUI;

public class IaHard extends Ia{
	public IaHard(Game g, Board b, GUI gu) {
		super(g, b, gu);
	}
	
	public Move playIa(Board board) {
		if(board.sizeHistoric() < 3) {
			return randomMove(board);
		}
		else if(board.sizeHistoric() <7) {
			HORIZON = 2;
			nega(board, HORIZON, null);
		}
		else if (board.sizeHistoric() <17) {
			HORIZON = 3;
			nega(board, HORIZON, null);
		}
		else {
			HORIZON = 4;
			nega(board, HORIZON, null);
		}
		
		return bestMove;
	}
}
