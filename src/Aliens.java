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
	
	public void moveAlien(boolean bool){
		if(x + size >= 800 && state){
			y += size;
			state = false;
		}
		if(x <= 0 && !(state)){
			y += size;
			state = true;
		}
		if (!(state)){
			x -= dx;
		}
		if (state){
			x += dx;
		}
	}
	
	public void speedAlien(){
		this.dx = (int) Math.pow(1.5, y / size);
	}
	
	public int getSize(){
		return size;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(this.x, this.y, this.size, this.size);
	}
	
	public void update(int keyUp, int KeyDown){
		//moveAlien(state);
	}
}