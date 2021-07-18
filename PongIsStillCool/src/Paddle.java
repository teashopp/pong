import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle extends GameObjectPong {

	boolean up;
	boolean down;
	Rectangle collisionBox0;
	Rectangle collisionBox1;
	Rectangle collisionBox2;
	
	Paddle(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		collisionBox0 = new Rectangle(x, y * 1/3, width, height * 1/3);
		collisionBox1 = new Rectangle(x, y * 2/3, width, height * 1/3);
		collisionBox2 = new Rectangle(x, y, width, height * 1/3);
	}

	// update paddles
	public void update() {
		if (up && y >= 0) {
			up();
		} else if (down && y <= 350) {
			down();
		}
		super.update();
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
