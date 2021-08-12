package View.Student;

import Dao.Student.StudentModeDAO;
import View.UI.StudentModeUI;
import Vo.Student.StudentModeVO2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class StudentModeMain2 extends StudentModeUI implements ActionListener {

    JPanel centerPane = new JPanel(new BorderLayout()); //StudentModeUI_2 의 센터에붙일 제일 큰판

    JPanel centerPane_northP;
    JLabel lb1 ;// 수강신청목록 라벨
    JPanel centerPane_centerP;
    JPanel centerP_NP;
    JComboBox jcb;
    JTextField tf;
    JButton jbt;
    JButton jbt2;
    JPanel centerP_CP;
    String title;
    DefaultTableModel model;
    JTable table;
    JScrollPane sp;
    JPanel centerPane_southP;


    public StudentModeMain2() {
        init();
        add(centerPane);

        showClass();
        classAllList2();
    }

    public void showClass() {

        centerPane_northP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerPane_northP.setPreferredSize(new Dimension(0,35));
        //centerPane_northP.setBorder(new LineBorder(Color.gray,1));
        lb1 = new JLabel("강의수강신청목록");
        lb1.setPreferredSize(new Dimension(130,40));

        centerPane_northP.add(lb1);

        centerPane_centerP = new JPanel(new BorderLayout());
        centerP_NP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String comboList[] = {"강의번호","이수구분","강의명","교수명"};
        jcb = new JComboBox(comboList);
        tf = new JTextField(15);
        jbt= new JButton("검색");;
        jbt2 = new JButton("목록새로고침");
        centerP_NP.add(jcb);    centerP_NP.add(tf); centerP_NP.add(jbt); centerP_NP.add(jbt2);
        centerPane_centerP.add(BorderLayout.NORTH,centerP_NP);
        centerP_CP = new JPanel(new BorderLayout());
        title= "강의번호/교수이름/이수구분/강의명/학점/강의시간/강의실/수강인원/신청인원/강의등록일"; ;
        model= new  DefaultTableModel(title.split("/"),0);;
        table = new JTable(model);
        sp = new JScrollPane(table);
        centerP_CP.add(sp);
        centerPane_centerP.add(BorderLayout.CENTER,sp);


        centerPane_southP = new JPanel();
        centerPane_southP.setPreferredSize(new Dimension(0,40));

        centerPane.add(BorderLayout.NORTH,centerPane_northP);
        centerPane.add(BorderLayout.CENTER,centerPane_centerP);
        centerPane.add(BorderLayout.SOUTH,centerPane_southP);

        jbt.addActionListener(this);
        jbt2.addActionListener(this);

    }


    public void classAllList2() {

        System.out.println("올리스트들어옴");
        StudentModeDAO dao = new StudentModeDAO(); //관리자모드의 수강관리DAO클래스
        List<StudentModeVO2> list = dao.selectClassRecord(); //전체학생정보저장소
        setClassModel2(list);//불러온거 셋팅

    }
    //제이테이블에 목록띄워주기
    public void setClassModel2(List<StudentModeVO2> list) { //리스트를받고
        model.setRowCount(0);
        for(int i=0; i<list.size(); i++) {

            StudentModeVO2 vo = list.get(i); //회원한명의 정보 ->배열로 만들어서 model에 추가시킬것임
            Object[]obj = {vo.getClass_code(),vo.getProf_name(),vo.getClass_div(),vo.getClass_name(),vo.getClass_grade(),
                    vo.getClass_time(),vo.getClass_room(), vo.getTot_mem(), vo.getReg_mem(),vo.getClass_date()};

            model.addRow(obj); //배열추가
        }
    }


    public void actionPerformed(ActionEvent ae) {
        Object eventBtn = ae.getSource();

        if(eventBtn==jbt) { //검색
            classSearch();

        }else if(eventBtn==jbt2) { //목록새로고침
            classAllList2(); //버튼누르면목록새로뜸
        }

    }

    //강의정보검색
    public void classSearch() {
        String search =tf.getText(); //검색할단어

        System.out.println(search);
        if(search!=null && !search.equals(" ")) { // 검색어가 있다
            String searchField =String.valueOf(jcb.getSelectedItem()); // 검색어 : 학생번호", "학생이름", "학과전공"
            //필드네임을 데이터로 보낸다
            String fieldName=" "; //어떤필드에서 검색할지 단어가 들어가있음

            if(searchField.equals("강의번호")) {
                fieldName="c.class_code";
            }else if(searchField.equals("이수구분")) {
                fieldName="c.class_div";

            }else if(searchField.equals("강의명")) {
                fieldName="c.class_name";
            }else if(searchField.equals("교수명")) {
                fieldName="p.prof_name";
            }
            StudentModeDAO dao = new StudentModeDAO();
            List<StudentModeVO2>list = dao.searchClassRecord2(search,fieldName);
            setClassModel2(list);
            tf.setText("");
        }
    }



    public static void main(String[] args) {
        new StudentModeMain2();

    }

}
