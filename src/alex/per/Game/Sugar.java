package alex.per.Game;

public class Sugar extends Brick{

	private boolean isEaten = false;
	
	public Sugar(){
		super();
		isEaten = true;
		
	}
	
	public Sugar(int x, int y){
		super(x,y);
		isEaten = true;
	}
	
	public boolean isEaten() {
		return isEaten;
	}

	public void setEaten(boolean isEaten) {
		this.isEaten = isEaten;
	}
	
	

	
}
