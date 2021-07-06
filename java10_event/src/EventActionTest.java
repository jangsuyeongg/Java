import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventActionTest extends JFrame implements ActionListener{
	//	ActionEvent, ActionListener(interface) 
	JButton btn = new JButton("클릭하세요");
	JButton btn2 = new JButton("확인");
	public EventActionTest() {
		add(BorderLayout.NORTH,btn);
		add(BorderLayout.SOUTH,btn2);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트처리
		//1. 인터페이스를 상속받는다.
		//2. 이벤트가 발생하는 컴퍼넌트를 등록한다.
		btn.addActionListener(this);
		btn2.addActionListener(this);// 현재클래스에서 메소드를검색해서 실행해~
	}
	//3. 추상메소드를 오버라이딩한다.	이벤트종류
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		//JButton eventBtn = (JButton)ae.getSource(); 둘중하나 
		
		if(obj == btn) {
			gugudan(7);
		}else if(obj == btn2) {
			System.exit(0);
		}
	}
	/*public void actionPerformed(ActionEvent ae) {
		//getActionCommend(): 이벤트가 발생한 컴퍼넌트의 라벨을 구한다.
		String event =ae.getActionCommand();
		if(event.equals("클릭하세요")) {
			//구구단
			gugudan(6);
		}else if(event.equals("확인"));{
		//프로그램종료
		System.exit(0);
		}
		//System.out.println("이벤트가 발생함..."+event);
	}
	*/
	public void gugudan(int dan) {
		for(int i=2;i<10; i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}
	}
	
	public static void main(String[] args) {
		new EventActionTest();

	}

}
