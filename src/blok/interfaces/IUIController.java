package blok.interfaces;

import blok.gui.MainPanel;
import blok.simulator.Simulator;

public interface IUIController {
	public void initialize();
	public void run();
	public MainPanel getMainPanel();
}
