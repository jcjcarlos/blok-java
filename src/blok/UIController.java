package blok;

import blok.gui.MainPanel;
import blok.gui.MainWindow;
import blok.interfaces.IUIController;
import blok.interfaces.abstractFactory.IThemeFactory;
import blok.simulator.Simulator;

public class UIController implements IUIController {
	private static IUIController uIController = null;
	private MainWindow mainWindow = null;
	private MainPanel mainPanel = null;
	
	private UIController() {	
	}
	
	public static IUIController getInstance() {
		if(uIController == null)
			uIController = new UIController();
		return uIController;
	}
	
	
	public void initialize() {
		if(mainPanel == null) {
			mainPanel = MainPanel.getInstance(Core.getInstance().getPluginController().getClassFactory());
			//mainPanel.setSimulator(Core.getInstance().getGameController().getSimulator());
		}
		if(mainWindow == null) {
			mainWindow = MainWindow.getInstance(mainPanel);
			mainWindow.setVisible(true);
		}
	}
	
	public void run() {
		if(mainPanel != null)
			mainPanel.setSimulator(Core.getInstance().getGameController().getSimulator());
	}

	public MainPanel getMainPanel(){
		return mainPanel;
	}
}
