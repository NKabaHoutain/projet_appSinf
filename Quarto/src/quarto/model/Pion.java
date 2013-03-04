package quarto.model;

import java.awt.Color;
import java.awt.Graphics;

import quarto.constante.Constante;

public class Pion {
	
	private boolean[] caract = new boolean[4];
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
	
	public String getUrlIMage() {
		return Constante.PATHFILE + this.toString().replace(" ", ".") + ".jpg";
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
	

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String toString() {
		return "" + PionField.getShortName(caract[PionField.PION_SIZE],PionField.PION_SIZE) + 
				" " + PionField.getShortName(caract[PionField.PION_BODY],PionField.PION_BODY)+
				" " + PionField.getShortName(caract[PionField.PION_COLOR],PionField.PION_COLOR) +
				" " + PionField.getShortName(caract[PionField.PION_SHAPE],PionField.PION_SHAPE);
	}
	
	
}
