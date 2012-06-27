import java.awt.Graphics;
import java.awt.Color;

public class specialAlien extends Aliens{
	
	private double x;
	private double y;
	private double dx;
	private double size;
	private boolean state;
	private boolean isDead;
	
	public specialAlien(int x_axis, int y_axis){
		x = x_axis;
		y = y_axis;
		dx = 2.0;
		size = 25;
		state = true;
		isDead = false;
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
	public boolean getLife(){
		return isDead;
	}
	
	public void update(ShipBullet bullet){
		moveAlien();
		if(bullet != null){
			isDead = goBoom(bullet, isDead, x, y, size);
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect((int) x, (int) y, (int) size, (int) size);
	}
	
}