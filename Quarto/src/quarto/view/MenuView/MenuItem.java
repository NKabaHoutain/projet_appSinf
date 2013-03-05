package quarto.view.MenuView;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MenuItem  {
	JFrame frame;
	JPanel panelButton;
	JPanel panelLogo;
	JLabel title;
	JButton start;
	JButton rules;
	JButton options;
	JButton details;
	Image logo;
	
	Dimension preferredSize = new Dimension(300,50);
	Dimension minSize = new Dimension(200,50);
	Dimension maxSize = new Dimension(300,50);
	Dimension space = new Dimension(0,5);
	
	public MenuItem() throws IOException {
		frame = new JFrame("Quarto");
		panelLogo = new JPanel();
		panelButton = new JPanel();
		logo = ImageIO.read(new File("C:\\Users\\Nicolas\\Pictures\\divers\\logo_quarto.jpg"));
		title = new JLabel( new ImageIcon (logo));
		start = new JButton("Démarrer une partie");
		rules = new JButton("Règles");
		options = new JButton("Options");
		details = new JButton("Détails");
		
		
		frame.setPreferredSize(new Dimension(600,600));
		frame.setLayout(new GridLayout(2,1));
		
		panelLogo.setLayout(new BoxLayout(panelLogo,BoxLayout.Y_AXIS));
		panelLogo.setPreferredSize(new Dimension(50,200));

		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(Component.CENTER_ALIGNMENT);
		title.setVisible(true);
		panelLogo.add(Box.createVerticalStrut(40));
		panelLogo.add(title);
		panelLogo.add(Box.createHorizontalGlue());
		
		panelButton.setPreferredSize(new Dimension(500,100));

		adjustSize(start,minSize,maxSize,preferredSize);
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentY(Component.CENTER_ALIGNMENT);
		start.setPreferredSize(preferredSize);
		panelButton.add(start);
		panelButton.add(Box.createRigidArea(space));
		
		adjustSize(rules,minSize,maxSize,preferredSize);
		rules.setAlignmentX(Component.CENTER_ALIGNMENT);
		rules.setAlignmentY(Component.CENTER_ALIGNMENT);
		rules.setPreferredSize(preferredSize);
		panelButton.add(rules);
		panelButton.add(Box.createRigidArea(space));
		
		adjustSize(options,minSize,maxSize,preferredSize);
		options.setAlignmentX(Component.CENTER_ALIGNMENT);
		options.setAlignmentY(Component.CENTER_ALIGNMENT);
		options.setPreferredSize(preferredSize);
		panelButton.add(options);
		panelButton.add(Box.createRigidArea(space));
		
		adjustSize(details,minSize,maxSize,preferredSize);
		details.setAlignmentX(Component.CENTER_ALIGNMENT);
		details.setAlignmentY(Component.CENTER_ALIGNMENT);
		details.setPreferredSize(preferredSize);
		panelButton.add(details);
		panelButton.add(Box.createGlue());
		
		frame.getContentPane().add(panelLogo,Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(panelButton,Component.CENTER_ALIGNMENT);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void adjustSize(Component c, Dimension min, Dimension max, Dimension pref) {
		c.setMinimumSize(min);
		c.setMaximumSize(max);
		c.setPreferredSize(pref);
	}

}
