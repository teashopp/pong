import javax.swing.JFrame;

public class Pong {
	
	// pong but every few seconds another ball is added and each time the ball hits a wall the person who missed loses a point
	
	
	// initial info
	JFrame gameframe;
	static final int WIDTH = 1000;
	static final int HEIGHT = 500;
	GamePanelPong gpp = new GamePanelPong();

	// run pong
	public static void main(String[] args) {
		Pong pong = new Pong();
		pong.initialize();
		pong.setup();
	}
	
	// initialize game frame
	public void initialize() {
		gameframe = new JFrame("Pong!");
	}

	// set up game frame
	public void setup() {
		gameframe.add(gpp);
		gameframe.setSize(WIDTH, HEIGHT);
		gameframe.setVisible(true);
		gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameframe.addKeyListener(gpp);
	}
	
}
