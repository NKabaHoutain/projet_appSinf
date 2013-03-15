package quarto.view.constante;

import java.awt.Dimension;

public class ViewConstante {
	
	public final static Dimension preferredSize[] ={	new Dimension(350,50),
														new Dimension(105,50),
														new Dimension(50,20)
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
	public final static String RULES = "Les joueurs ont à leur disposition 16 pièces qui se distinguent"+"\n" +
			"les unes entre elles suivant quatre caractéristiques : \n"+"\n"+

    "la couleur : blanche ou noire,"+"\n"+
    "la taille : grande ou petite,"+"\n"+
    "la forme : ronde ou carrée" +"\n"+
    "la consistance : pleine ou creuse (en fait un trou au sommet de la pièce)"+"\n"+"\n"+

	"Chaque pièce est unique et, avec 16 pièces, toutes les"+"\n"+
	"combinaisons de caractéristiques possibles sont épuisées."+"\n"+ "Les pièces sont communes aux deux adversaires"+
	"( la couleur ne distingue pas un camp)."+"\n"+
	"Pour gagner, il faut réaliser un alignement de 4 pièces ayant au moins"+"\n" +"une caractéristique en commun (4 blanches, 4 grandes, etc.)"+"\n" +
	"sur le plateau de jeu qui comporte 16 cases (4 sur 4)"+"\n"+"\n"+

	"Le plateau de jeu offre 10 possibilités d’alignement"+"\n" +"(4 horizontales, 4 verticales et 2 diagonales)."+"\n"+
	"Lorsque la seizième pièce est posée, le plateau est rempli."+"\n"+" Si aucun alignement n’est réalisé, la partie est nulle."+"\n"+"\n"+

	"La règle fondamentale du Quarto est la suivante : "+"\n"+
	"la pièce qu’un joueur pose à son tour de jeu est choisie par son adversaire";

	
	public final static String BUTTON_STARTMENU = "Dï¿½marrer une partie";
	public final static String BUTTON_REGLE = "Rï¿½gles";
	public final static String BUTTON_OPTION = "Options";
	public final static String BUTTON_DETAIL = "Dï¿½tails";
	public final static String BUTTON_VSPLAYER = "Vs J2";
	public final static String BUTTON_VSIA = "Vs IA";
	public final static String BUTTON_RETOUR = "Retour";
	public final static String BUTTON_CLASSIC = "Classique";
	public final static String BUTTON_TOURNOI = "Tournoi";
	public final static String BUTTON_END_OF_GAME = "Fin partie";
	public final static String BUTTON_RESTART = "Recommencer";
	public final static String BUTTON_UNDO = "Undo";

	public final static String BUTTON_FULLSCREEN = "Plein ï¿½cran";
	public final static String BUTTON_SELECT_PION = "Select";
	public final static String TEXTFIELD_MESSAGE = "J1 choississez \n un pion";
}
