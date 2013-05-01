package quarto.view.gameView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;
import quarto.view.menuView.PanelParcho;

public class HelpView extends PanelParcho {
	
	JPanel panelTitle;
	JPanel panelText;
	
	JLabel title;
	JTextPane text;
	
	public HelpView(GUI gui){
		
		panelTitle = new JPanel();
		panelText = new JPanel();
		title = new JLabel("Help");
		text = new JTextPane();
		
		StyledDocument doc = text.getStyledDocument();		
		MutableAttributeSet center = new SimpleAttributeSet();		
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, 0, center, true);
		
		title.setForeground(Color.black);
		text.setForeground(Color.black);
		text.setText(ViewConstante.HELP);
		text.setEditable(false);
		text.setOpaque(false);
		
		panelTitle.setPreferredSize(new Dimension(500,100));
		panelTitle.setMaximumSize(new Dimension(600,100));
		
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		title.setFont(new Font("Sherif",Font.BOLD,36));
		text.setFont(new Font("Sherif",Font.PLAIN,9));
		
		panelTitle.add(title);
		panelText.add(text);
		
		
		panelTitle.setOpaque(false);
		panelText.setOpaque(false);
		
		add(Box.createVerticalStrut(35));
		add(panelTitle);
		add(panelText);
	}

}
