package quarto.view.menuView;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

import quarto.constante.Constante;

public class ThemeItem extends JButton {
	
	private int name;
	private String imgPath;
	private ImageIcon img;
	
	public ThemeItem(int name,String imgPath){
		super(Constante.PATH_THEME[name]);
		this.name = name;
		
		setPreferredSize(new Dimension(180,180));
		this.img = new ImageIcon(imgPath);
		
		setContentAreaFilled(false);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(img.getImage(),0,0,getWidth(),getHeight(),this);
	}
	
	public int getTheme() {
		return name;
	}
}
