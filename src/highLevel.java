import java.awt.Color;
import java.awt.Graphics;

public class highLevel extends Aliens{
	private int points;
	private double x;
	private double y;
	private double size;
	private double state;
	public double dx;
	private boolean isDead = false;
	
	public highLevel(int x_axis, int y_axis){
		points = 100;
		x = x_axis;
		y = y_axis;
		size = 25;
		state = 1;
		dx = 1.0;
	}
	
	
	public void speedAlien(){
		dx = Math.pow(1.0005, y / size);
	}
	
	public double getDX(){
		return dx;
	}
	
	public boolean getLife(){
		return isDead;
	}
	
	public void update(ShipBullet bullet){
		double[] data = moveAlien(x,y,size,state,dx);
		x = data[0];
		y = data[1];
		state = data[2];
		speedAlien();
		if(bullet != null){
			isDead = goBoom(bullet, isDead, x, y, size);
		}
		this.setX(x);
		this.setY(y);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}
}
	