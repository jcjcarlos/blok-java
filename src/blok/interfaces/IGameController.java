package blok.interfaces;

import blok.adapter.ISimulator;
import blok.simulator.AdapterSimulator;

public interface IGameController {
	public void initialize();
	public void run();
	public ISimulator getSimulator();
}
