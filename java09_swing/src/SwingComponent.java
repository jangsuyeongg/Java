import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SwingComponent {
	JFrame frm = new JFrame("컴포넌트연습중");
	Rectangle frmSize = new Rectangle(200,200,500,500);//x,y,w,h
	public SwingComponent() {
		frm.setTitle("Component");
		//JTextField : 한줄의 문자열을 입력할 수 있는 컴퍼넌트
		//JFrame ->FlowLayout을 변경
		frm.setLayout(new FlowLayout());
		
		JTextField tf = new JTextField(10);
		frm.add(tf);
		
		JTextField tf2 = new JTextField("ABCDEFG", 20);
		//값을 변경하기
		tf2.setText("텍스트 필드의 값이 변경되었습니다.");
		
		try {
			String str1 = tf2.getText();
			String str2 = tf2.getText(2,3);
			System.out.println("str1-->"+str1);
			System.out.println("str2-->"+str2);
		} catch (Exception e) {
			
		}
		frm.add(tf2);
		//JPasswordField : 문자를 마크업 해준다.
		JPasswordField
		pf = new JPasswordField(20);
		frm.add(pf);
		
		//JTextArea: 여러줄의 문자열을 입력하는 컴퍼넌트
		JTextArea ta = new JTextArea(5, 30);
		JScrollPane sp = new JScrollPane(ta);//스크롤기능이 있는 컨테이너
		frm.add(sp);
		
		
		//JCheckBox :여러개를 선택할 수 있는 컴퍼넌트
		JCheckBox cb1 = new JCheckBox("사과");
		JCheckBox cb2 = new JCheckBox("베", true);
		frm.add(cb1);
		frm.add(cb2);
		
		//JSlider : 스틱을 이용한 값 선책
		JSlider s1 = new JSlider(JSlider.HORIZONTAL, 1, 10, 5); 
		frm.add(s1);
		
						//x,y,w,h
		frm.setBounds(frmSize);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new SwingComponent();
	}
}
