import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
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


public class StudentMode_delete extends StudentModeUI_2 implements ActionListener{
	JPanel pane = new JPanel(new BorderLayout());
		JPanel northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
			DefaultComboBoxModel<String> searchModel = new DefaultComboBoxModel<String>();
			JComboBox<String> searchkey = new JComboBox<String>(searchModel);
			JTextField searchWord = new JTextField(20);	
			JButton searchBtn = new JButton("검색");
			JButton newBtn = new JButton("새로고침");
			JLabel northLbl = new JLabel("수강신청목록");
		JPanel centerPane = new JPanel(new BorderLayout());
			DefaultTableModel model;
			JTable studentModelist;
			JScrollPane sp;
			JButton delbtn = new JButton("수강취소");
		JPanel southPane = new JPanel();
			int row;
			
			
			int willBeRemoved ;//취소할 강으코드
	public StudentMode_delete() {
		init();
		setForm();
		studentModelist.addMouseListener(new MyEvent());
		searchBtn.addActionListener(this);
		delbtn.addActionListener(this);
		newBtn.addActionListener(this);
	}
	
	public void setForm() {
		//north
		add(pane);
		pane.add(BorderLayout.NORTH,northPane);
			northPane.add(northLbl);	
		setSearchForm();
		northPane.add(newBtn);
		//center
		String title = "강의코드/담당이름/강의이름/이수구분/학점/강의시간/강의실/수강인원/신청인원/강의승인시각";
		model = new DefaultTableModel(title.split("/"),0);
		studentModelist = new JTable(model);
		sp = new JScrollPane(studentModelist);
		StudentModeAllList();
		centerPane.add(sp); 
		
		pane.add(BorderLayout.CENTER,centerPane);
		pane.add(BorderLayout.SOUTH,southPane);	
		
		//남쪽
		southPane.add(delbtn);
	    pane.add(BorderLayout.SOUTH, southPane); 
	    
		southPane.setBorder(new LineBorder(Color.GRAY,1,true));
		delbtn.setBackground(new Color(33, 140, 116));
		delbtn.setForeground(Color.white);
		delbtn.setFont(font);
		delbtn.setPreferredSize(new Dimension(110, 30)); //버튼어디에정렬
		
	
	}
	public void setSearchForm() {
		searchModel.addElement("강의코드");
		searchModel.addElement("담당이름");
		searchModel.addElement("강의이름");
		northPane.add(searchkey);
		northPane.add(searchWord);
		northPane.add(searchBtn);		 
		
	}
	public void StudentModeAllList() {
		StudentModeDAO dao = new StudentModeDAO();
		List<StudentModeVO2> list = dao.allRecord2();
		setStudentModeModel(list);
	}
	
	public void setStudentModeModel(List<StudentModeVO2> list) {
		//기존 JTable의 목록을 지우고 새로 리스트를 출력한다. 
		model.setRowCount(0);
		//컬렉션에 있는 vo를 get하여 JTable에 목록으로 추가한다.
		for(int i=0;i<list.size();i++) {
			StudentModeVO2 vo = list.get(i);
			Object[] obj = {vo.getClass_code(), vo.getProf_name(), vo.getClass_name(),vo.getClass_div(),
					vo.getClass_grade(),vo.getClass_time(),vo.getClass_room(),vo.getTot_mem(),
					vo.getReg_mem(),vo.getClass_date()};
			System.out.println(vo.getProf_name());
			model.addRow(obj);
		}
	}
	public void actionPerformed(ActionEvent ae) {
		   String eventBtn = ae.getActionCommand();
			if(eventBtn.equals("수강취소")) {
				StudentModeDelete();
			}else if(eventBtn.equals("검색")) {
				StudentModeSearch();
			}else if(eventBtn.equals("새로고침")) {
				StudentModeAllList();
			}
	   }
	public void StudentModeDelete() {
		//삭제할 신청목록
		JOptionPane op = new JOptionPane();
		//Object willBeRemoved = model.getValueAt(row, 0);
		willBeRemoved =(Integer)model.getValueAt(row, 0);

		StudentModeDAO dao = new StudentModeDAO();
		int que = op.showConfirmDialog(this,"정말 취소하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
		if(que == JOptionPane.YES_OPTION) {
			model.removeRow(row);
			int result = dao.deleteRecord(willBeRemoved);

			if(result>0) {
				updateClassList();
				JOptionPane.showMessageDialog(this,"강의취소 하였습니다.");
				StudentModeAllList();
				
			}else {
				JOptionPane.showMessageDialog(this,"강의취소 실패하였습니다.");
			}

		}else if(que ==JOptionPane.NO_OPTION) {
			
		}
	}
	public void updateClassList() {
		willBeRemoved =(Integer)model.getValueAt(row, 0);
	      
	      ClassVO vo = new ClassVO();
	      vo.setClass_code(willBeRemoved);
	      
	      StudentModeDAO dao = new StudentModeDAO();
	      System.out.println("다오만들어졌다 확인");
	      int cnt = dao.updateRecord(vo);
	      System.out.println("!!확인");
	      System.out.println(cnt);
	      
	      if(cnt>0){//수정시 리스트 다시 선택하기
	    	  System.out.println("main신청인원-1");
	      }else {
	         //수정실패하면 안내메시지 표시
	         
	         JOptionPane.showMessageDialog(this,"수강신청인원 수정 실패하였습니다");
	      }

	}
	
	
	
	//검색
	public void StudentModeSearch() {
		//검색어가 입력되어있는지 확인.
		String search = searchWord.getText();
		if(search!=null && !search.equals("")) {//검색어가 있다. 
			String searchField = (String)searchkey.getSelectedItem();//검색키 이름 전화번호 주소
			String fieldName = "";
			if(searchField.equals("강의코드")) {
				fieldName = "c.class_code";
			}else if(searchField.equals("담당이름")) {
				fieldName = "p.prof_name";
			}else if(searchField.equals("강의이름")) {
				fieldName = "c.class_name";
			}
			
			StudentModeDAO dao = new StudentModeDAO();
			List<StudentModeVO2> list = dao.searchRecord(search,fieldName);
			setStudentModeModel(list);
			searchWord.setText("");
		}
	}
	
	
	
	public class MyEvent extends MouseAdapter{
		//재오버라이딩
		@Override
		public void mouseClicked(MouseEvent me) {
			int eventBtn = me.getButton();
			if(eventBtn==1) {
				row = studentModelist.getSelectedRow();
				
				
			}
		}
	}
	public static void main(String[] args) {
		new StudentMode_delete();
		

	}

}
