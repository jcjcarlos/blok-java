/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blok.gui;

import blok.Core;
import blok.interfaces.abstractFactory.IThemeFactory;
import blok.simulator.Simulator;
import java.awt.Dimension;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 *
 * @author sandroandrade
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    private MainWindow(MainPanel mainPanel) {
    	//loadPlugins();
    	this.plugins = Core.getInstance().getPluginController().getClassName();
    	initComponents();
        Dimension size = new Dimension(1000, 600);

        //mainPanel = MainPanel.getInstance(factory);
        mainPanel.setPreferredSize(size);
        mainPanel.setMinimumSize(size);
        mainPanel.setMaximumSize(size);
        mainPanel.setSize(size);
        setContentPane(mainPanel);

        setResizable(false);
        pack();
        
        //Simulator simulator = Simulator.getInstance();
        //mainPanel.setSimulator(simulator);
        //simulator.init();
        //simulator.start();
    }
    
    public static MainWindow getInstance(MainPanel mainPanel) {
    	if(mainWindow == null)
    		mainWindow = new MainWindow(mainPanel);
    	return mainWindow;
    }
    /*
	@SuppressWarnings("deprecation")
    private void loadPlugins() {
        try {
            File currentDir = new File("./plugins");
            this.plugins = currentDir.list();
            URL[] jars = new URL[plugins.length];
            for(int i = 0; i < plugins.length; i++) {
            	jars[i] = (new File("./plugins/"+ plugins[i])).toURL();
            }
            this.ulc = new URLClassLoader(jars);
            setFactory();
            } catch(Exception e) {
            	System.out.println(e);
            }
         }
	
	private void setFactory() {
          try {
        	if(this.nomeClasse == null)
        		this.nomeClasse = plugins[0].split("\\.")[0];
         	this.factory = (IThemeFactory)Class.forName("blok."+this.nomeClasse.toLowerCase()+
          					"."+this.nomeClasse,true,ulc).newInstance();
         	if(this.factory!=null)
         		this.mainPanel.setFactory(factory);
          } catch(Exception e) {
        	  System.out.println(e);
          }
          
	}
	*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
    	jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jMenu1.setText("Temas");
        jMenuBar1.add(jMenu1);
        jMenu2.setText("Opções");
        jMenuBar1.add(jMenu2);
        jMenuItem1.setText("Atualizar temas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener(){
        	@Override
          	public void actionPerformed(java.awt.event.ActionEvent evt){
               	jRefreshActionPerformed(evt);
            }
         });
        jMenu2.add(jMenuItem1);
        
        
        jMenuItems2 = new javax.swing.JMenuItem[this.plugins.length];
        for(int i=0;i<this.plugins.length;i++) {
        	jMenuItems2[i] = new javax.swing.JMenuItem();
        	jMenuItems2[i].setText(this.plugins[i].split("\\.")[0]);
        	jMenuItems2[i].addActionListener(new java.awt.event.ActionListener(){
            	@Override
              	public void actionPerformed(java.awt.event.ActionEvent evt){
                   	jMenusActionPerformed(evt);
                }
             });
        	jMenu1.add(jMenuItems2[i]);
        }
        setJMenuBar(jMenuBar1);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jMenusActionPerformed(java.awt.event.ActionEvent evt){
    	System.out.println("Botão clicado");
    	this.factory = Core.getInstance().getPluginController().getClassFactory(evt.getActionCommand());
    	Core.getInstance().getUIController().getMainPanel().setFactory(this.factory);
    	System.out.println(factory);
    	//setFactory();
    }
    
    private void jRefreshActionPerformed(java.awt.event.ActionEvent evt){
    	//loadPlugins();
    	Core.getInstance().getPluginController().initialize();
    	this.plugins = Core.getInstance().getPluginController().getClassName();
    	initComponents();      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem[] jMenuItems2;
    
    // End of variables declaration//GEN-END:variables
    private IThemeFactory factory = null;
    private URLClassLoader ulc;
    private MainPanel mainPanel;
    private static MainWindow mainWindow = null;
    String[] plugins;
    String nomeClasse;
}
