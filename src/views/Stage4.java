package views;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;



public class Stage4 extends JFrame implements Runnable, KeyListener { 
	int num = 0;
	private BufferedImage bi = null;	
	private ArrayList enList = null;	
	private boolean left = false, right = false, up = false, down = false, fire = false;
	private boolean start = false, end = false;
	private int w = 1000, h = 800, x = 480, y = 750, xw = 20, xh = 20;   //(300, 500 비율)

	public Stage4() { 
		bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); 
		enList = new ArrayList();		
		this.addKeyListener(this);		
		this.setSize(w, h);				
		this.setTitle("BOSS Stage"); 
		this.setResizable(false);		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true); 		
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		
			@Override
			public void run() {
				dispose();
				FinishView fn = new FinishView(4);
				
			}
		};	
		timer.schedule(task, 6000);
		
	}

	public void run() { 
		try {								
			int enCnt = 0;
			
			while (true) {					
				Thread.sleep(10);			

				if (start) {				
					if (enCnt > 1800) {		
						enCreate();			
						enCnt = 0;
					} 
					enCnt += 25;			
					keyControl();			
					crashChk();				
				}
				draw();						
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void enCreate() {
		for (int i = 0; i < 9; i++) { 

			double rx = Math.random() * (w + xw);
			
			
			double ry = Math.random() * 800; 
			int an;
			do {
				an =(int) (Math.random() * (360 - 40 + 1)) + 360;
			}while(an<=360);
			Enemy en = new Enemy((int) rx, (int) ry, an);
			enList.add(en); 
		}
	}

	public void crashChk() {	
		
		
		
		Graphics g = this.getGraphics();				
		Polygon p = null;								

		for (int i = 0; i < enList.size(); i++) { 			
			Enemy e = (Enemy) enList.get(i);				
			
			
			int[] xpoints = { x, (x + xw), (x + xw), x };
			
		
			int[] ypoints = { y, y, (y + xh), (y + xh) };
			p = new Polygon(xpoints, ypoints, 4); 
			
		
			if (p.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {
				enList.remove(i);	
				start = false;		
				end = true;			
			}
		}
	}

	public void draw() {
		
		Graphics gs = bi.getGraphics(); 
		gs.setColor(Color.white);	
		gs.fillRect(0, 0, w, h);	
		gs.setColor(Color.black);	
		gs.drawString("Enemy 객체수 : " + enList.size(), 180, 50); 
		gs.drawString("게임시작 : Enter", 180, 90); 

		if (end) {
			gs.drawString("G A M E     O V E R", 100, 250);
			if(num == 0 ) {
			new PauseView();
			num = 1;
			}
		}

		gs.fillRect(x, y, xw+1, xh+1);	
		gs.setColor(Color.red);				
		for (int i = 0; i < enList.size(); i++) { 
			Enemy e = (Enemy) enList.get(i);	  
			gs.fillRect(e.x, e.y, e.w, e.h);	  
			if (e.y > h)						  
				enList.remove(i);				  
			e.moveEn();							 
		}

		Graphics ge = this.getGraphics();
		ge.drawImage(bi, 0, 0, w, h, this);
	}

	public void keyControl() {	
		if (0 < x) {		
			if (left)		
				x -= 3;		
		}
		if (w > x + xw) {	
			if (right)		
				x += 3;		
		}
		if (25 < y) {		
			if (up)			
				y -= 3;		
		}
		if (h > y + xh) {	
			if (down)		
				y += 3;		
		}
	}
	
	
	public void keyPressed(KeyEvent ke) {	
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:	
			left = true;		
			break;
		case KeyEvent.VK_RIGHT:	
			right = true;		
			break;
		case KeyEvent.VK_UP:	
			up = true;			
			break;
		case KeyEvent.VK_DOWN:	
			down = true;		
			break;
		case KeyEvent.VK_A:		
			fire = true;		
			break;
		case KeyEvent.VK_ENTER:	
			start = true;		
			end = false;		
			break;
		}
	}
	
	public void keyReleased(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:	
			left = false;		
			break;
		case KeyEvent.VK_RIGHT:	
			right = false;		
			break;
		case KeyEvent.VK_UP:	
			up = false;			
			break;
		case KeyEvent.VK_DOWN:	
			down = false;		
			break;
		case KeyEvent.VK_A:		
			fire = false;		
			break;
		}
	}

	public void keyTyped(KeyEvent ke) { 
	}

	public static void main(String[] args) {	
		Thread t = new Thread(new Stage4());		
		t.start();	// start : 쓰레드 시작 메소드
		
		
	
		
	}
}


class Enemy {	
	int x;	
	int y;	
	int w = 10;
	int h = 10; 
	int angle;

	public Enemy(int x, int y, int angle) { 
		this.x = x;				 
		this.y = y;	
		this.angle = angle;
	}

	public void moveEn() {
		x+= Math.sin(Math.toRadians(angle))+2;
		y+=Math.cos(Math.toRadians(angle))+1;
	}
}

