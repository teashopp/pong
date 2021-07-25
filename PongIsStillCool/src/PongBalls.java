import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class PongBalls extends GameObjectPong {

	Rectangle collisionBox;
	Random randd1 = new Random();
	int rand1 = randd1.nextInt(800 - 200) + 200;
	Random randd2 = new Random();
	int rand2 = randd2.nextInt(500 - 0);

	PongBalls(int x, int y, int width, int height) {
		super(x, y, width, height);
		collisionBox = new Rectangle(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}

	public void moveright() {
		x += speed;
	}

	public void moveleft() {
		x -= speed;
	}

	public void upright() {
		x += speed;
		y -= speed;
	}

	public void downright() {
		x += speed;
		y += speed;
	}

	public void upleft() {
		x -= speed;
		y -= speed;
	}

	public void downleft() {
		x -= speed;
		y += speed;
	}

	// create the ball
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(rand1, rand2, 30, 30);
		x -= speed;
	}

	public void add(PongBalls pongBalls) {
		// TODO Auto-generated method stub

	}

	public PongBalls getPongBalls() {
		return new PongBalls(500, 250, width, height);
	}

	public void update() {
		super.update();
	}
}
