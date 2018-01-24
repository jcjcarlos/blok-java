package blok;

import blok.adapter.ISimulator;
import blok.gui.MainPanel;
import blok.interfaces.IGameController;
import blok.simulator.AdapterSimulator;

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
		if (simulator == null)
			simulator = AdapterSimulator.getInstance();
	}

	public void run() {
		if (simulator != null)
			simulator.setMainPanel(Core.getInstance().getUIController().getMainPanel());
		simulator.init();
	}

	public ISimulator getSimulator() {
		return this.simulator;
	}
}
