package quarto.view.menuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import quarto.constante.Constante;
import quarto.view.GUI;
import quarto.view.button.BackButton;
import quarto.view.constante.ViewConstante;

public class ThemesView extends JPanel {
	
	private JPanel panelTheme;
	
	private ThemeItem[] themes;
	
	public ThemesView(ActionListener opt){
		super();
		
		setPreferredSize(new Dimension(400,400));
		setBackground(Color.black);
	
		panelTheme = new JPanel();
		
		panelTheme.setBackground(Color.black);
		panelTheme.setAutoscrolls(true);
		
		panelTheme.setLayout(new FlowLayout());
		
		setLayout(new FlowLayout());
		
		themes = new ThemeItem[2];
		for(int i = 0; i<2;i++){
			themes[i]= new ThemeItem(i,Constante.getPathTheme(i)+Constante.PLATEAU);
			themes[i].addActionListener(opt);
			panelTheme.add(themes[i]);
		}
		
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		add(panelTheme);
		
	}

}
