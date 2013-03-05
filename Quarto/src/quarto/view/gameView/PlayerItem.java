package quarto.view.gameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import quarto.controller.Controller;
import quarto.model.Player;

public class PlayerItem implements ActionListener {
	
	private Player player;
	private Controller controller;
	
	public PlayerItem(Player p, Controller controller){
		player = p;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object res = e.getSource();
		if(player.isInGame()) {
			if(res instanceof CaseItem) {
				controller.giveCase(((CaseItem) res).getCase(), player.getNom());
			}
			
			if(res instanceof PionItem) {
				controller.givePion(((PionItem) res).getPion(), player.getNom());
			}
		}
	}

}
