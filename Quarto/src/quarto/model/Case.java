package quarto.model;

import java.util.Observable;
import java.util.Observer;

public class Case extends Observable{
	private Pion pion;
	private final int x;
	private final int y;
	
	public Case(int i, int j){
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
		System.out.println("Case : " + p);
		notifyObservers();
	}
	
	
}
