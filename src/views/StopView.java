package views;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.BurgerConstant;

//����ȭ�� 3�� �� ȭ�� �����
public class StopView extends JFrame{
	private JPanel pan;
	private JLabel lbg;
	
	public StopView() {
		
		pan = new JPanel();
		lbg = new JLabel(new ImageIcon("imgs/Background/end.png"));
		
		pan.setLayout(null);
		lbg.setBounds(0, 0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		pan.add(lbg);
		add(pan);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.exit(0);
			}
		};
		
		timer.schedule(task, 1000);
		
		
		
		setFocusable(true);		//��Ŀ�� 0���߱�
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		setVisible(true);
		setTitle("�Ի���Ÿ����");	
	
	}
	
	public static void main(String[] args) {
		
		new StopView();	

	}
}
