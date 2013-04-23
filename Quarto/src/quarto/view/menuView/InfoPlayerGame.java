package quarto.view.menuView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import quarto.constante.Constante;

public class InfoPlayerGame extends JPanel{
	
		PlayerView firstP;
		PlayerView secondP;
		JLabel info;

		public InfoPlayerGame(boolean isIa, String p1, String p2){
			firstP = new PlayerView(Constante.getUserLogo(), p1);
			if(isIa)
				secondP = new PlayerView(Constante.getCpuLogo(), p2);
			else
				secondP = new PlayerView(Constante.getUserLogo(), p2);
			
			info = new JLabel("Select");
			info.setMaximumSize(new Dimension(100, 20));
			info.setAlignmentX(CENTER_ALIGNMENT);
			
		
			

			this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			
			this.add(Box.createVerticalGlue());
			this.add(firstP);
			this.add(Box.createRigidArea(new Dimension(100,20)));
			this.add(info);
			this.add(Box.createRigidArea(new Dimension(100,20)));
			this.add(secondP);
			this.add(Box.createVerticalGlue());

		}
		
		public void setText(String text) {
			
		}
}

