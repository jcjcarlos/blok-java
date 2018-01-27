package blok.themes.defaultfactory;

import java.io.File;

import blok.interfaces.abstractFactory.ISound;

public class Sound implements ISound{
	private static ISound sound = null;
	private static File file = null;
	
	private Sound() {
	}
	
	public static ISound getInstance() {
		if(sound == null)
			sound = new Sound();
		return sound;
	}
	
	@Override
	public File getSound() {
		if(file == null)
			file = new File("sounds/background.wav");
		return file;
	}

}
