package alex.per.interfaces;

public interface MyObservable {
	public void registerObserver(MyObserver ob);
//	public void notifyObservers();  //֪ͨ���й۲���
	public void GameAllPlay();
	public void GameAllStop();
	public void GameAllContinue();
	public void GameAllPause();
	public void GameAllRestart();
}
