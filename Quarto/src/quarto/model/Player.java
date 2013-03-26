package quarto.model;

public class Player {
	
	private String nom;
	private boolean ia;
	private boolean inGame;
	
	public Player(String s, boolean ia) {
		nom = s;
		inGame = false;
		this.ia = ia;
	}

	public String getNom() {
		return nom;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public boolean isIa() {
		return ia;
	}
}
