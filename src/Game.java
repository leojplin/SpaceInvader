import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;
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
	AlienBullet[] abs = new AlienBullet[25];
	AlienBullet specialab = null;
	ShipBullet sb;
	Random randomizer = new Random();
	int rainbowColors = 0;
	int counterForLowPoints = 0;
	int counterForMidPoints = 0;
	int counterForHighPoints = 0;
	int counterForSpecPoints = 0;
//	int counterForUpgrades = 0;
	int points = 0;
	int level = 1;
	int pointsToCheckNewLevel = 1;
	int checkNewLevelIncrease = 1;
	int checkIfSurvivalLevel = 1;
	int increaseSpeed = 0;
	int increaseFireRate = 0;
	int increaseBulletSize = 0;
	URL url;
	static AudioClip shipFireClip;
	static AudioClip alienFireClip;
	static AudioClip backgroundMusic;
	
	public void loadAudioClips(Game game)
	{
		try
		{
			url = getDocumentBase();
			
		} 
		catch (Exception e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
		}
		
		shipFireClip = game.getAudioClip(url, "Music/pulse-gun-03.au");
		alienFireClip = game.getAudioClip(url, "Music/pulse-gun-01.au");
		backgroundMusic = game.getAudioClip(url, "Music/avicii - levels (skrillex remix).au");
	}
	public void init()
	{
		loadAudioClips(this);
		addKeyListener(this);
		setSize(800, 600);
		setBackground(Color.BLACK);
	}
	
	public void start()
	{
		backgroundMusic.loop();
		spec = new specialAlien(50,0);
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
		sb = new ShipBullet(10000,2147482000);
		ship = new Ship();
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
						if(toFire <= 5 + increaseFireRate){
							abs[i] = alienFire(lowLevels[i], abs[i]);
						}
					}
				}
				catch (NullPointerException pont){
						continue;
					
				}
				if (lowLevels[i] == null)
				{
					counterForLowPoints++;
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
						int toFire = randomizer.nextInt(1000);
						if(toFire <= 5 + increaseFireRate){
							abs[i + 10] = alienFire(midLevels[i], abs[i + 10]);
						}
					}
				}
				catch (NullPointerException pont){
						continue;
					
				}
				if (midLevels[i] == null)
				{
					counterForMidPoints++;
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
						int toFire = randomizer.nextInt(1000);
						if(toFire <= 5 + increaseFireRate){
							abs[i + 20] = alienFire(highLevels[i], abs[i + 20]);
						}
					}
				}
				catch (NullPointerException pont){
						continue;
					
				}
				if (highLevels[i] == null)
				{
					counterForHighPoints++;
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
			if (specialab != null)
			{
				if (specialab.yPoints[0] > 600)
				{
					specialab = null;
				}
			}
			if (specialab == null)
			{
				specialab = new AlienBullet((int)(spec.x + 0.5 * spec.size),(int) (spec.y + spec.size));
				alienFireClip.play();
			}
			if (spec == null)
			{
				counterForSpecPoints++;
				spec = new specialAlien(10000000,10000000);
			}
			points = 50*counterForLowPoints + 100*counterForMidPoints + 200*counterForHighPoints + 500*counterForSpecPoints;// - 5000*counterForUpgrades;
			for(int i = 0; i < abs.length; i ++){
				try{
					if(abs[i] != null){
						abs[i].update();
					}
				}
				catch(NullPointerException pont){
					continue;
				}
			}
			if (specialab !=null)
			{
				specialab.update();
			}
			

			if (points > 0 && points%3000 == 0 && pointsToCheckNewLevel != points)
			{
				if (checkNewLevelIncrease% 2 ==1)
				{
					increaseSpeed++;
					checkNewLevelIncrease++;
				}
				else
				{
				increaseFireRate += 5;
				checkNewLevelIncrease++;
				}
				lives++;
				level++;
				this.newStart();
				pointsToCheckNewLevel = points;
			}
			
			repaint();
			try
			{
				Thread.sleep(19);
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
		if (rainbowColors +1 > 7)
		{
			rainbowColors = 0;
		}
		else
		{
			rainbowColors++;
		}
		switch (rainbowColors)
		{
			case 0:
				g.setColor(Color.MAGENTA);
				break;
			case 1:
				g.setColor(Color.BLUE);
				break;
			case 2:
				g.setColor(Color.CYAN);
				break;
			case 3:
				g.setColor(Color.GREEN);
				break;
			case 4:
				g.setColor(Color.YELLOW);
				break;
			case 5:
				g.setColor(Color.ORANGE);
				break;
			case 6:
				g.setColor(Color.RED);
				break;
			case 7:
				g.setColor(Color.PINK);
				break;
		}
		Font font = new Font("newFont", Font.BOLD, 12);
		g.setFont(font);
		g.drawString("Level: " + Integer.toString(level), 376, 595);
		g.drawString("Points: " + Integer.toString(points),720,595);
		g.drawString("Lives: " + Integer.toString(lives), 5, 595);
		font = new Font("newFont", Font.TRUETYPE_FONT, 10);
		g.setFont(font);
		g.drawString("Alien Fire Rate: " + Double.toString((double)(5+increaseFireRate)/(double)(10)) + "%", 5, 15);
		g.drawString("Alien Movement Speed: " + Integer.toString(1 + increaseSpeed), 5, 30);
		sb.paint(g);
		ship.paint(g);
		for(int i = 0; i < abs.length; i++){
			if(abs[i] != null){
				abs[i].paint(g);
			}
		}
		if (specialab != null)
		{
			specialab.paint(g);
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
	
	public AlienBullet alienFire(Aliens alien, AlienBullet oldAB){
		AlienBullet abr;
		if(oldAB == null){
			abr = new AlienBullet((int) (alien.x + (.5 * alien.size)), (int) (alien.y + alien.size));
			alienFireClip.play();
		}else{
			abr = oldAB;
			if(abr.yPoints[0] >= 600){
				abr = null;
			}
		}
		return abr;
	}


	public void newStart()
	{
		lowLevels = new lowLevel[10];
		midLevels = new midLevel[10];
		highLevels = new highLevel[5];
		abs = new AlienBullet[25];
		sb = new ShipBullet(10000,2147482000, increaseBulletSize);
		spec = new specialAlien(50,0, increaseSpeed);
		int x = 0;
		int y = 50;
		for(int h = 0; h < highLevels.length; h ++){
			highLevels[h] = new highLevel(x,y, increaseSpeed);
			x += 50;
			if(x >= 250){
				x = 0;
				y += 50;
			}
		}
		for(int j = 0; j < midLevels.length; j ++){
			midLevels[j] = new midLevel(x, y, increaseSpeed);
			x += 50;
			if(x >= 250){
				x = 0;
				y += 50;
			}
		}
		for(int i = 0; i < lowLevels.length; i ++){
			lowLevels[i] = new lowLevel(x,y, increaseSpeed);
			x += 50;
			if(x >= 250){
				x = 0;
				y += 50;
			}
		}
	}
}
//	public void purchaseBulletUpgrade()
//	{
//		if (points >= 5000)
//		{
//			points -= 5000;
//			counterForUpgrades++;
//			increaseBulletSize++;
//		}
//	}
//	
//	public void purchaseLife()
//	{
//		if (points >= 5000)
//		{
//			points -= 5000;
//			counterForUpgrades++;
//			lives++;
//		}
//		
//	}
//}