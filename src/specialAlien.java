import java.awt.Graphics;
import java.awt.Color;

public class specialAlien extends Aliens{
	
	private double x;
	private double y;
	private double dx;
	private double size;
	private boolean state;
	
	public specialAlien(int x_axis, int y_axis){
		x = x_axis;
		y = y_axis;
		dx = 2.0;
		size = 25;
		state = true;
	}
	
	public void moveAlien(){
		if(state){
			x += dx;
		}
		if(!(state)){
			x -= dx;
		}
		if(x >= 800){
			state = false;
		}
		if(x <= 0){
			state = true;
		}
	}
	public void update(){
		moveAlien();
	}
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect((int) x, (int) y, (int) size, (int) size);
	}
	
}