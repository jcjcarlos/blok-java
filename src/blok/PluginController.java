package blok;

import blok.interfaces.IPluginController;

public class PluginController implements IPluginController{
	private static IPluginController pluginController = null;
	
	private PluginController() {	
	}
	
	public static IPluginController getInstance() {
		if(pluginController == null)
			pluginController = new PluginController();
		return pluginController;
	}
	
	public void initialize() {
		
	}
}
