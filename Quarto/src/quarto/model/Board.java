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
		
		return winGame(c);
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
	
	private boolean winGame(Case c) {
		return winGameBis(c, CaseField.WINTAB);
	}
	
	private boolean winGameBis(Case c, int[] constante) {
		for (int i=0; i<4; i++) {
			if((Filled(c, constante[i]) && win(c, constante[i]))) {
				return true;
			}
		}
		return false;
	}
	
	private boolean Filled(Case c, int constante) {
		boolean res = true;
		for(int i=0; i<4; i++) {
			res = res && cases[CaseField.getRow(c, i, constante)][CaseField.getLine(c, i, constante)].isPion();
		}
		return res;
	}
	
	private boolean win(Case c, int constante) {
		for(int i=0; i<3; i++) {
			if(winBis(c, i, cases[CaseField.getRow(c, i, constante)][CaseField.getLine(c, i, constante)].getPion().getCaract(i), 1, constante)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean winBis(Case c, int i, boolean carac, int next, int constante) {
		if(next>3) {
			return true;
		}
		else {
			if(cases[CaseField.getRow(c, next, constante)][CaseField.getLine(c, next, constante)].getPion().getCaract(i) == carac ) {
				return winBis(c, i, carac, next+1, constante);
			}
			else {
				return false;
			}
		}
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
