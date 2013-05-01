package quarto.view.menuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.*;

import quarto.constante.Constante;
import quarto.view.GUI;
import quarto.view.button.BackButton;
import quarto.view.constante.ViewConstante;

public class ThemesView extends JPanel {
	
	private JPanel panelTheme;
	private JPanel panelButton;
	
	private ThemeItem[] themes;
	private BackButton back;
	public ThemesView(ActionListener opt){
		super();
		
		setPreferredSize(new Dimension(400,400));
		setBackground(Color.black);
	
		panelTheme = new JPanel();
		panelButton = new JPanel();
		
		panelTheme.setBackground(Color.black);
		panelTheme.setAutoscrolls(true);
		
		panelButton.setBackground(Color.black);
		
		panelTheme.setLayout(new FlowLayout());
		
		back = new BackButton(ViewConstante.BUTTON_RETOUR_OPTION,opt, ViewConstante.BACK);
		back.setForeground(Color.white);
		back.setBorder(BorderFactory.createLineBorder(Color.white));
		
		setLayout(new FlowLayout());
		
		themes = new ThemeItem[2];
		for(int i = 0; i<2;i++){
			themes[i]= new ThemeItem(i,Constante.getPathTheme(i)+Constante.PLATEAU);
			themes[i].addActionListener(opt);
			panelTheme.add(themes[i]);
		}
		
		panelButton.add(back);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		
		add(panelTheme);
		add(Box.createGlue());
		add(panelButton);
		
	}

}
