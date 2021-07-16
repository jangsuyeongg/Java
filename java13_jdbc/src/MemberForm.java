import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberForm extends JFrame{
	
	JSplitPane sp1,sp2,sp3;
	JTable table;
	JScrollPane sp; 
	JTextField tf = new JTextField();
	DefaultTableModel model;
	String title[] = {"번호","이름","전화번호","이메일","주소","등록일"}; 
	JPanel pane = new JPanel();
	JPanel pane1 = new JPanel(new FlowLayout());
	JPanel pane2 = new JPanel(new GridLayout(1,7));
	JPanel pane3 = new JPanel();
	JButton btn = new JButton();
	

	public MemberForm() {
		
		sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,pane1,pane2);
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,pane);
		sp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp2,pane3);
		
		add(sp3);
	
		pane1.setLayout(new FlowLayout(50));
		JLabel lb1 = new JLabel("번호");
		JTextField tf1 = new JTextField(10);
		JLabel lb2 = new JLabel("이름");
		JTextField tf2 = new JTextField(10);
		JLabel lb3 = new JLabel("전화번호");
		JTextField tf3 = new JTextField(30);
		JLabel lb4 = new JLabel("이메일");
		JTextField tf4 = new JTextField(30);
		JLabel lb5 = new JLabel("주소");
		JTextField tf5 = new JTextField(40);
		JLabel lb6 = new JLabel("등록일");
		JTextField tf6 = new JTextField(40);
		
		
		pane1.add(lb1);
		pane1.add(tf1);
		pane1.add(lb2);
		pane1.add(tf2);
		pane1.add(lb3);
		pane1.add(tf3);
		pane1.add(lb4);
		pane1.add(tf4);
		pane1.add(lb5);
		pane1.add(tf5);
		pane1.add(lb6);
		pane1.add(tf6);
		add(sp3);
		
		
		JButton btn1= new JButton("추가");
		JButton btn2= new JButton("수정");
		JButton btn3= new JButton("삭제");
		JButton btn4= new JButton("지우기");
		JButton btn5= new JButton("종료");
		JButton btn6= new JButton("엑셀로저장");
		JButton btn7= new JButton("엑셀불러오기");

		pane2.add(btn1);
		pane2.add(btn2);
		pane2.add(btn3);
		pane2.add(btn4);
		pane2.add(btn5);
		pane2.add(btn6);
		pane2.add(btn7);
		
		add(sp3);
		
		sp1.setDividerLocation(250);
		sp2.setDividerLocation(300);
		sp3.setDividerLocation(500);
		
		sp2.setDividerSize(1);
		sp1.setDividerSize(1);
		sp3.setDividerSize(1);
		
		
		model = new DefaultTableModel(title,0);
		table = new JTable(model); 
		table.setModel(model);
		sp = new JScrollPane(table);
		pane.add(sp);
		add(sp3);
		
		
		JTextField tf7 = new JTextField(20);
		JButton btn8 = new JButton("Searth");
		
		pane3.add(tf7);
		pane3.add(btn8);
		add(sp3);
	
		
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MemberForm();
	}
}
