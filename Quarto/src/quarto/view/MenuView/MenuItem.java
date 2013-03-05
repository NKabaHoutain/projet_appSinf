package quarto.view.MenuView;
import javax.swing.*;
import java.awt.*;

public class MenuItem {
	JFrame frame;
	JPanel panelButton;
	JPanel panelLogo;
	JLabel title;
	JButton start;
	JButton rules;
	JButton options;
	JButton details;
	Dimension preferredSize = new Dimension(150,50);
	Dimension space = new Dimension(30,0);
	
	public MenuItem() {
		frame = new JFrame("Quarto");
		panelLogo = new JPanel();
		panelButton = new JPanel();
		title = new JLabel("Quarto");
		start = new JButton("Démarrer une partie");
		rules = new JButton("Règles");
		options = new JButton("Options");
		details = new JButton("Détails");
		
		frame.setPreferredSize(new Dimension(600,600));
		
		panelLogo.setPreferredSize(new Dimension(200,150));
		panelLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelLogo.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelLogo.add(title);
		
		panelButton.setPreferredSize(new Dimension(600,350));
		panelButton.setLayout(new BoxLayout(panelButton,BoxLayout.Y_AXIS));
		panelButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentY(Component.CENTER_ALIGNMENT);
		start.setPreferredSize(preferredSize);
		panelButton.add(start);
		panelButton.add(Box.createVerticalGlue());
		
		rules.setAlignmentX(Component.CENTER_ALIGNMENT);
		rules.setAlignmentY(Component.CENTER_ALIGNMENT);
		rules.setPreferredSize(preferredSize);
		panelButton.add(rules);
		panelButton.add(Box.createVerticalGlue());
		
		options.setAlignmentX(Component.CENTER_ALIGNMENT);
		options.setAlignmentY(Component.CENTER_ALIGNMENT);
		options.setPreferredSize(preferredSize);
		panelButton.add(options);
		panelButton.add(Box.createVerticalGlue());
		
		details.setAlignmentX(Component.CENTER_ALIGNMENT);
		details.setAlignmentY(Component.CENTER_ALIGNMENT);
		details.setPreferredSize(preferredSize);
		panelButton.add(details);
		
		frame.getContentPane().add(panelButton);
		frame.add(Box.createRigidArea(space));
		frame.getContentPane().add(panelButton);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
