import java.awt.Color;
import java.awt.Graphics;

public class midLevel extends Aliens{
	private int points;
	private double x;
	private double y;
	private double size;
	private double state;
	private double dx;
	
	public midLevel(int x_axis, int y_axis){
		points = 100;
		x = x_axis;
		y = y_axis;
		size = 25;
		state = 1;
		dx = 1.5;
	}
	

	
	public void speedAlien(){
		dx = Math.pow(1.0005, y / size);
	}
	
	public void update(int keyDown, int keyUp){
		double[] data = moveAlien(x, y, dx, size, state);
		x = data[0];
		y = data[1];
		state = data[2];
		dx = speedAlien(dx, y);
		speedAlien();
	}
	
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect((int) x, (int) y, (int) size, (int) size);
	}
	
	
	
	
}
