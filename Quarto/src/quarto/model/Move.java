package quarto.model;

public class Move {
	private Pion pion;
	private int x;
	private int y;

	public Move(Pion p, int xx, int yy) {
		pion=p;
		x=xx;
		y=yy;
	}

	public Pion getPion() {
		return pion;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
