package blok;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import blok.interfaces.abstractFactory.IThemeFactory;
import blok.interfaces.IPluginController;
import blok.interfaces.ISimulator;

public class PluginController implements IPluginController {
	private static IPluginController pluginController = null;
	private String[] pluginsThemes;
	private String[] pluginsSimulators;
	private URLClassLoader ulcThemes;
	private URLClassLoader ulcSimulators;

	private PluginController() {
	}

	public static IPluginController getInstance() {
		if (pluginController == null)
			pluginController = new PluginController();
		return pluginController;
	}

	public void initialize() {
		loadThemesPlugins();
		loadSimulatorsPlugins();
	}

	@SuppressWarnings("deprecation")
	private void loadThemesPlugins() {
		try {
			File currentDir = new File("./plugins/themes");
			this.pluginsThemes = currentDir.list();
			URL[] jars = new URL[pluginsThemes.length];
			for (int i = 0; i < pluginsThemes.length; i++) {
				jars[i] = (new File("./plugins/themes/" + this.pluginsThemes[i])).toURL();
			}
			ulcThemes = new URLClassLoader(jars);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public IThemeFactory getFactory(String nome) {
		try {
			for (int i = 0; i < this.pluginsThemes.length; i++)
				if (pluginsThemes[i].split("\\.")[0].equalsIgnoreCase(nome)) {
					String nameClass = pluginsThemes[i].split("\\.")[0];
					return (IThemeFactory) Class
							.forName("blok." + nameClass.toLowerCase() + "." + nameClass, true, ulcThemes)
							.newInstance();
				}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public IThemeFactory getFactory() {
		return getFactory(this.pluginsThemes[1].split("\\.")[0]);
	}

	public String[] getFactoriesNames() {
		return pluginsThemes;
	}

	@SuppressWarnings("deprecation")
	private void loadSimulatorsPlugins() {
		try {
			File currentDir = new File("./plugins/simulators");
			this.pluginsSimulators = currentDir.list();
			URL[] jars = new URL[this.pluginsSimulators.length];
			for (int i = 0; i < this.pluginsSimulators.length; i++)
				jars[i] = (new File("./plugins/simulators/" + this.pluginsSimulators[i])).toURL();
			this.ulcSimulators = new URLClassLoader(jars);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ISimulator getSimulator(String nome) {
		try {
			for(int i = 0;i < this.pluginsSimulators.length;i++ )
				if(this.pluginsSimulators[i].split("\\.")[0].equalsIgnoreCase(nome)){
					String nameClass = this.pluginsSimulators[i].split("\\.")[0];
					return (ISimulator) Class.forName(nameClass.toLowerCase()+"."+nameClass,true,this.ulcSimulators).newInstance();
				}
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public ISimulator getSimulator() {
		return getSimulator(this.pluginsSimulators[0].split("\\.")[0]);
	}
	
	public String[] getSimulatorsNames() {
		return this.pluginsSimulators;
	}

}
