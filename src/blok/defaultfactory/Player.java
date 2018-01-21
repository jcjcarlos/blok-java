package blok.defaultfactory;

import java.io.File;
import java.util.Random;

import blok.interfaces.abstractFactory.IPlayer;

public class Player implements IPlayer {
	private static IPlayer player = null;
	private static File file = null;
	
	private Player() {
	}
	
	public static IPlayer getInstance() {
		if(player == null)
			player = new Player();
		return player;
	}
		
	@Override
	public File getPlayer() {
		if(file == null)
			file =  new File("images/player" + Math.abs((new Random()).nextInt()%9) + ".png");
		return file;
	}

}
