import java.awt.Color;
import java.awt.Graphics;


public class ShipBullet 
{
	int bulletWidth = 2;
	int bulletLength = 15;
	int bulletSpeed = 15;
	int[] xPoints = new int[4];
	int[] yPoints = new int[4];
	
	public ShipBullet(int x, int y) 
	{
		xPoints[0] = x - bulletWidth +1;
		xPoints[1] = x - bulletWidth +1;
		xPoints[2] = x + bulletWidth;
		xPoints[3] = x + bulletWidth;
		yPoints[0] = y + bulletSpeed;
		yPoints[1] = y - bulletLength + bulletSpeed; 
		yPoints[2] = y - bulletLength + bulletSpeed;
		yPoints[3] = y + bulletSpeed;
	}
	
	public ShipBullet(int x, int y, int increaseBulletSize) 
	{
		bulletWidth += increaseBulletSize;
		bulletLength += 2*increaseBulletSize;
		xPoints[0] = x - bulletWidth +1;
		xPoints[1] = x - bulletWidth +1;
		xPoints[2] = x + bulletWidth;
		xPoints[3] = x + bulletWidth;
		yPoints[0] = y + bulletSpeed;
		yPoints[1] = y - bulletLength + bulletSpeed; 
		yPoints[2] = y - bulletLength + bulletSpeed;
		yPoints[3] = y + bulletSpeed;
	}
	
	public void update()
	{
		yPoints[0] -= bulletSpeed;
		yPoints[1] -= bulletSpeed;
		yPoints[2] -= bulletSpeed;
		yPoints[3] -= bulletSpeed; 
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillPolygon(xPoints, yPoints, 4);
	}
}
