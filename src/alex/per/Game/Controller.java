package alex.per.Game;

import java.util.ArrayList;
import java.util.Observer;

import alex.per.Util.CONSTANT;
import alex.per.interfaces.MyObservable;
import alex.per.interfaces.MyObserver;

public class Controller implements MyObservable{
	private int state ;
	private ArrayList<MyObserver> oberlist;
	
	public Controller(){
		state = CONSTANT.stop;
		oberlist = new ArrayList<MyObserver>();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public void registerObserver(MyObserver ob) {
		oberlist.add(ob);
		
	}

	@Override
	public void GameAllPlay() {
		for(MyObserver ob: oberlist){
			ob.GamePlay();
		}
	}

	@Override
	public void GameAllStop() {
		for(MyObserver ob: oberlist){
			ob.GameStop();
		}
		
	}

	@Override
	public void GameAllContinue() {
		for(MyObserver ob: oberlist){
			ob.GameContinue();
		}
		
	}

	@Override
	public void GameAllPause() {
		for(MyObserver ob: oberlist){
			ob.GamePause();
		}
		
	}

	@Override
	public void GameAllRestart() {
	
		
	}


}
