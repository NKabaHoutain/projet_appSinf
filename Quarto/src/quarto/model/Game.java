package quarto.model;

public class Game {
	
	private Board board;
	private Player playerOne;
	private Player playerTwo;
	
	/**
	 * Constructeur
	 * @param p1
	 * @param p2
	 */
	public Game(Player p1, Player p2) {
		board = new Board();
		playerOne = p1;
		playerTwo = p2;

		playerOne.setInGame(true);
	}
	
	public Board getBoard() {
		return board;
	}
	

	private void changeGamer()
	{
		playerOne.setInGame(!playerOne.isInGame());
		playerTwo.setInGame(!playerTwo.isInGame());
	}
	
	private String nextPlayer() {
		changeGamer();
		
		if(playerOne.isInGame()) {
			return playerOne.getNom();
		}
		return playerTwo.getNom();
	}
	
	public Player selectPlayer(String nom) {
		if(playerOne.getNom().equals(nom)) {
			return playerOne;
		}
		return playerTwo;
	}

	public boolean move(Case c) {
		return board.move(c);
	}

	public void selectPion(Pion p) {
		board.selectPion(p);
		
	}

	public void pionSelected() {
		board.pionSelected(nextPlayer());
		
	}

	public void undo() {
		board.undo(nextPlayer());	
	}


}
