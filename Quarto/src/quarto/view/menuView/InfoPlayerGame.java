package quarto.view.menuView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import quarto.constante.Constante;
import quarto.view.constante.ViewConstante;

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
			
			info = new JLabel("SELECT");
			info.setMaximumSize(new Dimension(100, 20));
			info.setAlignmentX(CENTER_ALIGNMENT);
			info.setFont(new Font("Sherif", Font.BOLD, 18));
			info.setForeground(Color.white);
			
			firstP.setBorder(BorderFactory.createLineBorder(Color.red,3));
			secondP.setBorder(BorderFactory.createLineBorder(Color.black,3));

			this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			
			this.add(Box.createVerticalGlue());
			this.add(firstP);
			this.add(Box.createRigidArea(new Dimension(100,20)));
			this.add(info);
			this.add(Box.createRigidArea(new Dimension(100,20)));
			this.add(secondP);
			this.add(Box.createVerticalGlue());

			setOpaque(false);
			
		}
		
		public void change(String name) {
			if(info.getText().equals(ViewConstante.SELECT))
				info.setText(ViewConstante.MOVE);
			else
				info.setText(ViewConstante.SELECT);
			
			
			if(name.equals(firstP.getNom())) {
				firstP.setBorder(BorderFactory.createLineBorder(Color.red,3));
				secondP.setBorder(BorderFactory.createLineBorder(Color.black,3));
			}
			else {
				firstP.setBorder(BorderFactory.createLineBorder(Color.black,3));
				secondP.setBorder(BorderFactory.createLineBorder(Color.red,3));
			}
		}
		
}

