import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock extends JFrame implements Runnable {
	JPanel pane = new JPanel(new GridLayout(2,3));
	Calendar now = Calendar.getInstance();
	Font fnt = new Font("굴림", Font.BOLD,50);
	
		JLabel nlbl = new JLabel("Los_Angeles", JLabel.LEFT);
		JLabel nlb2 = new JLabel("Korea",JLabel.CENTER);
		JLabel nlb3 = new JLabel("Singapore",JLabel.RIGHT);
	
		JLabel lbl1 = new JLabel("00:00:00", JLabel.LEFT);
		JLabel lbl2 = new JLabel("00:00:00", JLabel.CENTER);
		JLabel lbl3 = new JLabel("00:00:00", JLabel.RIGHT);
	public DigitalClock() {
		setTitle("시계");
		
		pane.add(nlbl);
		pane.add(nlb2);
		pane.add(nlb3);
		pane.add(lbl1);
		pane.add(lbl2);
		pane.add(lbl3);
		add(pane);

		nlbl.setFont(fnt);
		nlb2.setFont(fnt);
		nlb3.setFont(fnt);
		lbl1.setFont(fnt);
		lbl2.setFont(fnt);
		lbl3.setFont(fnt);
	
		setSize(1000,200);
		setVisible(true);
	}
	
	public void run() {
		do {
			lbl2.setText(getTimer2());
			lbl1.setText(getTimer1());
			lbl3.setText(getTimer3());
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}while(true);
	}
	
	//현재시간을 00:00:00
	public String getTimer2() {
		now = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		return fmt.format(now.getTime());
	}
	public String getTimer1() {
		TimeZone time;
		Date date = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		time = TimeZone.getTimeZone("America/Los_Angeles");
		fmt.setTimeZone(time);
		return fmt.format(date);
		
	}
	public String getTimer3() {
		TimeZone time;
		Date date = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		time = TimeZone.getTimeZone("Asia/Singapore");
		fmt.setTimeZone(time);
		return fmt.format(date);
	}
	public static void main(String[] args) {
		DigitalClock dc1=	new DigitalClock();	
		Thread t1 = new Thread(dc1);
		t1.start();
	
		
	}
}
