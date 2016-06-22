package alex.per.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import alex.per.Util.CONSTANT;
import alex.per.interfaces.MyObserver;

public class GameJPanel extends JPanel implements MyObserver {
	private static final int NUM = 30;
	private static final int RATE = 20;

//	private boolean IsFirst = true;
	private int layout[][];
	private Sugar sugar;
	private Snake snake;
	private int GameState = CONSTANT.stop;
	private Controller clr;
	
	public GameJPanel(Controller clr){
		super();
		this.clr = clr;
		clr.registerObserver(this);
	}

	public void initLayout() {
		layout = new int[NUM][NUM];
		for (int i = 0; i < NUM; i++) {
			for (int j = 0; j < NUM; j++) {
				if (i == 0 || i == NUM - 1 || j == 0 || j == NUM - 1) {
					layout[i][j] = 1;
				} else {
					layout[i][j] = 0;
				}
			}
		}
	}

	public void paintLayout(Graphics g) {
		Color c = g.getColor();
		for (int i = 0; i < NUM; i++) {
			for (int j = 0; j < NUM; j++) {
				if (layout[i][j] == 1) {
					g.setColor(Color.BLACK);
				} else {
					g.setColor(Color.BLUE);
				}
				g.fillRect(i * RATE, j * RATE, RATE, RATE);
			}
		}
		g.setColor(c);
	}

	/*
	 * public void initSugar(){ int x = new Random().nextInt(NUM-2)+1; int y =
	 * new Random().nextInt(NUM-2)+1; sugar = new Sugar(x, y);
	 * System.out.println("x:"+x+" y:"+y); }
	 */

	public void paintSugar(Graphics g) {
		int x = 0;
		int y = 0;
		boolean IsCovered = true; // 糖果不能和蛇身在同一个位置，否则会被覆盖

		if (sugar.isEaten() == true) {
			while (IsCovered) {
				x = new Random().nextInt(NUM - 2) + 1;
				y = new Random().nextInt(NUM - 2) + 1;
				for (Brick snakeBody : snake.getBodyList()) {
					if (x == snakeBody.x && y == snakeBody.y) {
						continue;
					}
				}
				IsCovered = false;

			}

			sugar.setX(x);
			sugar.setY(y);
			sugar.setEaten(false);
		} else {
			x = sugar.getX();
			y = sugar.getY();
		}
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x * RATE, y * RATE, RATE, RATE);
		g.setColor(c);
	}

	public void initSnake() {
		int x = new Random().nextInt(NUM - 20) + 10;
		int y = new Random().nextInt(NUM - 20) + 10;
		int direction = new Random().nextInt(4);
		snake = new Snake(x, y, direction);
	}

	public void paintSnake(Graphics g) {
		ArrayList<Brick> snakeTmp = snake.getBodyList();
		Brick b = null;
		for (int i = 0; i < snakeTmp.size(); i++) {
			b = snakeTmp.get(i);
			g.setColor(Color.yellow);
			g.fillRect(b.x * RATE, b.y * RATE, RATE - 2, RATE - 2);
		}
		snake.move();
		snake.setIsDealTurn(false);
	}

	/*
	 * public void init(){ setSize(500,500); initLayout(); initSugar();
	 * initSnake(); IsFirst = false; }
	 */
	public void launch() {
//		super.launch();
		RepaintThread rt = new RepaintThread();
		Thread t = new Thread(rt);
		t.start();
		// setLayout(null);
		// setSize(NUM*RATE,NUM*RATE);
		setBounds(0, 5, NUM * RATE, NUM * RATE);
		addKeyListener(new KeyMonitor());
		initLayout();
		sugar = new Sugar();
		initSnake();

	}

	public void HitCheck() {
		ArrayList<Brick> alist = snake.getBodyList();
		Brick head = alist.get(0);
		int x = head.getX();
		int y = head.getY();
		if (x == 0 || x == NUM - 1 || y == 0 || y == NUM - 1) {
			System.out.println("Dead!!!!!");

		}
		for (int i = 1; i < alist.size(); i++) {
			Brick b = alist.get(i);
			if (x == b.getX() && y == b.getY()) {
				System.out.println("Die!!!");
				break;
			}
		}
		if (x == sugar.getX() && y == sugar.getY()) {
			System.out.println("Eating!!!!!");
			sugar.setEaten(true);
			snake.setIsAddbody(true);
		}

	}

	public void paint(Graphics g) {
		paintLayout(g);
		paintSugar(g);
		paintSnake(g);
		HitCheck();
	}

	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// System.out.println(e.getKeyCode());
			snake.DealTurn(e);
		}

	}

	class RepaintThread implements Runnable {

		@Override
		public void run() {
			System.out.println("here");
			while ( clr.getState() == CONSTANT.stop) {
				try {
					repaint();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void GamePlay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GamePause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GameStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GameContinue() {
		// TODO Auto-generated method stub
		
	}

}
