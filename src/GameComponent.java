import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;


public abstract class GameComponent
{
	public static ArrayList<GameComponent> componentList = new ArrayList<>();
	
	public GameComponent(){
		componentList.add(this);
	}
	public abstract void update(int keyDown,int keyUp);
	public abstract void draw(Graphics g);
}
