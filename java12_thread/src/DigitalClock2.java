import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock2 extends JFrame implements Runnable {
		Font fnt = new Font("굴림", Font.BOLD,100);
		Calendar now = Calendar.getInstance();
		JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);
		int x, y;
	public DigitalClock2() {
		super("시계");
		add(lbl);
		lbl.setFont(fnt);
	

	}
	public DigitalClock2(int x, int y) {
		this();
		this.x = x;
		this.y = y;
		setBounds(x, y, 500,200);
		setVisible(true);
		
		Thread t = new Thread(this);
		t.start();
		
		
	}
	//시간변경
	public void run() {
		do {
			//시간변경
			lbl.setText(getTimer());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}while(true);
	}
	//현재시간을 00:00:00
	public String getTimer() {
		now = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		return fmt.format(now.getTime());
	}
	public static void main(String[] args) {
	/*	 DigitalClock2 dc1 = new  DigitalClock2(0,0);
		 Thread t1 = new  Thread(dc1);
		 t1.start();
		 
		 DigitalClock2 dc2 = new  DigitalClock2(500,0);
		 Thread t2 = new  Thread(dc2);
		 t2.start();
		 
		 DigitalClock2 dc3 = new  DigitalClock2(1000,0);
		 Thread t3 = new  Thread(dc3);
		 t3.start();
*/
		new DigitalClock2(0,0);
		new DigitalClock2(500,0);
		new DigitalClock2(1000,0);
		
	}
}
