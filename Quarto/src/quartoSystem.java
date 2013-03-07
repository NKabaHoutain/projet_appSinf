
import java.io.IOException;


import quarto.controller.Controller;
import quarto.view.MenuView.MenuItem;
import quarto.view.MenuView.GameModeView;
import quarto.model.Game;
import quarto.model.Player;
import quarto.view.MenuView.GameTypeView;



public class quartoSystem {

	public static void main(String[] args) throws IOException
	{
		Controller controller = new Controller();
		//Controller controller = new Controller();
		//MenuItem menu = new MenuItem();
		//GameModeView game = new GameModeView();
		GameTypeView game = new GameTypeView();
		controller.startGame();
		
	}
}
