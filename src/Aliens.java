import java.awt.Color;
import java.awt.Graphics;

public class Aliens extends GameComponent{

	private int x;
	private int y;
	private int size = 25;
	private int[] where = {x, y};
	private int dx = 1;
	private boolean state = true;
	
	public Aliens(){
		
	}
	
	//public void killByUser(Bullet bullet){
		//if(bullet.x == this.x && bullet.y == this.y){
		//	
		//}
	//}
	
	public boolean getState(){
		return state;
	}
	
	public int getSize(){
		return size;
	}
	
	public void draw(Graphics g){

	}
	
	public void update(int keyUp, int KeyDown){
		
	}
}