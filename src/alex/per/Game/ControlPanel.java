package alex.per.Game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import alex.per.Util.CONSTANT;
import alex.per.interfaces.MyObserver;

public class ControlPanel extends JPanel implements ActionListener,MyObserver{
	private JButton btnStart, btnRestart;
	private JLabel lbScore, lbShowScore;
	private Controller clr;
	
	public ControlPanel(Controller clr){

		this.clr = clr;
		clr.registerObserver(this);
		
		
//		setSize(180, 400);
		setLayout(null);
		setBounds(600, 0, 200, 640);
//		setBackground(Color.GREEN);
		
		lbScore = new JLabel();
		lbScore.setBounds(20, 100, 40, 30);
		lbScore.setBorder(BorderFactory.createLineBorder(Color.red));
		lbScore.setText("Score");
		this.add(lbScore);
		
		lbShowScore = new JLabel();
//		lbShowScore.setText("hehe");
		lbShowScore.setBounds(65, 100, 100, 30);
		lbShowScore.setBorder(BorderFactory.createLineBorder(Color.orange));
		lbShowScore.setBackground(Color.WHITE);
		lbShowScore.setOpaque(true);
		this.add(lbShowScore);
		
		btnStart = new JButton();
		btnStart.setText("Start");
//		btnStart.setSize(100, 100);
		btnStart.setBounds(50, 250, 100,50);
		this.add(btnStart);
		btnStart.addActionListener(this);
		
		btnRestart = new JButton();
		btnRestart.setText("Restart");
		btnRestart.setEnabled(false);
		btnRestart.setBounds(50, 360, 100, 50);
		this.add(btnRestart);
		btnRestart.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnStart){
			if(clr.getState() == CONSTANT.stop){
				clr.setState(CONSTANT.playing);
				btnRestart.setEnabled(true);
				clr.GameAllPlay();
			}
			else if(clr.getState() == CONSTANT.pause){
				clr.setState(CONSTANT.playing);
				clr.GameAllContinue();
			}
			else if(clr.getState() == CONSTANT.playing){
				clr.setState(CONSTANT.pause);
				clr.GameAllPause();
			}
		}
		else if(obj == btnRestart){
			if(clr.getState() == CONSTANT.pause 
				|| clr.getState() == CONSTANT.playing){
				clr.setState(CONSTANT.playing);
				clr.GameAllRestart();
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
