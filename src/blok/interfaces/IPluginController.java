package blok.interfaces;

import blok.interfaces.abstractFactory.IThemeFactory;

public interface IPluginController {
	public void initialize();
	public IThemeFactory getFactory(String name);
	public IThemeFactory getFactory();
	public ISimulator getSimulator();
	public ISimulator getSimulator(String name);
	public String[] getFactoriesNames();
	public String[] getSimulatorsNames();
}
