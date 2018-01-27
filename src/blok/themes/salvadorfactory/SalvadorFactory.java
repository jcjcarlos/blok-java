package blok.themes.salvadorfactory;
import blok.interfaces.abstractFactory.*;

public class SalvadorFactory implements IThemeFactory {

	@Override
	public IBackGround createBackGround() {
		return BackGround.getInstance();
	}

	@Override
	public IGround createGround() {
		// TODO Auto-generated method stub
		return Ground.getInstance();
	}

	@Override
	public IBrick createBrick() {
		// TODO Auto-generated method stub
		return Brick.getInstance();
	}

	@Override
	public ISound createSound() {
		// TODO Auto-generated method stub
		return Sound.getInstance();
	}

	@Override
	public IPlayer createPlayer() {
		// TODO Auto-generated method stub
		return Player.getInstance();
	}

}
