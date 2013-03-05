package quarto.view.gameView;
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
	Dimension preferredSize = new Dimension(200,50);
	
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
		
		panelLogo.setPreferredSize(new Dimension(200,200));
		panelLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelLogo.setAlignmentY(Component.TOP_ALIGNMENT);
		
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(Component.TOP_ALIGNMENT);
		panelLogo.add(title);
		
		panelButton.setPreferredSize(new Dimension(200,200));
		panelButton.setLayout(new BoxLayout(panelButton,BoxLayout.Y_AXIS));
		panelButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentY(Component.CENTER_ALIGNMENT);
		start.setPreferredSize(preferredSize);
		panelButton.add(start);
		
		rules.setAlignmentX(Component.CENTER_ALIGNMENT);
		rules.setAlignmentY(Component.CENTER_ALIGNMENT);
		rules.setPreferredSize(preferredSize);
		panelButton.add(rules);
		
		options.setAlignmentX(Component.CENTER_ALIGNMENT);
		options.setAlignmentY(Component.CENTER_ALIGNMENT);
		options.setPreferredSize(preferredSize);
		panelButton.add(options);
		
		details.setAlignmentX(Component.CENTER_ALIGNMENT);
		details.setAlignmentY(Component.CENTER_ALIGNMENT);
		details.setPreferredSize(preferredSize);
		panelButton.add(details);
		
		frame.getContentPane().add(panelButton);
		frame.getContentPane().add(panelButton);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
