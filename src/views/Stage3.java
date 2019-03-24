package views;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.event.*;

import audios.BGMusic2;
import audios.BGMusic3;
import audios.IngredientAudio;
import constants.BurgerConstant;
import handlers.BurgerHandler1;

//import BugerHandler1;
//import BugerHandler2;

import java.net.*;
import java.util.Timer;
import java.util.TimerTask;


class GamePanel3 extends JPanel {
	private JLabel lblback = new JLabel(new ImageIcon("imgs/Background/stage1.png"));
	private JButton pause = new JButton(new ImageIcon("imgs/icon/pause.png"));
	private JButton stop = new JButton(new ImageIcon("imgs/icon/stop.png"));
	private JLabel lbl,lblscoreimg;
	public static JLabel lblscore;
	public static int score = GamePanel2.score,chk;
	private Stage2 view;
	
	
	private JLabel[] lblfriend,lblingredient;
	private int[] instartX,inendX,instartY,inendY;
	private int[] ingredientX = {100,500,100,300,700,800};	//재료의 X좌표
	private int[] ingredientY = {300,400,650,100,100,600};		//재료의 Y좌표
//								빵, 패티, 양파, 토마토, 양상추, 소스
	
	private boolean prev_status_hit = false;
	
	boolean left = false, right = false, up = false, down = false, fire = false;
    TargetThread3 targetThread3;
    TargetThread4 targetThread4;
     JLabel target1,target2;
     JLabel my = new JLabel();
    private GamePanel2 l;

    
    public JLabel getMy() {
		return my;
	}


	public void setMy(JLabel my) {
		this.my = my;
	}
	
	   
    public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
class SponzibapKeyAdapter extends KeyAdapter {
		
		int x = my.getX();
		int y = my.getY();
		@Override
		public void keyPressed(KeyEvent e) {
			
			boolean object_hit = false;
			int keycode = e.getKeyCode();
			int x = my.getX();
			int y = my.getY();
			
			if(chk == 6){
				FinishView fn = new FinishView(3);
			}
			

			for (int i = 0; i < ingredientX.length; i++) {
				if(x >instartX[i] && x < inendX[i] )
					if(y > instartY[i] && y < inendY[i]) {	
						if(!prev_status_hit) {
							
							//remove
							instartX[i] = -10;
							instartY[i] = -10;
							
							ingredientX[i] = -10;
							ingredientY[i] = -10;
							lblingredient[i].setBounds(ingredientX[i],ingredientY[i],0,0);
							
							for (int j = 0; j < inendX.length; j++) {
								instartX[i] = ingredientX[i] - 100;
								inendX[i] = ingredientX[i] + 100;
								
								instartY[i] = ingredientY[i] - 100;
								inendY[i] = ingredientY[i] + 100;
							}//for
							
							remove(lblingredient[i]);
							
							score += 10;
							lblscore.setText(""+score);
							new IngredientAudio();
							prev_status_hit = true;
							chk++;
						}
						object_hit = true;
					}
			}//for ingredient
			
			prev_status_hit = object_hit;
			
			
			
			//System.out.println(x+" , "+y);
			
			switch (keycode) { 
			case KeyEvent.VK_LEFT:	
				if(x == 0)
					my.setLocation(x, y);	
				else 
					my.setLocation(x-10, y);
				my.setIcon(new ImageIcon("imgs/bab/bab_L.png"));
				break;
			case KeyEvent.VK_RIGHT:	 
				if(x == BurgerConstant.JFRAME_WIDTH - BurgerConstant.BAB_JLABEL_WIDTH - 20)
					my.setLocation(x, y);	
				else 
					my.setLocation(x+10, y);
				my.setIcon(new ImageIcon("imgs/bab/bab_R.png"));
				break;
			case KeyEvent.VK_UP:	
				if(y == 0)
					my.setLocation(x, y);	
				else 
					my.setLocation(x, y-10);
				my.setIcon(new ImageIcon("imgs/bab/bab_U.png"));
				break;
			case KeyEvent.VK_DOWN:	
				if(y == BurgerConstant.JFRAME_HEIGHT - BurgerConstant.BAB_JLABEL_HEIGHT-50)
					my.setLocation(x, y);	
				else 
					my.setLocation(x, y+10);
				my.setIcon(new ImageIcon("imgs/bab/bab_D.png"));
				break;
			}
		}
	}


