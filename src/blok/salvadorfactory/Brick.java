package blok.salvadorfactory;

import java.io.File;

import blok.interfaces.abstractFactory.IBrick;

public class Brick implements IBrick {
	private static IBrick brick = null;
	private static File file = null;
	
	private Brick(){
	}
	
	public static IBrick getInstance() {
		if(brick == null)
			brick = new Brick();
		return brick;
	}
	
	@Override
	public File getBrick() {
		if(file == null)
			file = new File("images/salvadorbrick.png");
		return file;
	}

}
