package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.BurgerConstant;
import views.*;



//점수 및 이름 등록
public class ScoreSignUp extends JFrame{
    Stage2 stage = null;	
	private JButton score = new JButton(new ImageIcon("imgs/text/text_signup.png"));
	private JButton stop = new JButton(new ImageIcon("imgs/text/text_stop.png"));
	private JLabel lbg = new JLabel(new ImageIcon("imgs/Background/scoresignup.png"));
	private JTextField textfield = new JTextField(15);
	public static int allScore = (GamePanel3.score + 100); 
	public JLabel lblscore;
	public static int rank25;
	public static String name;
	


	public ScoreSignUp() {
		System.out.println(allScore);
		setLayout(null);
		
		
		score.setBorderPainted(false);score.setContentAreaFilled(false);score.setFocusPainted(false);
		stop.setBorderPainted(false);stop.setContentAreaFilled(false);stop.setFocusPainted(false);
		
	
		
		lblscore = new JLabel(""+ allScore);
		lblscore.setBounds(500, 50, 400, 200);
		add(lblscore);
		lblscore.setFont(new Font("DialogInput",Font.BOLD,70));
		
		
		score.setBounds(100, 600, 200, 50);
		stop.setBounds(700, 600, 200, 50);
		
		textfield.setBounds(500, 400, 200, 50);
		
		lbg.setBounds(0, 0, BurgerConstant.JFRAME_WIDTH, BurgerConstant.JFRAME_HEIGHT);
		
		add(score);
		add(stop);
		add(lbg);
		add(textfield);
		
		
		
		score.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	name = textfield.getText();
            	ScoreBoard scoreboard = new ScoreBoard();
            	
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
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		//Class.forName("org.sqlite.JDBC");			
		Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		String winner = "";
		String you="";
		String v1="";
		int v2;
		int total, temp;
		ArrayList<Integer> scores = null;
		scores = new ArrayList<>();

		PreparedStatement ps = connection.prepareStatement("insert into ranking values(?,?)");
		ps.setString(1, name);
		ps.setInt(2, allScore);
		int res = ps.executeUpdate();
		if(res==1) {
			System.out.println("성공");
		}
		ps.close();
		
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery("SELECT name, score FROM ranking");
		
		
while(rs.next()) {
			
			
			v1 = rs.getString("name");
			v2 = rs.getInt("score");
			
			scores.add(v2);
			System.out.println(v1);
			System.out.println(v2);

		}


				you = v1;
				
				Collections.sort(scores);
				total = scores.size();
	

					for(int i=total-1;i>=0;i--) {
						temp=scores.get(i);
						System.out.println(temp);
						if(allScore==temp) {
							rank25=total-i;
							System.out.println(you+"등수 : "+rank25);
						}

					}
					

		
		s.close();
		rs.close();
		
		
		
		connection.close();
		
		if(rank25==1) {
			WinView win = new WinView();		
		}
		else {
			ScoreBoard sb = new ScoreBoard();
		}
		
		
	}

	
	}
