import java.awt.Graphics;

public class Aliens{
	
	int points;
	int x;
	int y;
	int size;
	int dx;
	
	public Aliens(){
		
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
	
	public void update(){
		
	}
	
	public void paint(Graphics g){
		
	}
}