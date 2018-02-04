package blok;

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
		// simulator = Box2DSimulator.getInstance();
		simulator = Core.getInstance().getPluginController().getSimulator();
	}

	public void run() {
		simulator.setMainPanel(Core.getInstance().getUIController().getMainPanel());
		simulator.init();
	}

	public void setSimulator(String name) {
		ISimulator temp = Core.getInstance().getPluginController().getSimulator(name);
		if (temp != null && temp instanceof ISimulator)
			simulator = temp;
	}

	public ISimulator getSimulator() {
		return simulator;
	}

}
