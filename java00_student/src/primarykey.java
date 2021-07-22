
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class primarykey extends JFrame implements ActionListener{
	JPanel formPane =new JPanel(new BorderLayout());
		JPanel formWestPane= new JPanel(new GridLayout(4,1));
			String str1[]= {" �� �� �� ȣ  "," �� �� "," �� �� ��ȭ ��ȣ "," ���� �繫�� "};
		JPanel formCenter = new JPanel(new GridLayout(4,1,5,5));
			JTextField tf1 = new JTextField(5);
			JTextField tf2 = new JTextField(50);
			JTextField tf3 = new JTextField(10);
			JTextField tf4 = new JTextField(30);
			
		JPanel centerPane = new JPanel(new BorderLayout());
			JPanel btnList = new JPanel(new GridLayout(1,0,3,3));	
				JButton[]btn = {new JButton("���"), new JButton("�߰�"), new JButton("����"), new JButton("����")};
	 
	int MajoradminNumber,MajorPhone;//�Է¹��������� ������ ����
	String Major_Name,Major_Office;
	
	//db����
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		}catch(ClassNotFoundException c) {
			System.out.println("����̺�ε�����..");
		}		
	}
		
	Connection conn;
	PreparedStatement pstmt;

	
	public primarykey() {
		
		super("pkŰ �Է�");
		
		//Frame - North
		setForm();
		//Frame - Center
		setButtonTable();
		
		setSize(1024,768);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public void setForm() {
		
		add(BorderLayout.NORTH,formPane);
			formPane.add(BorderLayout.WEST,formWestPane);
				for(int i=0; i<str1.length; i++) {
					JLabel lb1 = new JLabel(str1[i]);
					formWestPane.add(lb1);
				}
			formPane.add(BorderLayout.CENTER,formCenter);
//				for(int i=0; i<Tf.length; i++) {
//					JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); //��������
//					p.add(Tf[i]);					
//					formCenter.add(p);
//				}
			JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); //��������
			p.add(tf1);	
			JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			p2.add(tf2);
			JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			p3.add(tf3);
			JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			p4.add(tf4);			
			
			formCenter.add(p);	
			formCenter.add(p2);	
			formCenter.add(p3);	
			formCenter.add(p4);	
	}
	
	//Frame - Center
	public void setButtonTable() {
		
		add(centerPane);
		centerPane.add(BorderLayout.NORTH,btnList);
			for(int i=0; i<btn.length; i++) {
				btnList.add(btn[i]);
				//�̺�Ʈ���
				btn[i].addActionListener(this); // ��� �߰� ���� ����
			}
	}
	
	//������ȣ : ��ư�� ������ ���̺� ���� �߰��ϴ¸޼ҵ�
	public void majorOutputdata() {		
		
		MajoradminNumber = Integer.parseInt(tf1.getText());
		Major_Name = tf2.getText();
		MajorPhone = Integer.parseInt(tf3.getText());
		Major_Office = tf4.getText();
		
		try {
			//db����
			//db����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##scott","tiger");
			String sql = "insert into Major(Major_number,Major,Major_Phone,Major_Location) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MajoradminNumber);
			pstmt.setString(2, Major_Name);
			pstmt.setInt(3, MajorPhone);
			pstmt.setString(4, Major_Office);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("���ڵ尡 �߰� �Ǿ����ϴ�");
			}else {
				System.out.println("���ڵ� �߰� �����Ͽ����ϴ�");
			}		
		}catch(SQLException s) {
			System.out.println("�����ͺ��̽� ���� ���� �߻�--->"+s.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();			
			}catch(Exception e) {
				System.out.println("�ݱ� ����...");
			}
		}
	
	}
	
	
	//���¸޼ҵ�
	public void resetData() {
		
//		this.adminNumber = Integer.valueOf(" ");
//		this.studentNumber = Integer.valueOf(" ");
//		this.professorNumber = Integer.valueOf(" ");
		tf1.setText(" ");
		tf2.setText(" ");
		tf3.setText(" ");
		tf4.setText(" ");
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		JButton event= (JButton)ae.getSource(); 
		String btnLb1 = event.getText(); 
		
		switch(event.getText()) {
			
		case "�߰�" :
			majorOutputdata();
			resetData();
			break;
			
		
		}
	}
	

	public static void main(String[] args) {
		new primarykey();
		

	}

}
