import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends GameObjectPong {

	boolean up;
	boolean down;

	Paddle(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	// update paddles
	public void update() {
		if (up && y >= 0) {
			up();
		} else if (down && y <= 350) {
			down();
		}
	}

	// draw paddles
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

	public void up() {
		y -= speed;
	}

	public void down() {
		y += speed;
	}
}
