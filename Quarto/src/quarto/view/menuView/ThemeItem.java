package quarto.view.menuView;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class ThemeItem extends JButton {
	
	private String name;
	private String imgPath;
	private ImageIcon img;
	
	public ThemeItem(String name,String imgPath){
		super(name);
		
		setPreferredSize(new Dimension(100,100));
		this.img = new ImageIcon(imgPath);
		
		setContentAreaFilled(false);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img.getImage(),0,0,getWidth(),getHeight(),this);
	}
}
