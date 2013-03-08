package quarto.view.gameView;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import quarto.controller.Controller;
import quarto.model.Board;
import quarto.view.GUI;
import quarto.view.gameView.BoardGameItem;
import quarto.view.gameView.BoardSideItem;

public class GameItem extends JPanel {
	
	BoardGameItem boardGame;
	BoardSideItem boardSide;
	
	public GameItem(Board board, Controller controller,GUI gui){
		
		boardGame = new BoardGameItem(board,controller);
		boardSide = new BoardSideItem(gui);
		this.setLayout(new BorderLayout());
		this.add(boardGame,BorderLayout.WEST);
		this.add(boardSide,BorderLayout.EAST);
		this.setVisible(true);
		
	}
	
	public BoardGameItem getBoardGameItem() {
		return boardGame;
	}


}
