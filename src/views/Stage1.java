package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.StyledEditorKit.FontSizeAction;

import constants.BurgerConstant;
import handlers.BurgerHandler1;

//stage1
public class Stage1 extends JFrame{
	
	//private JPanel pan = new JPanel();
	private JLabel lblback = new JLabel(new ImageIcon("imgs/Background/stage1.png"));
	private JButton pause = new JButton(new ImageIcon("imgs/icon/pause.png"));
	private JButton stop = new JButton(new ImageIcon("imgs/icon/stop.png"));
	
	private BurgerHandler1 l;
	private JLabel lbl,lblscoreimg,lblscore;
	public static int score;
	private JLabel[] lblfriend,lblingredient;
	
	
	private int[] friendX = {600,100,50,800};		//친구의 X좌표	
	private int[] friendY = {150,50,600,600};			//친구의 Y좌표
//							뚱이, 다람이, 징징이, 핑핑이
	private int[] ingredientX = {250,400,600,400,800,850};	//재료의 X좌표
	private int[] ingredientY = {300,200,500,600,400,150};	//재료의 Y좌표
//								빵, 패티, 양파, 토마토, 양상추, 소스

	public Stage1() {	

		BevelBorder border = new BevelBorder(BevelBorder.RAISED);
				
		pause.setBorderPainted(false);pause.setContentAreaFilled(false);pause.setFocusPainted(false);
		stop.setBorderPainted(false);stop.setContentAreaFilled(false);stop.setFocusPainted(false);
		
		lblback.setBounds(0, 0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		
		pause.setBounds(870, 0, 70, 70);
		stop.setBounds(920, 0, 70, 70);

		pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PauseView pv1 = new PauseView();
				dispose();
			}
		});
		
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StopView stop = new StopView();
				dispose();
				
			}
		});
		
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		
		//점수
		lblscoreimg = new JLabel(new ImageIcon("imgs/text/text_score.png"));
		lblscoreimg.setBounds(650,5,150,70);
		add(lblscoreimg);
		
		lblscore = new JLabel(""+score);
		lblscore.setBounds(780,0,100,70);
		add(lblscore);
		lblscore.setFont(new Font("DialogInput",Font.BOLD,55));

		
		//스폰지밥
		ImageIcon icon = new ImageIcon("imgs/bab/bab_D.png");	
		lbl = new JLabel(icon);
		lbl.setBounds(400, 0, BurgerConstant.BAB_JLABEL_WIDTH, BurgerConstant.BAB_JLABEL_HEIGHT);
		add(lbl);
		
		lblfriend = new JLabel[friendX.length];
		lblingredient = new JLabel[ingredientX.length];
		
		//friend 라벨
		for (int i = 0; i < friendX.length; i++) {
			lblfriend[i] = new JLabel(new ImageIcon("imgs/friend/friend"+ (i+1) +".png"));
			lblfriend[i].setBounds(friendX[i], friendY[i], BurgerConstant.FRIEND_JLABEL_WIDTH, BurgerConstant.FRIEND_JLABEL_HEIGHT);
			add(lblfriend[i]);
		}
		
		//ingredient 라벨
		for (int i = 0; i < ingredientX.length; i++) {
			lblingredient[i] = new JLabel(new ImageIcon("imgs/ingredients/ingredient"+ (i+1) +".png"));
			lblingredient[i].setBounds(ingredientX[i], ingredientY[i], BurgerConstant.INGREDIENT_JLABEL_WIDTH, BurgerConstant.INGREDIENT_JLABEL_HEIGHT);
			add(lblingredient[i]);
		}
		
		l=new BurgerHandler1(this);
		addKeyListener(l);
		
		add(stop);
		add(pause);
		add(lblback);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		
			@Override
			public void run() {
				
				
				try {
					TimerView tv = new TimerView();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		timer.schedule(task,180000);
		
		setFocusable(true);		//포커스 0맞추기
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		setVisible(true);
		setTitle("게살버거만들기");
		
		
	}
	
	public void remove(int i) {
		lblingredient[i].setBounds(ingredientX[i],ingredientY[i],0,0);
		remove(lblingredient[i]);
		
		
	}
	
	
	//좌표 getter, setter
		public int[] getFriendX() {
			return friendX;
		}

		public int[] getFriendY() {
			return friendY;
		}

		public int[] getIngredientX() {
			return ingredientX;
		}

		public int[] getIngredientY() {
			return ingredientY;
		}

		//lbl getter
		public JLabel getLbl() {
			return lbl;
		}
		
		//lblScore getter
		public JLabel getLblScore() {
			return lblscore;
		}
				
		//score getter,setter
		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
		public BurgerHandler1 getL() {
			return l;
		}
		
		

	
	public static void main(String[] args) {
		Stage1 stage1 = new Stage1();
		
		

	}

}



