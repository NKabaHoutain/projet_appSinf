package quarto.view.menuView;

import quarto.constante.Constante;
import quarto.controller.Controller;
import quarto.option.Option;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import quarto.view.GUI;
import quarto.view.button.BackButton;
import quarto.view.constante.ViewConstante;

public class OptionsView extends PanelParcho implements ActionListener {
	
	JPanel panelTitle;
	JPanel panelUndo;
	JPanel panelButton;
	JPanel panelLvl;
	JPanel panelSound;
	JPanel panelTheme;
	JLabel title;
	Font titleFont;
	Font textFont;
	JLabel musicText;
	JLabel sfxText;
	JLabel levelText;
	JLabel easyText;
	JLabel mediumText;
	JLabel hardText;
	JLabel undoText;
	JLabel themeText;
	JLabel themeName; 
	JCheckBox music;
	JCheckBox sfx;
	JCheckBox easy;
	JCheckBox medium;
	JCheckBox hard;
	JCheckBox undo;
	
	JFrame frame;
	

	BackButton back;
	BackButton save;
	JButton changeTheme;
	
	GUI gui;
	
	public OptionsView(GUI gui) {
		
		this.gui = gui;
		
		panelTitle = new JPanel();
		panelUndo = new JPanel();
		panelButton = new JPanel();
		panelLvl = new JPanel();
		panelSound = new JPanel();
		panelTheme = new JPanel();
		
		title =  new JLabel("Options");
		titleFont = new Font("Serif",Font.BOLD,36);
		textFont = new Font ("Serif",Font.PLAIN,18); 
		
		
		undoText = new JLabel("Activer undo:",SwingConstants.CENTER);
		musicText = new JLabel("Musique: ",SwingConstants.CENTER);
		sfxText = new JLabel("sfx:",SwingConstants.CENTER);
		levelText = new JLabel("Niveau: ",SwingConstants.CENTER);
		easyText = new JLabel("Facile",SwingConstants.CENTER);
		mediumText = new JLabel("Medium",SwingConstants.CENTER);
		hardText = new JLabel("Difficile",SwingConstants.CENTER);
		themeText = new JLabel("Theme: ",SwingConstants.CENTER);
		themeName = new JLabel (Option.getThemeName().replace("/", ""),SwingConstants.CENTER);
		
		undoText.setForeground(Color.white);
		sfxText.setForeground(Color.white);
		
		undo = new JCheckBox();
		music = new JCheckBox();
		sfx = new JCheckBox();
		easy = new JCheckBox();
		easy.addActionListener(this);
		medium = new JCheckBox();
		medium.addActionListener(this);
		hard = new JCheckBox();
		hard.addActionListener(this);


		back = new BackButton(ViewConstante.BUTTON_RETOUR, gui, ViewConstante.BACK );
		save = new BackButton(ViewConstante.BUTTON_SAVE, this, ViewConstante.BACK );
		changeTheme = new JButton(ViewConstante.BUTTON_CHANGE);
		
		changeTheme.addActionListener(this);
		
		title.setFont(titleFont);
		panelTitle.add(Box.createVerticalStrut(105));
		panelTitle.add(title);
		panelTitle.setPreferredSize(new Dimension(600,100));
		
		
		musicText.setFont(textFont);
		sfxText.setFont(textFont);
		undoText.setFont(textFont);
		levelText.setFont(textFont);
		easyText.setFont(textFont);
		mediumText.setFont(textFont);
		hardText.setFont(textFont);
		themeText.setFont(textFont);
		themeName.setFont(textFont);
		
		music.setOpaque(false);
		sfx.setOpaque(false);
		undo.setOpaque(false);
		easy.setOpaque(false);
		medium.setOpaque(false);
		hard.setOpaque(false);
		
		music.setForeground(Color.white);
		
		
		panelSound.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelSound.add(Box.createHorizontalStrut(100));
		panelSound.add(musicText);
		panelSound.add(music);
		panelSound.add(Box.createHorizontalStrut(10));
		panelSound.add(sfxText);
		panelSound.add(sfx);
		
		panelLvl.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelLvl.add(Box.createHorizontalStrut(100));
		panelLvl.add(levelText);
		panelLvl.add(Box.createHorizontalStrut(25));
		panelLvl.add(easyText);
		panelLvl.add(easy);
		panelLvl.add(mediumText);
		panelLvl.add(medium);
		panelLvl.add(hardText);
		panelLvl.add(hard);
		
		panelUndo.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelUndo.add(Box.createHorizontalStrut(100));
		panelUndo.add(undoText);
		panelUndo.add(Box.createHorizontalStrut(32));
		panelUndo.add(undo);
	
		panelTheme.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelTheme.add(Box.createHorizontalStrut(100));
		panelTheme.add(themeText);
		panelTheme.add(Box.createHorizontalStrut(25));
		panelTheme.add(themeName);
		panelTheme.add(Box.createHorizontalStrut(20));
		panelTheme.add(changeTheme);
		
		panelButton.setLayout(new FlowLayout());
		panelButton.add(back);
		panelButton.add(save);
		
		init();
		
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		panelTitle.setOpaque(false);
		add(panelTitle);
		add(Box.createHorizontalGlue());
		
		panelSound.setOpaque(false);
		add(panelSound);		
		add(Box.createVerticalGlue());
		panelLvl.setOpaque(false);
		add(panelLvl);
		add(Box.createVerticalGlue());
		panelUndo.setOpaque(false);
		add(panelUndo);
		add(Box.createVerticalGlue());
		panelTheme.setOpaque(false);
		add(panelTheme);
		add(Box.createVerticalGlue());
		panelButton.setOpaque(false);
		add(panelButton);
	}
	
	private void init() {
		undo.setSelected(Option.isUndo());
		sfx.setSelected(Option.isPlaySfx());
		music.setSelected(Option.isPlayMusic());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		
		if(s instanceof JButton) {
			if( ((JButton) s).getText().equals(ViewConstante.BUTTON_SAVE)) {
				Option.setUndo(undo.isSelected());
				Option.setPlaySfx(sfx.isSelected());
				Option.setPlayMusic(music.isSelected());
				Option.setGameLevel(getLevel());
				
				if(!music.isSelected()) {
					Controller.music.stopMusic();
				}
				else {
					Controller.music.restart();
				}
				
				gui.startMenu();
			}
			else if(s instanceof ThemeItem) {
				Option.setTheme(((ThemeItem) s).getTheme());
				themeName.setText(Option.getThemeName().replace("/", ""));
				frame.dispose();
			}
			else if(((JButton)s).getText().equals(ViewConstante.BUTTON_CHANGE)){
				frame = new JFrame();
				frame.add(new ThemesView(this));
				frame.setVisible(true);
				frame.setResizable(false);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			else if(((JButton)s).getText().equals(ViewConstante.BUTTON_RETOUR_OPTION)){
				frame.dispose();
			}
		}
		else if (s instanceof JCheckBox) {
			methLevel(((JCheckBox)s));
		}
		
	}
	private void methLevel(JCheckBox box) {
		easy.setSelected(easy == box);
		medium.setSelected(medium == box);
		hard.setSelected(hard == box);
	}
	
	private int getLevel() {
		if(hard.isSelected())
			return Constante.LVL_HARD;
		else if(medium.isSelected())
			return Constante.LVL_MEDIUM;
		else
			return Constante.LVL_EASY;
	}
}
