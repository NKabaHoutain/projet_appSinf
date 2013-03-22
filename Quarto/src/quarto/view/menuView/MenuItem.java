package quarto.view.menuView;
import javax.imageio.ImageIO;
import javax.swing.*;

import quarto.constante.Constante;
import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MenuItem extends JPanel {
	JPanel panelButton;
	JPanel panelLogo;
	JLabel title;
	JButton start;
	JButton rules;
	JButton options;
	JButton details;
	Image logo;
	
	public MenuItem(GUI gui) throws IOException {
		/*
		 * Initialisation des panels
		 */
		panelLogo = new JPanel();
		panelButton = new JPanel();
		logo = ImageIO.read(new File("Ressources/Images/Menu/logo_quarto.jpg"));
		title = new JLabel( new ImageIcon (logo));
		start = new JButton(ViewConstante.BUTTON_STARTMENU);
		rules = new JButton(ViewConstante.BUTTON_REGLE);
		options = new JButton(ViewConstante.BUTTON_OPTION);
		details = new JButton(ViewConstante.BUTTON_DETAIL);
		
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(Component.CENTER_ALIGNMENT);
		title.setVisible(true);
		
		panelLogo.setLayout(new BoxLayout(panelLogo,BoxLayout.Y_AXIS));
		panelLogo.setPreferredSize(new Dimension(50,200));
		panelLogo.add(Box.createVerticalStrut(40));
		panelLogo.add(title);
		panelLogo.add(Box.createHorizontalGlue());
		
		panelButton.setPreferredSize(new Dimension(500,100));

		initButton(start, gui);
		initButton(rules, gui);
		initButton(options, gui);
		initButton(details, gui);
		
		
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
	
	private void initButton(JButton c, GUI gui) {
		GUI.adjustSize(c,ViewConstante.MENUITEM);

		c.addActionListener(gui);
		
		c.setAlignmentX(Component.CENTER_ALIGNMENT);
		c.setAlignmentY(Component.CENTER_ALIGNMENT);
	}

}
