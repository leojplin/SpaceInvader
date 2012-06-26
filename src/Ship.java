import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Ship extends GameComponent
{
	private int[] xPoints = {400, 390, 410};
	private int[] yPoints = {555, 580, 580};
	boolean keyLeft = false;
	boolean keyRight = false;
	final int lateralSpeed = 1;
	
	public Ship() {
		// TODO Auto-generated constructor stub
	}
	
	public void moveLeft()
	{
		if (xPoints[1] + lateralSpeed < 0)
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
		if (xPoints[2] + lateralSpeed > 600)
		{
			xPoints[0] = 590;
			xPoints[1] = 580;
			xPoints[2] = 600;
		}
		else
		{
			xPoints[0] += lateralSpeed;
			xPoints[1] += lateralSpeed;
			xPoints[2] += lateralSpeed;
		}
	}
	
//	public void killedByAlien(AlienBullet alienbullet)
//	{
//		if (alienbullet.x <= xPoints[2] && alienbullet.x >= xPoints[1])
//		{
//			if (alienbullet.y <= yPoints[2] && alienbullet.y >= yPoints[1])
//			{
//				//method to destroy ship
//				//method to lose one life
//			}
//		}
//	}
//	
	public void update()
	{
		if (keyLeft)
		{
			moveLeft();
		}
		if (keyRight)
		{
			moveRight();
		}
//		killedByAlien();
		System.out.println("keyLeft is:" + keyLeft + "; keyRight is:" + keyRight);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillPolygon(xPoints, yPoints, 3);
	}
}
