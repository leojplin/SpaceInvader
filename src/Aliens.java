import java.awt.Graphics;

public class Aliens{
	
	AlienBullet ab;
	
	int points;
	double x;
	double y;
	int size;
	int dx;
	
	public Aliens(){
		
	}
	
	public void setX(double xNew){
		x = xNew;
	}
	
	public void setY(double yNew){
		y = yNew;
	}
	
	public double[] moveAlien(double x_pos, double y_pos, double big, double toRight, double x_vel){
		if(x_pos + big >= 800 && toRight >= 1){
			y_pos += big;
			toRight = 0;
		}
		if(x_pos <= 0 && toRight < 1){
			y_pos += big;
			toRight = 1;
		}
		if(toRight >= 1){
			x_pos += x_vel;
		}
		if(toRight < 1){
			x_pos -= x_vel;
		}
		double[] data = {x_pos, y_pos, toRight};
		return data;
	}
	
	public boolean goBoom(ShipBullet bullet, boolean bool, double x, double y, double size){
		for(int i = 0; i < bullet.xPoints.length; i ++){
			if(bullet.xPoints[i] <= (x + size) && bullet.xPoints[i] >= x){
				if(bullet.yPoints[i] <= y + size && bullet.yPoints[i] >= y){
					bool = true;
				}
			}
		}
		return bool;
	}
	
	public void update(){
		
	}
	
	public void paint(Graphics g){
		
	}
}