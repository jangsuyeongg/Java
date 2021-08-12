import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class StudentMain extends AdminUI implements ActionListener ,MouseListener {
	
	
	
	Font font = new Font("돋음", Font.BOLD, 20);
	
	JPanel centerPane = new JPanel(new BorderLayout());//UI_2 센터에 패널더함
	
	//학생정보관리-학생전체조회화면	
	JPanel northPane;
		JTextField tf;	
		JComboBox<String> jcb;
		JButton jbt;
		JButton jbt2;		
	JPanel centercenterPane;	
		JTable table;
		JScrollPane sp; 
		DefaultTableModel model;
		String title;
		
	
	//학생조회
	JPanel updatePane; //south-수정패널
		JPanel updateNorth;
			JLabel updateLb1;
		JPanel updateCenter; 		
			JTable updateTable;
			JScrollPane sp2; 
			DefaultTableModel updatemodel;
			String title2;
		JPanel updateSouth;		
			JButton updateJbt; //수정버튼
			JButton deleteJbt;
			
			
			
			String major_Name; //수정으로 입력된 전공명
			int major_Code; //입력된전공명으로 가져온 전공코드
			

	public StudentMain() {
		
		init();
		add(centerPane);
		
		showStudentAll();//1-1.조회,수정,삭제 화면 기본셋팅
		studentAllList();//1-2.학생전체조회+검색버튼이벤트처리

		
	}

	//학생정보관리-학생전체조회화면	
	public void showStudentAll() {
	
		northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));  //제이콤보박스 텍스드필드 검색버튼

		System.out.println("학생전체조회화면메소드시작"); //TEST
			String comboList[] = {"학생번호", "학생이름", "학과전공"};
			jcb = new JComboBox(comboList);
			tf = new JTextField(15); //검색창
			jbt = new JButton("검색");
			jbt2 = new JButton("목록새로고침");
			northPane.add(jcb);
			northPane.add(tf);
			northPane.add(jbt);	
			northPane.add(jbt2);
			
		centerPane.add(BorderLayout.NORTH,northPane);//센터페널에 검색페널추가
			
		centercenterPane = new JPanel(new BorderLayout());
			
			title= "학생번호/학과전공/비밀번호/학생이름/학년/이메일/핸드폰/주소/학적상태/가입일자/생년월일"; 
			model = new  DefaultTableModel(title.split("/"),0);

		    table = new JTable(model);
		    sp = new JScrollPane(table);
		    centercenterPane.add(sp);
		    
		    table.addMouseListener(this);		 
	
		centerPane.add(BorderLayout.CENTER,centercenterPane); //센터페널에 센터에 학생태이블뜨게
