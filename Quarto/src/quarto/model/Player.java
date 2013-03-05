package quarto.model;

public class Player {
	
	private String nom;
	
	private final Object lock=new Object();
	private Pion pionChoice;
	private Case caseChoice;
	
	private boolean inGame;
	
	public Player(String s) {
		nom = s;
		pionChoice = null;
		caseChoice = null;
		inGame = false;
	}
	
	public Pion choicePion() {
		synchronized(lock) {
			pionChoice=null;
			while(pionChoice == null) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return pionChoice;
	}
	
	public Case choiceCase() {
		synchronized(lock) {
			caseChoice=null;
			while(caseChoice == null) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		return caseChoice;
	}
	
	public void setPionChoice(Pion p) {
		synchronized(lock) {
			pionChoice = p;
			lock.notify();
		}
	}
	
	public void setCaseChoice(Case c) {
		synchronized(lock) {
			caseChoice = c;
			lock.notify();
		}
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
