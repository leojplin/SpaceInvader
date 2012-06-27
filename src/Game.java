import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Game extends Applet implements Runnable, KeyListener

{

	lowLevel[] lowLevels = new lowLevel[10];
	midLevel[] midLevels = new midLevel[10];
	highLevel[] highLevels = new highLevel[5];
	int lives = 3;
	specialAlien spec;
	private Image i;
	private Graphics doubleG;
	Ship ship;
	AlienBullet ab;
	ShipBullet sb;
	
	
	public void init()
	{
		addKeyListener(this);
		setSize(800, 600);
		setBackground(Color.LIGHT_GRAY);
	}
	
	public void start()
	{
		spec = new specialAlien(0,0);
		int x = 0;
		int y = 50;
		for(int h = 0; h < highLevels.length; h ++){
			highLevels[h] = new highLevel(x,y);
			x += 50;
			if(x >= 250){
				x = 0;
				y += 50;
			}
		}
		for(int j = 0; j < midLevels.length; j ++){
			midLevels[j] = new midLevel(x, y);
			x += 50;
			if(x >= 250){
				x = 0;
				y += 50;
			}
		}
		for(int i = 0; i < lowLevels.length; i ++){
			lowLevels[i] = new lowLevel(x,y);
			x += 50;
			if(x >= 250){
				x = 0;
				y += 50;
			}
		}
		ab = new AlienBullet(10,580);
		ship = new Ship();
		sb = new ShipBullet(10000,2147482000);
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run()
	{
		while(true)
		{
			if (ship != null)
				if (ship.isShipDead)
				{
					if (lives > 1)
					{
					lives--;			
					ship.xPoints[0] = 400;
					ship.xPoints[1] = 390;
					ship.xPoints[2] = 410;
					ship.isShipDead = false;
					}
					else
					{
						System.exit(0);
					}
				}
				sb.update();
				ship.update(this);
			if (ab != null)
			{
					ship.shotByAlien(ab);
			}
			for(int i = 0; i < lowLevels.length; i ++)
			{
				try{
					if((lowLevels[i].getLife())){
						lowLevels[i] = null;
					}
					else{
						lowLevels[i].update(sb);
					}
				}
				catch (NullPointerException pont){
						continue;
					
				}
			}
			for(int i = 0; i < midLevels.length; i ++)
			{
				try{
					if((midLevels[i].getLife())){
						midLevels[i] = null;
					}
					else{
						midLevels[i].update(sb);
					}
				}
				catch (NullPointerException pont){
						continue;
					
				}
			}
			for(int i = 0; i < highLevels.length; i ++)
			{
				try{
					if((highLevels[i].getLife())){
						highLevels[i] = null;
					}
					else{
						highLevels[i].update(sb);
					}
				}
				catch (NullPointerException pont){
						continue;
					
				}
					
				
				
			}
			spec.update();
			repaint();
			
			try
			{
				Thread.sleep(17);
			}
			catch (InterruptedException e){}
		}
		
	}
	
	@Override
	public void stop() 
	{
		
	}
	
	@Override
	public void destroy()
	{
		
	}
	
	public void checkShipBullet()
	{
		if (sb.yPoints[1] < 0 )
		{
			sb.yPoints[0] = 2147483647;
			sb.yPoints[1] = 2147483647;
			sb.yPoints[2] = 2147483647;
			sb.yPoints[3] = 2147483647;
		}
	}
	
	public void update(Graphics g) //Double buffering. Prevents flickering.
	{
		if (i == null)
		{
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		doubleG.setColor(getForeground());
		paint(doubleG);
		g.drawImage(i, 0, 0, this);
	}
	
	@Override
	public void paint(Graphics g) //Paints the graphic.
	{
		sb.paint(g);
		ship.paint(g);
		ab.paint(g);
		for(int i = 0; i < lowLevels.length; i ++)
		{
			if(lowLevels[i] != null){
				lowLevels[i].paint(g);
			}
			continue;
			
		}
		for(int i = 0; i < midLevels.length; i ++)
		{
			if(midLevels[i] != null){
				midLevels[i].paint(g);
			}
			continue;
			
		}
		for(int i = 0; i < highLevels.length; i ++)
		{
			if(highLevels[i] != null){
				highLevels[i].paint(g);
			}
			continue;
			
		}
		spec.paint(g);

	}

	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			ship.keyLeftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			ship.keyRightPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			ship.spacebarPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			ship.keyLeftPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
		ship.keyRightPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			ship.spacebarPressed = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
}
