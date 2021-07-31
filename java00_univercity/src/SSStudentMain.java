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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class SSStudentMain extends UI_2 implements ActionListener ,MouseListener {
	JTextField tf;	
	JComboBox<String> jcb;
	
	JTable table;
	JScrollPane sp; 
	DefaultTableModel model;
	Font font = new Font("돋음", Font.BOLD, 20);
	
	JPanel centerPane = new JPanel(new BorderLayout());//UI_2 센터에 패널더함
	//학생조회
	JPanel updatePane; //south-수정패널
		JTable updateTable;
		JScrollPane sp2; 
		DefaultTableModel updatemodel;
		
		
		
		JButton updateJbt; //수정버튼
	
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
	
	JPanel deletePane;//centerPane- center
		JPanel deletelb1P; //deletrPane-north
			JLabel deletelb1; 
		JPanel deleteCenterP; //deletrPane-center
			JTextField deleteTf;
	
	public SSStudentMain() {
		
		init();
		add(centerPane);
//		
//		showStudentAll();//조회,수정화면 기본셋팅
//		studentAllList();//학생전체조회+검색버튼이벤트처리
		
		studentInsertView(); //학생추가,학생삭제
		
	}

	//학생정보관리-학생전체조회화면x
	
	public void showStudentAll() {
	
		JPanel northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));  //제이콤보박스 텍스드필드 검색버튼

		System.out.println("학생전체조회화면메소드시작"); //TEST
			String comboList[] = {"학생번호", "학생이름", "학과전공"};
			jcb = new JComboBox(comboList);
			tf = new JTextField(15); //검색창
			JButton jbt = new JButton("검색");
			northPane.add(jcb);
			northPane.add(tf);
			northPane.add(jbt);			
			
		centerPane.add(BorderLayout.NORTH,northPane);//센터페널에 검색페널추가
			
		JPanel centercenterPane = new JPanel(new BorderLayout());
			
			String title= "학생번호/전공번호/비밀번호/학생이름/학년/이메일/핸드폰/주소/학적상태/가입일자/생년월일"; 
			model = new  DefaultTableModel(title.split("/"),0);

		    table = new JTable(model);
		    sp = new JScrollPane(table);
		    centercenterPane.add(sp);
		    
		    table.addMouseListener(this);
		    //table.addMouseListener(new JTableMouseEventProcess(formTf,memberList)); //
		    
		centerPane.add(BorderLayout.CENTER,centercenterPane); //센터페널에 센터에 학생태이블뜨게

		updatePane = new JPanel(new BorderLayout());	//맨아래 수정패널
			//1
			JPanel updateNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JLabel updateLb1 = new JLabel("학생정보수정");
				//JTextField updateTf = new JTextField(15);
				//JButton stuNumBtn = new JButton(" 검 색 ");//이벤트처리한검색한개더있음 
			updateNorth.add(updateLb1); //updateNorth.add(updateTf); updateNorth.add(stuNumBtn);
		updatePane.add(BorderLayout.NORTH,updateNorth);
			//2
			JPanel updateCenter = new JPanel(new BorderLayout());
				String title2= "학생번호/전공번호/비밀번호/학생이름/학년/이메일/핸드폰/주소/학적상태/가입일자/생년월일"; 
				updatemodel = new  DefaultTableModel(title2.split("/"),0);
				updateTable = new JTable(updatemodel);
				sp2 = new JScrollPane(updateTable);
			updateCenter.add(sp2);
		updatePane.add(BorderLayout.CENTER,updateCenter);
			//3
			JPanel updateSouth = new JPanel();
	    	updateJbt = new JButton(" 수 정 ");
	    	updateSouth.add(updateJbt);
	    updatePane.add(BorderLayout.SOUTH,updateSouth); 
	    
	    centerPane.add(BorderLayout.SOUTH,updatePane);    
	    
	    updatePane.setPreferredSize(new Dimension(0, 140));
			
		    jbt.addActionListener(this);
		    updateJbt.addActionListener(this);
		    //newUpdateJbt.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		//마우스이벤트는 url테스트....
		String eventBtn = ae.getActionCommand(); 
		Object eventBtn2 =ae.getSource();
		if(eventBtn.equals("검색")) { //학생검색
	//		studentSearch();
		}else if(eventBtn2== updateJbt){//학생수정
			studentUpdate();
		}else if(eventBtn.equals(" 추 가 ")) { //학생추가
	//		studentInsert();
		}else if(eventBtn.equals(" 삭 제 ")) { //학생삭제
	//		studentDelete();
		}else if(eventBtn.equals(" 새 로 고 침 ")) {
			
		}
	}
	
	//학생전체목록 가져오기 -JTable
	public void studentAllList() {
		System.out.println("올리스트들어옴");
		SSStudentDAO dao = new SSStudentDAO();
		List<SSStudentVO> list = dao.allRecord(); //전체학생정보저장소
		setStudentModel(list);//불러온거 셋팅
	}
	
	//제이테이블에 목록띄워주기
	public void setStudentModel(List<SSStudentVO> list) { //리스트를받고		
		model.setRowCount(0);  
			for(int i=0; i<list.size(); i++) {
				
				SSStudentVO vo = list.get(i); //회원한명의 정보 ->배열로 만들어서 model에 추가시킬것임
				Object[]obj = {vo.getStu_Code(),vo.getMajor_Code(),vo.getStu_pw(),vo.getStu_name(),vo.getStu_grade(),
						vo.getStu_email(),vo.getStu_tel(), vo.getStu_add(), vo.getStu_state(),vo.getStu_date(),vo.getStu_birth(),"수 정"};
					
				model.addRow(obj); //배열추가		
			}
	}
	
	//학생검색
