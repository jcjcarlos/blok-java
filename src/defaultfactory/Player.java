package blok.defaultfactory;

import java.util.Random;

import blok.AbstractFactory.IPlayer;

public class Player implements IPlayer {

	@Override
	public String getPlayer() {
		return "images/player" + Math.abs((new Random()).nextInt()%9) + ".png";
	}

}
