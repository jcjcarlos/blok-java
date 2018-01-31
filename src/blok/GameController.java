package blok;

import blok.gameController.Box2dSimulator;
import blok.interfaces.IGameController;
import blok.interfaces.ISimulator;

public class GameController implements IGameController {
	private static IGameController gameController = null;
	private ISimulator simulator = null;

	private GameController() {
	}

	public static IGameController getInstance() {
		if (gameController == null)
			gameController = new GameController();
		return gameController;
	}

	public void initialize() {
		simulator = Box2dSimulator.getInstance();
	}

	public void run() {
		simulator.setMainPanel(Core.getInstance().getUIController().getMainPanel());
		simulator.init();
	}

	public ISimulator getSimulator() {
		return this.simulator;
	}

}
