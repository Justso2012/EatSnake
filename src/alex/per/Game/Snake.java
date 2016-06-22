package alex.per.Game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.naming.directory.DirContext;

import alex.per.Util.CONSTANT;

public class Snake {
	private ArrayList<Brick> bodyList;
	private ArrayList<MovDirect> MovList;
	private int direction;
	private MovDirect movTo;    //下一个单位时间前进方向
	private boolean IsAddbody = false;
	private boolean IsDealTurn = false;  //单位时间内是否已处理转向
	
	
	public Snake(int x, int y, int direction){
		this.direction = direction;
		initDirect();
		initSnake(x,y);	
	}
	
	
	
	public ArrayList<Brick> getBodyList() {
		return bodyList;
	}




	public boolean isIsAddbody() {
		return IsAddbody;
	}

	public void setIsAddbody(boolean isAddbody) {
		IsAddbody = isAddbody;
	}

	public boolean isIsDealTurn() {
		return IsDealTurn;
	}



	public void setIsDealTurn(boolean isDealTurn) {
		IsDealTurn = isDealTurn;
	}



	public void initDirect(){
		MovList = new ArrayList<MovDirect>();
		MovDirect up = new MovDirect(0, -1);
		MovDirect left = new MovDirect(-1, 0);
		MovDirect down = new MovDirect(0, 1);
		MovDirect right = new MovDirect(1, 0);
		MovList.add(up);
		MovList.add(left);
		MovList.add(down);
		MovList.add(right);
	}
	
	public void initSnake(int x, int y){
		bodyList = new ArrayList<Brick>();

		Brick head = new Brick(x,y);
		bodyList.add(head);
		
		int tmp = (direction + 2)%4;  //用与头指向的相反方向构造蛇身
		movTo = MovList.get(tmp);
		for(int i = 0;i < CONSTANT.SNAKE_LEN - 1;i++){
			x += movTo.movX;
			y += movTo.movY;
			bodyList.add(new Brick(x,y));
		}
		
		
		
	}
	
	public void AddBody(){
		Brick b = bodyList.get(bodyList.size()-1);
		int x = b.getX();
		int y = b.getY();
		
		
	}
	public void move(){
		int x = 0, y = 0;
		int tmpx = 0, tmpy = 0;
		Brick b = null;
		movTo = MovList.get(direction);
		
		for(int i = 0;i < bodyList.size();i++){
			b = bodyList.get(i);
			
			x = b.getX();
			y = b.getY();
			if(i == 0){
				b.setX(x+movTo.movX);
				b.setY(y+movTo.movY);
			}else{
				b.setX(tmpx);
				b.setY(tmpy);
			}
			tmpx = x;
			tmpy = y;		
		}
		if(IsAddbody == true){
			Brick tail = new Brick(tmpx, tmpy);
			bodyList.add(tail);
			IsAddbody = false;
		}
	}

	public void DealTurn(KeyEvent e){
		int directmp = 0;
		if(IsDealTurn) return;   	//要确保一个单位时间内只能处理一次转向,否则可能反向移动
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			directmp = CONSTANT.UP;
			break;
		
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			directmp = CONSTANT.LEFT;
			break;
	
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			directmp = CONSTANT.DOWN;
			break;
			
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			directmp = CONSTANT.RIGHT;
			break;
			
		default:
			break;
		}
		
		if(direction != directmp && direction != (directmp + 2)% 4){
			direction = directmp;
		}
		IsDealTurn = true;
		
	}
	

	class MovDirect{
		int movX;
		int movY;
		public MovDirect(int x, int y){
			movX = x;
			movY = y;
		}
	}
	
	

}
