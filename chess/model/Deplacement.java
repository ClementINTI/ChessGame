package chess.model;

public class Deplacement {
	private int lastX;
	private int lastY;
	private int newX;
	private int newY;

	public Deplacement(int lastX, int lastY, int newX, int newY) {
		super();
		this.lastX = lastX;
		this.lastY = lastY;
		this.newX = newX;
		this.newY = newY;
	}

	public int getLastX() {
		return lastX;
	}

	public int getLastY() {
		return lastY;
	}

	public int getNewX() {
		return newX;
	}

	public int getNewY() {
		return newY;
	}

}
