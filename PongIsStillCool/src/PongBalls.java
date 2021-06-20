import java.awt.Color;
import java.awt.Graphics;

public class PongBalls extends GameObjectPong {

	PongBalls(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	// create the ball
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
	}

	public void add(PongBalls pongBalls) {
		// TODO Auto-generated method stub
		
	}

}
