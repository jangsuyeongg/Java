

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ManageStudent extends JFrame implements ActionListener{
	//JFrame - North
	DBConnection DB = new DBConnection();
		JPanel formPane = new JPanel(new BorderLayout());
			JPanel formWestPane = new JPanel(new GridLayout(9,1));
				String formLbl[] = {"학생번호","학생이름","학생학년","학생상태","학생이메일","학생핸드폰","학생주소","학생생일","학생비밀번호"};
			JPanel formCenter = new JPanel(new GridLayout(9,1,5,5));
				JTextField[] formTf = {new JTextField(10), new JTextField(10),new JTextField(25),
						new JTextField(25),new JTextField(12),new JTextField(25),new JTextField(25),new JTextField(10),new JTextField(10)};
		
		//JFrame - Center
		JPanel centerPane = new JPanel(new BorderLayout());
			JPanel btnList = new JPanel(new GridLayout(1,0,3,3));
				JButton[] btn = {new JButton("전체목록"), new JButton("학생추가"),
						new JButton("학생수정"), new JButton("학생삭제")};
			DefaultTableModel model;
			String title = "학생번호/학생비밀번호/학생이름/학생이메일/학생핸드폰/학생주소/학생상태/학생가입일자";
			JTable memberList;
			JScrollPane sp;
				
	public ManageStudent() {
		super("학생관리시스템");
		
		//Frame - North
		setForm();
		//Frame - Center
		setButtonJTable();
		
		setSize(1024,768);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		for(int i=0; i<btn.length; i++)
		{
			btn[i].addActionListener(this);
		}
	}
	//Frame-North
	public void setForm() {
		add(BorderLayout.NORTH,formPane);
			formPane.add(BorderLayout.WEST,formWestPane);
				for(int i=0; i<formLbl.length; i++) {
					JLabel lbl = new JLabel(formLbl[i]);
					formWestPane.add(lbl);
				}
			formPane.add(BorderLayout.CENTER,formCenter);
				for(int i=0; i<formTf.length;i++) {
					JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
					p.add(formTf[i]);
					formCenter.add(p);
				}
	}
	//Frame-Center
	public void setButtonJTable() {
		add(centerPane);
			centerPane.add(BorderLayout.NORTH,btnList);
				for(int i=0;i<btn.length;i++) {
					btnList.add(btn[i]);
					//이벤트등록
					btn[i].addActionListener(this);
				}
	//JTable							제목
			model = new DefaultTableModel(title.split("/"),0);
			memberList = new JTable(model);
			sp = new JScrollPane(memberList);
			centerPane.add(sp);
			
			
			
		
			
			
				
	}
	public void actionPerformed(ActionEvent ae) {
		String event = ae.getActionCommand();
		if(event.equals("학생추가")) {
			insertNewStudent();	
		}
	}
	
	public void insertNewStudent() {
		String[]data=new String[9];
		for(int i=0;i<formTf.length;i++) {
			data[i]= formTf[i].getText();
		}
		new InsertStudent(data, centerPane);
	}
		
	public static void main(String[] args) {
		new ManageStudent();
	}

}
