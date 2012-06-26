
public class GameRunner
{
	lowLevel[] lowLevels = new lowLevel[10];
	lowLevel a;
	midLevel b;

	public GameRunner(){
		
		int x = 0;
		int y = 0;
		for(int i = 0; i < lowLevels.length; i ++){
			lowLevels[i] = new lowLevel(x,y);
			x += 50;
			if(x >= 100){
				x = 0;
				y += 50;
			}
//
		
		a = new lowLevel(0,0);
		b = new midLevel(0, 50);
		}
	
		
	}
}