//	public void studentSearch() {
//			
//			String search =tf.getText(); //검색할단어
//			
//			if(search!=null && !search.equals(" ")) { // 검색어가 있다
//				String searchField = (String)jcb.getSelectedItem(); // 검색어 : 학생번호", "학생이름", "학과전공"
//				//필드네임을 데이터로 보낸다
//				String fieldName=" "; //어떤필드에서 검색할지 단어가 들어가있음
//				if(searchField.equals("학생번호")) {
//					fieldName="Stu_Code";
//				}else if(searchField.equals("학생이름")) {
//					fieldName="stu_name";
//				}else if(searchField.equals("학과전공")) {
//					fieldName="class_name";
//				}
//				SSStudentDAO dao = new SSStudentDAO();
//				List<SSStudentVO>list = dao.searchRecord(search,fieldName);
//				setStudentModel(list);
//				tf.setText(" ");
//			}
//		}
	
	//학생정보수정
	public void studentUpdate() { 	
		System.out.println("수정업데이트에도착");
		SSStudentVO vo = new SSStudentVO();
		
		vo.setStu_Code((Integer)(updateTable.getValueAt(0,0))); // not null //시퀀스넘버
		vo.setMajor_Code((Integer)(updateTable.getValueAt(0,1))); // not null
		vo.setStu_pw((String)updateTable.getValueAt(0,2)); //입력받은걸 vo저장송에 set
		vo.setStu_name((String)updateTable.getValueAt(0,3));
		vo.setStu_grade((String)updateTable.getValueAt(0,4));
		vo.setStu_email((String)updateTable.getValueAt(0,5));
		vo.setStu_tel((String)updateTable.getValueAt(0,6)); //엥 이거 int아니냐
		vo.setStu_add((String)updateTable.getValueAt(0,7));
		vo.setStu_state((String)updateTable.getValueAt(0,8));
		vo.setStu_date((String)updateTable.getValueAt(0,9));
		vo.setStu_birth((String)(updateTable.getValueAt(0,10)));  // 
		
		System.out.println(vo.allprint());
		
		SSStudentDAO dao = new SSStudentDAO();
		int cnt = dao.updateRecord(vo); //DAO클래스의 update메소드를 이용하여 쿼리문으로 수정함
		
		if(cnt>0){//수정시 리스트 다시 선택하기
			System.out.println("asd");
			studentAllList();
		}else {
			//수정실패하면 안내메시지 표시
			System.out.println("main 학생정보수정오류");
			JOptionPane.showMessageDialog(this,"회원정보 수정 실패하였습니다");
		}
	}

	
//	======================================================================================
//	학생추가화면
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
//				String insertLb1[]= {" 학 생 번 호 "," 전 공 번 호 "," 비 밀 번 호 "," 이 름 "," 학 년 "
//									," 이 메 일 "," 전 화 번 호 "," 주 소 "," 학 적 상 태 "," 가 입 일 자 "," 생 년 월 일 "};
			insertCenter = new JPanel(new GridLayout(11,1)); //뒤에 추가한 5는 간격을 5px만큼 주는것
//				JTextField[] insertTf = {new JTextField(10), new JTextField(4), new JTextField(10),new JTextField(10)
//										, new JTextField(4),new JTextField(30),new JTextField(15),new JTextField(45)
//										, new JTextField(10),new JTextField(15), new JTextField(20),};  
						
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
					if(i==0 || i==9 )  insertTf[i].setEditable(false);
				}
				
			
			
			insertSouthP = new JPanel();	//레이아웃 멀로하지	
			insertSouthP.setBorder(new LineBorder(Color.GRAY,1,true));
			JButton insertJbt = new JButton(" 추 가 "); //추가패널 남쪽에 버튼 추가 //패널안에 넣말	
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
			deletelb1P.setBorder(new LineBorder(Color.GRAY,1,true));			
				deletelb1 = new JLabel("학생삭제"); 
				deletelb1.setFont(font);			
				deletelb1.setPreferredSize(new Dimension(150, 30));
			deletelb1P.add(BorderLayout.WEST,deletelb1);
			
			deletePane.add(BorderLayout.NORTH,deletelb1P); //삭제패널 북쪽에 라벨 추가
			deletelb1P.setPreferredSize(new Dimension(0, 45));
		
			deleteCenterP = new JPanel(); //레이아웃 흠냐뤼
				JLabel deleteLb1 = new JLabel("학생번호"); //폰트,사이즈
				deleteTf = new JTextField(15);
				JButton deleteJbt = new JButton(" 삭 제 ");
				deleteJbt.setFont(font);
				deleteJbt.setPreferredSize(new Dimension(100, 30));
				deleteJbt.setBackground(new Color(33, 140, 116));
				deleteJbt.setForeground(Color.white);
			deleteCenterP.add(deleteLb1); deleteCenterP.add(deleteTf); deleteCenterP.add(deleteJbt); 
			
			deletePane.add(BorderLayout.CENTER,deleteCenterP);
			centerPane.add(BorderLayout.CENTER,deletePane);
			
			//추가,삭제버튼 이벤트처리
			insertJbt.addActionListener(this); //추가버튼
			deleteJbt.addActionListener(this); //삭제버튼
	}
	
	//학생추가
