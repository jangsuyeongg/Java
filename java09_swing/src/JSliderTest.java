import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class JSliderTest  extends JFrame {
	JSlider s1 = new JSlider(JSlider.HORIZONTAL, 0,100,40);
	JSlider s2 = new JSlider(JSlider.VERTICAL, 0,100,50);

	public JSliderTest (){
		//s1에 옵션설정
		s1.setMajorTickSpacing(10);//주눈금표시
		s1.setMinorTickSpacing(2);//보조눈금
		s1.setPaintTicks(true);//눈금보여주기
		s1.setPaintLabels(true);//라벨표시(주 눈금단위로 숫자로 보여주기)
		
		//s2
		//라벨만들기
		Hashtable<Integer, JLabel> ht = new Hashtable<Integer,JLabel>();
		ht.put(0,new JLabel("하"));
		ht.put(50, new JLabel("중"));
		ht.put(100, new JLabel ("상"));
		
		s2.setMajorTickSpacing(50);//눈금간격
		s2.setLabelTable(ht);//사용자정의 라벨설정
		s2.setPaintTicks(true);//눈금보이기
		s2.setPaintLabels(true);//라벨보이기
		
		//자동눈금선으로 이동하기 
		s2.setSnapToTicks(true);
		
		
		add(BorderLayout.NORTH,s1);
		add(BorderLayout.WEST,s2);
		
		setSize(500,500);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new JSliderTest();
	}
}
