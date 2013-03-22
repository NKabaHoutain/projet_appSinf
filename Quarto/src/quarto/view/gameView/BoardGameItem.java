package quarto.view.gameView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.PopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;

import quarto.constante.Constante;
import quarto.controller.Controller;
import quarto.model.Board;
import quarto.model.Case;
import quarto.model.Pion;
import quarto.view.GUI;

public class BoardGameItem extends JPanel implements Observer{


	private List<CaseItem> cases = new ArrayList<CaseItem>();
	private List<PionItem> pions= new ArrayList<PionItem>();
	
	private PositionPionItem list;
	private BoardItem grille;
	/**
	 * Construction du plateau de jeu.
	 * Pour chaque case et pour chaque pièce, on crée un objet bouton correspondant;
	 * on garde cette correspondance dans les maps bc et bp
	 * @param jeu l'objet qui gère la partie
	 */
	public BoardGameItem(Board board, Controller controller) {
		super();
		
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				CaseItem b = new CaseItem(board.getCase(i,j));
				board.getCase(i,j).addObserver(b);
				b.addActionListener(controller);
				cases.add(b);
				b.setPreferredSize(new Dimension(120, 120));
				board.getCase(i, j).addObserver(b);
			}	
		}
		
		for(Pion p: board.getAvailablePions()) {
			PionItem b=new PionItem(p);
			p.addObserver(b);
			b.addActionListener(controller);
			b.addMouseListener(controller);
			pions.add(b);
			b.setPreferredSize(new Dimension(60, 60));
		}
		
		setLayout(new BorderLayout());
		
		grille=new BoardItem();
		
		for(CaseItem b : cases)
			grille.add(b);
		add(grille,BorderLayout.CENTER);
		
		list=new PositionPionItem();
		for(PionItem b : pions)
			list.add(b);
		
		add(list,BorderLayout.SOUTH);
		
		
		enableCase(false);
		
		this.setVisible(true);
		
		
		
	}
	
	
	
	private void enableCase(boolean b) {
		for(CaseItem c : cases) {
			c.setEnabled(b && ! c.isPion());
		}
	}
	
	private void enablePion(boolean b) {
		for(PionItem p : pions) {
			p.setEnabled(b && p.getPion().isAvailable());
		}
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {	
		if (arg1 instanceof Boolean) {
			enableCase(!((Boolean)arg1));
			enablePion(((Boolean)arg1));
		}
	}
}
