package quarto.view.gameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerItem implements ActionListener {
	
	private String nom;
	
	public PlayerItem(String s){
		nom = s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object res = e.getSource();
		
		if(res instanceof CaseItem) {
			((CaseItem) res).getCase();
		}
		
		if(res instanceof PionItem) {
			((PionItem) res).getPion();
		}
		
	}
	
	

}
