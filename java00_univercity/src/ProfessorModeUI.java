import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class ProfessorModeUI extends JFrame{
	
	JPanel northPane;
	JLabel northlb1; 
	JButton logout;

	JPanel leftMenuPane;
	String [] menuTitle = {"강의개설", "강의수정","강의목록","개인정보/수정"};
	Font font;
	
	
	
	public ProfessorModeUI() {
		
		init();
		
		setSize(1024,768);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void init() {
		setNorthPane(); //nothpanel 셋팅
		setLeftMenu(); //메뉴바
		
	}

	public void setNorthPane() {		
		
		northPane = new JPanel(new BorderLayout());	
		northPane.setBackground(new Color(33, 140, 116));
		
		northlb1 = new JLabel("notrhlb1"); //접속자 정보
		northlb1.setHorizontalAlignment(JLabel.CENTER);
		
	
		northlb1.setOpaque(true);
		northlb1.setBackground(new Color(33, 140, 116)); 
		northlb1.setForeground(Color.white);
		northlb1.setPreferredSize(new Dimension(900, 0)); 
		
		logout = new JButton("로그아웃");
		
		
		northPane.add(BorderLayout.WEST,northlb1); //접속한 사용자 정보 보여주는 JLabel 추가
		northPane.add(BorderLayout.EAST,logout); // 로그아웃버튼
		northPane.setPreferredSize(new Dimension(0, 35)); //사이즈조절
		add(BorderLayout.NORTH,northPane);
	}
	
	public void setLeftMenu() {
		leftMenuPane = new JPanel(new GridLayout(8,0));
		leftMenuPane.setPreferredSize(new Dimension(160, 0));//메뉴바패널 사이즈,위치
		leftMenuPane.setBackground(new Color(213, 213, 213));
		font = new Font("바탕", Font.BOLD, 17);

		for(int i=0; i<menuTitle.length; i++) {
			JButton jbt= new JButton(menuTitle[i]);
			jbt.setFont(font);	
			jbt.setBackground(new Color(213, 213, 213));
			leftMenuPane.add(jbt);
		}
		
		add(BorderLayout.WEST,leftMenuPane);
		
		
	}
	
	
	public static void main(String[] args) {
		new ProfessorModeUI();
	}

}
