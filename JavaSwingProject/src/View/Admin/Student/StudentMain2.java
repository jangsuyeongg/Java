package View.Admin.Student;

import Dao.Student.StudentDAO;
import View.UI.AdminUI;
import Vo.Student.StudentVO3;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StudentMain2 extends AdminUI implements ActionListener, MouseListener {

    //***********학생추가패널****************

    Font font = new Font("돋음", Font.BOLD, 20);

    JPanel centerPane = new JPanel(new BorderLayout());//UI_2 센터에 패널더함


    //학생추가,삭제화면
    JPanel insertPane;//centerPane - north
    JPanel insertlb1P; //insertPane-north
    JLabel insertlb1;
    JPanel insertWestPane; //insertPane-west
    String insertLb1[]= {" 학 생 번 호 "," 전 공 번 호 "," 비 밀 번 호 "," 이 름 "," 학 년 "
            ," 이 메 일 "," 전 화 번 호 "," 주 소 "," 학 적 상 태 "," 가 입 일 자 "," 생 년 월 일 "};
    JPanel insertCenter; //insertPane-center
    JTextField[] insertTf = {new JTextField(10), new JTextField(4), new JTextField(10),new JTextField(10)
            , new JTextField(4),new JTextField(30),new JTextField(15),new JTextField(45)
            , new JTextField(10),new JTextField(15), new JTextField(20),};
    JPanel insertSouthP; //insertPane-south
    JButton insertJbt;
    JPanel deletePane;//centerPane- center
    JPanel deletelb1P; //deletrPane-north
    JPanel deleteCenterP; //deletrPane-center

    public StudentMain2() {

        init();
        add(centerPane);


        studentInsertView(); //2.학생추가

    }

    public void actionPerformed(ActionEvent ae) {
        //마우스이벤트는 url테스트....

        Object eventBtn =ae.getSource();
        if(eventBtn ==insertJbt) { //학생검색
            studentInsert();
        }
    }

    //학생추가화면
    public void studentInsertView() {
        //센터패널에 패널2개삽입 -> 추가패널 /삭제패널

        insertPane = new JPanel(new BorderLayout());//1.추가패널

        insertlb1P = new JPanel(new BorderLayout());
        insertlb1P.setBorder(new LineBorder(Color.GRAY,1,true));
        insertlb1 = new JLabel("학생추가"); //폰트설정,패널안에넣말
        insertlb1.setFont(font);
        insertlb1.setPreferredSize(new Dimension(150, 30));
        insertlb1P.add(BorderLayout.WEST,insertlb1);

        insertPane.add(BorderLayout.NORTH,insertlb1P); //삭제패널 북쪽에 라벨 추가
        insertlb1P.setPreferredSize(new Dimension(0, 45));

        insertWestPane= new JPanel(new GridLayout(11,1,5,5));

        insertCenter = new JPanel(new GridLayout(11,1)); //뒤에 추가한 5는 간격을 5px만큼 주는것

        insertPane.add(BorderLayout.WEST,insertWestPane); //추가패널 서쪽에 패널추가
        for(int i=0; i<insertLb1.length; i++) {
            JLabel lb1 = new JLabel(insertLb1[i]);
            insertWestPane.add(lb1);
        }
        insertPane.add(BorderLayout.CENTER,insertCenter);//추가패널 센터에 패널추가
        for(int i=0; i<insertTf.length; i++) {
            JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); //왼쪽정렬
            p.add(insertTf[i]);
            insertCenter.add(p);

            //텍스트필드 비활성화
            if(i==0 || i==2 || i==9 )  insertTf[i].setEditable(false);
        }



        insertSouthP = new JPanel();	//레이아웃 멀로하지
        insertSouthP.setBorder(new LineBorder(Color.GRAY,1,true));
        insertJbt = new JButton(" 추 가 "); //추가패널 남쪽에 버튼 추가 //패널안에 넣말
        insertJbt.setBackground(new Color(33, 140, 116));
        insertJbt.setForeground(Color.white);
        insertJbt.setFont(font);
        insertJbt.setPreferredSize(new Dimension(100, 30)); //버튼어디에정렬
        insertSouthP.add(insertJbt);
        insertPane.add(BorderLayout.SOUTH,insertSouthP);

        centerPane.add(BorderLayout.NORTH,insertPane);
        insertPane.setPreferredSize(new Dimension(0, 480));

        deletePane = new JPanel(new BorderLayout());	//2.삭제패널

        deletelb1P = new JPanel(new BorderLayout());
        deletePane.add(BorderLayout.NORTH,deletelb1P); //삭제패널 북쪽에 라벨 추가
        deletelb1P.setPreferredSize(new Dimension(0, 45));

        deleteCenterP = new JPanel();
        deletePane.add(BorderLayout.CENTER,deleteCenterP);
        centerPane.add(BorderLayout.CENTER,deletePane);

        insertJbt.addActionListener(this); //추가버튼

    }

    //학생추가
    public void studentInsert() { //학생추가 --- DAO- insertDAO
        //String Stu_code = insertTf[0].getText(); // not null //시퀀스넘버
        String Major_Code = insertTf[1].getText(); // not null
        //String stu_pw = insertTf[2].getText();
        String stu_name = insertTf[3].getText();
        String stu_grade = insertTf[4].getText();
        String stu_email=insertTf[5].getText();
        String stu_tel=insertTf[6].getText();
        String stu_add=insertTf[7].getText();
        String stu_state=insertTf[8].getText();
        //int stu_date=insertTf[9].getText();
        String stu_birth = insertTf[10].getText();  // not null


        if( Major_Code==null || Major_Code.equals(" ") || //stu_pw==null || stu_pw.equals(" ")||
                stu_name==null || stu_name.equals(" ") || stu_birth==null || stu_birth.equals(" ")	)  { //모든공백허용x 근데 흠......
            JOptionPane.showMessageDialog(this, "데이터 값을 입력하세요");
        }else {
            StudentVO3 vo = new StudentVO3();

            vo.setMajor_Code(Integer.parseInt(Major_Code));
            //vo.setStu_pw(stu_pw); // 초기비밀번호는 생년원일
            vo.setStu_name(stu_name);
            vo.setStu_grade(stu_grade);
            vo.setStu_email(stu_email);
            vo.setStu_tel(stu_tel);
            vo.setStu_add(stu_add);
            vo.setStu_state(stu_state);
            //vo.setStu_date((stu_date);
            vo.setStu_birth(stu_birth);

            StudentDAO dao = new StudentDAO();
            int cnt = dao.insertRecord(vo);

            if(cnt>0) {//학생추가 : 추가된 레코드가 잇을때
                formDataClear(); //회원이 추가되면 폼의 데이털르 지운다
                JOptionPane.showMessageDialog(this, "학생추가 되었습니다");
            }else{ //회원추가실패
                JOptionPane.showMessageDialog(this, "학생추가 실패하였습니다");
            }
        }

    }

    //폼지우기
    public void formDataClear() {
        //학생 추가되고나면 form에 있던 데이터를 지운다
        //폼의 값을 지운다.
        for(int i=0; i<insertTf.length; i++) {
            insertTf[i].setText(" ");
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


    public static void main(String[] args) {
        new StudentMain2();

    }

}

