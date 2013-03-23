package quarto.constante;

public class Constante {

	/*
	 * Constante de l'IA
	 */
	public static final String GAMELEVEL[] = { 	"Niveau1",
												"Niveau2",
												"Niveau3"		};
	public static final int LVL_EASY = 0;
	public static final int LVL_MEDIUM = 1;
	public static final int LVL_HARD = 2;
	
	/*
	 * Constante des details
	 */
	public static final int LOSEGAME = 0;
	public static final int DRAWGAME = 1;
	public static final int WINGAME = 2;
	
	

	/*
	 * Constante de la music
	 */
	public static boolean PlayMusic = false;
	
	/*
	 * Constante des path
	 */
	public final static int PARQUET = 0;
	public final static int PLANCHE = 1;
	
	public final static String PATH_RESSOURCE = "./Ressources/";
	public final static String PATH_MUSIC = "Musics/";
	public final static String PATH_IMAGES = "Images/";
	public final static String PATH_PIONS = "Pions/";
	public final static String PATH_MENU = "Menu/";
	public final static String PATH_TEXTURE = "Textures/";
	
	public final static String PATH_DETAIL = "Details.txt";
	
	public final static String PLATEAU = "board.jpg";
	public final static String PLATEAUWIN = "boardRed.jpg";
	public final static String BORDER = "boardBlur.jpg";
	
	public final static String[] PATH_THEME = {	"Parquet/" ,
												"Planche/"		};
	
	
	
	public static String getPathMusic() {
		return PATH_RESSOURCE + PATH_MUSIC ;
	}
	public static String getPathPion() {
		return PATH_RESSOURCE + PATH_IMAGES + PATH_PIONS;
	}
	
	public static String getPathTheme(int theme) {
		return PATH_RESSOURCE + PATH_IMAGES + PATH_TEXTURE + PATH_THEME[theme];
	}
	
	public static String getPathDetail() {
		return PATH_RESSOURCE + PATH_DETAIL;
	}
	
}
