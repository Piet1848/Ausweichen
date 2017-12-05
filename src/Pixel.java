import ledControl.BoardController;

public class Pixel {
	public int height, row, playerH;
	static BoardController controller;
	
	public Pixel() {
		height = (int) (Math.random()*11);
		row = 11;
		controller = BoardController.getBoardController();
	}
	
	public void automove() {
		row--;
	}
	
	public int getHeight() {
		int h = height;
		return h;
	}
	
	public int getRow() {
		int r = row;
		return r;
	}
	
	public int collide() {
		return 5;
	}
	
}
