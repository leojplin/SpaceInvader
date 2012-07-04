import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class lowLevel extends Aliens{
	
	private int points;
	double x;
	double y;
	double size;
	private double state;
	private double dx;
	private boolean isDead;
	private Random randomizer;
	
	public lowLevel(int x_axis, int y_axis){
		points = 50;
		x = x_axis;
		y = y_axis;
		size = 25;
		state = 1;
		dx = 1.0;
		isDead = false;
		randomizer = new Random();
		this.setX(x);
		this.setY(y);
	}
	
	public lowLevel(int x_axis, int y_axis, int deltax){
		points = 100;
		x = x_axis;
		y = y_axis;
		size = 25;
		state = 1;
		dx = 1.0 + deltax;
	}
	
	public boolean getLife(){
		return isDead;
	}
	


	
	public void update(ShipBullet bullet, Game game){
		
		double[] data = moveAlien(x,y,size,state,dx);
		x = data[0];
		y = data[1];
		state = data[2];
		if(bullet != null){
			isDead = goBoom(bullet, isDead, x, y, size);
		}
		this.setX(x);
		this.setY(y);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}
}