package blok;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import blok.interfaces.abstractFactory.IThemeFactory;
import blok.interfaces.IPluginController;

public class PluginController implements IPluginController{
	private static IPluginController pluginController = null;
	private String[] plugins;
	private String nomeClasse = null;
	private URLClassLoader ulc;
	private IThemeFactory factory = null;
	private PluginController() {	
	}
	
	public static IPluginController getInstance() {
		if(pluginController == null)
			pluginController = new PluginController();
		return pluginController;
	}
	
	public void initialize() {
		loadPlugins();
	}
	
	@SuppressWarnings("deprecation")
	private void loadPlugins() {
        try {
            File currentDir = new File("./plugins");
            this.plugins = currentDir.list();
            URL[] jars = new URL[plugins.length];
            for(int i = 0; i < plugins.length; i++) {
            	jars[i] = (new File("./plugins/"+ this.plugins[i])).toURL();
            }
            ulc = new URLClassLoader(jars);
            setFactory();
        } catch(Exception e) {
           	System.out.println(e);
        }
	}
	
	private void setFactory() {
		try {
			if(this.nomeClasse == null) {
        		this.nomeClasse = plugins[1].split("\\.")[0];
        		System.out.println(nomeClasse);
        	}
         	this.factory = (IThemeFactory)Class.forName("blok."+this.nomeClasse.toLowerCase()+
          					"."+this.nomeClasse,true,ulc).newInstance();
        } catch(Exception e) {
        	System.out.println("Não encontrou plugins");
        	System.out.println(e);
        }
	}

	public IThemeFactory getClassFactory(String nome) {
		for(int i = 0; i < this.plugins.length; i++)
			if(plugins[i].split("\\.")[0].equalsIgnoreCase(nome))
				this.nomeClasse = plugins[i].split("\\.")[0];
		setFactory();
		return this.factory;
	}
	
	public IThemeFactory getClassFactory() {
		setFactory();
		return this.factory;
	}
	
	public String[] getClassName() {
		return plugins;
	}
}
