import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JListTest extends JFrame implements ActionListener{
	
	JPanel pane = new JPanel(new GridLayout(2,1));
	JButton leftBtn = new JButton("<--");
	JButton rightBtn = new JButton("-->");
	
	DefaultListModel<String> leftModel = new DefaultListModel<String>(); 
	JList<String> leftList = new JList<String>(leftModel);
	JScrollPane sp1 = new JScrollPane(leftList);
	DefaultListModel<String> rightModel = new DefaultListModel<String>(); 
	JList<String> rightList = new JList<String>(rightModel);
	JScrollPane sp2 = new JScrollPane(rightList);
	
	String data[] = {"사과","포도","망고","파인애플","바나나","체리","키위","오렌지","토마토","수박"};
	String data2="장미/백합/튤립/코스모스/맨드라미";
	
	public JListTest() {
		for(int i=0; i<data.length;i++) {
			leftModel.addElement(data[i]);
		}
		
		StringTokenizer st = new StringTokenizer(data2,"/");
		while(st.hasMoreTokens()) {
			rightModel.addElement(st.nextToken());
		}
		
		
		pane.add(leftBtn);
		pane.add(rightBtn);
		add(pane);
		add(BorderLayout.WEST,sp1);
		add(BorderLayout.EAST,sp2);
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if (event == leftBtn) {
			listDataChanged(rightList, leftList);      // 오->왼
		}else if(event==rightBtn) {
			listDataChanged(leftList, rightList);      // 왼->오
		}
	}
	//							원데이터소스	   옮길곳
	public void listDataChanged(JList orgList, JList tarList) {
		DefaultListModel<String> orgModel = (DefaultListModel)orgList.getModel();//remove
		DefaultListModel<String> tarModel = (DefaultListModel)tarList.getModel();// add
		
		List<String> list = orgList.getSelectedValuesList();//사과, 키위, 오렌지
		for(int i=0; i<list.size(); i++) {
			tarModel.addElement(list.get(i));//추가
			orgModel.removeElement(list.get(i));//삭제
		}
	}

	public static void main(String[] args) {
		new JListTest();
	}
}
