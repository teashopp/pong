import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManagerPong implements ActionListener {

	// variables
	ArrayList<PongBalls> pongballs;
	int score = 0;
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

	void addPongBalls(ArrayList<PongBalls> pongballs) {
		pongballs.add(new PongBalls(rand1, rand2, 50, 50));
	}

	// update pong balls
	void update() {
		for (int i = pongballs.size() - 1; i >= 0; i--) {
			pongballs.get(i).update();
		}
		checkCollision();
		for (int i = pongballs.size() - 1; i >= 0; i--) {
			if (pongballs.get(i).x <= 0) {
				score += 1;
			}

			else if (pongballs.get(i).x >= 1000) {
				score -= 1;
			}
		}
	}

	// draw pong balls
	void draw(Graphics g) {
		for (int i = pongballs.size() - 1; i >= 0; i--) {
			p1.draw(g);
			p2.draw(g);
			pongballs.get(i).draw(g);
		}
	}

	// clean up the screen
	void purge() {
		for (int i = pongballs.size() - 1; i >= 0; i--) {
			if (!pongballs.get(i).isActive) {
				pongballs.remove(i);
			}
		}
	}

	// check collision
	void checkcollision() {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addPongBalls(pongballs);
	}

	public void checkCollision() {
		for (int i = pongballs.size() - 1; i >= 0; i--) {
			if (p1.collisionBox0.intersects(pongballs.get(i).collisionBox)) {

			}

			else if (p1.collisionBox1.intersects(pongballs.get(i).collisionBox)) {

			}

			else if (p1.collisionBox2.intersects(pongballs.get(i).collisionBox)) {

			}

			else if (p2.collisionBox0.intersects(pongballs.get(i).collisionBox)) {

			}

			else if (p2.collisionBox1.intersects(pongballs.get(i).collisionBox)) {

			}

			else if (p2.collisionBox2.intersects(pongballs.get(i).collisionBox)) {

			}
		}
	}
}
