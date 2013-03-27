package quarto.view.menuView;

import javax.imageio.ImageIO;
import javax.swing.*;

import quarto.constante.Constante;
import quarto.view.GUI;
import quarto.view.button.MenuButton;
import quarto.view.constante.ViewConstante;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MenuItem extends JPanel {
	
	JPanel panelButton;
	JPanel panelLogo;
	JLabel title;
	MenuButton start;
	MenuButton rules;
	MenuButton options;
	MenuButton details;
	Image logo;
	
	public MenuItem(GUI gui) {
		/*
		 * Initialisation des panels
		 */
		panelLogo = new JPanel();
		panelButton = new JPanel();
		try {
			logo = ImageIO.read(new File(Constante.getPathLogo()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		title = new JLabel( new ImageIcon (logo));
		start = new MenuButton(ViewConstante.BUTTON_STARTMENU, gui, ViewConstante.MENUITEM);
		rules = new MenuButton(ViewConstante.BUTTON_REGLE, gui, ViewConstante.MENUITEM);
		options = new MenuButton(ViewConstante.BUTTON_OPTION, gui, ViewConstante.MENUITEM);
		details = new MenuButton(ViewConstante.BUTTON_DETAIL, gui, ViewConstante.MENUITEM);
		
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(Component.CENTER_ALIGNMENT);
		title.setVisible(true);
		
		panelLogo.setLayout(new BoxLayout(panelLogo,BoxLayout.Y_AXIS));
		panelLogo.setPreferredSize(new Dimension(50,200));
		panelLogo.add(Box.createVerticalStrut(40));
		panelLogo.add(title);
		panelLogo.add(Box.createHorizontalGlue());
		
		panelButton.setPreferredSize(new Dimension(500,100));
		
		panelButton.add(start);
		panelButton.add(Box.createRigidArea(ViewConstante.space[ViewConstante.MENUITEM]));
		
		panelButton.add(rules);
		panelButton.add(Box.createRigidArea(ViewConstante.space[ViewConstante.MENUITEM]));
		
		panelButton.add(options);
		panelButton.add(Box.createRigidArea(ViewConstante.space[ViewConstante.MENUITEM]));
		
		panelButton.add(details);
		panelButton.add(Box.createGlue());
		
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new GridLayout(2,1));
		this.add(panelLogo,Component.CENTER_ALIGNMENT);
		this.add(panelButton,Component.CENTER_ALIGNMENT);
		this.setVisible(true);
	}

}
