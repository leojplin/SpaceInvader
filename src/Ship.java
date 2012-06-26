import java.awt.Color;
import java.awt.Graphics;


public class Ship
{
	int[] xPoints = {400, 390, 410};
	int[] yPoints = {555, 580, 580};
	final int lateralSpeed = 25;
	boolean keyLeftPressed = false;
	boolean keyRightPressed = false;
	boolean spacebarPressed = false;
	boolean isShipDead = false;
	ShipBullet sb;
	
	public Ship() 
	{
		
	}
	
	public void moveLeft()
	{
		if (xPoints[1] - lateralSpeed < 0)
		{
			xPoints[0] = 10;
			xPoints[1] = 0;
			xPoints[2] = 20;
		}
		else
		{
			xPoints[0] -= lateralSpeed;
			xPoints[1] -= lateralSpeed;
			xPoints[2] -= lateralSpeed;
		}
	}
	
	public void moveRight()
	{
		if (xPoints[2] + lateralSpeed > 800)
		{
			xPoints[0] = 790;
			xPoints[1] = 780;
			xPoints[2] = 800;
		}
		else
		{
			xPoints[0] += lateralSpeed;
			xPoints[1] += lateralSpeed;
			xPoints[2] += lateralSpeed;
		}
	}
	
	public void fireShipBullet()
	{
		if (spacebarPressed)
		{
			if (!(sb != null))
			{
			sb = new ShipBullet(xPoints[0], yPoints[0]);
			}
			checkShipBullet();
		}
	}
	
	public void checkShipBullet()
	{
		if (sb !=null)
		{
			if (sb.yPoints[1] < 0 )
			{
				sb = null;
			}
		}
	}
	
	public void shotByAlien(AlienBullet ab)
	{
		if (ab.xPoints[0] >= xPoints[1] && ab.xPoints[0] <= xPoints[2] || ab.xPoints[2] >= xPoints[1] && ab.xPoints[2] <= xPoints[2])
		{
			if (ab.yPoints[0] >= yPoints[0] && ab.yPoints[0] <= yPoints[1] || ab.yPoints[1] >= yPoints[0] && ab.yPoints[1] <= yPoints[1])
			{
				isShipDead = true; //method to destroy
				//method to lose one life
			}
		}
	}
	
	public void update(AlienBullet ab)
	{
		if (keyLeftPressed)
		{
			moveLeft();
		}
		if (keyRightPressed)
		{
			moveRight();
		}
		if (spacebarPressed)
		{
			fireShipBullet();
		}
		if (sb != null)
		{
			sb.update();
		}
		
		if (ab != null)
		{
		shotByAlien(ab);
		}
	}
	
	public void paint(Graphics g)
	{
		if (sb !=null)
		{
			sb.paint(g);
		}
		g.setColor(Color.RED);
		g.fillPolygon(xPoints, yPoints, 3);
	}
}
