package quarto.ia;

import quarto.model.Board;
import quarto.model.Game;
import quarto.view.GUI;

public class IaEasy extends Ia {
	
	public IaEasy(Game g, Board b, GUI gu) {
		super(g, b, gu);
	}
	
	public Move playIa(Board board) {
		return super.randomMove(board);
	}
}
