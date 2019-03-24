package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.BurgerConstant;

public class TutorialView extends JFrame{
	
	private JPanel pan = new JPanel(); 	
	private JButton start = new JButton(new ImageIcon("imgs/text/text_start.png"));
	private JButton stop = new JButton(new ImageIcon("imgs/text/text_stop.png"));
	private JLabel lbg = new JLabel(new ImageIcon("imgs/Background/tutorial.png"));


	public TutorialView() {

		
		pan.setLayout(null);
		
		start.setBorderPainted(false);start.setContentAreaFilled(false);start.setFocusPainted(false);
		stop.setBorderPainted(false);stop.setContentAreaFilled(false);stop.setFocusPainted(false);

		
		start.setBounds(100, 500, 200, 50);
		stop.setBounds(700, 500, 200, 50);
		
		lbg.setBounds(0, 0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		
		
		pan.add(start);
		pan.add(stop);
		pan.add(lbg);
		
		add(pan);
		
		start.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	Stage1 Stage1 = new Stage1();
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
		setTitle("게살버거만들기");
	}

	public static void main(String[] args) {
		new TutorialView();
	}

}
