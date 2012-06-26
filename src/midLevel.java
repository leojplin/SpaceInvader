import java.awt.Color;
import java.awt.Graphics;

public class midLevel extends Aliens{
	private int points;
	private double x;
	private double y;
	private double size;
	private double state;
	private double dx;
	private boolean isDead;
	
	public midLevel(int x_axis, int y_axis){
		points = 100;
		x = x_axis;
		y = y_axis;
		size = 25;
		state = 1;
		dx = 1.0;
		isDead = false;
	}
	
	public void goBoom(ShipBullet bullet){
		for(int i = 0; i < bullet.xPoints.length; i ++){
			if(bullet.xPoints[i] <= x + size && bullet.xPoints[i] >= x){
				if(bullet.yPoints[i] <= y && bullet.yPoints[i] >= y + size){
					isDead = true;
				}
			}
		}
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
	}
	
	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, (int)size, (int)size);
	}
	
	
	
	
}
