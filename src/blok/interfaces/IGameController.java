package blok.interfaces;

import blok.adapter.ISimulator;
import blok.simulator.Box2dSimulator;

public interface IGameController {
	public void initialize();
	public void run();
	public ISimulator getSimulator();
}
