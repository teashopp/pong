import java.awt.Rectangle;

public class GameObjectPong {

	// variables
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive;

	// game object stuff
	GameObjectPong(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 0;
		isActive = true;
	}

	void update() {

	}

}
