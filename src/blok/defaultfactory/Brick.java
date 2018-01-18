package blok.defaultfactory;

import blok.AbstractFactory.IBrick;

public class Brick implements IBrick {

	@Override
	public String getBrick() {
		return "images/brick.png";
	}

}
