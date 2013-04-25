package quarto.view.button;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class MenuButton extends JButton implements MouseListener {
	
	public MenuButton(String text, GUI gui, int constante) {
		super(text);
		
		setMinimumSize(ViewConstante.minSize[constante]);
		setMaximumSize(ViewConstante.maxSize[constante]);
		setPreferredSize(ViewConstante.preferredSize[constante]);
		
		addMouseListener(this);
		addActionListener(gui);
		
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setAlignmentY(Component.CENTER_ALIGNMENT);
		
		setBackground(Color.black);
		setForeground(Color.white);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setBackground(Color.WHITE);
		setForeground(Color.black);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBackground(Color.black);
		setForeground(Color.white);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
