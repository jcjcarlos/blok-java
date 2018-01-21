package blok.salvadorfactory;

import java.io.File;

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
			file =  new File("images/salvadorplayer.png");
		return file;
	}
}
