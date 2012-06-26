import java.awt.Graphics;
import java.awt.Color;

public class lowLevel extends Aliens{
	
	private int points;
	private int x;
	private int y;
	private int size;
	private boolean state;
	
	public lowLevel(int x_axis, int y_axis){
		points = 50;
		x = x_axis;
		y = y_axis;
		size = 25;
		state = true;
	}
	
	@Override
	public void update(int keyDown, int keyUp){
		moveAlien(state);
		speedAlien();
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, size, size);
	}
}