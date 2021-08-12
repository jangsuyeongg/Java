package View.UI;

import javax.swing.*;
import java.awt.*;

public class UI_2 extends JFrame {

    JPanel northPane;
    JLabel northlb1;
    JButton logout;

    JPanel leftMenuPane;
    String [] menuTitle = {"공지사항관리", "강의정보관리","교수정보관리","학생정보관리"};
    Font font;



    public UI_2() {

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
        font = new Font("바탕", Font.BOLD, 20);

        for(int i=0; i<menuTitle.length; i++) {
            JButton jbt= new JButton(menuTitle[i]);
            jbt.setFont(font);
            jbt.setBackground(new Color(213, 213, 213));
            leftMenuPane.add(jbt);
        }

        add(BorderLayout.WEST,leftMenuPane);


    }


    public static void main(String[] args) {
        new UI_2();
    }

}
