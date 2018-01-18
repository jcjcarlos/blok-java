package blok.defaultfactory;

import blok.AbstractFactory.IGround;

public class Ground implements IGround {

	@Override
	public String getGround() {
		return "images/ground.png";
	}

}
