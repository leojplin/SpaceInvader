import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Game extends Applet implements Runnable, KeyListener

{
	Image dbImage;
	Graphics dbGraphics;
	GameRunner gr;
	int width;
	int height;
	boolean keyLeft = false;
	boolean keyRight = false;
	
	
	public void run()
	{
		while(true)
		{
			
			for(GameComponent gc : GameComponent.componentList)
			{
				gc.update();
			}
			repaint();
			
			try
			{
				Thread.sleep(17);
			}
			catch (InterruptedException e){}
		}
		
	}
	
	public void init()
	{
		addKeyListener(this);
		width = 800;
		height = 600;
		gr = new GameRunner();
		this.setSize(width, height);
		dbImage = createImage(this.getWidth(), this.getHeight());
		dbGraphics = dbImage.getGraphics();
		Thread t = new Thread(this);
		t.start();
	}
	
	
	public void update(Graphics g)
	{
		paint(g);
	}
	
	public void paint(Graphics g)
	{
		dbGraphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		
		for(GameComponent gc : GameComponent.componentList)
		{
			gc.draw(dbGraphics);
		}
		
		g.drawImage(dbImage, 0, 0, this);
	}

	
	@Override
	public void keyPressed(KeyEvent e) 
	{

		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keyLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keyRight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keyLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keyRight = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
}
