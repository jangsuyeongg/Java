import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class URLEx extends JFrame implements ActionListener{
	JPanel pane = new JPanel(); 
		JLabel lbl = new JLabel("URL");
		JTextField tf = new JTextField(20);
		JButton btn = new JButton("소스보기");
	JLabel lbl2 = new JLabel();
	
	public URLEx() {
		add(BorderLayout.NORTH,pane);
		pane.add(lbl);		
		pane.add(tf);
		pane.add(btn);
		
		add(BorderLayout.CENTER,lbl2);
		//URLRead();

		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		btn.addActionListener(this);
	}

	public void URLRead() {
		
		try {
			String search = "https://"+tf.getText();
			URL url = new URL(search); 
			
			URLConnection connection = url.openConnection();
			connection.connect();
			String type = connection.getContentType();
			int idx = type.indexOf("charset=");
			String encode = type.substring(idx+8);
			
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is, encode);
			BufferedReader br = new BufferedReader(isr);
			String allData = "";
			while(true) {
				String readData = br.readLine();
				if(readData == null) break;
				allData += readData ;
			}
			lbl2.setText(allData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		if(eventBtn.equals("소스보기")) {
			URLRead();
		}
	}
	public static void main(String[] args) {
		new URLEx();

	}

}
