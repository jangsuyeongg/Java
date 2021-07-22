

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
				String formLbl[] = {"�л���ȣ","�л��̸�","�л��г�","�л�����","�л��̸���","�л��ڵ���","�л��ּ�","�л�����","�л���й�ȣ"};
			JPanel formCenter = new JPanel(new GridLayout(9,1,5,5));
				JTextField[] formTf = {new JTextField(10), new JTextField(10),new JTextField(25),
						new JTextField(25),new JTextField(12),new JTextField(25),new JTextField(25),new JTextField(10),new JTextField(10)};
		
		//JFrame - Center
		JPanel centerPane = new JPanel(new BorderLayout());
			JPanel btnList = new JPanel(new GridLayout(1,0,3,3));
				JButton[] btn = {new JButton("��ü���"), new JButton("�л��߰�"),
						new JButton("�л�����"), new JButton("�л�����")};
			DefaultTableModel model;
			String title = "�л���ȣ/�л���й�ȣ/�л��̸�/�л��̸���/�л��ڵ���/�л��ּ�/�л�����/�л���������";
			JTable memberList;
			JScrollPane sp;
				
	public ManageStudent() {
		super("�л������ý���");
		
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
					//�̺�Ʈ���
					btn[i].addActionListener(this);
				}
	//JTable							����
			model = new DefaultTableModel(title.split("/"),0);
			memberList = new JTable(model);
			sp = new JScrollPane(memberList);
			centerPane.add(sp);
			
			
			
		
			
			
				
	}
	public void actionPerformed(ActionEvent ae) {
		String event = ae.getActionCommand();
		if(event.equals("�л��߰�")) {
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