//-----------------------------------------------------------------------------------------------
		updatePane = new JPanel(new BorderLayout());	//맨아래 수정패널
			//1
			updateNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
				updateLb1 = new JLabel("학생정보수정");				
			updateNorth.add(updateLb1); 
		updatePane.add(BorderLayout.NORTH,updateNorth);
			//2
			updateCenter = new JPanel(new BorderLayout());
				title2= "학생번호/학과전공/비밀번호/학생이름/학년/이메일/핸드폰/주소/학적상태/가입일자/생년월일"; 
				updatemodel = new  DefaultTableModel(title2.split("/"),0);
				updateTable = new JTable(updatemodel);
				sp2 = new JScrollPane(updateTable);
			updateCenter.add(sp2);
		updatePane.add(BorderLayout.CENTER,updateCenter);
			//3
			updateSouth = new JPanel();
	    	updateJbt = new JButton(" 수 정 ");
	    	deleteJbt = new JButton(" 삭 제 ");
	    	updateSouth.add(updateJbt);
	    	updateSouth.add(deleteJbt);
	    updatePane.add(BorderLayout.SOUTH,updateSouth); 
	    
	    centerPane.add(BorderLayout.SOUTH,updatePane);    
	    
	    updatePane.setPreferredSize(new Dimension(0, 140));
			
		    jbt.addActionListener(this);
		    jbt2.addActionListener(this);
		    updateJbt.addActionListener(this);
		    deleteJbt.addActionListener(this);
		    
	}
	
	public void actionPerformed(ActionEvent ae) {
		//마우스이벤트는 url테스트....
		
		Object eventBtn =ae.getSource();
		if(eventBtn==jbt) { //학생검색
			studentSearch();
		}else if(eventBtn== updateJbt){//학생수정
			getMajorCode();
			studentUpdate();			
		}else if(eventBtn==deleteJbt) { //학생삭제
			studentDelete();
		}else if(eventBtn==jbt2) {
			studentAllList();
		}
	}
	
	//학생전체목록 가져오기 -JTable
	public void studentAllList() {

		System.out.println("올리스트들어옴");
		StudentDAO dao = new StudentDAO();
		List<StudentVO2> list = dao.allRecord(); //전체학생정보저장소
		setStudentModel(list);//불러온거 셋팅
		
	}
	//제이테이블에 목록띄워주기
	public void setStudentModel(List<StudentVO2> list) { //리스트를받고		
		model.setRowCount(0);  
			for(int i=0; i<list.size(); i++) {
				
				StudentVO2 vo = list.get(i); //회원한명의 정보 ->배열로 만들어서 model에 추가시킬것임
				Object[]obj = {vo.getStu_Code(),vo.getMajor_name(),vo.getStu_pw(),vo.getStu_name(),vo.getStu_grade(),
						vo.getStu_email(),vo.getStu_tel(), vo.getStu_add(), vo.getStu_state(),vo.getStu_date(),vo.getStu_birth()};
					
				model.addRow(obj); //배열추가		
			}
	}
	
	//학생검색
	public void studentSearch() {
			
			String search =tf.getText(); //검색할단어
			System.out.println(search);
			if(search!=null && !search.equals(" ")) { // 검색어가 있다
				String searchField = String.valueOf(jcb.getSelectedItem());//**메소드 선택안해도 되는걸로 바꿔야함
				System.out.println(searchField);
				// 검색어 : 학생번호", "학생이름", "학과전공"
				//필드네임을 데이터로 보낸다
				String fieldName=" "; //어떤필드에서 검색할지 단어가 들어가있음
				
				System.out.println("main학생검색메소드도착");
				
				if(searchField.equals("학생번호")) {
					fieldName="s.Stu_Code";
				}else if(searchField.equals("학생이름")) {
					System.out.println("제이콤보박스 학생이름 선택");
					fieldName="s.stu_name";
				}else if(searchField.equals("학과전공")) {
					fieldName="m.major_name";
				}
				StudentDAO dao = new StudentDAO();
				List<StudentVO2>list = dao.searchRecord(search,fieldName);
				setStudentModel(list);
				tf.setText("");
			}
		}
		
	//받아온걸 우선LIST에 저장
	//LIST 에서 강의명으로 강의번호 찾음
	//디비에 업데이트할때  강의번호로 업데이트
	
		
	//전공명으로 전공번호가져오기
	public void getMajorCode() {
		major_Name =String.valueOf(updateTable.getValueAt(0,1));//수정으로 입력된 전공명 가져옴
			
			if( major_Name!=null && !major_Name.equals(" ")) {
				StudentDAO dao = new StudentDAO();
					//찾기메소드
				major_Code = dao.searchMajorCode(major_Name);//전공명으로 전공코드가져옴	
				System.out.println(major_Code);
					
			}else if( major_Name==null &&  major_Name.equals(" ")){
					//JOptionPane.showMessageDialog(this, "삭제할 강의명을 입력하세요");
			}else {
				//JOptionPane.showMessageDialog(this, "존재하지 않는 강의명 입니다");
			}
	}
		
	
	//학생정보수정
	public void studentUpdate() { 	
		System.out.println("수정업데이트에도착");
		StudentVO3 vo = new StudentVO3();
		
		vo.setStu_Code((Integer)(updateTable.getValueAt(0,0))); // ****not null //시퀀스넘버
		vo.setMajor_Code(major_Code); // not null
		vo.setStu_pw((String)updateTable.getValueAt(0,2)); //입력받은걸 vo저장송에 set
		vo.setStu_name((String)updateTable.getValueAt(0,3));
		vo.setStu_grade((String)updateTable.getValueAt(0,4));
		vo.setStu_email((String)updateTable.getValueAt(0,5));
		vo.setStu_tel((String)updateTable.getValueAt(0,6)); 
		vo.setStu_add((String)updateTable.getValueAt(0,7));
		vo.setStu_state((String)updateTable.getValueAt(0,8));
		vo.setStu_date((String)updateTable.getValueAt(0,9));
		vo.setStu_birth((String)(updateTable.getValueAt(0,10)));  
		
		//System.out.println(vo.allprint());
		
		StudentDAO dao = new StudentDAO();
		int cnt = dao.updateRecord(vo); //DAO클래스의 update메소드를 이용하여 쿼리문으로 수정함
		
		if(cnt>0){//수정시 리스트 다시 선택하기
			System.out.println("main 학생정보수정성공");
			JOptionPane.showMessageDialog(this,"회원정보 수정 완료하였습니다");			
			studentAllList();
			updatemodel.setRowCount(0); //수정테이블 리셋
		}else {
			//수정실패하면 안내메시지 표시
			System.out.println("main 학생정보수정오류");
			JOptionPane.showMessageDialog(this,"회원정보 수정 실패하였습니다");
		}
	}
	
	
	
	

	//학생삭제
	public void studentDelete() {
		JOptionPane op = new JOptionPane();
		Object willBeRomoved = updatemodel.getValueAt(0,0);
		StudentDAO dao = new StudentDAO();
		int que =op.showConfirmDialog(this,"정말 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION );
		if(que == JOptionPane.YES_OPTION) {
			updatemodel.setRowCount(0); // updatemodel.remove(0);
			int result = dao.deleteRecord(willBeRomoved);
			
			if(result>0) {
				JOptionPane.showMessageDialog(this,"학생데이터를 삭제하였습니다");
				studentAllList();
				updatemodel.setRowCount(0); //삭제테이블 리셋
			}else {
				JOptionPane.showMessageDialog(this,"데이터삭제를 실패 하였습니다");
			}
			
		}else if(que==JOptionPane.NO_OPTION) {
			System.out.println("학생삭제안함");
		}
		
		
	}

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
			v.add(String.valueOf(table.getValueAt(row,1)));
			v.add(String.valueOf(table.getValueAt(row,2)));
			v.add(String.valueOf(table.getValueAt(row,3)));
			v.add(String.valueOf(table.getValueAt(row,4)));
			v.add(String.valueOf(table.getValueAt(row,5)));
			v.add(String.valueOf(table.getValueAt(row,6)));
			v.add(String.valueOf(table.getValueAt(row,7)));
			v.add(String.valueOf(table.getValueAt(row,8)));
			v.add(String.valueOf(table.getValueAt(row,9)));
			v.add(String.valueOf(table.getValueAt(row,10)));
			updatemodel.addRow(v);	
			
		} 		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}	

	
	public static void main(String[] args) {
		new StudentMain();

	}

	

}
