package quarto.model;

public class Player {
	
	private String nom;
	
	private final Object lock=new Object();
	private Pion pionChoice;
	private Case caseChoice;
	
	public Player(String s) {
		nom = s;
		pionChoice = null;
		caseChoice = null;
	}
	
	public Pion choicePion() {
		while(pionChoice == null) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return pionChoice;
	}
	
	public Case choiceCase() {
		while(caseChoice == null) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return caseChoice;
	}
	
	public void setPionChoice(Pion p) {
		pionChoice = p;
		lock.notify();
	}
	
	public void setCaseChoice(Case c) {
		caseChoice = c;
		lock.notify();
	}

	public String getNom() {
		return nom;
	}
	
	

}
