package blok.interfaces;

import blok.interfaces.abstractFactory.IThemeFactory;

public interface IPluginController {
	public void initialize();
	public IThemeFactory getClassFactory(String nome);
	public IThemeFactory getClassFactory();
	public String[] getClassName();
}
