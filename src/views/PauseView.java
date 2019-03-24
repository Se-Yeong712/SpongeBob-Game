package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.BurgerConstant;

//일시정지 화면
public class PauseView extends JFrame{
	
	JPanel pan = new JPanel();
	JLabel lblpause = new JLabel(new ImageIcon("imgs/Background/pausebackground.png"));
	
	JButton replay = new JButton(new ImageIcon("imgs/text/text_replay.png"));
	JButton stop = new JButton(new ImageIcon("imgs/text/text_stop.png"));
	
	public PauseView() {
		
		pan.setLayout(null);
		
		
		replay.setBorderPainted(false);replay.setContentAreaFilled(false);replay.setFocusPainted(false);
		stop.setBorderPainted(false);stop.setContentAreaFilled(false);stop.setFocusPainted(false);		
		

		replay.setBounds(200, 200, 200, 100);
		stop.setBounds(400, 200, 200, 100);
		
		lblpause.setBounds(0, 0,800, 500);
		
		

		pan.add(replay);
		pan.add(stop);
		pan.add(lblpause);
		
		add(pan);
		
		
		replay.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	
            	Stage1 Stage1 = new Stage1();
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
		setBounds(100,150, 800, 500);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new PauseView();

	}

}
