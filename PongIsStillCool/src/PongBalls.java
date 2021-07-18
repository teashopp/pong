import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class PongBalls extends GameObjectPong {
	
	Rectangle collisionBox;
	Random randd1 = new Random();
	int rand1 = randd1.nextInt(1000 - 0);
	Random randd2 = new Random();
	int rand2 = randd2.nextInt(500 - 0);

	PongBalls(int x, int y, int width, int height) {
		super(x, y, width, height);
		collisionBox = new Rectangle(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}

	// create the ball
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, rand1, rand2);
	}

	public void add(PongBalls pongBalls) {
		// TODO Auto-generated method stub
		
	}
	
	public PongBalls getPongBalls() {
		return new PongBalls(500,250,width,height);
	}
	
	public void update() {
		super.update();
	}
}
