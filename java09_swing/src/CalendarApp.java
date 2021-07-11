import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarApp extends JFrame implements ActionListener{
	JPanel northPanel = new JPanel();
	JButton leftBtn = new JButton("◀");
	JButton rightBtn = new JButton("▶");
	JComboBox<Integer> yearBox = new JComboBox<Integer>();
	JComboBox<Integer> monthBox = new JComboBox<Integer>();
	JPanel centerPanel = new JPanel();
	JLabel yearStr = new JLabel("년");
	JLabel monthStr = new JLabel("월");
	Font font = new Font("굴림체", Font.BOLD, 25);
	Calendar now = Calendar.getInstance();
	int thisYear = now.get(Calendar.YEAR);
	int thisMonth = now.get(Calendar.MONTH);
	
	public CalendarApp() {
		Image icon = Toolkit.getDefaultToolkit().getImage("img/cat_icon.png");
		setIconImage(icon);
		setTitle("Calendar");
		
		// northPanel에 각 버튼 삽입
		add(BorderLayout.NORTH, northPanel);
		northPanel.setBackground(Color.pink);
		northPanel.setPreferredSize(new Dimension(500, 50));
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		
		// 및 각 버튼 세팅
		northPanel.add(leftBtn);
		leftBtn.setSize(60, 40);
		
		inputYearBox();
		
		northPanel.add(yearStr);
		yearStr.setSize(60, 40);
		
		inputMonthBox();
		
		northPanel.add(monthStr);
		monthStr.setSize(60, 40);
		
		northPanel.add(rightBtn);
		rightBtn.setSize(60, 40);
		
		
		// centerPanel 7x7 레이아웃 만들기
		add(centerPanel);
		centerPanel.setLayout(new GridLayout(7, 7));
		centerPanel.setBackground(Color.lightGray);


		// days, dates 입력하기
		inputDays();
		inputDates();

		
		// 화살표 누르면 월 +-1
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		// 월/년도 바꾸면 날짜 객체 수정해서 다시 출력
		monthBox.addActionListener(this);
		yearBox.addActionListener(this);




		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	
	public void actionPerformed(ActionEvent aEvent) {
		if(aEvent.getActionCommand().equals("◀")) {
			if(thisMonth <= 0) {
				thisMonth = 11;
				thisYear -= 1;
				yearBox.setSelectedItem(thisYear);
			} else {
				thisMonth -= 1;
			}
			monthBox.setSelectedItem(thisMonth+1);
		} else if (aEvent.getActionCommand().equals("▶")) {
			if(thisMonth >= 11) {
				thisMonth = 0;
				thisYear += 1;
				yearBox.setSelectedItem(thisYear);
				System.out.println("얘가 먼저 콤보박스를 바꿔준 후에 콤보박스 변경 이벤트 발생해야 함");
				// 근데 이유는 모르겠는데 버튼을 눌러도 콤보박스 > 버튼 순으로 실행됨
			} else {
				thisMonth += 1;
			}
			monthBox.setSelectedItem(thisMonth+1);
		} else if (aEvent.getActionCommand().equals("comboBoxChanged")) {
			System.out.println("전달받은 콤보박스: " + thisYear);
			System.out.println("전달받은 콤보박스: " + thisMonth);
//			thisYear = Integer.parseInt(String.valueOf(yearBox.getSelectedItem()));
//			thisMonth = Integer.parseInt(String.valueOf(monthBox.getSelectedItem()))-1;
			System.out.println("콤보박스: " + thisYear);
			System.out.println("콤보박스: " + thisMonth);
			resetPanel();
		}  

	}
	
	public void resetPanel() {
		centerPanel.setVisible(false);
		centerPanel.removeAll();
		now.set(Calendar.MONTH, thisMonth);
		now.set(Calendar.YEAR, thisYear);
		centerPanel.setVisible(true);
		centerPanel.setLayout(new GridLayout(7, 7));
		centerPanel.setBackground(Color.lightGray);
		inputDays();
		inputDates();
	}

	public void inputYearBox() {
		// 연 콤보 박스는 올해를 기준으로 -5년 +5년 선택 가능
		northPanel.add(yearBox);
		yearBox.setSize(60, 40);
		for(int i=5; i>0; i--) {
			yearBox.addItem(thisYear-i);
		}
		yearBox.addItem(thisYear);
		for(int i=1; i<6; i++) {
			yearBox.addItem(thisYear+i);
		}
		yearBox.setSelectedItem(thisYear);
	}
	
	public void inputMonthBox() {
		// 월 콤보 박스는 1~12 선택 가능
		northPanel.add(monthBox);
		monthBox.setSize(60, 40);
		int monthText = 1;
		while (true) {
			monthBox.addItem(monthText++);
			if(monthText == 13) break;
		}
		monthBox.setSelectedItem(thisMonth + 1);
	}
	
	public void inputDays() {
		String days[] = {"일", "월", "화", "수", "목", "금", "토"};
		for(int i=0; i<days.length; i++) {
			JLabel dayLabel = new JLabel(days[i], JLabel.CENTER);
			if (days[i] == "일") {
				dayLabel.setForeground(Color.red);
			} else if (days[i] == "토") {
				dayLabel.setForeground(Color.blue);
			}
			dayLabel.setSize(60, 40);
			dayLabel.setFont(font);
			centerPanel.add(dayLabel);
		}
	}
	
	public void inputDates() {
		// 이번달의 마지막날
		int thisLastDate = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 오늘의 날짜
		int todayOfMonth = now.get(Calendar.DAY_OF_MONTH);
		// 오늘의 요일
		int todayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		// 첫 날의 요일은 (오늘날짜와 첫 날의 차이(오늘-1)를 7로 나눈 나머지)를 뺀 날임
		// 7월 25일 일요일이라고 치면 차이는 24, 7로 나눈 나머지는 3이므로 일요일(1)에서 3일 뒤로 간 목요일(-2)인 것
		// 근데 이러면 음수가 나올 수 있으므로 음수일 때 +7을 해주면 됨 (목요일 = -2 = 5)
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
			if ((i+1) % 7 == 1) {
				dateLabel.setForeground(Color.red);
			} else if ((i+1) % 7 == 0) {
				dateLabel.setForeground(Color.blue);
			}
			dateLabel.setSize(60, 40);
			dateLabel.setFont(font);
			centerPanel.add(dateLabel);
		}
		
	}

	public static void main(String[] args) {
		new CalendarApp();

	}

}
