package quarto.view.gameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quarto.controller.Controller;

public class PlayerItem implements ActionListener {
	
	private String nom;
	private Controller controller;
	private boolean inGame=false;
	
	public PlayerItem(String s, Controller controller){
		nom = s;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object res = e.getSource();
		if(inGame) {
			if(res instanceof CaseItem) {
				controller.giveCase(((CaseItem) res).getCase(), nom);
			}
			
			if(res instanceof PionItem) {
				controller.givePion(((PionItem) res).getPion(), nom);
			}
		}
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	
	

}
