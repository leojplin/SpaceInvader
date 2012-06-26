import java.awt.Color;
import java.awt.Graphics;

public class highLevel extends Aliens{
	private int points;
	private double x;
	private double y;
	private double size;
	private boolean state;
	private double dx;
	
	public highLevel(int x_axis, int y_axis){
		points = 100;
		x = x_axis;
		y = y_axis;
		size = 25;
		state = true;
		dx = 1.0;
	}
	
	public void moveAlien(boolean bool){
		if(x + size >= 800 && state){
			y += size;
			state = false;
		}
		if(x <= 0 && !(state)){
			y += size;
			state = true;
		}
		if (!(state)){
			x -= dx;
		}
		if (state){
			x += dx;
		}
	}
	
	public void speedAlien(){
		dx = Math.pow(1.0005, y / size);
	}
	
	public void update(){
		moveAlien(state);
		speedAlien();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}
}
	