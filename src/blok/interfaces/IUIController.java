package blok.interfaces;

import blok.gameController.Box2dSimulator;
import blok.gui.MainPanel;

public interface IUIController {
	public void initialize();
	public void run();
	public MainPanel getMainPanel();
}
