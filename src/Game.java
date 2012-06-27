import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;



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
	AlienBullet[] abs = new AlienBullet[10];
	ShipBullet sb;
	Random randomizer = new Random();
	
	
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
			for(int i = 0; i < abs.length; i ++){
				if (abs[i] != null)
				{
						ship.shotByAlien(abs[i]);
				}
			}
			
			for(int i = 0; i < lowLevels.length; i ++)
			{
				try{
					if((lowLevels[i].getLife())){
						lowLevels[i] = null;
						sb.yPoints[0] = 2147483647;
						sb.yPoints[1] = 2147483647;
						sb.yPoints[2] = 2147483647;
						sb.yPoints[3] = 2147483647;
					}
					else{
						lowLevels[i].update(sb, this);
						int toFire = randomizer.nextInt(1000);
						if(toFire <= 5){
							int chance = randomizer.nextInt(lowLevels.length);
							abs[i] = alienFire(lowLevels[i], abs[i]);
						}
						for(int j = 0; j < abs.length; j ++){
							if(abs[j] != null){
								abs[j].update();
							}
						}
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
						sb.yPoints[0] = 2147483647;
						sb.yPoints[1] = 2147483647;
						sb.yPoints[2] = 2147483647;
						sb.yPoints[3] = 2147483647;
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
						sb.yPoints[0] = 2147483647;
						sb.yPoints[1] = 2147483647;
						sb.yPoints[2] = 2147483647;
						sb.yPoints[3] = 2147483647;
					}
					else{
						highLevels[i].update(sb);
					}
				}
				catch (NullPointerException pont){
						continue;
					
				}
					
				
				
			}
			try{
				if(spec.getLife()){
					spec = null;
					sb.yPoints[0] = 2147483647;
					sb.yPoints[1] = 2147483647;
					sb.yPoints[2] = 2147483647;
					sb.yPoints[3] = 2147483647;
				}
				else{
					spec.update(sb);
				}
			}
			catch (NullPointerException pont){
					
			}
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
		for(int i = 0; i < abs.length; i++){
			if(abs[i] != null){
				abs[i].paint(g);
			}
		}
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
			if((spec != null)){
				spec.paint(g);
			}
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
	public AlienBullet alienFire(lowLevel low, AlienBullet oldAB){
		AlienBullet abr;
		if(oldAB == null){
			abr = new AlienBullet((int) (low.x + (.5 * low.size)), (int) (low.y + low.size));
		}else{
			abr = oldAB;
			if(abr.yPoints[0] >= 600){
				abr = null;
			}
		}
		return abr;
	}
}
