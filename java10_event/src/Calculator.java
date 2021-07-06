
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{
	
	 JLabel txtField = new JLabel("0.0");
	  
		private Object b1; 
		private Object b2;
		
	 
	public Calculator() {
		 add(txtField, "North");
		
		GridLayout layout = new GridLayout(5,1);
		setLayout(layout);
		
		JButton btn1 = new JButton("BackSpace");
		add(btn1);
		JButton btn2 = new JButton("Clear");
		add(btn2);
		JButton btn3 = new JButton("End");
		add(btn3);
		
		JPanel pane = new JPanel(new GridLayout(1, 3));
		pane.add(btn1); pane.add(btn2); pane.add(btn3);
		add(pane);
		
		JPanel pane2 = new JPanel(new GridLayout(4, 4));
		JButton b1 = new JButton("7");
		JButton b2 = new JButton("8");
		JButton b3 = new JButton("9");
		JButton b4 = new JButton("+");
		JButton b5 = new JButton("4");
		JButton b6 = new JButton("5");
		JButton b7 = new JButton("6");
		JButton b8 = new JButton("-");
		JButton b9 = new JButton("1");
		JButton b10 = new JButton("2");
		JButton b11 = new JButton("3");
		JButton b12 = new JButton("*");
		JButton b13 = new JButton("0");
		JButton b14 = new JButton(".");
		JButton b15 = new JButton("=");
		JButton b16 = new JButton("/");
		
		
		pane2.add(b1); pane2.add(b2); pane2.add(b3);pane2.add(b4);pane2.add(b5);
		pane2.add(b6); pane2.add(b7); pane2.add(b8);pane2.add(b9);pane2.add(b10);
		pane2.add(b11); pane2.add(b12); pane2.add(b13);pane2.add(b14);pane2.add(b15);
		pane2.add(b16);
		add(pane2);
		
		setSize(400,400);
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	
	}
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		
		if(obj == b1) {
			txtField.setText("7");
		
		}else if(obj == b2) {
			txtField.setText("8");
		}
	}
	
	public static void main(String[] args) {
		new Calculator();
		
	}
}
