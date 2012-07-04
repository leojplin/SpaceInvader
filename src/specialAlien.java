import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class specialAlien extends Aliens{
	
	double x;
	double y;
	private double dx;
	double size;
	private boolean state;
	private boolean isDead;
	private int lives = 3;
	Color color = Color.BLUE;
	Random r = new Random();
	
	public specialAlien(int x_axis, int y_axis){
		x = x_axis;
		y = y_axis;
		dx = 2.0;
		size = 25;
		state = true;
		isDead = false;
	}
	
	public specialAlien(int x_axis, int y_axis, int deltax){
		points = 100;
		x = x_axis;
		y = y_axis;
		size = 25;
		state = true;
		dx = 1.0 + deltax;
	}
	
	public void moveAlien(){
		if(state){
			x += dx;
		}
		if(!(state)){
			x -= dx;
		}
		if(x >= 800-size){
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
			if (goBoom(bullet, isDead, x, y, size))
			{
				lives--;
				if (lives < 0)
				{
					isDead = true;
				}
				dx += 2;
				x = r.nextInt(800)+1;
				if (lives == 3)
				{
					color = Color.GREEN;
				}
				if (lives == 2)
				{
					color = Color.YELLOW;
				}
				if (lives == 1)
				{
					color = Color.ORANGE;
				}
				if (lives == 0)
				{
					color = Color.RED;
					
				}

			}
		}
	}
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect((int) x, (int) y, (int) size, (int) size);
	}
	
}