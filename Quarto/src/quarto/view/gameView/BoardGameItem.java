package quarto.view.gameView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Observer;

import javax.swing.*;

import quarto.model.Board;
import quarto.model.Pion;
public class BoardGameItem extends JPanel {

	/**
	 * A chaque case du jeu est attachée un bouton graphique CaseItem
	 */
	private final CaseItem[][] bc = new CaseItem [4][4];
	/**
	 * A chaque pièce disponible du jeu est attachée un bouton PionItem
	 */
	private final LinkedHashMap<Pion, PionItem> bp= new LinkedHashMap<Pion, PionItem>();
	/**
	 * Composant graphique pour afficher des messages aux utilisateurs
	 */
	private final JLabel message = new JLabel();
	/**
	 * Construction du plateau de jeu.
	 * Pour chaque case et pour chaque pièce, on crée un objet bouton correspondant;
	 * on garde cette correspondance dans les maps bc et bp
	 * @param jeu l'objet qui gère la partie
	 */
	public BoardGameItem(Board board) {
		super();
		
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++) {
				CaseItem b=new CaseItem(board.getCase(i,j));
				bc[i][j] = b;
				b.setPreferredSize(new Dimension(120, 120));
			}
		for(Pion p: board.getAvailablePions()) {
			PionItem b=new PionItem(p);
			bp.put(p, b);
			b.setPreferredSize(new Dimension(60, 60));
		}
	}
	
	/**
	 * Provoque l'affichage du plateau de jeu.
	 * Une frame est crée dans laquelle le plateau est affiché.
	 * La mise en page place les boutons correspondant au plateau en grille
	 */
	public void start() {
		JFrame frame=new JFrame();
		setLayout(new BorderLayout());
		JPanel grille=new JPanel();
		grille.setLayout(new GridLayout(4,4));
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++){
				grille.add(bc[i][j]);
			}
		}
		add(grille,BorderLayout.CENTER);
		JPanel liste=new JPanel();
		liste.setLayout(new GridLayout(2,8));
		add(liste,BorderLayout.SOUTH);
		for(PionItem b : bp.values())
			liste.add(b);
		add(message,BorderLayout.NORTH);
		frame.setContentPane(this);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
