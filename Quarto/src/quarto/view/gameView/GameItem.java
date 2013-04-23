package quarto.view.gameView;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import quarto.controller.Controller;
import quarto.model.Board;
import quarto.view.GUI;
import quarto.view.gameView.BoardGameItem;
import quarto.view.gameView.BoardSideItem;

public class GameItem extends JPanel{
	
	BoardGameItem boardGame;
	BoardSideItem boardSide;
	GUI gui;
	
	public GameItem(Board board, Controller controller,GUI gui, String p1, String p2){
		this.gui = gui;
		boardGame = new BoardGameItem(board,controller);
		boardSide = new BoardSideItem(gui, controller.isIa(), p1, p2);
		board.addObserver(boardGame);
		board.addObserver(boardSide);
		this.setLayout(new BorderLayout());
		this.add(boardGame,BorderLayout.WEST);
		this.add(boardSide,BorderLayout.EAST);
		this.setVisible(true);
	}
	
	public BoardGameItem getBoardGameItem() {
		return boardGame;
	}




}
