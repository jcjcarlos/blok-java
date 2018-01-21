package blok.interfaces;

public interface ICore {
	public void initialize();
	public void run();
	public IGameController getGameController();
	public IPluginController getPluginController();
	public IUIController getUIController();
}
