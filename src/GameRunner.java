
public class GameRunner
{
	lowLevel[] lowLevels = new lowLevel[10];
	midLevel[] midLevels = new midLevel[10];

	public GameRunner(){
		
		int x = 0;
		int y = 0;
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

	
		
	}
}
