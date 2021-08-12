package View.Admin;

import Select.AllStateSession;
import View.Admin.ProFessor.ClassMain;
import View.Admin.ProFessor.ProfessorMain;
import View.Admin.ProFessor.ProfessorMain_insert;
import View.Admin.Student.StudentMain;
import View.Admin.Student.StudentMain2;
import View.MainIndex;
import View.Notice.NoticeDetail;
import View.Notice.NoticeMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainPage extends JFrame implements ActionListener {
	String id = AllStateSession.login_id;
	JPanel northPane;
	JLabel northlb1; 
	JButton logout;

	JPanel leftMenuPane;
	String menuTitle[] = {"공지사항목록","공지사항작성", "강의정보관리","교수정보관리","교수추가","학생정보관리","학생정보개설"};
	JButton jbt[];
	Font font;	
	
	JPanel centerP;
	JPanel centerP_northP;
			JPanel northP_north;
			JPanel northP_center;
			
			
	ImageIcon icon;
	Image imageIcon;
	Image changeimg;
	ImageIcon changeIcon;
	JLabel lb1;

		
	public AdminMainPage() {
		init();
		addComponent();//***
		
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
		
		northlb1 = new JLabel("ID:"+AllStateSession.login_id+"이름:"+AllStateSession.login_name);//접속자 정보 *******로그인 한 id **********); //접속자 정보 *******로그인 한 id **********
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
		logout.addActionListener(this);
	}
	
	public void setLeftMenu() {
		leftMenuPane = new JPanel(new GridLayout(8,0));
		leftMenuPane.setPreferredSize(new Dimension(160, 0));//메뉴바패널 사이즈,위치
		leftMenuPane.setBackground(new Color(213, 213, 213));
		font = new Font("바탕", Font.BOLD, 20);

		for(int i=0; i<menuTitle.length; i++) {
			JButton jbt= new JButton(menuTitle[i]);
			jbt.setFont(font);
			jbt.setBackground(new Color(213, 213, 213));
			leftMenuPane.add(jbt);
			jbt.addActionListener(this);
		}
		add(BorderLayout.WEST,leftMenuPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		Object eventButton =e.getActionCommand();
		if(event==logout)
		{
			AllStateSession.login_id=null;
			AllStateSession.login_state=0;
			setVisible(false);
			new MainIndex();//메인으로 돌아감
		}
		else if(eventButton.equals("공지사항목록"))
		{
			new NoticeMain();
			//setVisible(false);
			System.out.println("공지사항 눌러짐");
		}
		else if(eventButton.equals("공지사항작성"))
		{
			new NoticeDetail();
			System.out.println("공지사항작성");
		}
		else if(eventButton.equals("강의정보관리"))
		{
			new ClassMain();
			System.out.println("강의정보관리");
		}
		else if(eventButton.equals("교수정보관리"))
		{
			System.out.println("교수정보관리들어감");
			new ProfessorMain();
		}
		else if(eventButton.equals("교수추가"))
		{
			System.out.println("교수추가");
			new ProfessorMain_insert();
		}
		else if(eventButton.equals("학생정보관리"))
		{
			new StudentMain();
			System.out.println("학생정보관리");
		}
		else if(eventButton.equals("학생정보개설"))
		{
			new StudentMain2();
			System.out.println("학생정보개설");
		}
	}


	//------------------------------------------------------------------
	
	public void addComponent() {
		
		centerP = new JPanel(new BorderLayout());
		//add(BorderLayout.CENTER,centerP);
			centerP_northP = new JPanel(new BorderLayout());
				northP_north = new JPanel();//여백..색상만
				northP_north.setPreferredSize(new Dimension(0,50));
				//northP_north.setBackground(Color.white);
				northP_center = new JPanel();//사진
					icon= new ImageIcon("src/img/campusimg.jpg");
					imageIcon = icon.getImage();
					changeimg = imageIcon.getScaledInstance(890,200,java.awt.Image.SCALE_SMOOTH);
					changeIcon = new ImageIcon(changeimg);
					lb1 = new JLabel(changeIcon);
				
				northP_center.add(lb1);
				
			centerP.add(BorderLayout.NORTH,northP_north);
			centerP.add(BorderLayout.CENTER,northP_center);
			add(BorderLayout.CENTER,centerP);
	}

	public static void main(String[] args) {
		new AdminMainPage();
	}


}
