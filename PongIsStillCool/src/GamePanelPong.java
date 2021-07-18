import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanelPong extends JPanel implements ActionListener, KeyListener {

	// variables
	static final int MENU = 0;
	static final int GAME = 1;
	static final int END0 = 2;
	static final int END1 = 3;
	static int currentState = MENU;
	Timer frameDraw;
	Timer pongballspawn;
	Paddle p1 = new Paddle(100, 200, 50, 150);
	Paddle p2 = new Paddle(900, 200, 50, 150);
	ObjectManagerPong omp = new ObjectManagerPong(p1, p2);

	// font variables
	Font titleFont0;
	Font titleFont1;

	GamePanelPong() {
		// set fonts
		titleFont0 = new Font("Arial", Font.PLAIN, 45);
		titleFont1 = new Font("Arial", Font.PLAIN, 25);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	// update at menu
	public void updateMenuState() {

	}

	// update during game
	public void updateGameState() {
		p1.update();
		p2.update();

		omp.update();

		if (omp.score == 2) {
			currentState = 3;
		}

		else if (omp.score == -2) {
			currentState = 2;
		}
	}

	// update at end
	public void updateEndState() {

	}

	// draw menu
	public void drawMenuState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
		g.setFont(titleFont0);
		g.setColor(Color.white);
		g.drawString("Pong!", 400, 200);
		g.setFont(titleFont1);
		g.drawString("For instructions, hit space!", 300, 250);
	}

	// draw game
	public void drawGameState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
		g.setFont(titleFont1);
		g.setColor(Color.white);
		g.drawString("Pong!", 450, 100);
		p1.draw(g);
		p2.draw(g);
		omp.draw(g);
	}

	// draw end 1
	public void drawEndState0(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
		g.setFont(titleFont0);
		g.setColor(Color.white);
		g.drawString("Game over, left player wins!", 400, 250);
	}

	// draw end 2
	public void drawEndState1(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
		g.setFont(titleFont0);
		g.setColor(Color.white);
		g.drawString("Game over, right player wins!", 400, 250);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		}
		if (currentState == GAME) {
			drawGameState(g);
		}
		if (currentState == END0) {
			drawEndState0(g);
		}
		if (currentState == END1) {
			drawEndState1(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		}
		if (currentState == GAME) {
			updateGameState();
		}
		if (currentState == END0) {
			updateEndState();
		}
		if (currentState == END1) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// give instructions
		if (currentState == MENU) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				System.out.println(
						"Use the W and S keys to control the left paddle; use the up and down keys to control the right paddle");
			}
		}
		// update current state
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END0) {
				currentState = MENU;
				pongballspawn.stop();
			} else if (currentState == END1) {
				currentState = MENU;
				pongballspawn.stop();
			} else {
				currentState++;
			}
		}
		// move paddles
		if (currentState == GAME) {
			pongballSpawn();
			// move left paddle
			if (e.getKeyCode() == KeyEvent.VK_W) {
				p1.up = true;
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				p1.down = true;
			}
			// move right paddle
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				p2.up = true;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				p2.down = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// stop paddles
		if (currentState == GAME) {
			// stop left paddle
			if (e.getKeyCode() == KeyEvent.VK_W) {
				p1.up = false;
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				p1.down = false;
			}
			// stop right paddle
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				p2.up = false;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				p2.down = false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void pongballSpawn() {
		pongballspawn = new Timer(1000, omp);
		pongballspawn.start();
	}
}
