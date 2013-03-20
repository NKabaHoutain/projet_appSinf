package quarto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Stack;


public class Board extends Observable{
	
	private List<Pion> pions;
	private Case[][] cases;
	private Stack <Case> historicMove;
	
	private boolean canSelectedPion;
	
	private Case caseWin;
	private int constante;
	
	/* INITIALISATION
	 ****************
	 */
	/**
	 * Constructeur
	 */
	public Board() {
		createPions();
		createCase();
		historicMove = new Stack<Case>();
		canSelectedPion = true;
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
		canSelectedPion = true;
		Pion p = getSelectedPion();
		c.addPion(p);
		
		p.setSelected(false);
		
		historicMove.push(c);
		change(BoardField.PION_ACTIF);
		change(this);
		
		
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
		change(this);
	}
	
	public void pionSelected(String player) {
		canSelectedPion = false;
		change(BoardField.CASE_ACTIVE);
		change(this);
		change("Joueur " + player + " joue");
		
	}
	
	public void undo(String player) {
		Case c = historicMove.pop();
		Pion p = c.getPion();
		c.deletePion();
		
		p.setAvailable(true);
		
		p.change();
		c.change();
		selectPion(p);
		pionSelected(player);
	}

	public void change(Object s) {
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
	public Pion getSelectedPion() {
		for(Pion p :pions) {
			if(p.isSelected()) return p;
		}
		return null;
	}
	
	public boolean canSelectedPion() {
		return getSelectedPion() != null && canSelectedPion;
	}
	
	public boolean isHistoric() {
		return !historicMove.isEmpty();
	}
	
	public void paintWinCase() {
		for(int i=0; i<4; i++) {
			cases[CaseField.getRow(caseWin, i, constante)][CaseField.getLine(caseWin, i, constante)].win();
		}
	}
	
	/* TEST DE VICTOIRE
	 ****************** 
	 */
	private boolean winGame(Case c) {
		for (int i=0; i<4; i++) {
			if((Filled(c, CaseField.WINTAB[i]) && win(c, CaseField.WINTAB[i]))) {
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
		for(int i=0; i<4; i++) {
			if(winBis(c, i, cases[CaseField.getRow(c, i, constante)][CaseField.getLine(c, i, constante)].getPion().getCaract(i), 0, constante)) {
				caseWin = c;
				this.constante = constante;
				paintWinCase();
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
}
