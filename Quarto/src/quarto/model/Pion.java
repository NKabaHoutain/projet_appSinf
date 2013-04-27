package quarto.model;

import java.util.Observable;

import quarto.constante.Constante;

public class Pion extends Observable{
	
	private final boolean[] caract = new boolean[4];
	private boolean selected;
	private boolean available;
	
	
	/*
	 * CONSTRUCTEUR
	 */
	public Pion(boolean size, boolean body, boolean color, boolean shape) {
		caract[PionField.PION_SIZE]  = size;
		caract[PionField.PION_BODY]  = body;
		caract[PionField.PION_COLOR] = color;
		caract[PionField.PION_SHAPE] = shape;
		
		available = true;
	}
	
	
	public boolean getCaract(int i) {
		return caract[i];
	}

	public String getUrlImage() {
		return Constante.getPathPion() + toString().replace(' ', '_') + ".png";
	}
	
	public boolean isBlack() {
		return caract[PionField.PION_COLOR] != PionField.BLANC;
	}
	
	public boolean isSmall() {
		return caract[PionField.PION_SIZE] != PionField.GRAND;
	}
	
	public boolean isCercle() {
		return caract[PionField.PION_SHAPE] != PionField.CARRE;
	}
	
	public boolean isHollow() {
		return caract[PionField.PION_BODY] != PionField.PLEIN;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public void change() {
		setChanged();
		this.notifyObservers();
		clearChanged();
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String toString() {
		return "" + PionField.getShortName(caract[PionField.PION_SIZE],PionField.PION_SIZE) + 
				" " + PionField.getShortName(caract[PionField.PION_COLOR],PionField.PION_COLOR) +
				" " + PionField.getShortName(caract[PionField.PION_SHAPE],PionField.PION_SHAPE) +
				" " + PionField.getShortName(caract[PionField.PION_BODY],PionField.PION_BODY);
	}
}
