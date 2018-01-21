package blok;

import blok.interfaces.IGameController;

public class GameController implements IGameController{
	private static IGameController gameController = null;
	
	private GameController() {	
	}
	
	public static IGameController getInstance() {
		if(gameController == null)
			gameController = new GameController();
		return gameController;
	}
	public void initialize() {
		
	}
}
