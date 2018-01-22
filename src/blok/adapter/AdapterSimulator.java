package blok.adapter;

import blok.simulator.Simulator;
import sun.misc.GC;

public class AdapterSimulator implements ISimulator {

	private Simulator simulator;

	public AdapterSimulator() {
		this.simulator = Simulator.getInstance();
	}

	@Override
	public void run() {
		simulator.run();

	}

	@Override
	public void start() {
		simulator.start();

	}

	@Override
	public void init() {
		simulator.init();

	}

	@Override
	public void stop() {
		simulator.stop();

	}

	@Override
	public void removeBody(AdapterPoint p) {

	}

}
