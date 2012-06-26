import java.awt.Graphics;
import java.awt.Color;

public class lowLevel extends Aliens{
	
	private int points;
	private int x;
	private int y;
	private int size;
	private boolean state;
	private int dx;
	
	public lowLevel(int x_axis, int y_axis){
		points = 50;
		x = x_axis;
		y = y_axis;
		size = 25;
		state = true;
		dx = 1;
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
		dx = (int) Math.pow(1.05, y / size);
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