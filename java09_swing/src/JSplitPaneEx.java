import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;


public class JSplitPaneEx extends JFrame{
	JSplitPane spHori, spClockCalendar, spCalcu, spPack;
	DigitalClock3 dc = new DigitalClock3(0,0);
	SwingCalendar2 swingCal = new SwingCalendar2();
	CalculatorEx2 cal = new CalculatorEx2();
	
	ImageIcon ii = new ImageIcon("img/kakao2.jfif");
	JLabel lbl = new JLabel(ii);
	
	PackMan2 pm = new PackMan2();
	public JSplitPaneEx() {
		//시계, 달력
		spClockCalendar = new JSplitPane(JSplitPane.VERTICAL_SPLIT,dc,swingCal);
		spCalcu = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spClockCalendar, cal);
		spPack = new JSplitPane(JSplitPane.VERTICAL_SPLIT,lbl,pm);
		spHori = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, spCalcu, spPack);
		
		add(spHori);
		
		setSize(1200,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);// true: 창크기 조절 가능, false: 창크기 고정
		
		//팩맨
		pm.packmanStart(pm);
		
	}

	public static void main(String[] args) {
		new JSplitPaneEx();

	}

}
