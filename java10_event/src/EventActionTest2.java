import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventActionTest2 extends JFrame{
	JButton okBtn = new JButton("OK");
	JLabel lbl = new JLabel("jjjj",JLabel.CENTER);
	public EventActionTest2() {
		add(BorderLayout.NORTH,okBtn);
		add(lbl);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		okBtn.addActionListener(new EventProcess(lbl));
		
	}

	public static void main(String[] args) {
		new EventActionTest2();

	}

}
