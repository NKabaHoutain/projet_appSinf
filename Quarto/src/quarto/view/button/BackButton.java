package quarto.view.button;

import java.awt.Component;

import javax.swing.JButton;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class BackButton extends JButton{

	public BackButton(String text, GUI gui, int constante) {
		super(text);
		
		setMinimumSize(ViewConstante.minSize[constante]);
		setMaximumSize(ViewConstante.maxSize[constante]);
		setPreferredSize(ViewConstante.preferredSize[constante]);
		
		addActionListener(gui);
		
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setAlignmentY(Component.CENTER_ALIGNMENT);
		
	}
}
