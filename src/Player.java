
import java.awt.event.KeyEvent;
import ledControl.BoardController;
import ledControl.gui.KeyBuffer;


public class Player {
	private static KeyBuffer	buffer;
	public int height;
	public int lifes;
	static BoardController controller;
	
	public static void main(String[] args) {
		controller = BoardController.getBoardController();
		controller.setColor(0, 5, 127, 0, 0);
		controller.updateLedStripe();
		new Player();
	}
	
	public Player() {
		lifes = 5;
		height = 5;

		controller = BoardController.getBoardController();
		controller.setColor(0, 5, 127, 0, 0);
		controller.updateLedStripe();
	}
	
	public int getHeight() {
		int h = height;
		return h;
	}
	
	public void move() {
		buffer = controller.getKeyBuffer();

			KeyEvent event = buffer.pop();
			if (event != null){
				if (event.getID() == java.awt.event.KeyEvent.KEY_PRESSED){
					switch (event.getKeyCode()){
					case java.awt.event.KeyEvent.VK_UP:
						height--;
						if(height<0) {
							height = 11;
						}
						break;
					case java.awt.event.KeyEvent.VK_DOWN:
						height++;
						if(height>11) {
							height = 0;
						}
						break;
					default:
					}
				}
				update();
				controller.sleep(120);
				buffer.clear();
			}
	}
	
	public void update() {
		controller.resetColors();
		controller.setColor(0, height, 127, 0, 0);
		controller.updateLedStripe();
	}
	
	
}
