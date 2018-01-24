package blok.adapter;

import blok.gui.MainPanel;

public interface ISimulator {
	public void run();

	public void start();

	public void init();

	public void stop();
	
	public void setMainPanel(MainPanel mainPanel);

	public void removeBody(AdapterPoint p);
}
