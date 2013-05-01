package quarto.view.menuView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import quarto.view.GUI;
import quarto.view.button.BackButton;
import quarto.view.constante.ViewConstante;

public class RulesView extends PanelParcho {
	
	JPanel panelTitle;
	JLabel title;
	Font fontTitle;
	JPanel panelText;
	JTextPane rules;
	JPanel panelButton;
	BackButton back;
	
	public RulesView(GUI gui){
		
		panelTitle = new JPanel();
		panelText = new JPanel();
		panelButton = new JPanel();
		title = new JLabel(ViewConstante.BUTTON_REGLE);
		fontTitle = new Font("Sherif",Font.BOLD,36);
		rules = new JTextPane();
		back = new BackButton(ViewConstante.BUTTON_RETOUR, gui, ViewConstante.BACK);
		
		
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		panelTitle.setPreferredSize(new Dimension(600,50));
		panelText.setPreferredSize(new Dimension(500,500));
		panelButton.setPreferredSize(new Dimension(600,50));
		
		StyledDocument doc = rules.getStyledDocument();		
		MutableAttributeSet center = new SimpleAttributeSet();		
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, 0, center, true);
		rules.setOpaque(false);
		rules.setText(ViewConstante.RULES);
		title.setFont(fontTitle);
		
		title.setForeground(Color.black);		
		rules.setEditable(false);
		rules.setForeground(Color.black);
		
		initElement(title);
		initElement(rules);
		
		panelTitle.add(title);
		panelTitle.setPreferredSize(new Dimension(600,30));
		panelText.add(rules);
		if(gui!= null) {
			panelButton.add(back);
		}
		
		add(Box.createVerticalStrut(30));
		panelTitle.setOpaque(false);
		add(panelTitle);
		add(Box.createVerticalStrut(2));
		panelText.setOpaque(false);
		add(panelText);
		add(Box.createVerticalStrut(0));
		panelButton.setOpaque(false);
		add(panelButton);
		add(Box.createVerticalStrut(25));
		
	}
	
	public static void initElement(JComponent c) {
		c.setAlignmentX(Component.CENTER_ALIGNMENT);
		c.setAlignmentY(Component.CENTER_ALIGNMENT);
	}

}
