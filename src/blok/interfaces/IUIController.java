package blok.interfaces;

import blok.gui.MainPanel;
import blok.simulator.Box2dSimulator;

public interface IUIController {
	public void initialize();
	public void run();
	public MainPanel getMainPanel();
}
