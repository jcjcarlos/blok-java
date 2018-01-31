package blok.interfaces;

import blok.gameController.Box2dSimulator;

public interface IGameController {
	public void initialize();
	public void run();
	public ISimulator getSimulator();
}
