import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManagerPong {

	// variables
	ArrayList<PongBalls> pongballs;
	int scoreLeft = 0;
	int scoreRight = 0;
	Paddle p1;
	Paddle p2;
	Random random = new Random();
	// 15 is max, 10 is min
	int rand1 = random.nextInt(900 - 100 + 1) + 100;
	int rand2 = random.nextInt(15 - 10 + 1) + 10;

	public ObjectManagerPong(Paddle p1, Paddle p2) {
		this.p1 = p1;
		this.p2 = p2;
		pongballs = new ArrayList<PongBalls>();
	}

	void addPongBalls(PongBalls pongballs) {
		pongballs.add(new PongBalls(rand1,rand2,50,50));
	}

	// update pong balls
	void update() {
		for (int i = pongballs.size(); i >= 0; i--) {
			pongballs.get(i).update();
		}
	}

	// draw pong balls
	void draw(Graphics g) {
		for (int i = pongballs.size(); i >= 0; i--) {
			p1.draw(g);
			p2.draw(g);
			pongballs.get(i).draw(g);
		}
	}

	// clean up the screen
	void purge() {
		for (int i = pongballs.size(); i >= 0; i--) {
			if (!pongballs.get(i).isActive) {
				pongballs.remove(i);
			}
		}
	}

	int getscore() {
		return scoreLeft;
	}

	// check collision
	void checkcollision() {

	}

}
