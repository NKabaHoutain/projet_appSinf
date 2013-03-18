package quarto.model;

import java.util.Observable;

public class Case extends Observable{
	private Pion pion;
	private final int x;
	private final int y;
	private boolean win;
	
	public Case(int i, int j){
		win = false;
		pion= null;
		x=i;
		y=j;
	}
	
	public Pion getPion(){
		return pion;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String toString() {
		return getX() + "  " + getY();
	}
	
	public void addPion(Pion p) {
		pion = p;
		p.setAvailable(false);
		change();
	}
	
	public void change() {
		setChanged();
		this.notifyObservers();
		clearChanged();
	}
	
	public boolean isPion() {
		return pion != null;
	}

	public void deletePion() {
		pion = null;
	}
	
	public void win() {
		win = true;
		change();
	}
	
	public boolean isWin() {
		return win;
	}
	
}
