package quarto.view.menuView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerView extends JPanel{

	private ImageIcon img;
	private JLabel name;
	
	public PlayerView(String url, String name) {
		super();
		
		this.name = new JLabel(name);
		this.name.setPreferredSize(new Dimension(60,20));
		this.name.setForeground(Color.white);
		
		img = new ImageIcon(url);
		
		this.add(Box.createRigidArea(new Dimension(100,85)));
		this.add(this.name);
		setPreferredSize(new Dimension(100,120));
		setMaximumSize(new Dimension(100,120));
		
	}
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(img.getImage(), 0,0, getWidth(), getHeight()-20, this);	
	}
	
	public String getNom() {
		return name.getText();
	}
}
