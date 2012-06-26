import java.awt.Graphics;
import java.awt.Color;

public class lowLevel extends Aliens {
	
	private int points;
	private int x;
	private int y;
	
	public lowLevel(){
		points = 50;
	}
	
	
	
	public void draw(Graphics g, lowLevel alien){
		g.setColor(Color.BLUE);
		g.fillRect(alien.x, alien.y, 5, 5);
	}
}