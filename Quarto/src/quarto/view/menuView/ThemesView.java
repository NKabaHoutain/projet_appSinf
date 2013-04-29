package quarto.view.menuView;

import java.awt.Dimension;
import java.awt.FlowLayout;

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
	private BackButton apply;
	
	public ThemesView(GUI gui){
		super();
		
		setPreferredSize(new Dimension(400,400));
	
		panelTheme = new JPanel();
		panelButton = new JPanel();
		
		panelTheme.setLayout(new FlowLayout());
		panelButton.setLayout(new FlowLayout());
		
		setLayout(new FlowLayout());
		back = new BackButton(ViewConstante.BUTTON_RETOUR, gui, ViewConstante.BACK);
		apply = new BackButton(ViewConstante.BUTTON_APPLY, gui,ViewConstante.BACK);
		
		
		themes = new ThemeItem[2];
		for(int i = 0; i<2;i++){
			themes[i]= new ThemeItem(Constante.PATH_THEME[i]+"board.jpg",Constante.getPathTheme(i));
			themes[i].addActionListener(gui);
			panelTheme.add(themes[i]);
		}
		
		panelButton.add(back);
		panelButton.add(apply);
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		add(panelTheme);
		add(panelButton);
		
		
	}

}
