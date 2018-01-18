package blok.salvadorfactory;

import blok.AbstractFactory.IBrick;

public class Brick implements IBrick {

	@Override
	public String getBrick() {
		return "images/salvadorbrick.png";
	}

}
