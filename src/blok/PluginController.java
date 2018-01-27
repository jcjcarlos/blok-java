package blok;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import blok.interfaces.abstractFactory.IThemeFactory;
import blok.interfaces.IPluginController;

public class PluginController implements IPluginController {
	private static IPluginController pluginController = null;
	private String[] pluginsThemes;
	private String[] pluginsSimulators;
	private String nameClasse = null;
	private URLClassLoader ulc;
	private IThemeFactory factory = null;

	private PluginController() {
	}

	public static IPluginController getInstance() {
		if (pluginController == null)
			pluginController = new PluginController();
		return pluginController;
	}

	public void initialize() {
		loadThemePlugins();
	}

	@SuppressWarnings("deprecation")
	private void loadThemePlugins() {
		try {
			File currentDir = new File("./plugins/themes");
			this.pluginsThemes = currentDir.list();
			URL[] jars = new URL[pluginsThemes.length];
			for (int i = 0; i < pluginsThemes.length; i++) {
				System.out.println(this.pluginsThemes[i]);
				jars[i] = (new File("./plugins/themes/" + this.pluginsThemes[i])).toURL();
			}
			ulc = new URLClassLoader(jars);
			setFactory();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void setFactory() {
		try {
			if (this.nameClasse == null) {
				this.nameClasse = pluginsThemes[1].split("\\.")[0];
				System.out.println(nameClasse);
			}
			this.factory = (IThemeFactory) Class
					.forName("blok." + this.nameClasse.toLowerCase() + "." + this.nameClasse, true, ulc).newInstance();
		} catch (Exception e) {
			System.out.println("Não encontrou plugins");
			System.out.println(e);
		}
	}
	
	private void loadSimulatorPlugins() {
		File currentDir = new File("./plugins/simulator");
		this.pluginsSimulators = currentDir.list();
		URL[] jars = new URL[this.pluginsSimulators.length];
		//for(int i = 0;i < this.pluginsSimulators.length;i++)
			//jars[i] = (new File("./plugins/simulators"))
		
	}

	public IThemeFactory getClassFactory(String nome) {
		for (int i = 0; i < this.pluginsThemes.length; i++)
			if (pluginsThemes[i].split("\\.")[0].equalsIgnoreCase(nome))
				this.nameClasse = pluginsThemes[i].split("\\.")[0];
		setFactory();
		return this.factory;
	}

	public IThemeFactory getClassFactory() {
		setFactory();
		return this.factory;
	}

	public String[] getClassName() {
		return pluginsThemes;
	}
}
