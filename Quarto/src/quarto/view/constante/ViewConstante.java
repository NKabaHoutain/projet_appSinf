package quarto.view.constante;

import java.awt.Dimension;

public class ViewConstante {
	
	public final static int CASE_HEIGHT = 120;
	public final static int SIZE_BORDER_GAME = 20;
	
	public final static Dimension preferredSize[] ={	new Dimension(350,50),
														new Dimension(105,50),
														new Dimension(100,20)
																					};
	public final static Dimension minSize[] = 		{	new Dimension(350,50),
														new Dimension(105,40),
														new Dimension(50,15)
																					};
	public final static Dimension maxSize[] = 		{	new Dimension(400,50),
														new Dimension(110,60),
														new Dimension(50,30)
																					};
	public final static Dimension space[] = 		{	new Dimension(0,5),
														new Dimension(0,10)
																					};
	
	
	public final static int MENUITEM = 0;
	public final static int GAMETYPE = 0;
	public final static int GAMEMODE = 0;
	public final static int BOARDSIDE = 1;
	public final static int BACK = 2;
	
	
	public final static String URL_LOGO = "C:\\Users\\Nicolas\\Pictures\\divers\\logo_quarto.jpg";
	
	public final static String RULES = "Les joueurs ont � leur disposition 16 pi�ces qui se distinguent"+"\n" +
			"les unes entre elles suivant quatre caract�ristiques : \n"+"\n"+

    "la couleur : blanche ou noire,"+"\n"+
    "la taille : grande ou petite,"+"\n"+
    "la forme : ronde ou carr�e" +"\n"+
    "la consistance : pleine ou creuse (en fait un trou au sommet de la pi�ce)"+"\n"+"\n"+

	"Chaque pi�ce est unique et, avec 16 pi�ces, toutes les"+"\n"+
	"combinaisons de caract�ristiques possibles sont �puis�es."+"\n"+ "Les pi�ces sont communes aux deux adversaires"+
	"( la couleur ne distingue pas un camp)."+"\n"+
	"Pour gagner, il faut r�aliser un alignement de 4 pi�ces ayant au moins"+"\n" +"une caract�ristique en commun (4 blanches, 4 grandes, etc.)"+"\n" +
	"sur le plateau de jeu qui comporte 16 cases (4 sur 4)"+"\n"+"\n"+

	"Le plateau de jeu offre 10 possibilit�s d�alignement"+"\n" +"(4 horizontales, 4 verticales et 2 diagonales)."+"\n"+
	"Lorsque la seizi�me pi�ce est pos�e, le plateau est rempli."+"\n"+" Si aucun alignement n�est r�alis�, la partie est nulle."+"\n"+"\n"+

	"La r�gle fondamentale du Quarto est la suivante : "+"\n"+
	"la pi�ce qu�un joueur pose � son tour de jeu est choisie par son adversaire";

	
	public final static String BUTTON_STARTMENU = "D�marrer une partie";
	public final static String BUTTON_REGLE = "R�gles";
	public final static String BUTTON_OPTION = "Options";
	public final static String BUTTON_DETAIL = "D�tails";
	public final static String BUTTON_VSPLAYER = "Vs J2";
	public final static String BUTTON_VSIA = "Vs IA";
	public final static String BUTTON_RETOUR = "Retour";
	public final static String BUTTON_RETOUR_GAME = "Reprendre";
	public final static String BUTTON_CLASSIC = "Classique";
	public final static String BUTTON_TOURNOI = "Tournoi";
	public final static String BUTTON_END_OF_GAME = "Fin partie";
	public final static String BUTTON_RESTART = "Recommencer";
	public final static String BUTTON_UNDO = "Undo";
	public final static String BUTTON_SAVE = "Sauver";

	public final static String BUTTON_FULLSCREEN = "Plein �cran";
	public final static String BUTTON_SELECT_PION = "Select";
	public final static String TEXTFIELD_MESSAGE = "J1 choississez \n un pion";
}
