package alex.per.Game;

/**
 * 块状物，作为蛇身、糖果的组成单位
 * @author john
 *
 */
public class Brick {
	protected int x;
	protected int y;
	

	public Brick(){
		
	}
	
	public Brick(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
}