	//AudioClip sound;
    GamePanel3(){
        this.setLayout(null);
        
        pause.setBorderPainted(false);pause.setContentAreaFilled(false);pause.setFocusPainted(false);
		stop.setBorderPainted(false);stop.setContentAreaFilled(false);stop.setFocusPainted(false);
		
		lblback.setBounds(0, 0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		
		pause.setBounds(870, 0, 70, 70);
		stop.setBounds(920, 0, 70, 70);

		pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PauseView pv1 = new PauseView();
				
			}
		});
		
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StopView stop = new StopView();
				//dispose();
				
			}
		});
        

		lblscoreimg = new JLabel(new ImageIcon("imgs/text/text_score.png"));
		lblscoreimg.setBounds(650,5,150,70);
		add(lblscoreimg);
		
		lblscore = new JLabel(""+score);
		lblscore.setBounds(780,0,100,70);
		add(lblscore);
		lblscore.setFont(new Font("DialogInput",Font.BOLD,55));


        target1 = new JLabel(new ImageIcon("imgs/friend/friend1.png"));
        target1.setSize(BurgerConstant.FRIEND_JLABEL_WIDTH,BurgerConstant.FRIEND_JLABEL_HEIGHT);
        this.add(target1);
        
        target2 = new JLabel(new ImageIcon("imgs/friend/friend2.png"));
        target2.setSize(BurgerConstant.FRIEND_JLABEL_WIDTH,BurgerConstant.FRIEND_JLABEL_HEIGHT);
        this.add(target2);

        my = new JLabel(new ImageIcon("imgs/bab/bab_D.png"));
        my.setSize(BurgerConstant.BAB_JLABEL_WIDTH,BurgerConstant.BAB_JLABEL_HEIGHT);
        this.add(my);
        
        //lblfriend = new JLabel[friendX.length];
		lblingredient = new JLabel[ingredientX.length];
		
		this.instartX = new int[ingredientX.length];
		this.inendX = new int[ingredientX.length];
		this.instartY = new int[ingredientX.length];
		this.inendY = new int[ingredientX.length];
		for (int i = 0; i < inendX.length; i++) {
			instartX[i] = ingredientX[i] - 100;
			inendX[i] = ingredientX[i] + 100;
			
			instartY[i] = ingredientY[i] - 100;
			inendY[i] = ingredientY[i] + 100;
		}//for
        
        addKeyListener(new SponzibapKeyAdapter());

        for (int i = 0; i < ingredientX.length; i++) {
			lblingredient[i] = new JLabel(new ImageIcon("imgs/ingredients/ingredient"+ (i+1) +".png"));
			lblingredient[i].setBounds(ingredientX[i], ingredientY[i],  100,100);
			add(lblingredient[i]);
		}
        
        
        
		this.add(stop);
		this.add(pause);
		this.add(lblback);
    }
    

	public JLabel getLblscore() {
		return lblscore;
	}

	public void setLblscore(JLabel lblscore) {
		this.lblscore = lblscore;
	}

	public void startGame(){
    	BulletThread3 bulletThread3 = null;
    	BulletThread4 bulletThread4 = null;
    	target1.setLocation(0, 0);
        target2.setLocation(0, 400);
        my.setLocation(400,0);

        targetThread3 = new TargetThread3(target1);
        targetThread3.start();
        
        targetThread4 = new TargetThread4(target2);
        targetThread4.start();
        

       bulletThread3 = new BulletThread3(my,target1,targetThread3);
       bulletThread3.start();
       
       bulletThread4 = new BulletThread4(my,target2,targetThread4);
       bulletThread4.start();

    }
   
}
    class TargetThread3 extends Thread{
        JLabel target;
        TargetThread3(JLabel target){
            this.target=target;
            target.setLocation(0, 0);
        }
        public void run(){
            while(true){
            	int xx = target.getX();
            	int yy = target.getY();
                int x=(int) (xx+Math.cos(Math.toRadians(30))*5);
                int y=(int) (yy+Math.sin(Math.toRadians(30))*5);
                
                //프레임 밖으로 나갈경우
                if(x>990)
                    target.setLocation(0, 0);
                else
                    target.setLocation(x, y);
                
                try{
                    sleep(90);
                }
                //스레드가 죽게되면 초기 위치에 위치하고, 0.5초를 기다린다.
                catch(Exception e){
                    target.setLocation(0, 0);
                    try{
                        sleep(500);
                    }
                    catch(Exception e2){}
                }
            }
        }
    }
    
    class BulletThread3 extends Thread{
        JLabel target;
        JLabel my;
        Thread targetThread;
        
        public BulletThread3(JLabel target, JLabel my, Thread targetThread){
            this.my=my;
            this.target=target;
            this.targetThread=targetThread;
        }
        
        
//        public int minusscore(){
//        	return -10;
//        }
//        
        public void run(){
            while(true){
                if(hit()){//타겟이 맞았다면
                    targetThread.interrupt();//타겟 스레드를 죽인다.
                    GamePanel3.score -= 10;
                    GamePanel3.lblscore.setText(""+GamePanel3.score);
                    return;//총알 스레드도 죽인다.
                }
      
                try{
                    sleep(20);
                }
                
                catch(Exception e){}
            }
        }
        
        private boolean hit(){
            int x=my.getX();
            int y=my.getY();
            int w=my.getWidth();
            int h=my.getHeight();
            
            if(targetContains(x,y)
                    ||targetContains(x+w-1,y)
                    ||targetContains(x+w-1,y+h-1)
                    ||targetContains(x,y+h-1))
                return true;
            else
                return false;
        }
        private boolean targetContains(int x, int y){
            //타겟의 x좌표가 총알 x좌표보다 작거나 같으며 총알 x좌표보다 타겟 x좌표 + 타겟의 가로 길이가 크고 
            if(((target.getX()<=x)&&(x<target.getX()+target.getWidth()))   
                    //타겟의 y좌표가 총알 y좌표보다 작거나 같으며 총알 y좌표보다 타겟 y좌표 + 타겟의 세로 길이가 크면
                    &&((target.getY()<=y)&&(y<target.getY()+target.getHeight())))
                return true;
            
            else
                return false;
        }
    }
    
    
    class TargetThread4 extends Thread{
        JLabel target;
        TargetThread4(JLabel target){
            this.target=target;
            target.setLocation(0, 0);
        }
        public void run(){
            while(true){
            	int xx = target.getX();
                int x=(int) (xx+Math.sin(Math.toRadians(30))*5);
                
                //프레임 밖으로 나갈경우
                if(x>990)
                    target.setLocation(0, 0);
                else
                    target.setLocation(x,300);
                
                try{
                    sleep(10);
                }
                //스레드가 죽게되면 초기 위치에 위치하고, 0.5초를 기다린다.
                catch(Exception e){
                    target.setLocation(0, 0);
                    try{
                        sleep(500);
                    }
                    catch(Exception e2){}
                }
            }
        }
    }
    
    class BulletThread4 extends Thread{
        JLabel target;
        JLabel my;
        Thread targetThread;
        
        public BulletThread4(JLabel target, JLabel my, Thread targetThread){
            this.my=my;
            this.target=target;
            this.targetThread=targetThread;
        }
        
        public void run(){
            while(true){
                if(hit()){//타겟이 맞았다면
                    targetThread.interrupt();//타겟 스레드를 죽인다.
                    GamePanel3.score -= 10;
                    GamePanel3.lblscore.setText(""+GamePanel3.score);
                    return;//총알 스레드도 죽인다.
                }
      
                try{
                    sleep(20);
                }
                
                catch(Exception e){}
            }
        }
        
        private boolean hit(){
            int x=my.getX();
            int y=my.getY();
            int w=my.getWidth();
            int h=my.getHeight();
            
            if(targetContains(x,y)
                    ||targetContains(x+w-1,y)
                    ||targetContains(x+w-1,y+h-1)
                    ||targetContains(x,y+h-1))
                return true;
            else
                return false;
        }
        private boolean targetContains(int x, int y){
            //타겟의 x좌표가 총알 x좌표보다 작거나 같으며 총알 x좌표보다 타겟 x좌표 + 타겟의 가로 길이가 크고 
            if(((target.getX()<=x)&&(x<target.getX()+target.getWidth()))   
                    //타겟의 y좌표가 총알 y좌표보다 작거나 같으며 총알 y좌표보다 타겟 y좌표 + 타겟의 세로 길이가 크면
                    &&((target.getY()<=y)&&(y<target.getY()+target.getHeight())))
                return true;
            
            else
                return false;
        }
    }


public class Stage3 extends JFrame{
	public int sc = GamePanel2.score + 50;

	
	public Stage3() {
			dispose();
			dispose();
			dispose();
		  	setTitle("게살버거 만들기");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        GamePanel3 p = new GamePanel3();
	        add(p);
	        p.setScore(sc);
	        
	        setSize(1000,800);
	        setResizable(false);
	        setVisible(true);
	        p.startGame();
	        p.requestFocus();
	        new BGMusic3();
	}
	
	

	
    public static void main(String[] args) {
    	 new Stage3();
    	 
    } 
    
       
}