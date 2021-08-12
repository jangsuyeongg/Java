package View.UI;

import Select.AllStateSession;
import View.MainIndex;
import View.Student.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentModeUI extends JFrame implements ActionListener {

    JPanel northPane;
    JLabel northlb1;
    JButton logout;

    JPanel leftMenuPane;
    String [] menuTitle = {"수강신청", "신청내역조회","수강신청취소","성적확인","개인정보/수정"};
    Font font;



    public StudentModeUI() {

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

        northlb1 = new JLabel("ID:"+ AllStateSession.login_id+"이름:"+AllStateSession.login_name+"학생");//접속자 정보 *******로그인 한 id **********); //접속자 정보 *******로그인 한 id **********
        northlb1.setHorizontalAlignment(JLabel.CENTER);


        northlb1.setOpaque(true);
        northlb1.setBackground(new Color(33, 140, 116));
        northlb1.setForeground(Color.white);
        northlb1.setPreferredSize(new Dimension(900, 0));

        logout = new JButton("로그아웃");


        northPane.add(BorderLayout.WEST,northlb1); //접속한 사용자 정보 보여주는 JLabel 추가
        northPane.add(BorderLayout.EAST,logout); // 로그아웃버튼
        northPane.setPreferredSize(new Dimension(0, 35)); //사이즈조절
        logout.addActionListener(this);
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
            jbt.addActionListener(this);
            leftMenuPane.add(jbt);
        }


        add(BorderLayout.WEST,leftMenuPane);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        Object eventButton =e.getActionCommand();
        //{"수강신청", "신청내역조회","수강신청취소","성적확인","개인정보/수정"};
        if(event==logout)
        {
            AllStateSession.login_id=null;
            AllStateSession.login_state=0;
            setVisible(false);
            new MainIndex();//메인으로 돌아감
        }
        else if(eventButton=="수강신청")
        {
            System.out.println("수강신청  들어옴");
            new StudentModeMain();
        }
        else if(eventButton=="신청내역조회")
        {
            new StudentModeMain2();
            System.out.println("신청내역조회 들어옴");

        }
        else if(eventButton=="수강신청취소")
        {
            System.out.println("수강신청취소  들어옴");
            new StudentMode_delete();
        }
        else if(eventButton=="성적확인")
        {
            System.out.println("성적확인");
            new StudentModeScore();

        }
        else if(eventButton=="개인정보/수정")
        {
            System.out.println("개인정보/수정");
            new StudentModeProfile();
        }

    }

    public static void main(String[] args) {
        new StudentModeUI();
    }

}
