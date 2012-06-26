import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class lowLevel extends Aliens{
	
	private double x;
	private double y;
	private double size = 25;
	private double state = 1;
	private double dx = 1.5;
	
	public lowLevel(int x_axis, int y_axis){
		x = x_axis;
		y = y_axis;
	}
	
	
	
	
	@Override
	public void update(int KeyDown, int KeyUp){
		double[] data = moveAlien(x, y, dx, size, state);
		x = data[0];
		y = data[1];
		state = data[2];
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, (int) size, (int) size);
	}
}