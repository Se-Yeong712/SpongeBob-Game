package handlers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import constants.BurgerConstant;
import views.FinishView;
import views.ScoreSignUp;
import views.Stage1;
import views.Stage2;
import views.Stage3;

//핸들러
public class BurgerHandler2 extends KeyAdapter{

	private JLabel lbl;
	private Stage1 view;
	private Stage2 stage2;
	
	private int[] friendX,friendY,ingredientX, ingredientY;
	private int[] frstartX,frendX,frstartY,frendY;
	private int[] instartX,inendX,instartY,inendY;
	private JLabel lblScore;
	private boolean prev_status_hit = false;
	public static int chk;
	
	//public BGMusic1 bgm = new BGMusic1();
	
	public BurgerHandler2(Stage1 view) {
		super();
		this.view = view;
		this.lbl = view.getLbl();
		this.lblScore = view.getLblScore();
		this.friendX = view.getFriendX();
		this.friendY = view.getFriendY();
		this.ingredientX = view.getIngredientX();
		this.ingredientY = view.getIngredientY();
		
		//friend에 대한 코드
		this.frstartX = new int[friendX.length];
		this.frendX = new int[friendX.length];
		this.frstartY = new int[friendX.length];
		this.frendY = new int[friendX.length];
		
		for (int i = 0; i < frendX.length; i++) {
			frstartX[i] = friendX[i] - BurgerConstant.FRIEND_JLABEL_WIDTH;
			frendX[i] = friendX[i] + BurgerConstant.FRIEND_JLABEL_WIDTH;
			
			frstartY[i] = friendY[i] - BurgerConstant.FRIEND_JLABEL_WIDTH;
			frendY[i] = friendY[i] + BurgerConstant.FRIEND_JLABEL_WIDTH;
		}//for
		
		
		//ingredient에 대한 코드
		this.instartX = new int[ingredientX.length];
		this.inendX = new int[ingredientX.length];
		this.instartY = new int[ingredientX.length];	
		this.inendY = new int[ingredientX.length];
		for (int i = 0; i < inendX.length; i++) {
			instartX[i] = ingredientX[i] - BurgerConstant.INGREDIENT_JLABEL_WIDTH;
			inendX[i] = ingredientX[i] + BurgerConstant.INGREDIENT_JLABEL_WIDTH;
			
			instartY[i] = ingredientY[i] - BurgerConstant.INGREDIENT_JLABEL_WIDTH;
			inendY[i] = ingredientY[i] + BurgerConstant.INGREDIENT_JLABEL_WIDTH;
		}//for
		
	}
	

	

	@Override
	public void keyPressed(KeyEvent e) {
		boolean object_hit = false;
		if(chk == 6){
			//bgm = null;
			view.dispose();
			chk = 0 ;
			FinishView fn = new FinishView(1);
		}
			
		int x = lbl.getX();
		int y = lbl.getY();
		
//		친구의 위치를 확인해서 점수감소
		for (int i = 0; i < friendX.length; i++) {
			if(x > frstartX[i]  && x < frendX[i] )
				if(y > frstartY[i] && y < frendY[i]) {
					if(!prev_status_hit) {		//이전에 부딪힌적이 없다면 -> 점수감소
					view.setScore(view.getScore() - 10);
					lblScore.setText(""+view.getScore());
					prev_status_hit = true;
					}
					object_hit = true;
				}
					
		}//for friend
		
//		재료의 위치를 확인해서 점수증가
		for (int i = 0; i < ingredientX.length; i++) {
			if(x >instartX[i] && x -100 < inendX[i] && y > instartY[i] && y < inendY[i])
				if(true) {	
					if(!prev_status_hit) {
						instartX[i] = -10;
						instartY[i] = -10;
						
						ingredientX[i] = -10;
						ingredientY[i] = -10;
						
						view.remove(i);	
						
						for (int j = 0; j < inendX.length; j++) {
							instartX[i] = ingredientX[i] - 100;
							inendX[i] = ingredientX[i] + 100;
							
							instartY[i] = ingredientY[i] - 100;
							inendY[i] = ingredientY[i] + 100;
						}//for
						
						view.setScore(view.getScore() + 10);
						lblScore.setText(""+view.getScore());
						prev_status_hit = true;
						chk++;
					}
					object_hit = true;
				}
			
			
		}//for ingredient
		
		prev_status_hit = object_hit;
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if(x == BurgerConstant.JFRAME_WIDTH - BurgerConstant.BAB_JLABEL_WIDTH - 20)
				lbl.setLocation(x,y);
			else 
				lbl.setLocation(x + 10,y);
			
			lbl.setIcon(new ImageIcon("imgs/bab/bab_R.png"));
			break;
			
		case KeyEvent.VK_LEFT:
			if(x == 0)
				lbl.setLocation(x,y);
			else
				lbl.setLocation(x - 10,y);
			
			lbl.setIcon(new ImageIcon("imgs/bab/bab_L.png"));
			break;
			
		case KeyEvent.VK_UP:
			if(y == 0)
				lbl.setLocation(x,y);
			else
				lbl.setLocation(x,y - 10);
			
			lbl.setIcon(new ImageIcon("imgs/bab/bab_U.png"));
			break;
			
		case KeyEvent.VK_DOWN:
			if(y == BurgerConstant.JFRAME_HEIGHT - BurgerConstant.BAB_JLABEL_HEIGHT-50) {		//제목 표시줄 높이 -30을 해줘야한다.
				lbl.setLocation(x,y);
			}
			else {
				lbl.setLocation(x,y + 10);
			}
			lbl.setIcon(new ImageIcon("imgs/bab/bab_D.png"));
			break;
		}//switch
		
		}
	


	
	@Override
	public void keyTyped(KeyEvent e) {		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {	
		
	}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
