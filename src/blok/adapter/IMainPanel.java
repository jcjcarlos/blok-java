package blok.adapter;

import java.util.ArrayList;

import org.jbox2d.dynamics.Body;

import blok.gui.MainPanel.State;

public interface IMainPanel {
	public void bodiesCreated(ArrayList<Body> bodies);

	public void bodiesUpdate(ArrayList<Body> bodies);

	public void setState(State state);
}
