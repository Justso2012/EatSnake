package alex.per.Game;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameMain extends JFrame{
	public GameMain(){
		setLayout(null);
		setSize(800,640);
		setLocation(50, 50);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Controller clr = new Controller();
		
		GameJPanel gp = new GameJPanel(clr);
//		gp.setLayout(null);
		gp.setFocusable(true);
		gp.launch();
		add(gp);
//		add(gp,BorderLayout.CENTER);


		ControlPanel cp = new ControlPanel(clr);
//		cp.setLayout(null);
		add(cp);
//		add(cp, BorderLayout.SOUTH);
		
	}
	
/*	public void lauch(){
		GameJPanel gp = new GameJPanel();
//		gp.setFocusable(true);
		gp.launch();
		add(gp,BorderLayout.CENTER);
		setVisible(true);
	}*/
	
	public static void main(String[] args){
		GameMain gm = new GameMain();
		gm.setVisible(true);
		
/*		jf.setSize(800,800);
		jf.setLocation(50, 50);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameJPanel gp = new GameJPanel();
		gp.setFocusable(true);
		gp.launch();
		jf.add(gp,BorderLayout.CENTER);
		jf.setVisible(true);
		*/
	}
}
