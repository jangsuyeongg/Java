import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame{
	JTabbedPane tp;
	
	JLabel lbl;
	ImageIcon ii = new ImageIcon("img/kakao2.jfif");
	JButton btn;
	ImageIcon iii = new ImageIcon("img/aaaaa.jfif");
	DigitalClock3 dc = new DigitalClock3(0,0);
	CalculatorEx2 cal = new CalculatorEx2();
	SwingCalendar2 calendar = new SwingCalendar2();
	PackMan2 pm = new PackMan2();
	public JTabbedPaneTest() {
		super("탭메뉴");
		tp = new JTabbedPane(JTabbedPane.LEFT);
		tp.addTab("계산기", cal);
		lbl = new JLabel(ii);
		tp.addTab("레이블", lbl);
		btn = new JButton(iii);
		tp.addTab("버튼", btn);
		
		tp.addTab("시계", dc);
		tp.addTab("팩맨", pm);
		tp.addTab("달력", null, calendar, "달력");
		
		tp.insertTab("Button", null, new JButton("추가된 버튼"),"중간에 탭매뉴 추가",3);
		
		//탭의 활성화 및 비활성화
		
		//true:활성화, false:비활성화
		//				탭Index, true/false
		//tp.setEnabledAt(2, false);
		//첫번쨰 탭을 제외한 나머지 모든 탭을 비활성화한다.
		//tp.setEnabled(false);
		
	
		add(tp);
		setSize(500,500);

		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pm.setCanvasSize(); //팩맨 캔버스 크기를 설정한다.
		Thread t = new Thread(pm);
		t.start();
	//	tp.addTab("팩맨", pm);
		//탭의 삭제
		//try {Thread.sleep(3000);}catch(Exception e) {}
		//tp.removeTabAt(3);
	}

	public static void main(String[] args) {
		new  JTabbedPaneTest ();
	}
}
