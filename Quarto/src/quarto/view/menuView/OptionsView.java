package quarto.view.menuView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class OptionsView extends JPanel {
	
	JPanel panelTitle;
	JPanel centerPanel;
	JPanel panelButton;
	JLabel title;
	Font titleFont;
	Font textFont;
	JLabel musicText;
	JLabel soundEffectText;
	JLabel chronoText;
	JLabel timeByText;
	JLabel undoText;
	JSlider music;
	JSlider sfx;
	JCheckBox chrono;
	JComboBox timeBy;
	JCheckBox undo;
	JButton back;
	JButton save;
	
	public OptionsView(GUI gui) {
		
		panelTitle = new JPanel();
		centerPanel= new JPanel();
		panelButton = new JPanel();
		title =  new JLabel("Options");
		titleFont = new Font("Serif",Font.BOLD,36);
		textFont = new Font ("Serif",Font.PLAIN,18); 
		musicText = new JLabel("Niveau musique",SwingConstants.CENTER);
		soundEffectText = new JLabel("Niveau sfx",SwingConstants.CENTER);
		chronoText = new JLabel("Activer chrono",SwingConstants.CENTER);
		timeByText = new JLabel("Temps par tour",SwingConstants.CENTER);
		undoText = new JLabel("Activer undo",SwingConstants.CENTER);
		
		music = new JSlider();
		sfx = new JSlider();
		chrono = new JCheckBox();
		timeBy= new JComboBox();
		undo = new JCheckBox();
		back = new JButton(ViewConstante.BUTTON_RETOUR);
		save = new JButton(ViewConstante.BUTTON_SAVE);
		
		title.setFont(titleFont);
		panelTitle.add(Box.createVerticalStrut(100));
		panelTitle.add(title);
		panelTitle.setPreferredSize(new Dimension(600,100));
		
		centerPanel.setLayout(new GridLayout(5,2));
		centerPanel.add(musicText);
		centerPanel.add(music);
		centerPanel.add(soundEffectText);
		centerPanel.add(sfx);
		centerPanel.add(chronoText);
		centerPanel.add(chrono);
		centerPanel.add(timeByText);
		centerPanel.add(timeBy);
		centerPanel.add(undoText);
		centerPanel.add(undo);
	
		panelButton.setLayout(new BoxLayout(panelButton,BoxLayout.X_AXIS));
		initButton(back,gui);
		initButton(save,gui);
		panelButton.add(back);
		panelButton.add(Box.createHorizontalStrut(15));
		panelButton.add(save);
		panelButton.setPreferredSize(new Dimension(600,100));
		
		
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(panelTitle);
		add(centerPanel);
		add(panelButton);
		
	}
	private void initButton(JButton c, GUI gui) {
		GUI.adjustSize(c, ViewConstante.BACK );

		c.addActionListener(gui);
		
		GUI.initElement(c);
	}

}
