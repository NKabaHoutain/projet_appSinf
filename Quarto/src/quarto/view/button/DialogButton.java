package quarto.view.button;

import java.awt.Color;

import javax.swing.JButton;

import quarto.view.GUI;

public class DialogButton extends JButton {
	
	public DialogButton(String text,GUI gui){
		super(text);
		
		addActionListener(gui);
		setBackground(Color.white);
		
		
	}

}
