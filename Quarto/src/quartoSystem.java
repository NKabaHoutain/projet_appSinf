import javax.swing.JFrame;

import quarto.model.Board;
import quarto.view.gameView.BoardGameItem;



public class quartoSystem {

	
	
	public static void main(String[] args)
	{
		Board board = new Board();
		
		BoardGameItem b = new BoardGameItem(board);
		
		b.start();
	}

}
