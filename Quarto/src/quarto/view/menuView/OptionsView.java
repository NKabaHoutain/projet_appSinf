package quarto.view.menuView;

import quarto.option.Option;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class OptionsView extends JPanel implements ActionListener,ChangeListener{
	
	JPanel panelTitle;
	JPanel panelVolume;
	JPanel panelTimeBy;
	JPanel panelChrono;
	JPanel panelUndo;
	JPanel panelButton;
	JPanel panelLvl;
	JPanel panelSound;
	JLabel title;
	Font titleFont;
	Font textFont;
	JLabel soundVolumeText;
	JLabel musicText;
	JLabel sfxText;
	JLabel chronoText;
	JLabel levelText;
	JLabel easyText;
	JLabel mediumText;
	JLabel hardText;
	JLabel timeByText;
	JLabel undoText;
	JSlider soundVolume; 
	JCheckBox music;
	JCheckBox sfx;
	JCheckBox chrono;
	JCheckBox easy;
	JCheckBox medium;
	JCheckBox hard;
	JComboBox<Integer> timeBy;
	JCheckBox undo;
	JButton back;
	JButton save;
	
	int vol;
	
	public OptionsView(GUI gui) {
		
		panelTitle = new JPanel();
		panelVolume= new JPanel();
		panelTimeBy = new JPanel();
		panelChrono = new JPanel();
		panelUndo = new JPanel();
		panelButton = new JPanel();
		panelLvl = new JPanel();
		panelSound = new JPanel();
		
		title =  new JLabel("Options");
		titleFont = new Font("Serif",Font.BOLD,36);
		textFont = new Font ("Serif",Font.PLAIN,18); 
		
		soundVolumeText = new JLabel("Niveau sfx",SwingConstants.CENTER);
		chronoText = new JLabel("Activer chrono",SwingConstants.CENTER);
		timeByText = new JLabel("Temps par tour",SwingConstants.CENTER);
		undoText = new JLabel("Activer undo",SwingConstants.CENTER);
		musicText = new JLabel("Musique:",SwingConstants.CENTER);
		sfxText = new JLabel("sfx:",SwingConstants.CENTER);
		levelText = new JLabel("Niveau: ",SwingConstants.CENTER);
		easyText = new JLabel("Facile",SwingConstants.CENTER);
		mediumText = new JLabel("Medium",SwingConstants.CENTER);
		hardText = new JLabel("Difficile",SwingConstants.CENTER);
		
		
		
		soundVolume = new JSlider(JSlider.HORIZONTAL,0,100,50);
		timeBy= new JComboBox<Integer>();
		timeBy.setPreferredSize(new Dimension(205,25));
		chrono = new JCheckBox();
		undo = new JCheckBox();
		music = new JCheckBox();
		sfx = new JCheckBox();
		easy = new JCheckBox();
		medium = new JCheckBox();
		hard = new JCheckBox();
		back = new JButton(ViewConstante.BUTTON_RETOUR);
		save = new JButton(ViewConstante.BUTTON_SAVE);
		
		soundVolume.addChangeListener(this);
		soundVolume.setMajorTickSpacing(10);
		soundVolume.setPaintTicks(true);
		save.addActionListener(this);
		
		
		title.setFont(titleFont);
		panelTitle.add(Box.createVerticalStrut(100));
		panelTitle.add(title);
		panelTitle.setPreferredSize(new Dimension(600,100));
		
		soundVolumeText.setFont(textFont);
		musicText.setFont(textFont);
		sfxText.setFont(textFont);
		timeByText.setFont(textFont);
		chronoText.setFont(textFont);
		undoText.setFont(textFont);
		levelText.setFont(textFont);
		easyText.setFont(textFont);
		mediumText.setFont(textFont);
		hardText.setFont(textFont);
		
	
		panelVolume.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelVolume.add(Box.createHorizontalStrut(100));
		panelVolume.add(soundVolumeText);
		panelVolume.add(Box.createHorizontalStrut(51));
		panelVolume.add(soundVolume);
		
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
		panelLvl.add(easyText);
		panelLvl.add(easy);
		panelLvl.add(mediumText);
		panelLvl.add(medium);
		panelLvl.add(hardText);
		panelLvl.add(hard);
		
		panelTimeBy.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelTimeBy.add(Box.createHorizontalStrut(100));
		panelTimeBy.add(timeByText);
		panelTimeBy.add(Box.createHorizontalStrut(16));
		panelTimeBy.add(timeBy);
	
		
		panelChrono.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelChrono.add(Box.createHorizontalStrut(100));
		panelChrono.add(chronoText);
		panelChrono.add(Box.createHorizontalStrut(14));
		panelChrono.add(chrono);
		
		panelUndo.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelUndo.add(Box.createHorizontalStrut(100));
		panelUndo.add(undoText);
		panelUndo.add(Box.createHorizontalStrut(32));
		panelUndo.add(undo);
	
		panelButton.setLayout(new FlowLayout());
		initButton(back,gui);
		initButton(save,gui);
		panelButton.add(back);
		panelButton.add(save);
		
		init();
		
		this.setPreferredSize(new Dimension(600,600));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(panelTitle);
		add(Box.createHorizontalGlue());
		add(panelVolume);
		add(panelSound);
		add(panelTimeBy);
		add(panelLvl);
		add(panelChrono);
		add(panelUndo);
		add(panelButton);
	}
	private void initButton(JButton c, GUI gui) {
		GUI.adjustSize(c, ViewConstante.BACK );
		c.addActionListener(gui);
		GUI.initElement(c);
	}
	

	private void init() {
		undo.setSelected(Option.isUndo());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		
		if(s instanceof JButton) {
			if( ((JButton) s).getText().equals(ViewConstante.BUTTON_SAVE)) {
				Option.setUndo(undo.isSelected());
			}
		}
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
	    if (!source.getValueIsAdjusting()) {
	        vol = (int)source.getValue();
	        Option.setSoundVolume(vol);
	        }

		
	}

}
