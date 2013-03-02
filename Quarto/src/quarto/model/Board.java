package quarto.model;

import java.util.ArrayList;
import java.util.List;


public class Board {
	
	private List<Pion> pions;
	private Pion[][] board;
	
	
	public Board()
	{
		createPions();
		board = new Pion [4][4];
	}


	private void createPions()
	{
		pions =  new ArrayList<Pion>();
		
		for (int i=0; i<2; i++)
		{
			for (int j=0; j<2; j++)
			{
				for (int k=0; k<2; k++)
				{
					for(int l=0; l<2; l++)
					{
						pions.add(new Pion(i<1, j<1, k<1, l<1));
					}
				}
			}
		}
	}
}
