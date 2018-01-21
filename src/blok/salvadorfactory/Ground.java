package blok.salvadorfactory;

import java.awt.Image;

import javax.swing.ImageIcon;

import blok.interfaces.abstractFactory.IGround;

public class Ground implements IGround {
	private static IGround ground = null;
	private static Image imageicon = null;
	
	private Ground() {
	}
	
	public static IGround getInstance() {
		if(ground == null)
			ground = new Ground();
		return ground;
	}
	
	@Override
	public Image getGround() {
		if(imageicon == null)
			imageicon = new ImageIcon("images/salvadorground.png").getImage();
		return imageicon;
	}

}
