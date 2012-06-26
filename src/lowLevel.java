import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class lowLevel extends Aliens{
	
	private int points;
	private double x;
	private double y;
	private double size;
	private boolean state;
	private double dx;
	
	public lowLevel(int x_axis, int y_axis){
		points = 50;
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
	public void checkDeath(){
		if()
	}
	
	public void update(int KeyDown, int KeyUp){
		moveAlien(state);
		speedAlien();
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}
}