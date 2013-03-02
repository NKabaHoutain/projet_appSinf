package quarto.model;

public class PionField {
	
	public static final int PION_SIZE = 0;
	public static final int PION_COLOR = 1;
	public static final int PION_SHAPE = 2;
	public static final int PION_BODY = 3;

	public static final boolean GRAND = true;
	public static final boolean BLANC = true;
	public static final boolean CARRE = true;
	public static final boolean PLEIN = true;
	
	public static final String[] NAME = {	"GRAND",
											"BLANC",
											"CARRE",
											"PLEIN",
											
											"PETIT",
											"NOIR",
											"ROND",
											"CREUX"		};
	
	public static final String[] SHORTNAME = {	"GR",
												"BL",
												"CA",
												"PL",
												
												"PE",
												"NO",
												"RO",
												"CR"	};

	public static String getName(boolean caract, int typeCaract)
	{
		if(!caract) typeCaract+=4;
		
		return NAME[typeCaract];
	}
	public static String getShortName(boolean caract, int typeCaract)
	{
		if(!caract) typeCaract+=4;
		
		return SHORTNAME[typeCaract];
	}
}
