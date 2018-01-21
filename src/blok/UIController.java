package blok;

import blok.interfaces.IUIController;

public class UIController implements IUIController {
	private static IUIController uIController = null;
	
	private UIController() {	
	}
	
	public static IUIController getInstance() {
		if(uIController == null)
			uIController = new UIController();
		return uIController;
	}
	
	
	public void initialize() {
		
	}
}
