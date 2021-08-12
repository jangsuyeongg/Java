import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ProfessorModeMain extends ProfessorModeUI implements ActionListener ,MouseListener {
	
	JPanel centerPane = new JPanel(new BorderLayout());//ProfessorModeUI 센터의 센터패널:이클래스의제일큰판
	
		JPanel northP; //개설강의목록 
			JPanel north_NPane;
				JLabel lb1;
			JPanel north_CPane;	
				JTable table;
				JScrollPane sp; 
				DefaultTableModel model;
				String title ;
		JPanel centerP; //선택된 강의 수정 패널
			JPanel center_NPane;
				JLabel lb2;
			JPanel center_CPane;
				JTable table2;
				JScrollPane sp2; 
				DefaultTableModel model2;
				String title2;
			JPanel center_SPane;
				JButton jbt;
		JPanel southP; // 강의검색후 삭제
			JPanel south_NPane;
				JLabel lb3;
			JPanel south_CPane;
				JLabel lb4;
				JTextField tf;
				JButton jbt2;	
			
				int Class_Code; //강의명으로가져온 삭제할 강의코드
				String searchClass; //삭제하려고 검색한 강의명
				
				
	public ProfessorModeMain() {
		init();
		add(centerPane);
		
		showProfClassAll();
		profClassAllList();
	}
	
	public void showProfClassAll() {
		//////////////강의개설목록////////////////////
		northP = new JPanel(new BorderLayout());
			north_NPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lb1 = new JLabel(" 개설강의목록");
			north_NPane.add(lb1);
		northP.add(BorderLayout.NORTH,north_NPane);
			north_CPane = new JPanel(new BorderLayout());
				title ="강의번호/교수이름/이수구분/강의명/학점/강의시간/강의실/수강인원/신청인원/강의등록일"; //StudentModeVO2사용
				model = new  DefaultTableModel(title.split("/"),0);
				table = new JTable(model);
				sp = new JScrollPane(table);
		    north_CPane.add(sp);
		northP.add(BorderLayout.CENTER,north_CPane);  
		
		centerPane.add(BorderLayout.NORTH,northP);
		northP.setPreferredSize(new Dimension(0,300));
		    
    	////////////선택된강의수정////////////////////    
		centerP = new JPanel(new BorderLayout()); //선택된 강의 수정 패널
			center_NPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lb2 = new JLabel(" 강의정보수정");
			center_NPane.add(lb2);
		centerP.add(BorderLayout.NORTH,center_NPane);
			center_CPane = new JPanel(new BorderLayout());
				title2 = "강의번호/교수이름/이수구분/강의명/학점/강의시간/강의실/수강인원/신청인원/강의등록일";;
				model2 = new  DefaultTableModel(title.split("/"),0);;
				table2 = new JTable(model2);
				sp2 = new JScrollPane(table2); 
			center_CPane.add(sp2);
		centerP.add(BorderLayout.CENTER,center_CPane);
			center_SPane = new JPanel(new FlowLayout());
				jbt= new JButton(" 수 정 ");//이벤트등록
			center_SPane.add(jbt);
		centerP.add(BorderLayout.SOUTH,center_SPane);
    
		centerPane.add(BorderLayout.CENTER,centerP);		
		////////////강의검색후삭제////////////////////    
		southP = new JPanel(new BorderLayout()); 
			south_NPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
				lb3= new JLabel(" 강의삭제 ");
			south_NPane.add(lb3);
		southP.add(BorderLayout.NORTH,south_NPane);
			south_CPane= new JPanel(new FlowLayout());
				lb4 =new JLabel("강의명");
				
				tf = new JTextField(20);
				jbt2 = new JButton(" 삭 제 ");//이벤트등록
			south_CPane.setBorder(new LineBorder(Color.GRAY,1,true));
			south_CPane.add(lb4); south_CPane.add(tf); south_CPane.add(jbt2);
		southP.add(south_CPane);
		south_CPane.setPreferredSize(new Dimension(0,120));
		
		centerPane.add(BorderLayout.SOUTH,southP);	
		
		table.addMouseListener(this); //***이벤트등록
		jbt.addActionListener(this);
		jbt2.addActionListener(this);
		
		 
	}
	
	//교수가개설한강의전체목록 가져오기 -JTable
	public void profClassAllList() {

		System.out.println("올리스트들어옴");
		ProfessorModeDAO dao = new ProfessorModeDAO();
		List<StudentModeVO2> list = dao.allClassRecord(); //전체학생정보저장소
		profClassModel(list);//불러온거 셋팅
			
	}
	//제이테이블에 목록띄워주기
	public void profClassModel(List<StudentModeVO2> list) { //리스트를받고		
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
		if(eventBtn==jbt) {//수정
			profClassUpdate();//수정메소드
			profClassAllList();
			model2.setRowCount(0); //수정할강의뜨는 부분 리셋
		}else if(eventBtn==jbt2) {//삭제
			getClassCode() ;//검색메소드:강의명입력 -> 그 강의명과일차하는데이터의 강의번호가져옴
			classDelete(Class_Code);//삭제메소드:가져온 강의번호를 가지고 강의삭제
			model2.setRowCount(0); 
			profClassAllList(); // 삭제하고 화면다시 새화면
		}
		
	}
	
	//개설강의수정
	public void profClassUpdate() {
		System.out.println("개설강의업데이트에도착");
		StudentModeVO2 vo = new StudentModeVO2();
		
		vo.setClass_code((Integer)(table2.getValueAt(0,0))); // ****not null //시퀀스넘버
		vo.setProf_name(String.valueOf(table2.getValueAt(0,1))); // not null
		vo.setClass_div(String.valueOf(table2.getValueAt(0,2))); //입력받은걸 vo저장송에 set
		vo.setClass_name((String)table2.getValueAt(0,3));
		vo.setClass_grade((String)table2.getValueAt(0,4));
		vo.setClass_time((String)table2.getValueAt(0,5));
		vo.setClass_room((String)table2.getValueAt(0,6)); 
		
		String a = String.valueOf(table.getValueAt(0,7)); //수강인원
		int a1 = Integer.parseInt(a);		
		vo.setTot_mem(a1);
		
		String b = String.valueOf(table.getValueAt(0,8));//신청인원
		int b1 = Integer.parseInt(b);
		vo.setReg_mem(b1);
		
		vo.setClass_date((String)table2.getValueAt(0,9));		
		
		
		ProfessorModeDAO dao = new ProfessorModeDAO();
		int cnt = dao.updateClassRecord(vo); //DAO클래스의 update메소드를 이용하여 쿼리문으로 수정함
		
		if(cnt>0){//수정시 리스트 다시 선택하기
			System.out.println("main 강의정보수정성공");
			JOptionPane.showMessageDialog(this,"강의정보 수정 완료하였습니다");			
			//profClassAllList();
			//model2.setRowCount(0); //수정테이블 리셋 //왜 안없어지지?
		}else {
			//수정실패하면 안내메시지 표시
			System.out.println("main 강의정보수정오류");
			JOptionPane.showMessageDialog(this,"강의정보 수정 실패하였습니다");
		}
	}
	

	//강의명으로 강의번호가져오기
	public void getClassCode() {
		searchClass =tf.getText(); //강의명검색한거 겟
		
		if(searchClass!=null && !searchClass.equals(" ")) {
			ProfessorModeDAO dao = new ProfessorModeDAO();
			//찾기메소드
			Class_Code = dao.searchCladdCode(searchClass);//강의명으로 강의코드가져옴	
			
			tf.setText(" ");
		}else if(searchClass==null && searchClass.equals(" ")){
			JOptionPane.showMessageDialog(this, "삭제할 강의명을 입력하세요");
		}else {
			JOptionPane.showMessageDialog(this, "존재하지 않는 강의명 입니다");
		}
	}
	
//	//개설강의삭제
	public void classDelete(int code) {//번호를 가져와서 테이블에 있는지 없는지 확인하고
		
				ProfessorModeDAO dao = new ProfessorModeDAO();
				
				int cnt = dao.deleteClassRecord(code); 
				if(cnt>0) { //강의삭제됨
					JOptionPane.showMessageDialog(this, searchClass+"강의를 삭제하였습니다");
					profClassAllList();
					tf.setText(" "); //입력창클리어
					
				}else {//강의삭제실패
					JOptionPane.showMessageDialog(this, searchClass+"강의삭제를 실패하였습니다");
				}
			
			
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	//왼쪽마우스로  행 클릭시 아래쪽 테이블에 선태한 행의 정보가 뜸
	public void mouseReleased(MouseEvent e){
		if(e.getButton()==1) {//왼쪽버튼클릭
			model2.setRowCount(0);
			int row = table.getSelectedRow(); //현재클릭한행구해줌

		
			Vector<Object> v = new Vector<Object>();
			v.add((Integer)table.getValueAt(row,0)); //강의번호
			v.add(String.valueOf(table.getValueAt(row,1))); //교수이름
			v.add(String.valueOf(table.getValueAt(row,2)));//이수구분
			v.add(String.valueOf(table.getValueAt(row,3)));//강의명
			v.add(String.valueOf(table.getValueAt(row,4)));//학점
			v.add(String.valueOf(table.getValueAt(row,5)));//강의시간
			v.add(String.valueOf(table.getValueAt(row,6)));//강의실
			
			String a = String.valueOf(table.getValueAt(row,7)); //수강인원
			int a1 = Integer.parseInt(a);
			v.add(a1);
			
			String b = String.valueOf(table.getValueAt(row,8));//신청인원
			int b1 = Integer.parseInt(b);
			v.add(b1);
			
			v.add(String.valueOf(table.getValueAt(row,9))); //강의등록일
			
			model2.addRow(v);	

		} 		
		
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}	

	
	public static void main(String[] args) {
		new ProfessorModeMain();

	}

}
