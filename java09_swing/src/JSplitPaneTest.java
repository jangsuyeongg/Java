import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class JSplitPaneTest extends JFrame{
	JSplitPane sp1, sp2;
	CalculatorEx2 cal = new CalculatorEx2();
	SwingCalendar2 calendar = new SwingCalendar2();
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	public JSplitPaneTest() {
		// 수직나누기 
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, cal, calendar); //세로
		// 수평나누기
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, sp);//수평-가로로 
	
		add(sp1);
		//경게선의 위치를 설정할수 있다.
		sp2.setDividerLocation(350);//위쪽이 350px, 아래쪽은 남은영역
		sp1.setDividerLocation(800);//왼쪽이 800px
		
		//경계선의 두께 설정
		sp2.setDividerSize(0);
		sp1.setDividerSize(20);
		
		//원터치
		sp1.setOneTouchExpandable(true);//화살표로 원터치하면 확대축소 해주는 기능
		
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JSplitPaneTest();
	}
}
