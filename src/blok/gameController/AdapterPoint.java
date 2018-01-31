package blok.gameController;

public class AdapterPoint {
	private float x;
	private float y;
	private boolean player = false;

	public AdapterPoint(float x,float y) {
		this.setX(x);
		this.setY(y);
		this.setPlayer(false);
	}
	
	public AdapterPoint(float x,float y,boolean isPlayer) {
		this.setX(x);
		this.setY(y);
		this.setPlayer(isPlayer);
	}
	
	public boolean isPlayer() {
		return player;
	}

	public void setPlayer(boolean isPlayer) {
		this.player = isPlayer;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public String toString() {
		return this.getX()+" "+this.getY();
	}

}
