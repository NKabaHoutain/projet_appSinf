package quarto.model;

public class Move {
	Pion pion;
	int x;
	int y;

	public Move(Pion p, int xx, int yy) {
		pion=p;
		x=xx;
		y=yy;
	}
}
