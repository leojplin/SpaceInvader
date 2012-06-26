public class Aliens {

	private int x;
	private int y;
	private int size = 10;
	private int[] where = {x, y};
	private int dx = 1;
	
	public Aliens(){
		
	}
	
	//public void killByUser(Bullet bullet){
		//if(bullet.x == this.x && bullet.y == this.y){
		//	
		//}
	//}
	
	public void moveAlien(){
		x += dx;
		if(x + size >= 1000){
			y += 15;
			x -= 50;
		}ddas
	}
	
	public void speedAlien(){
		dx = (int) Math.pow(2, y % 15);
	}
}