package View.Student;

import Dao.Student.StudentModeDAO;
import View.UI.StudentModeUI;
import Vo.Class.ClassVO;
import Dao.Student.StudentModeDAO;
import Dao.Student.StudentDAO;

import Vo.Student.StudentModeVO2;
import Vo.Student.StudentModeVO3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class StudentModeMain extends StudentModeUI implements ActionListener ,MouseListener{
    //*****교수번호 -> 교수명으로 수정


    JPanel centerPane = new JPanel(new BorderLayout()); //StudentModeUI_2 의 센터에붙일 제일 큰판

    JPanel centerNorthP; //centerPane의 위쪽패널
    JPanel northP; //전체강의목록제목 들어갈패널
    JLabel lb1;
    JPanel centerP; //강의테이블 들어갈패널
    String title;
    DefaultTableModel model;
    JTable table;
    JScrollPane sp;
    JPanel southP;//신청버튼들어갈패널
    JButton jbt;

    JPanel centerSouthP ;//centerPane의 아래패널
    JPanel northP2 ; //수강신청내역제목 들어갈패널
    JLabel lb2;
    JPanel centerP2; //신청한강의테이블 들어갈패널
    String title2;
    DefaultTableModel model2;
    JTable table2;
    JScrollPane sp2;

    String class_num;//마우스이벤트로 선택된행의 강의코드값을 우선 스트링으로 가져옴
    int class_code; //선택된행의 강의번호

    public StudentModeMain() {
        init();
        add(centerPane); //StudentModeUI_2 의 센터에 큰판 add

        classApply();
        classAllList();
    }

    public void classApply() {//강의신청

        centerNorthP = new JPanel(new BorderLayout()); //centerPane의 위쪽패널
        //1.
        northP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lb1 = new JLabel("전체 강의목록");
        northP.add(lb1);
        centerNorthP.add(BorderLayout.NORTH,northP);
        //2.
        centerP = new JPanel(new BorderLayout()); //강의테이블 들어갈패널
        title= "강의번호/교수이름/이수구분/강의명/학점/강의시간/강의실/수강인원/신청인원/강의등록일";
        model = new  DefaultTableModel(title.split("/"),0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        centerP.add(sp);
        centerNorthP.add(BorderLayout.CENTER,centerP);
        //3
        southP = new JPanel(new FlowLayout(FlowLayout.RIGHT));//신청버튼들어갈패널
        jbt = new JButton(" 신 청 ");
        southP.add(jbt);
        centerNorthP.add(BorderLayout.SOUTH,southP);

        centerSouthP = new JPanel(new BorderLayout());
        //1
        northP2 = new JPanel(new FlowLayout(FlowLayout.LEFT)); //수강신청내역제목 들어갈패널
        lb2 = new JLabel("수강 신청내역");
        northP2.add(lb2);
        centerSouthP.add(BorderLayout.NORTH,northP2);
        //2
        centerP2 = new JPanel(new BorderLayout()); //신청한강의테이블 들어갈패널
        title2= "강의번호/교수이름/이수구분/강의명/학점/강의시간/강의실/수강인원/신청인원/강의신청시간";
        model2 = new  DefaultTableModel(title2.split("/"),0);
        table2= new JTable(model2);
        sp2 = new JScrollPane(table2);
        centerP2.add(sp2);
        centerSouthP.add(BorderLayout.CENTER,centerP2);


        centerPane.add(BorderLayout.CENTER,centerNorthP);//큰판에다가 위쪽패널 추가
        centerPane.add(BorderLayout.SOUTH,centerSouthP); //큰판에다가 아래패널 추가

        centerSouthP.setPreferredSize(new Dimension(0, 200));


        jbt.addActionListener(this);
        table.addMouseListener(this);
    }

    //강의전체목록 가져오기 -JTable
    public void classAllList() {

        System.out.println("올리스트들어옴");
        StudentModeDAO dao = new StudentModeDAO(); //관리자모드의 수강관리DAO클래스
        List<StudentModeVO2> list = dao.allRecord3(); //전체학생정보저장소
        setClassModel(list);//불러온거 셋팅

    }
    //제이테이블에 목록띄워주기
    public void setClassModel(List<StudentModeVO2> list) { //리스트를받고
        model.setRowCount(0);
        for(int i=0; i<list.size(); i++) {

            StudentModeVO2 vo = list.get(i); //회원한명의 정보 ->배열로 만들어서 model에 추가시킬것임
            Object[]obj = {vo.getClass_code(),vo.getProf_name(),vo.getClass_div(),vo.getClass_name(),vo.getClass_grade(),
                    vo.getClass_time(),vo.getClass_room(), vo.getTot_mem(), vo.getReg_mem(),vo.getClass_date()};

            model.addRow(obj); //배열추가
        }
    }

//----------------------------------------------------------

    //수강신청내역목록 가져오기 -JTable
    public void classAllList2() {

        System.out.println("올리스트들어옴");
        StudentModeDAO dao = new StudentModeDAO(); //관리자모드의 수강관리DAO클래스
        List<StudentModeVO2> list = dao.selectClassRecord(); //전체학생정보저장소
        setClassModel2(list);//불러온거 셋팅

    }
    //제이테이블에 목록띄워주기
    public void setClassModel2(List<StudentModeVO2> list) { //리스트를받고
        model2.setRowCount(0);
        for(int i=0; i<list.size(); i++) {

            StudentModeVO2 vo = list.get(i); //회원한명의 정보 ->배열로 만들어서 model에 추가시킬것임
            Object[]obj = {vo.getClass_code(),vo.getProf_name(),vo.getClass_div(),vo.getClass_name(),vo.getClass_grade(),
                    vo.getClass_time(),vo.getClass_room(), vo.getTot_mem(), vo.getReg_mem(),vo.getClass_date()};

            model2.addRow(obj); //배열추가
        }
    }

    //이벤트
    public void actionPerformed(ActionEvent ae) {
        Object eventBtn =ae.getSource();

        if(eventBtn==jbt) { //신청
            //1.마우스이벤트로 선택된 강의번호를 저장
            //2.신청이완료되면 메시지나오고 수강신청테이블 table2에 목록나와야됨
            //3. 수강신청인원+1 으로 수정하고 -> 강의전체테이블나와야함
            applyClass(); //수강신청메소드
        }
    }

    //수강신청하는메소드
    public void applyClass() {//수강신청하는메소드
        class_code = Integer.parseInt(class_num);
        //int stu_code =Integer.parseInt(AllStateSession.login_id);//학생번호 ??
        //String class_time = "sysdate";//수강신청날짜 ??설정안해줘도되나?

        StudentModeVO3 vo = new StudentModeVO3();
        vo.setClass_code(class_code);
        //vo.setStu_code(stu_code);
        //vo.setClass_time(class_time);

        StudentModeDAO dao = new StudentModeDAO();
        int cnt = dao.insertApplyClass(vo);

        if(cnt>0) {//강의신청완료
            updateClassList(); //수강신청인원수정 + 강의리스트 새로불러옴
            classAllList2();//수강신청내역불러오는메소드실행 : table2에 내가 신청한 테이블정보가 나와야한다

            JOptionPane.showMessageDialog(this, "강의신청 완료되었습니다");
        }else{ //강의신청실패
            JOptionPane.showMessageDialog(this, "강의신청 실패하였습니다");
        }

    }

    //수강신청시 강의정보중 신청인원 수정하는 메소드
    public void updateClassList() { // 수강신청인원+1 , 수강리스트다시셋팅

        class_code = Integer.parseInt(class_num);

        ClassVO vo = new ClassVO();
        vo.setClass_code(class_code);

        StudentModeDAO dao = new StudentModeDAO();
        System.out.println("다오만들어졌다 확인");
        int cnt = dao.updateRecord2(vo);
        System.out.println("!!확인");
        System.out.println(cnt);

        if(cnt>0){//수정시 리스트 다시 선택하기
            classAllList();
        }else {
            //수정실패하면 안내메시지 표시

            JOptionPane.showMessageDialog(this,"수강신청인원 수정 실패하였습니다");
        }
    }

    //수강신청내역테이블 가져오기
    //학생번호로 score테이블에서 학생이 신청한 "강의코드"
    //"강의코드를" 가지고 class테이블에서 정보가져옴


    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {

        if(e.getButton()==1) {
            int row = table.getSelectedRow();
            //선택된 행의 강의코드만가져옴
            class_num = String.valueOf(table.getValueAt(row, 0));
        }
        System.out.println(class_num);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}



    public static void main(String[] args) {
        new StudentModeMain();
    }

}

