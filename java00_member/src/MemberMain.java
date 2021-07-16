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
			String formLbl[] = {"��  ȣ","��  ��","����ó","�̸���","��  ��","�����"};
		JPanel formCenter = new JPanel(new GridLayout(6,1,5,5));
			JTextField[] formTf = {new JTextField(5), new JTextField(15),new JTextField(20),
					new JTextField(30),new JTextField(45),new JTextField(20)};
			
	//JFrame - Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel btnList = new JPanel(new GridLayout(1,0,3,3));
			JButton[] btn = {new JButton("��ü���"), new JButton("����߰�"),
					new JButton("�������"), new JButton("�������"),new JButton("�������"), 
					new JButton("����"),	new JButton("��������"), new JButton("�����б�")};
		DefaultTableModel model;
		String title = "��ȣ/�̸�/����ó/�̸���/�ּ�/�����";
		JTable memberList;
		JScrollPane sp;
			
	public MemberMain() {
		super("ȸ�������ý���");
		
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
						JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); // jpanel �� �ѹ��� ��ƾ� ��..
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
		
	}

	public static void main(String[] args) {
		new MemberMain();
	}
}
