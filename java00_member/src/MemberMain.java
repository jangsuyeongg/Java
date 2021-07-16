import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberMain extends JFrame implements ActionListener{
	//JFrame - North
	JPanel formPane = new JPanel(new BorderLayout());
		JPanel formWestPane = new JPanel(new GridLayout(6,1));
			String formLbl[] = {"번  호","이  름","연락처","이메일","주  소","등록일"};
		JPanel formCenter = new JPanel(new GridLayout(6,1,5,5));
			JTextField[] formTf = {new JTextField(5), new JTextField(15),new JTextField(20),
					new JTextField(30),new JTextField(45),new JTextField(20)};
			
	//JFrame - Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel btnList = new JPanel(new GridLayout(1,0,3,3));
			JButton[] btn = {new JButton("전체목록"), new JButton("사원추가"),
					new JButton("사원수정"), new JButton("사원삭제"),new JButton("폼지우기"), 
					new JButton("종료"),	new JButton("엑셀쓰기"), new JButton("엑셀읽기")};
		DefaultTableModel model;
		String title = "번호/이름/연락처/이메일/주소/등록일";
		JTable memberList;
		JScrollPane sp;
			
	public MemberMain() {
		super("회원관리시스템");
		
		//Frame - North
		setForm();
		//Frame - Center
		setButtonJTable();
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
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
						JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); // jpanel 에 한번더 담아야 함..
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
		
	}

	public static void main(String[] args) {
		new MemberMain();
	}
}
