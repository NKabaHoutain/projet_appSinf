package quarto.ia;

import quarto.model.Case;
import quarto.model.Pion;

public class Move {

	private Case cases;
	private Pion pionPose;
	private Pion pionSelect;
	
	public Move(Case c, Pion pose, Pion select) {
		cases = c;
		pionPose = pose;
		pionSelect = select;
	}
	
	public int getX() {
		return cases.getX();
	}
	
	public int getY() {
		return cases.getY();
	}
	
	public Case getCase() {
		return cases;
	}
	
	public Pion getSelectedPion() {
		return pionSelect;
	}
	
	public Pion getPionPose() {
		return pionPose;
	}
	
	public String toString() {
		return "case : " + cases + "  pionPose : " + pionPose + "  pionSelect : " + pionSelect;
	}
}
