import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SourceViewer extends JFrame implements ActionListener{
	JPanel pane = new JPanel(new BorderLayout());
		JLabel lbl = new JLabel("URL");
		JTextField tf = new JTextField();
		JButton btn = new JButton("소스보기");
		
	JTabbedPane tPane = new JTabbedPane();	
	public SourceViewer() {
		pane.add(BorderLayout.WEST, lbl);
		pane.add(tf);
		pane.add(BorderLayout.EAST,btn);
		add(BorderLayout.NORTH, pane);
		add(tPane);
		
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		tf.addActionListener(this);
		btn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==tf || obj ==btn) {
			startSourceView();
		}
	}
	public void startSourceView() {
		String urlAddr = tf.getText();
		if(!urlAddr.equals("")) {
			try {
				JTextArea ta = new JTextArea();
				JScrollPane sp = new JScrollPane(ta);
				
				tPane.addTab(urlAddr, sp);
				tPane.setSelectedComponent(sp);//추가된 탭의 컴퍼넌트를 활성화한다.
				
				URL url = new URL(urlAddr);
				URLConnection connection = url.openConnection();
				connection.connect();
				String headerType = connection.getContentType();
				int idx = headerType.indexOf("charset");
				String encode = headerType.substring(idx+8);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), encode));
				
				while(true) {
					String data = br.readLine();
					if(data == null)break;
					ta.append(data+"\n");
				}
				br.close();
				tf.setText("");
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new SourceViewer();
	}
}
