package View.Admin.ProFessor;

import Dao.Class.ClassDAO;
import View.UI.AdminUI;
import Vo.Class.ClassVO;
import Vo.Class.ClassVO2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

public class ClassMain extends AdminUI implements ActionListener, MouseListener {

    JPanel centerPane = new JPanel(new BorderLayout()); //전체패널
    JPanel northPane;//전체패널의북쪽패널
    JComboBox jcb;
    JTextField tf;
    JButton jbt;
    JButton jbt2;
    JPanel centercenterPane;//전체패널의센터
    DefaultTableModel model;
    JTable table;
    JScrollPane sp;
    JPanel updatePane; //전체패널의 남쪽패널
    JPanel updateNorth;
    JLabel updateLb1;
    JPanel updateCenter;
    DefaultTableModel updatemodel;
    JTable updateTable;
    JScrollPane sp2;

    //JPanel tfPane;

    JPanel updateSouth;
    JButton updateJbt;
    JButton deleteJbt;

    public ClassMain() {
        init();
        add(centerPane); //전체패널

        showClassAll();
        classAllList();
    }



    //조회전체화면
    public void showClassAll() {
        //조회=======================================================================
        northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String comboList[] = {"강의번호", "강의명", "담당교수"};
        jcb = new JComboBox(comboList);
        tf = new JTextField(15); //검색창
        jbt = new JButton("검색"); //**이벤트
        jbt2 = new JButton("목록새로고침"); //**이벤트
        northPane.add(jcb); northPane.add(tf); northPane.add(jbt); northPane.add(jbt2);
        centerPane.add(BorderLayout.NORTH,northPane);//센터페널에 검색페널추가

        centercenterPane = new JPanel(new BorderLayout()); //전체패널의센터의 센터
        String title= "강의번호/교수번호/이수구분/강의명/교수명/학점/강의시간/강의실/수강인원/신청인원/강의등록일";
        model = new  DefaultTableModel(title.split("/"),0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        centercenterPane.add(sp);
        table.addMouseListener(this); //마우스이벤트등록
        centerPane.add(BorderLayout.CENTER,centercenterPane); //센터페널에 센터에 학생태이블뜨게

        //수정=======================================================================	=
        updatePane = new JPanel(new BorderLayout());	//맨아래 수정패널
        //1
        updateNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        updateLb1 = new JLabel("강의정보수정");
        updateNorth.add(updateLb1);
        updatePane.add(BorderLayout.NORTH,updateNorth);
        //2
        updateCenter = new JPanel(new BorderLayout());
        String title2= "강의번호/교수번호/이수구분/강의명/교수명/학점/강의시간/강의실/수강인원/신청인원/강의등록일";
        updatemodel = new  DefaultTableModel(title2.split("/"),0);
        updateTable = new JTable(updatemodel);
        sp2 = new JScrollPane(updateTable);
        updateCenter.add(sp2);//updateCenrer의 센터에붙임 -north에붙이는걸로수정할말
        //updateCenrer의 south에 붙임 - center에붙이는걸로수정할말
        //tfPane = new JPanel( new FlowLayout(FlowLayout.LEFT)); //레이아웃멀로허지

        //updateCenter.add(BorderLayout.SOUTH,tfPane);
        updatePane.add(BorderLayout.CENTER,updateCenter);
        //3
        updateSouth = new JPanel();
        updateJbt = new JButton(" 수 정 ");
        deleteJbt = new JButton(" 삭 제 ");
        updateSouth.add(updateJbt); updateSouth.add(deleteJbt);
        updatePane.add(BorderLayout.SOUTH,updateSouth);


        centerPane.add(BorderLayout.SOUTH,updatePane);

        updatePane.setPreferredSize(new Dimension(0, 140));

        //**이벤트등록
        jbt.addActionListener(this);//검색
        jbt2.addActionListener(this);//새로고침
        updateJbt.addActionListener(this);//수정
        deleteJbt.addActionListener(this);//삭제
    }

    //강의전체목록 가져오기 -JTable
    public void classAllList() {

        System.out.println("강의올리스트들어옴");
        ClassDAO dao = new ClassDAO();
        java.util.List<ClassVO2> list = dao.allRecord(); //전체학생정보저장소
        setClassModel(list);//불러온거 셋팅

    }
    //제이테이블에 목록띄워주기
    public void setClassModel(java.util.List<ClassVO2> list) { //리스트를받고
        model.setRowCount(0);
        for(int i=0; i<list.size(); i++) {

            ClassVO2 vo = list.get(i); //회원한명의 정보 ->배열로 만들어서 model에 추가시킬것임
            Object[]obj = {vo.getClass_code(),vo.getProf_code(),vo.getClass_div(),vo.getClass_name(),vo.getProf_name(),vo.getClass_grade(),
                    vo.getClass_time(),vo.getClass_room(), vo.getTot_mem(), vo.getReg_mem(),vo.getClass_date()};

            model.addRow(obj); //배열추가
        }
    }

    //이벤트처리
    public void actionPerformed(ActionEvent ae) {//검색,새로고침,수정,삭제

        Object eventBtn =ae.getSource();

        if(eventBtn==jbt) {//검색
            classSearch();
        }else if(eventBtn==jbt2) { //목록새로고침
            classAllList();
        }else if(eventBtn==updateJbt) {//수정
            classUpdate();
            updatemodel.setRowCount(0);//수정할강의 뜨는 부분 리셋
        }else if(eventBtn==deleteJbt) {//삭제 -updatetable 리셋하고 디비에서쿼리문으로삭제
            classDelete();
            updatemodel.setRowCount(0);
        }

    }

    //강의정보검색
    public void classSearch() {
        String search =tf.getText(); //검색할단어

        if(search!=null && !search.equals(" ")) { // 검색어가 있다
            String searchField =String.valueOf(jcb.getSelectedItem()); // 검색어 : 학생번호", "학생이름", "학과전공"
            //필드네임을 데이터로 보낸다
            String fieldName=" "; //어떤필드에서 검색할지 단어가 들어가있음

            if(searchField.equals("강의번호")) {
                fieldName="c.class_code";
            }else if(searchField.equals("강의명")) {
                fieldName="c.class_name";
            }else if(searchField.equals("담당교수")) {
                fieldName="p.jkkjprof_name";
            }
            ClassDAO dao = new ClassDAO();
            List<ClassVO2> list = dao.searchRecord(search,fieldName);
            setClassModel(list);
            tf.setText("");
        }
    }

    //강의정보수정
    public void classUpdate() {
        ClassVO vo = new ClassVO();


        try {
            vo.setClass_code((Integer)(updateTable.getValueAt(0,0))); // not null //시퀀스넘버
            vo.setProf_code((Integer)(updateTable.getValueAt(0,1))); // not null
            vo.setClass_div(String.valueOf(updateTable.getValueAt(0,2))); //입력받은걸 vo저장송에 set
            vo.setClass_name(String.valueOf(updateTable.getValueAt(0,3)));
            //vo.setProf_name(String.valueOf(updateTable.getValueAt(0,4)));
            vo.setClass_grade(String.valueOf(updateTable.getValueAt(0,5)));
            vo.setClass_time(String.valueOf(updateTable.getValueAt(0,6)));
            vo.setClass_room(String.valueOf(updateTable.getValueAt(0,7)));

            String a = String.valueOf(updateTable.getValueAt(0,8));
            int a1 = Integer.parseInt(a);
            vo.setTot_mem(a1);

            String b = String.valueOf(updateTable.getValueAt(0,9));
            int b1 = Integer.parseInt(b);
            vo.setReg_mem(b1);

            vo.setClass_date(String.valueOf(updateTable.getValueAt(0,10)));

        }catch(Exception ee) {
            System.out.println("classUpdate()메소드오류");
            ee.printStackTrace();

        }

        ClassDAO dao = new ClassDAO();
        int cnt = dao.updateRecord(vo); //DAO클래스의 update메소드를 이용하여 쿼리문으로 수정함

        if(cnt>0){//수정시 리스트 다시 선택하기
            System.out.println("main 강의정보수정완료");
            JOptionPane.showMessageDialog(this,"강의정보 수정 완료하였습니다");
            classAllList();
        }else {
            //수정실패하면 안내메시지 표시
            System.out.println("main 강의정보수정오류");
            JOptionPane.showMessageDialog(this,"강의정보 수정 실패하였습니다");
        }
    }

    //강의삭제
    public void classDelete() {
        JOptionPane op = new JOptionPane();
        Object willBeRomoved = updatemodel.getValueAt(0,0);
        ClassDAO dao = new ClassDAO();
        int que =op.showConfirmDialog(this,"정말 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION );
        if(que == JOptionPane.YES_OPTION) {
            updatemodel.setRowCount(0); // updatemodel.remove(0);
            int result = dao.deleteRecord(willBeRomoved);

            if(result>0) {
                JOptionPane.showMessageDialog(this,"강의를 삭제하였습니다");
                classAllList();
                //updatemodel.setRowCount(0); // 왜 안없어지지?
            }else {
                JOptionPane.showMessageDialog(this,"강의삭제를 실패 하였습니다");
            }

        }else if(que==JOptionPane.NO_OPTION) {
            System.out.println("강의삭제안함");
        }


    }
    //마우스이벤트
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==1) {//왼쪽버튼클릭
            updatemodel.setRowCount(0);
            int row = table.getSelectedRow(); //현재클릭한행구해줌


            Vector<Object> v = new Vector<Object>();
            v.add((Integer)table.getValueAt(row,0));
            v.add((Integer)table.getValueAt(row,1));
            v.add(String.valueOf(table.getValueAt(row,2)));
            v.add(String.valueOf(table.getValueAt(row,3)));
            v.add(String.valueOf(table.getValueAt(row,4))); //교수명
            v.add(String.valueOf(table.getValueAt(row,5)));
            v.add(String.valueOf(table.getValueAt(row,6)));
            v.add(String.valueOf(table.getValueAt(row,7)));
            String a = String.valueOf(table.getValueAt(row,8));
            int a1 = Integer.parseInt(a);
            v.add(a1);

            String b = String.valueOf(table.getValueAt(row,9));
            int b1 = Integer.parseInt(b);
            v.add(b1);

            v.add(String.valueOf(table.getValueAt(row,10)));

            updatemodel.addRow(v);

            //System.out.println(.getValueAt(row,7));
//			tf1.setText(String.valueOf(table.getValueAt(row,7)));
//			tf2.setText(String.valueOf(table.getValueAt(row,8)));

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


    public static void main(String[] args) {
        new ClassMain();

    }

}
