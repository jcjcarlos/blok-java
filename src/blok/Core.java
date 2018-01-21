package blok;

import blok.interfaces.*;


public class Core implements ICore {
	private static ICore core = null;
	
	private Core() {	
	}
	
	public static ICore getInstance() {
		if(core == null)
			core = new Core();
		return core;
	}
	
	public void initialize() {
		this.pluginController = PluginController.getInstance();
		this.uiController = UIController.getInstance();
		this.gameController = GameController.getInstance();
		
		this.pluginController.initialize();
		this.uiController.initialize();
		this.gameController.initialize();
	}
	
	public void run() {
		this.uiController.run();
		this.gameController.run();
	}
	
	public IGameController getGameController() {
		return this.gameController;
	}
	
	public IPluginController getPluginController() {
		return this.pluginController;
	}
	
	public IUIController getUIController() {
		return this.uiController;
	}
	
	private IGameController gameController;
	private IPluginController pluginController;
	private IUIController uiController;
}
