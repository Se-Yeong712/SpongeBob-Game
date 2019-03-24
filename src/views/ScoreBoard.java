package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.BurgerConstant;

//누적등수 리스트
public class ScoreBoard extends JFrame{

	private ScoreSignUp signup;
	private JButton replay = new JButton(new ImageIcon("imgs/text/text_replay.png"));
	private JButton stop = new JButton(new ImageIcon("imgs/text/text_stop.png"));
	private JLabel lbg = new JLabel(new ImageIcon("imgs/Background/scoreboard.png"));
	public static int rank2 = ScoreSignUp.rank25;
	private JLabel printRank;
	public static String name2 = ScoreSignUp.name;
	private JLabel printname;

	public ScoreBoard() {
		
		setLayout(null);
		
		replay.setBorderPainted(false);replay.setContentAreaFilled(false);replay.setFocusPainted(false);
		stop.setBorderPainted(false);stop.setContentAreaFilled(false);stop.setFocusPainted(false);


		
		printRank = new JLabel(""+rank2);
		printname = new JLabel(""+name2);
		
		printRank.setBounds(40, 250, 100, 100);
		printname.setBounds(500, 200, 400, 200);
		
		add(printname);
		add(printRank);
		
		System.out.println(rank2);
		System.out.println(name2);
		
		printRank.setFont(new Font("DialogInput",Font.BOLD,100));
		printname.setFont(new Font("DialogInput",Font.BOLD,100));
		
		replay.setBounds(100, 600, 200, 50);
		stop.setBounds(700, 600, 200, 50);
		
		
		
		
		lbg.setBounds(0, 0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		
	
		
		add(replay);
		add(stop);
		add(lbg);
		
		
		replay.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	Stage1 stage1 = new Stage1();
            	
            }
        });

		stop.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				StopView stop = new StopView();
			}
		});
	
		
		
		
		setFocusable(true);		//포커스 0맞추기
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		setVisible(true);
		setTitle("당신의 등수는 ?");
	}

	
	public static void main(String[] args) {
		
		ScoreBoard scoreboard = new ScoreBoard();

	}
}
