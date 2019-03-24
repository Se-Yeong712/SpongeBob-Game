package views;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.BurgerConstant;

public class TimerView extends JFrame{
	private JPanel pan = new JPanel();
	private JLabel lbg;
	
	public TimerView() throws InterruptedException {
		lbg = new JLabel(new ImageIcon("imgs/Background/timeout.png"));
		
		pan.setLayout(null);
		lbg.setBounds(0, 0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		pan.add(lbg);
		add(pan);
		
	
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		
			@Override
			public void run() {
				dispose();
				PauseView pv = new PauseView();
				dispose();
			}
		};
		
		timer.schedule(task, 1000);
		
		
		
		setFocusable(true);		//포커스 0맞추기
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,10, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args) throws InterruptedException {
		new TimerView();

	}

}
