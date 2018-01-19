/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blok.gui;

import blok.AbstractFactory.IThemeFactory;
import blok.simulator.Simulator;
import java.awt.Dimension;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author sandroandrade
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        loadPlugins();
        Dimension size = new Dimension(1000, 600);

        MainPanel mainPanel = new MainPanel(factory);
        mainPanel.setPreferredSize(size);
        mainPanel.setMinimumSize(size);
        mainPanel.setMaximumSize(size);
        mainPanel.setSize(size);
        setContentPane(mainPanel);

        setResizable(false);
        pack();
        
        Simulator simulator = new Simulator(mainPanel);
        mainPanel.setSimulator(simulator);
        simulator.init();
        //simulator.start();
    }
    
 
	@SuppressWarnings("deprecation")
	private void loadPlugins() {
    	System.out.println("Chamou o metodo");
    	try {
    		System.out.println("Entrou no try");
    		File currentDir = new File("./plugins");
    		String[] plugins = currentDir.list();
    		URL[] jars = new URL[plugins.length];
    		javax.swing.JMenu[] menus = new javax.swing.JMenu[plugins.length];
    		for(int i = 0; i < plugins.length; i++) {
    			String classe = plugins[i].split("\\.")[0];
    			System.out.println(i+1 + " - " + classe);
    			menus[i] = new javax.swing.JMenu();
    			menus[i].setText(classe);
    			this.jMenuBar1.add(menus[i]);
    			jars[i] = (new File("./plugins/"+ plugins[i])).toURL();
    		}
    		URLClassLoader ulc = new URLClassLoader(jars);
    		String nomeClasse = plugins[1].split("\\.")[0];
    		IThemeFactory factory = (IThemeFactory)Class.forName("blok."+nomeClasse.toLowerCase()
    				+"."+nomeClasse,true,ulc).newInstance();
    		this.factory = factory;
    		
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private IThemeFactory factory;
    // End of variables declaration//GEN-END:variables
}
