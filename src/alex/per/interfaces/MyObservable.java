package alex.per.interfaces;

public interface MyObservable {
	public void registerObserver(MyObserver ob);
//	public void notifyObservers();  //通知所有观察者
	public void GameAllPlay();
	public void GameAllStop();
	public void GameAllContinue();
	public void GameAllPause();
	public void GameAllRestart();
}
