package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ExceptionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.lang.model.type.NullType;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.BurgerConstant;
import handlers.BurgerHandler1;



 class finish extends Thread{
	
	
}
public class FinishView extends JFrame {
	
	private JPanel pan = new JPanel();
	private JLabel lblnext = new JLabel(new ImageIcon("imgs/Background/finish.png"));
	Stage1 stage1;
	Stage2 stage2;
	Stage3 stage3;
	Stage4 stage4;
	
	public FinishView(int stagenum){
		pan.setLayout(null);
		
		lblnext.setBounds(0, 0,BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		pan.add(lblnext);
		
		add(pan);
	
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		
			@Override
			public void run() {
				dispose();
				if(stagenum == 1) {
					dispose();
					stage2 = new Stage2();
				}
				if(stagenum == 2) {
					dispose();
					dispose();
					stage3 = new Stage3();
				}
				if(stagenum == 3) {
					dispose();
					dispose();
					Thread t = new Thread(new Stage4());
					t.start();
				}
				if(stagenum == 4) {
					dispose();
					ScoreSignUp sign = new ScoreSignUp();
				}
				
				dispose();
			}
		};timer.schedule(task, 3000);

		
		setFocusable(true);		//포커스 0맞추기
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,0,BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		setVisible(true);
		setTitle("게살버거만들기");	
	
		
	}

	public static void main(String[] args) {
		new FinishView(1);
	}

}
