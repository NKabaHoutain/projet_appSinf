package quarto.view.menuView;

import java.awt.FlowLayout;

import javax.swing.*;

import quarto.view.GUI;
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
	private JButton start;
	private JButton cancel;
	private JLabel j1;
	private JLabel j2;
	private JTextField nameJ1;
	private JTextField nameJ2;
	
	
	JDialog dd;
	Point naturalLocation;
	Timer shakeTimer;
	

	public PlayersInfoView(GUI gui){
		
		
		panelName1 = new JPanel();
		panelName2 = new JPanel();
		panelButton = new JPanel();
		start = new JButton(ViewConstante.BUTTON_START);
		cancel = new JButton(ViewConstante.BUTTON_CANCEL);
		j1 = new JLabel("Nom J1");
		j2 = new JLabel("Nom J2");
		nameJ1 = new JTextField(10);
		nameJ2 = new JTextField(10);
		Box dialog = new Box(BoxLayout.Y_AXIS);
		
		panelName1.setLayout(new FlowLayout());
		panelName1.add(j1);
		panelName1.add(nameJ1);
		
		panelName2.setLayout(new FlowLayout());
		panelName2.add(j2);
		panelName2.add(nameJ2);
		
		panelButton.setLayout(new FlowLayout());
		start.addActionListener(gui);
		cancel.addActionListener(gui);
		panelButton.add(start);
		panelButton.add(cancel);
		
		dialog.add(panelName1);
		dialog.add(panelName2);
		dialog.add(panelButton);
		add(dialog);
		
		pack();
		setVisible(true);
		setAlwaysOnTop(true); 
		setModal(true);
		
		dd = this;
	}


	public String getNameJ1() {
		return nameJ1.getText();
	}


	public String getNameJ2() {
		return nameJ2.getText();
	}
	
	public boolean isName() {
		return ! (nameJ1.getText().equals("") || nameJ2.getText().equals(""));
	}
	
	
	

	 
	public void startShake() {
	    final long startTime;
	    
	    naturalLocation = dd.getLocation();
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

	  public void stopShake() {
	    shakeTimer.stop();
	    dd.setLocation(naturalLocation);
	    dd.repaint();
	  }
}
