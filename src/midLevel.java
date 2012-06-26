import java.awt.Color;
import java.awt.Graphics;

public class midLevel extends Aliens{
	private int points;
	private int x;
	private int y;
	private int size;
	private boolean state;
	
	public midLevel(int x_axis, int y_axis){
		points = 100;
		x = x_axis;
		y = y_axis;
		size = 25;
		state = true;
	}
	
	public void update(int keyDown, int keyUp){
		moveAlien(state);
		speedAlien();
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, size, size);
	}
	
	
	
	
}
