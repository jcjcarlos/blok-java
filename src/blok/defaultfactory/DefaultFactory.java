package blok.defaultfactory;
import blok.AbstractFactory.IBackGround;
import blok.AbstractFactory.IBrick;
import blok.AbstractFactory.IGround;
import blok.AbstractFactory.IPlayer;
import blok.AbstractFactory.ISound;
import blok.AbstractFactory.IThemeFactory;

public class DefaultFactory implements IThemeFactory {

	@Override
	public IBackGround createBackGround() {
		return new BackGround();
	}

	@Override
	public IGround createGround() {
		// TODO Auto-generated method stub
		return new Ground();
	}

	@Override
	public IBrick createBrick() {
		// TODO Auto-generated method stub
		return new Brick();
	}

	@Override
	public ISound createSound() {
		// TODO Auto-generated method stub
		return new Sound();
	}

	@Override
	public IPlayer createPlayer() {
		// TODO Auto-generated method stub
		return new Player();
	}

}
