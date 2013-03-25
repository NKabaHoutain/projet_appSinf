package quarto.view.menuView;

import java.awt.FlowLayout;

import javax.swing.*;

import quarto.view.GUI;
import quarto.view.constante.ViewConstante;

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
		
	}


	public JTextField getNameJ1() {
		return nameJ1;
	}


	public JTextField getNameJ2() {
		return nameJ2;
	}
}
