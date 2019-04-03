package views;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
//시작 메인페이지
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.BurgerConstant;

public class StartView extends JFrame {

	private JPanel pan;
	private JButton start,tutorial,stop;
	private JLabel lbg;
	private Font font;
	
	public StartView() {
		pan = new JPanel();
		start = new JButton(new ImageIcon("imgs/text/text_start_startview.png"));
		tutorial = new JButton(new ImageIcon("imgs/text/text_tutorial_startview.png"));
		stop = new JButton(new ImageIcon("imgs/text/text_stop_startview.png"));
		lbg = new JLabel(new ImageIcon("imgs/Background/main.png"));
		
		pan.setLayout(null);
	
		start.setBorderPainted(false);start.setContentAreaFilled(false);start.setFocusPainted(false);
		tutorial.setBorderPainted(false);tutorial.setContentAreaFilled(false);tutorial.setFocusPainted(false);
		stop.setBorderPainted(false);stop.setContentAreaFilled(false);stop.setFocusPainted(false);		
		
		start.setBounds(100, 500, 200, 50);
		tutorial.setBounds(420, 500, 200, 50);
		stop.setBounds(700, 500, 200, 50);
		
		lbg.setBounds(0, 0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		
		
		pan.add(start);
		pan.add(tutorial);
		pan.add(stop);
		pan.add(lbg);
		
		add(pan);
		
		start.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	Stage1 Stage1 = new Stage1();
            	dispose();
            }
        });
		tutorial.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	TutorialView TutorialView = new TutorialView();
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
		
		setFocusable(true);		//포커스 0맞추기
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		setVisible(true);
		setTitle("게살버거만들기");	
		
	}
	


	public static void main(String[] args) {
		new StartView();

	}

}
