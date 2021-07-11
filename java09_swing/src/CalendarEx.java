import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarEx extends JFrame implements ActionListener{
	Calendar now = Calendar.getInstance();
	JPanel centerPanel = new JPanel(new GridLayout(1,7));
	JPanel pane = new JPanel();
	JComboBox<Integer> c1 = new JComboBox<Integer>();
	JComboBox<Integer> c2 = new JComboBox<Integer>();
	Button btn = new Button("◀");
	Button btn2 = new Button("▶");

	

	
	
	public CalendarEx() {
		setTitle("Calendar");
		add(BorderLayout.NORTH,pane);
		pane.add(btn);
		pane.add(c1);
		pane.add(c2);
		pane.add(btn2);
		
		inputYearBox();
		inputMonthBox();
		
		inputDays();
		inputDates();
		centerPanel.setOpaque(true);
		
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		add(centerPanel);
		
		
	}
	
	
	public void inputDays() {
		String days[] = {"일", "월", "화", "수", "목", "금", "토"};
		for(int i=0;i<days.length;i++) {///
			JLabel dayLabel = new JLabel(days[i], JLabel.CENTER);///
			centerPanel.add(dayLabel);
			
		}
	}
	public void inputDates() {
		int thisLastDate = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 오늘의 날짜
		int todayOfMonth = now.get(Calendar.DAY_OF_MONTH);
		// 오늘의 요일
		int todayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		
		int theDate = 1;
		int firstDayOfWeek = todayOfWeek - ((todayOfMonth - 1) % 7);
		if (firstDayOfWeek <= 0) {
			firstDayOfWeek += 7;
		}
		int dates[] = new int[42];
		for(int i=0; i<dates.length; i++) {
			if (i<firstDayOfWeek - 1) {
				dates[i] = 0;
			} else if(theDate>thisLastDate) {
				dates[i] = 0;
			} else {
				dates[i] = theDate++;
			}
			JLabel dateLabel = new JLabel(String.valueOf(dates[i]), JLabel.CENTER);
			if (dateLabel.getText().equals("0")) {
				dateLabel.setVisible(false);
			}
			
			centerPanel.add(dateLabel);
		}
	}
	
	public void inputYearBox() {
		pane.add(c1);
	
	//	for(int i=5; i>0; i--) {
		//	c1.addItem(thisYear-i);
		}
		//c1.addItem(thisYear);
		//for(int i=1; i<6; i++) {
			//c1.addItem(thisYear+i);
		//}
		//c1.setSelectedItem(thisYear);
	//}
	
	public void inputMonthBox() {
	
		pane.add(c2);
		int month = 1;
		for(int i=1;i<12;i++) {
			c2.addItem(month++);
		}
			c2.addItem(month++);
		}
	public void actionPerformed(ActionEvent ae) {
	}
	public static void main(String[] args) {
		new CalendarEx();

	}

}
