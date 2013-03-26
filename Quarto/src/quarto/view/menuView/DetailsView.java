package quarto.view.menuView;
 import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;
public class DetailsView extends JPanel {

	JPanel panelTitle;
	JPanel panelResult;
	JPanel panelEasy;
	JPanel panelMedium;
	JPanel panelHard;
	JPanel panelTime;
	JPanel panelMove;
	JPanel panelGameNum;
	JPanel panelButton;
	
	JLabel title;
	JLabel resultText;
	JLabel easyText;
	JLabel mediumText;
	JLabel hardText;
	JLabel timeText;
	JLabel moveText;
	JLabel gameNumText;
	
	JLabel easy;
	JLabel medium;
	JLabel hard;
	JLabel time;
	JLabel move;
	JLabel gameNum;
	JButton back;
	
	Font titleFont;
	Font textFont;
	
	DetailsView(GUI gui) {
		
		panelTitle = new JPanel();
		panelResult = new JPanel();
		panelEasy = new JPanel();
		panelMedium = new JPanel();
		panelHard = new JPanel();
		panelTime = new JPanel();
		panelMove = new JPanel();
		panelGameNum = new JPanel();
		panelButton = new JPanel();
		
		title = new JLabel("Details",SwingConstants.CENTER);
		resultText= new JLabel("Victoires/Défaites/Nulles",SwingConstants.CENTER);
		easyText= new JLabel("Facile",SwingConstants.CENTER);
		mediumText = new JLabel("Moyen",SwingConstants.CENTER);
		hardText = new JLabel("Difficile",SwingConstants.CENTER);
		timeText = new JLabel("Temps max/min: ",SwingConstants.CENTER);
		moveText = new JLabel("Nombre Coups: ",SwingConstants.CENTER);
		gameNumText = new JLabel("Nombre partie jouees: ",SwingConstants.CENTER);
		
		easy = new JLabel();
		medium =  new JLabel();
		hard =  new JLabel();
		time =  new JLabel();
		move =  new JLabel();
		gameNum =  new JLabel();
		back = new JButton(ViewConstante.BUTTON_RETOUR);
		
		titleFont = new Font("Serif",Font.BOLD,36);
		textFont = new Font ("Serif",Font.PLAIN,18); 
		
		title.setFont(titleFont);
		title.setFont(titleFont);
		panelTitle.add(Box.createVerticalStrut(100));
		panelTitle.add(title);
		panelTitle.setPreferredSize(new Dimension(600,100));
		
		resultText.setFont(textFont);
		easyText.setFont(textFont);
		mediumText.setFont(textFont);
		hardText.setFont(textFont);
		timeText.setFont(textFont);
		moveText.setFont(textFont);
		gameNumText.setFont(textFont);
		
		panelResult.setLayout(new FlowLayout());
		panelResult.add(resultText);
		
		panelEasy.setLayout(new FlowLayout());
		panelEasy.add(easyText);
		panelEasy.add(easy);
		
		panelMedium.setLayout(new FlowLayout());
		panelMedium.add(mediumText);
		panelMedium.add(medium);
		
		panelHard.setLayout(new FlowLayout());
		panelHard.add(hardText);
		panelHard.add(hard);
		
		panelTime.setLayout(new FlowLayout());
		panelTime.add(timeText);
		panelTime.add(time);
		
		panelMove.setLayout(new FlowLayout());
		panelMove.add(moveText);
		panelMove.add(move);
		
		panelGameNum.setLayout(new FlowLayout());
		panelGameNum.add(gameNumText);
		panelGameNum.add(gameNum);
		
		initButton(back,gui);
		panelButton.add(back);
		
		setPreferredSize(new Dimension(600,600));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(panelTitle);
		add(panelResult);
		add(panelEasy);
		add(panelMedium);
		add(panelHard);
		add(panelTime);
		add(panelMove);
		add(panelGameNum);
		add(panelButton);
		
		
		
	}
	private void initButton(JButton c, GUI gui) {
		GUI.adjustSize(c, ViewConstante.BACK );
		c.addActionListener(gui);
		GUI.initElement(c);
	}
}
