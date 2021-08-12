package View.UI;

import Select.AllStateSession;
import View.MainIndex;
import View.Professor.ProfessorModeMain;
import View.Professor.ProfessorModeMain2;
import View.Professor.ProfessorModeProfile;
import View.Professor.ProfessorMode_insert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorModeUI extends JFrame implements ActionListener {

    JPanel northPane;
    JLabel northlb1;
    JButton logout;

    JPanel leftMenuPane;
    String [] menuTitle = {"강의정보관리", "수강학생목록","강의개설","개인정보/수정"};
    Font font;



    public ProfessorModeUI() {

        init();

        setSize(1024,768);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void ProfessorModeUI2() {

        setNorthPane(); //nothpanel 셋팅

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

        northlb1 = new JLabel("ID:"+ AllStateSession.login_id+"이름:"+AllStateSession.login_name+" 교수님");//접속자 정보 *******로그인 한 id **********); //접속자 정보 *******로그인 한 id **********
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
            jbt.addActionListener(this);
            //{"강의정보관리", "수강학생목록","강의개설","개인정보/수정"};
        }

        add(BorderLayout.WEST,leftMenuPane);

        logout.addActionListener(this);
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
        else if(eventButton=="강의정보관리")
        {
            System.out.println("강의정보관리  들어옴");
            new ProfessorModeMain();
        }
        else if(eventButton=="수강학생목록")
        {
            System.out.println("수강학생목록 들어옴");
            new ProfessorModeMain2();
        }
        else if(eventButton=="강의개설")
        {
            System.out.println("강의개설  들어옴");
            new ProfessorMode_insert();
        }
        else if(eventButton=="강의개설")
        {
            System.out.println("개인정보/수정");
            new ProfessorModeProfile();
        }
    }

    public static void main(String[] args) {
        new ProfessorModeUI();
    }


}
