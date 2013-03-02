package quarto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Stack;




public class Board extends Observable{
	
	private List<Pion> pions;
	private Pion[][] board;
	private Stack <Move> historicMove;
	
	
	public Board() {
		createPions();
		board = new Pion [4][4];
	}
	
	/**
	 * Pre : historicMove est non vide
	 * @return	le dernier move
	 */
	public Move Undo() {
		return historicMove.pop();
	}
	
	public void SelectPion(Pion pion) {
		for(Pion p : pions) {
			p.setSelected(p==pions);
		}
	}
	
	
	

	public List<Pion> getPions() {
		return pions;
	}

	private void createPions() {
		pions =  new ArrayList<Pion>();
		
		for (int i=0; i<2; i++)
		{
			for (int j=0; j<2; j++)
			{
				for (int k=0; k<2; k++)
				{
					for(int l=0; l<2; l++)
					{
						pions.add(new Pion(i<1, j<1, k<1, l<1));
					}
				}
			}
		}
	}
}
