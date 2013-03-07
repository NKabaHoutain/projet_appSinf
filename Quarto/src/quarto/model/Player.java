package quarto.model;

public class Player {
	
	private String nom;
	
	private boolean inGame;
	
	public Player(String s) {
		nom = s;
		inGame = false;
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

}
