package quarto.view.menuView;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.*;

import quarto.constante.Constante;
import quarto.view.GUI;
import quarto.view.button.DialogButton;
import quarto.view.constante.ViewConstante;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PlayersInfoView extends JDialog {
	
	private JPanel panelName1;
	private JPanel panelName2;
	private JPanel panelButton;
	private DialogButton start;
	private DialogButton cancel;
	private JLabel j1;
	private JLabel j2;
	private JTextField nameJ1;
	private JTextField nameJ2;
	
	
	private JDialog dd;
	private Point naturalLocation;
	private Timer shakeTimer;
	private boolean inShake;
	
	private boolean isIa;
	
	

	public PlayersInfoView(GUI gui, Point locationFrame, boolean type){
		
		isIa = type;
		
		panelName1 = new JPanel();
		panelName2 = new JPanel();
		panelButton = new JPanel();
		start = new DialogButton(ViewConstante.BUTTON_START,gui);
		cancel = new DialogButton(ViewConstante.BUTTON_CANCEL,gui);
		j1 = new JLabel("Nom J1");
		j2 = new JLabel("Nom J2");
		nameJ1 = new JTextField(7);
		nameJ2 = new JTextField(7);
		Box dialog = new Box(BoxLayout.Y_AXIS);
		
		panelName1.setBackground(Color.black);
		panelName2.setBackground(Color.black);
		panelButton.setBackground(Color.black);

		j1.setForeground(Color.white);
		j2.setForeground(Color.WHITE);
		
		panelName1.setLayout(new FlowLayout());
		panelName1.add(j1);
		panelName1.add(nameJ1);
		
		panelName2.setLayout(new FlowLayout());
		panelName2.add(j2);
		panelName2.add(nameJ2);
		if(type)
		{
			nameJ2.setEditable(false);
			nameJ2.setText("CPU");
		}
		
		panelButton.setLayout(new FlowLayout());
		panelButton.add(start);
		panelButton.add(cancel);
		
		dialog.add(panelName1);
		dialog.add(panelName2);
		dialog.add(panelButton);
		add(dialog);

		
		pack();
		setVisible(true);
		setAlwaysOnTop(true); 
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		
		setLocation((int)(locationFrame.getX()+ViewConstante.SIZE_MAIN_FRAME/2- this.getSize().getHeight()/2),
						(int)(locationFrame.getY()+ViewConstante.SIZE_MAIN_FRAME/2 - this.getSize().getWidth()/2));
		
		dd = this;
		
		
		naturalLocation = getLocation();
		inShake=false;
		
	}


	public String getNameJ1() {
		return nameJ1.getText();
	}


	public String getNameJ2() {
		return nameJ2.getText();
	}
	
	public boolean isName() {
		return ! (nameJ1.getText().equals("") || nameJ2.getText().equals("") || nameJ1.getText().equals(nameJ2.getText()));
	}
	
	
	public void startShake() {
		if(!inShake) {
		    final long startTime;
		    inShake=true;
	
		    startTime = System.currentTimeMillis();
		    shakeTimer = new Timer(5, new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		double TWO_PI = Math.PI * 2.0;
		    		double SHAKE_CYCLE = 50;
	
		    		long elapsed = System.currentTimeMillis() - startTime;
		    		double waveOffset = (elapsed % SHAKE_CYCLE) / SHAKE_CYCLE;
		    		double angle = waveOffset * TWO_PI;
	
		     	   int SHAKE_DISTANCE = 10;
	
		     	   int shakenX = (int) ((Math.sin(angle) * SHAKE_DISTANCE) + naturalLocation.x);
		    	    dd.setLocation(shakenX, naturalLocation.y);
		    	    dd.repaint();
	
		    	    int SHAKE_DURATION = 1000;
		    	    if (elapsed >= SHAKE_DURATION)
		    	    	stopShake();
		    	}
		    });
		    shakeTimer.start();
		}
	  }

	  public void stopShake() {
	    shakeTimer.stop();
	    dd.setLocation(naturalLocation);
	    dd.repaint();
	    inShake=false;
	  }
	  
	  public boolean isIa() {
		  return isIa;
	  }
	
}
