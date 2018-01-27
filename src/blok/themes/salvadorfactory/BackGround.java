package blok.themes.salvadorfactory;

import java.awt.Image;

import javax.swing.ImageIcon;

import blok.interfaces.abstractFactory.IBackGround;

public class BackGround implements IBackGround {
	private static IBackGround background = null;
	private static Image image = null;
	
	private BackGround(){
	}
	
	public static IBackGround getInstance() {
		if(background == null)
			background = new BackGround();
		return background;
	}
	@Override
	public Image getBackGround() {
		if(image == null)
			image = new ImageIcon("images/salvadorbackground.png").getImage();
		return image;
	}

}
