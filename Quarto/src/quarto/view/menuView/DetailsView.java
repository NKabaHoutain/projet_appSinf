package quarto.view.menuView;
 import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import quarto.constante.Constante;
import quarto.detail.Detail;
import quarto.view.GUI;
import quarto.view.button.BackButton;
import quarto.view.constante.ViewConstante;
public class DetailsView extends PanelParcho {

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
	JLabel TotalTime;
	BackButton back;
	
	Font titleFont;
	Font textFont;
	
	public DetailsView(GUI gui) {
		
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
		resultText= new JLabel("Victoires/Defaites/Nulles",SwingConstants.CENTER);
		easyText= new JLabel("Facile",SwingConstants.CENTER);
		mediumText = new JLabel("Moyen",SwingConstants.CENTER);
		hardText = new JLabel("Difficile",SwingConstants.CENTER);
		timeText = new JLabel("Temps max/min: ",SwingConstants.CENTER);
		moveText = new JLabel("Nombre Coups max/min: ",SwingConstants.CENTER);
		gameNumText = new JLabel("Temps total: ",SwingConstants.CENTER);
		
		easy = new JLabel(Detail.getStringLevel(Constante.LVL_EASY));
		medium =  new JLabel(Detail.getStringLevel(Constante.LVL_MEDIUM));
		hard =  new JLabel(Detail.getStringLevel(Constante.LVL_HARD));
		
		time =  new JLabel(Detail.getStringTime());
		move =  new JLabel(Detail.getStringMove());
		TotalTime =  new JLabel(Detail.getStringTotalTime());
		back = new BackButton(ViewConstante.BUTTON_RETOUR, gui, ViewConstante.BACK );
		
		titleFont = new Font("Serif",Font.BOLD,36);
		textFont = new Font ("Serif",Font.PLAIN,18); 
		
		title.setFont(titleFont);
		title.setFont(titleFont);
		panelTitle.add(Box.createVerticalStrut(105));
		panelTitle.add(title);
		panelTitle.setPreferredSize(new Dimension(600,50));
		
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
		panelGameNum.add(TotalTime);
		
		panelButton.add(back);
		
		setPreferredSize(new Dimension(600,600));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		panelTitle.setOpaque(false);
		add(panelTitle);
		panelResult.setOpaque(false);
		add(panelResult);
		panelEasy.setOpaque(false);
		add(panelEasy);
		panelMedium.setOpaque(false);
		add(panelMedium);
		panelHard.setOpaque(false);
		add(panelHard);
		panelTime.setOpaque(false);
		add(panelTime);
		panelMove.setOpaque(false);
		add(panelMove);
		panelGameNum.setOpaque(false);
		add(panelGameNum);
		panelButton.setOpaque(false);
		add(panelButton);
		
		
		
	}
}
