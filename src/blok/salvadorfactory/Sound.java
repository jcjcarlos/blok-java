package blok.salvadorfactory;

import blok.AbstractFactory.ISound;

public class Sound implements ISound{

	@Override
	public String getSound() {
		return "sounds/background.wav";
	}

}
