package blok.interfaces;

import blok.simulator.AdapterSimulator;

public interface IGameController {
	public void initialize();
	public void run();
	public AdapterSimulator getSimulator();
}
