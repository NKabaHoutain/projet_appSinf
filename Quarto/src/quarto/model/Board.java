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
	/**
	 * 
	 * @param c
	 */
	public boolean move(Case c) {
		Pion p = getSelectedPion();
		c.addPion(p);
		p.setSelected(false);
		
		change("case");
		
		return win(c);
	}
	
	/**
	 * 
	 * @param pion
	 */
	public void selectPion(Pion pion) {
		for(Pion p : pions) {
			p.setSelected(p==pion);
		}
		
		change("pion");
	}
	
	private boolean win(Case c) {
		
		return testLine(c.getX());
	}
	
	private boolean testLine(int x) {
		return false;
	}
	
	
	public void change(String s) {
		setChanged();
		this.notifyObservers(s);
		clearChanged();
	}
	
	
	/* OPERATION D'INFORMATION
	 ************************* 
	 */
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public Case getCase(int i, int j) {
		return cases[i][j];
	}
	/**
	 * 
	 * @return
	 */
	public List<Pion> getAvailablePions() {
		List<Pion> result = new ArrayList<Pion>();
		for(Pion p :pions) {
			if(p.isAvailable()) result.add(p);
		}
		
		return result;
	}
	/**
	 * 
	 * @return
	 */
	private Pion getSelectedPion() {
		for(Pion p :pions) {
			if(p.isSelected()) return p;
		}
		return null;
	}
}
