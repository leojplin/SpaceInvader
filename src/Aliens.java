import java.awt.Graphics;

public class Aliens extends GameComponent{
	
	private int points;
	private double dx;
	
	public Aliens(){

	}
	

	public double[] moveAlien(double x_pos, double y_pos, double x_vel, double big, double bool){
		if(x_pos + big >= 800 && bool >= 1){
			y_pos += big;
			bool = 0;
		}
		if(x_pos <= 0 && bool < 1){
			y_pos += big;
			bool = 1;
		}
		if (bool < 1){
			x_pos -= x_vel;
		}
		if (bool >= 1){
			x_pos += x_vel;
		}
		double[] ls = {x_pos, y_pos, bool};
		return ls;
	}
	
	public double speedAlien(double speed, double y_pos){
		speed = Math.pow(1.0005, y_pos / 25);
		return speed;
	}
	
	public double getDX(){
		return dx;
	}
	public void setDX(double newDX){
		dx = newDX;
	}
	
	public void update(int KeyDown, int keyUp){
		
	}
	
	public void draw(Graphics g){
		
	}
}