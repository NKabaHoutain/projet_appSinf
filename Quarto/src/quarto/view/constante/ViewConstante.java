package quarto.view.constante;

import java.awt.Dimension;

public class ViewConstante {
	
	public final static String MOVE = "MOVE";
	public final static String SELECT = "SELECT";
	
	public final static int SIZE_MAIN_FRAME = 600;
	
	public final static int CASE_HEIGHT = 120;
	public final static int SIZE_BORDER_GAME = 20;
	
	public final static Dimension preferredSize[] ={	new Dimension(300,50),
														new Dimension(105,50),
														new Dimension(100,20)
																					};
	public final static Dimension minSize[] = 		{	new Dimension(300,50),
														new Dimension(105,40),
														new Dimension(100,20)
																					};
	public final static Dimension maxSize[] = 		{	new Dimension(300,50),
														new Dimension(110,60),
														new Dimension(100,30)
																					};
	public final static Dimension space[] = 		{	new Dimension(0,5),
														new Dimension(0,10)
																					};
	
	
	public final static int MENUITEM = 0;
	public final static int GAMEMODE = 0;
	public final static int BOARDSIDE = 1;
	public final static int BACK = 2;
	
	
	public final static String URL_LOGO = "C:\\Users\\Nicolas\\Pictures\\divers\\logo_quarto.jpg";
	
	public final static String RULES = "\n\nLes joueurs ont a leur disposition 16 pieces qui se distinguent"+"\n" +
			"les unes entre elles suivant quatre caracteristiques : \n"+"\n"+

    "la couleur : blanche ou noire,"+"\n"+
    "la taille : grande ou petite,"+"\n"+
    "la forme : ronde ou carree" +"\n"+
    "la consistance : pleine ou creuse"+"\n"+"\n"+

	"Chaque piece est unique et, avec 16 pieces, toutes les"+"\n"+
	"combinaisons de caracteristiques possibles sont epuisees."+"\n"+ "Les pieces sont communes aux deux adversaires"+"\n"+
	
	"\nPour gagner, il faut realiser un alignement de 4 pieces ayant au moins"+"\n" +"une caracteristique en commun (4 blanches/grandes/...)"+"\n" +
	"sur le plateau de jeu qui comporte 16 cases (4 sur 4)"+"\n"+"\n"+

	"Le plateau de jeu offre 10 possibilites d alignement"+"\n" +"(4 horizontales, 4 verticales et 2 diagonales)."+"\n"+
	"Lorsque la seizieme piece est posee, le plateau est rempli."+"\n"+" Si aucun alignement n est realise, la partie est nulle."+"\n"+"\n"+

	"La regle fondamentale du Quarto est la suivante : "+"\n"+
	"La piece a jouer est choisie par l adversaire";
	
	public final static String HELP = "Deroulement de la partie: \n"+"\n Le petit cadre autour de l'icone de joueurs\n permet d'identifier"+
	"c est a quelle joueur de jouer. \nSi le cadre est rouge,cela  signifie que c est a ce joueur de jouer.\n"+
			"  il lui suffit juste d'effectuer la tache demandee (move/select)\n"+"  Pour selectionner un pion, chaque joueur peut\n soit cliquer sur le pion puis la main"+
	" soit faire un double clique \n(quand le pion est selectionne, le fond devient rouge)\n"+
			"Afin de poser le pion, le joueur dois juste cliquer\n sur la case sur laquelle il souhaite poser le pion\n"+
	"\n Utilite des boutons\n"+
			"\n Livre : acceder aux regles de Quarto!\n"+
			"Fleche: Annuler la derniere action (undo)\n"+
			"X: Fin de partie, le joueur peut soit abandonner,\n soit recommencer la partie";

	
	public final static String BUTTON_STARTMENU = "Start game";
	public final static String BUTTON_REGLE = "Rules";
	public final static String BUTTON_OPTION = "Options";
	public final static String BUTTON_DETAIL = "Details";
	public final static String BUTTON_VSPLAYER = "Vs J2";
	public final static String BUTTON_VSIA = "Vs IA";
	public final static String BUTTON_RETOUR = "Back";
	public final static String BUTTON_RETOUR_GAME = "Resume";
	public final static String BUTTON_CLASSIC = "Classic";
	public final static String BUTTON_TOURNOI = "Tournament";
	public final static String BUTTON_END_OF_GAME = "End";
	public final static String BUTTON_RESTART = "Restart";
	public final static String BUTTON_UNDO = "Undo";
	public final static String BUTTON_START = "GO!";
	public final static String BUTTON_CANCEL = "Annuler";
	public final static String BUTTON_SAVE = "Save";
	public final static String BUTTON_GIVE_UP ="Quit";
	public final static String BUTTON_CHANGE ="Change";
	public static final String BUTTON_HELP = "Help";
	public static final String BUTTON_APPLY = "Apply";
	public static final String BUTTON_RETOUR_OPTION = "Back";

	public final static String BUTTON_FULLSCREEN = "Plein �cran";
	public final static String BUTTON_SELECT_PION = "Select";
	
	public final static String TEXTFIELD_MESSAGE = "J1 choississez \n un pion";

	
	
}
