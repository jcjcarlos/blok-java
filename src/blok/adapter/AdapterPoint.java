package blok.adapter;

public class AdapterPoint {
	private float x;
	private float y;
	private boolean player = false;

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

}
