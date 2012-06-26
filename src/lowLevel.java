import java.awt.Graphics;
import java.awt.Color;

public class lowLevel extends Aliens{
	
	private int points;
	private int x;
	private int y;
	
	public lowLevel(int x_axis, int y_axis){
		points = 50;
		x = x_axis;
		y = y_axis;
	}
	
	
	public void update(int keyDown, int keyUp){
		moveAlien(true);
		speedAlien();
	}
	
	public void draw(Graphics g, lowLevel alien){
		g.setColor(Color.BLUE);
		g.fillRect(alien.x, alien.y, 5, 5);
	}
}