package quarto.model;

public class CaseField {
	
	public static final int ROW = 0;
	public static final int LINE = 1;
	public static final int DIAGUP = 2;
	public static final int DIAGDOWN = 3;
	
	public static final int[] WINTAB = { 	ROW,
											LINE,
											DIAGUP,
											DIAGDOWN
														};
	

	public static int getRow(Case c, int i, int constante) {
		switch(constante) {
			case ROW : return c.getX();
			case LINE : return i;
			case DIAGUP : return i;
			case DIAGDOWN : return i;
			default : return -1;
		}
	}
	
	public static int getLine(Case c, int i, int constante) {
		switch(constante) {
			case ROW : return i;
			case LINE : return c.getY();
			case DIAGUP : return 3-i;
			case DIAGDOWN : return i;
			default : return -1;
		}
	}

}
