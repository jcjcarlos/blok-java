package blok.interfaces;

import blok.simulator.Simulator;

public interface IGameController {
	public void initialize();
	public void run();
	public Simulator getSimulator();
}
