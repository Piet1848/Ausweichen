import java.util.ArrayList;

public class Dodge {
	public int pixelcounter = 0;
	public int money = 0;
	public int lives = 5;
	public long lastMovingTime;
	public int runden;
	public double speed;
    public static Player player;
	private static ArrayList<Pixel> pixelList = new ArrayList<Pixel>();
	
	public static void main(String[] args) {
		new Dodge(20);
	}
	
	public Dodge(int nRunden) {
		runden = nRunden;
	    player = new Player();
		pixelList.add(new Pixel());
		player.move();
		while(pixelcounter <= runden) {  	// In jeder Runde:
			player.move();

			movePixels();
			
		}
	}
	
	public void movePixels() {
		if (System.currentTimeMillis() - lastMovingTime >= speed) {
			if(runden -pixelcounter>=12) {
				pixelList.add(new Pixel());
			}
			for(int p = 0; p < pixelList.size(); p++) {
				pixelList.get(p).automove();
				if(pixelList.get(p).getRow() == 0) {
					if(pixelList.get(p).getHeight() == player.getHeight()) {
						pixelList.get(p).collide();
					}
					pixelList.remove(p);
					pixelcounter++;
				}
			}
			lastMovingTime = System.currentTimeMillis();
		}
	}
}
