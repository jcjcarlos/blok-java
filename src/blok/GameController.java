package blok;

import blok.gui.MainPanel;
import blok.interfaces.IGameController;
import blok.simulator.Simulator;

public class GameController implements IGameController{
	private static IGameController gameController = null;
	private Simulator simulator = null;
	
	private GameController() {	
	}
	
	public static IGameController getInstance() {
		if(gameController == null)
			gameController = new GameController();
		return gameController;
	}
	
	public void initialize() {
		if(simulator == null)
			simulator = Simulator.getInstance();
	}
	
	public void run() {
		if(simulator != null)
			simulator.setMainPanel(Core.getInstance().getUIController().getMainPanel());
			simulator.init();
	}
	
	public Simulator getSimulator() {
		return this.simulator;
	}
}
