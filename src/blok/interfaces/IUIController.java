package blok.interfaces;

import blok.gui.MainPanel;
import blok.simulator.AdapterSimulator;

public interface IUIController {
	public void initialize();
	public void run();
	public MainPanel getMainPanel();
}