//	public void studentInsert() { //학생추가 --- DAO- insertDAO
//		//String Stu_code = insertTf[0].getText(); // not null //시퀀스넘버
//		String Major_Code = insertTf[1].getText(); // not null
//		String stu_pw = insertTf[2].getText();
//		String stu_name = insertTf[3].getText();
//		String stu_grade = insertTf[4].getText();
//		String stu_email=insertTf[5].getText();
//		String stu_tel=insertTf[6].getText();
//		String stu_add=insertTf[7].getText();
//		String stu_state=insertTf[8].getText();
//		//int stu_date=insertTf[9].getText();
//		String stu_birth = insertTf[10].getText();  // not null 
//		
//		
//		if( Major_Code==null || Major_Code.equals(" ") || stu_pw==null || stu_pw.equals(" ")||
//			stu_name==null || stu_name.equals(" ") || stu_birth==null || stu_birth.equals(" ")	)  { //모든공백허용x 근데 흠......
//				JOptionPane.showMessageDialog(this, "데이터 값을 입력하세요");
//		}else {
//			SSStudentVO vo = new SSStudentVO();
//			
//			vo.setMajor_Code(Integer.parseInt(Major_Code));
//			vo.setStu_pw(stu_pw);
//			vo.setStu_name(stu_name);
//			vo.setStu_grade(stu_grade);
//			vo.setStu_email(stu_email);
//			vo.setStu_tel(stu_tel); //int
//			vo.setStu_add(stu_add);
//			vo.setStu_state(stu_state);
//			//vo.setStu_date((stu_date);
//			vo.setStu_birth(stu_birth);		
//			
//			SSStudentDAO dao = new SSStudentDAO();
//			int cnt = dao.insertRecord(vo);
//			
//			if(cnt>0) {//학생추가 : 추가된 레코드가 잇을때
//				formDataClear(); //회원이 추가되면 폼의 데이털르 지운다
//				JOptionPane.showMessageDialog(this, "학생추가 되었습니다");
//			}else{ //회원추가실패
//				JOptionPane.showMessageDialog(this, "학생추가 실패하였습니다");
//			}			
//		}
//		
//	}
	
	//폼지우기
//	public void formDataClear() {
//			//학생 추가되고나면 form에 있던 데이터를 지운다
//			//폼의 값을 지운다.
//		for(int i=0; i<insertTf.length; i++) {
//				insertTf[i].setText(" ");
//		}
//			
//	}
	
	//학생삭제
//	public void studentDelete() {//번호를 가져와서 테이블에 있는지 없는지 확인하고
//			
//			//삭제할 사원번호
//			//							      데이터o  데이터x
//			String delNum = deleteTf.getText(); // "5"  ""
//			if(delNum==null || delNum.equals(" ")){
//				JOptionPane.showMessageDialog(this, "삭제할 학생번호를 입력하세요");
//			}else {
//				//db작업 -> memberDAO
//				SSStudentDAO dao = new SSStudentDAO();
//				int result = dao.deleteRecord(Integer.parseInt(delNum)); //0이면삭제x 0이상이면삭제o
//				if(result>0) { //학생삭제됨
//					JOptionPane.showMessageDialog(this, delNum+"학생을 삭제하였습니다");
//					deleteTf.setText(" "); //입력창클리어
//					
//				}else {//학생삭제실패
//					JOptionPane.showMessageDialog(this, delNum+"학생삭제를 실패하였습니다");
//				}
//			}
//			
//		}
	
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
			v.add((String)table.getValueAt(row,2));
			v.add((String)table.getValueAt(row,3));
			v.add((String)table.getValueAt(row,4));
			v.add((String)table.getValueAt(row,5));
			v.add((String)table.getValueAt(row,6));
			v.add((String)table.getValueAt(row,7));
			v.add((String)table.getValueAt(row,8));
			v.add((String)table.getValueAt(row,9));
			v.add((String)table.getValueAt(row,10));
			updatemodel.addRow(v);	
			
		} 		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}	

	
	public static void main(String[] args) {
		new SSStudentMain();

	}

	

}
