import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame {
	//Frame-Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel connPane = new JPanel(new BorderLayout());
			JTextField connTf = new JTextField();
			JButton connBtn = new JButton("접속");
		JTextArea msgTa = new JTextArea();
		JScrollPane sp = new JScrollPane(msgTa);
		
		JPanel msgPane = new JPanel(new BorderLayout());
			JTextField msgTf = new JTextField();
			JButton sendBtn = new JButton("보내기");
	//Frame - East
	JPanel eastPane = new JPanel(new BorderLayout());
		JLabel title = new JLabel("       접속자 리스트        ");
		
		DefaultListModel<String> connModel = new DefaultListModel<String>();
		JList<String> connList = new JList<String>(connModel);
		JScrollPane connSp = new JScrollPane(connList);
		
		JLabel count = new JLabel("현재 : 0명");
		
	public ChatClient() {
		add(centerPane);
		
		//connect
		centerPane.add(BorderLayout.NORTH, connPane);
		connPane.add(connTf);
		connPane.add("East",connBtn);
		
		//all message
		centerPane.add(sp);
		msgTa.setBackground(new Color(176,209,209));
		
		//message send
		centerPane.add("South",msgPane);
		msgPane.add(msgTf);
		msgPane.add("East",sendBtn);
		
		//chat information
		add("East", eastPane);
		eastPane.add("North",title);
		connModel.addElement("192.168.0.12");
		eastPane.add(connSp);
		eastPane.add("South",count);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ChatClient();
	}

}
