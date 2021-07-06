import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//하나씩, 배열로, 벡터로 모델로 콤보박스에 내용넣음 

public class JComboBoxTest extends JFrame implements ItemListener {
	JPanel pane = new JPanel();
	JComboBox<String> cb1 = new JComboBox<String>();
	JComboBox<String> cb2, cb3, cb4;
	
	JLabel lbl = new JLabel("선택값 표시되는 곳", JLabel.CENTER);
	Color clr[] = {Color.red, Color.blue, Color.green, Color.white,Color.black};
	public JComboBoxTest() {
		add(BorderLayout.NORTH,pane);
		pane.add(cb1);
		
		lbl.setOpaque(true);//투명화
		add(lbl);
		
		//목록추가
		cb1.addItem("자바");
		cb1.addItem("스프링");
		cb1.addItem("JSP");
		
		//배열의 데이터를 목록만들기
		String comboList[] = {"RED", "BLUE","GREEN","WHILE","BLACK"};
		cb2 = new JComboBox(comboList);
		pane.add(cb2);
		
		//컬렉션(Vector)을 이용한 목록만들기
		Vector<String> v = new Vector<String>();
		v.add("AAAAA");
		v.add("BBBBB");
		v.add("CCCCC");
		
		cb3 = new JComboBox(v);
		pane.add(cb3);
		//모델을 이용한 목록 만들기 
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("장미");
		model.addElement("국화");
		model.addElement("튤립");
		cb4 = new JComboBox<String>(model);
		pane.add(cb4);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록 
		cb2.addItemListener(this);
		cb4.addItemListener(this);
	}
	//오버라이딩
	public void itemStateChanged(ItemEvent ie) {
	JComboBox event= (JComboBox)ie.getSource();
	if(event.equals(cb2)) {
		//선택목록의 index가져오기
		int idx = cb2.getSelectedIndex();
		lbl.setBackground(clr[idx]);
	}else if(event.equals(cb4)) {
		lbl.setText((String)cb4.getSelectedItem());	
	}
}
	
	public static void main(String[] args) {
		new JComboBoxTest();
	}
}
