package quarto.view.menuView;

import quarto.option.Option;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

public class OptionsView extends JPanel implements ActionListener{
	
	JPanel panelTitle;
	JPanel panelVolume;
	JPanel panelTimeBy;
	JPanel panelChrono;
	JPanel panelUndo;
	JPanel panelButton;
	JLabel title;
	Font titleFont;
	Font textFont;
	JLabel soundVolumeText;
	JLabel chronoText;
	JLabel timeByText;
	JLabel undoText;
	JSlider soundVolume;
	JCheckBox chrono;
	JComboBox<Integer> timeBy;
	JCheckBox undo;
	JButton back;
	JButton save;
	
	public OptionsView(GUI gui) {
		
		panelTitle = new JPanel();
		panelVolume= new JPanel();
		panelTimeBy = new JPanel();
		panelChrono = new JPanel();
		panelUndo = new JPanel();
		panelButton = new JPanel();
		title =  new JLabel("Options");
		titleFont = new Font("Serif",Font.BOLD,36);
		textFont = new Font ("Serif",Font.PLAIN,18); 
		
		soundVolumeText = new JLabel("Niveau sfx",SwingConstants.CENTER);
		chronoText = new JLabel("Activer chrono",SwingConstants.CENTER);
		timeByText = new JLabel("Temps par tour",SwingConstants.CENTER);
		undoText = new JLabel("Activer undo",SwingConstants.CENTER);
		
		
		soundVolume = new JSlider();
		timeBy= new JComboBox<Integer>();
		timeBy.setPreferredSize(new Dimension(205,25));
		chrono = new JCheckBox();
		undo = new JCheckBox();
		back = new JButton(ViewConstante.BUTTON_RETOUR);
		save = new JButton(ViewConstante.BUTTON_SAVE);
		save.addActionListener(this);
		
		title.setFont(titleFont);
		panelTitle.add(Box.createVerticalStrut(100));
		panelTitle.add(title);
		panelTitle.setPreferredSize(new Dimension(600,100));
		
		soundVolumeText.setFont(textFont);
		timeByText.setFont(textFont);
		chronoText.setFont(textFont);
		undoText.setFont(textFont);
		
	
		panelVolume.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelVolume.add(Box.createHorizontalStrut(100));
		panelVolume.add(soundVolumeText);
		panelVolume.add(Box.createHorizontalStrut(51));
		panelVolume.add(soundVolume);
		
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
		add(panelTimeBy);
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

}
