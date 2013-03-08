package quarto.view.constante;

import java.awt.Dimension;

public class ViewConstante {
	
	public final static Dimension preferredSize[] ={	new Dimension(350,50),
														new Dimension(105,50)
																					};
	public final static Dimension minSize[] = 		{	new Dimension(350,50),
														new Dimension(105,40)
																					};
	public final static Dimension maxSize[] = 		{	new Dimension(400,50),
														new Dimension(110,60)
																					};
	public final static Dimension space[] = 		{	new Dimension(0,5),
														new Dimension(0,10)
																					};
	
	
	public final static int MENUITEM = 0;
	public final static int GAMETYPE = 0;
	public final static int GAMEMODE = 0;
	public final static int BOARDSIDE = 1;
	
	
	public final static String URL_LOGO = "/home/nhoutain/Eclipse/Workspace/logo_quarto.jpg";

	
	public final static String BUTTON_STARTMENU = "D�marrer une partie";
	public final static String BUTTON_REGLE = "R�gles";
	public final static String BUTTON_OPTION = "Options";
	public final static String BUTTON_DETAIL = "D�tails";
	public final static String BUTTON_VSPLAYER = "Vs J2";
	public final static String BUTTON_VSIA = "Vs IA";
	public final static String BUTTON_RETOUR = "Retour";
	public final static String BUTTON_CLASSIC = "Classique";
	public final static String BUTTON_TOURNOI = "Tournoi";
	public final static String BUTTON_END_OF_GAME = "Fin partie";
	public final static String BUTTON_RESTART = "Recommencer";
	public final static String BUTTON_UNDO = "Undo";

	public final static String BUTTON_FULLSCREEN = "Plein �cran";
	public final static String BUTTON_SELECT_PION = "Select";
	public final static String TEXTFIELD_MESSAGE = "J1 choississez \n un pion";
}
