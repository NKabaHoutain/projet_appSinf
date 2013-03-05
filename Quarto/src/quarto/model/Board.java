package quarto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Stack;


public class Board extends Observable{
	
	private List<Pion> pions;
	private Case[][] cases;
	private Stack <Move> historicMove;
	
	/* INITIALISATION
	 ****************
	 */
	/**
	 * Constructeur
	 */
	public Board() {
		createPions();
		createCase();
	}
	/**
	 * Crée les pions de la board
	 */
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
	/**
	 * Crée les cases de la board
	 */
	private void createCase() {
		cases = new Case [4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				cases[i][j] = new Case(i, j);
			}
		}
	}
	
	/* OPERATION D'UNE PARTIE
	 ************************ 
	 */
	public void move(Case c) {
		System.out.println(c);
		Pion p = getSelectedPion();
		pions.remove(p);
		c.addPion(p);
	}
	
	/**
	 *
	 */
	public void selectPion(Pion pion) {
		for(Pion p : pions) {
			p.setSelected(p==pion);
		}
	}
	
	/**
	 * Pre : historicMove est non vide
	 * @return	le dernier move
	 */
	public Move Undo() {
		return historicMove.pop();
	}
	
	
	
	public Case getCase(int i, int j) {
		return cases[i][j];
	}

	public List<Pion> getPions() {
		return pions;
	}

	
	public List<Pion> getAvailablePions() {
		List<Pion> result = new ArrayList<Pion>();
		for(Pion p :pions) {
			if(p.isAvailable()) result.add(p);
		}
		
		return result;
	}
	
	public Pion getSelectedPion() {
		for(Pion p :pions) {
			if(p.isSelected()) return p;
		}
		return null;
	}
}
