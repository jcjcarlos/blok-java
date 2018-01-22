package blok.adapter;

import java.util.ArrayList;

import org.jbox2d.dynamics.Body;

import blok.simulator.Simulator;

import blok.gui.MainPanel.State;

public class MainPanelAdapter implements IMainPanel {

	@Override
	public void bodiesCreated(ArrayList<Body> bodies) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bodiesUpdate(ArrayList<Body> bodies) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setState(State state) {
		// TODO Auto-generated method stub

	}

	private Simulator simulator = Simulator.getInstance();

}
