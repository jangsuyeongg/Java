import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorEx extends JFrame implements ActionListener{
	Font fnt = new Font("굴림체", Font.BOLD,25);
	JTextField tf = new JTextField("0.0");
	JPanel allBtnPane = new JPanel(new BorderLayout());
		JPanel northPane = new JPanel(new GridLayout(1,3));
		JPanel centerPane = new JPanel(new GridLayout(4,4));
	
	//버튼목록 list
	String btnStr[] = {"BackSpace","Clear","End","7","8","9","+"
			,"4","5","6","-","1","2","3","*","0",".","=","/"};
	double result; //0.0 연산결과값
	String operator;//보관
	
	public CalculatorEx() {
		setTitle("계산기");
		add(BorderLayout.NORTH, tf);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setFont(fnt);
		
		add(allBtnPane);
		allBtnPane.add(BorderLayout.NORTH, northPane);
		allBtnPane.add(BorderLayout.CENTER, centerPane);
		//버튼을 JPanel에 추가
		for(int i=0; i<btnStr.length; i++) {
			JButton btn = new JButton(btnStr[i]);
			btn.setFont(fnt);
			btn.setBackground(Color.LIGHT_GRAY);
			if(i<=2) {
				northPane.add(btn);
			}else {
				centerPane.add(btn);
			}
			//버튼들을 이벤트 등록
			btn.addActionListener(this);
		}
			
		setSize(500, 350);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) {
		JButton event = (JButton)ae.getSource();
		String btnLbl = event.getText();
		
		
		switch(btnLbl) {
		case "End" : 
			System.exit(0);
			break;
		case "0":	case "1":	case"2":	case"3":	case"4":
		case "5":	case "6":	case"7":	case"8":	case"9":
			inNumber(btnLbl);
			break;
		case "BackSpace":
			setBackSpace();
			break;
		case ".":
			setPoint();
			break;
		case "+":	case "-":	case "*":	case"/":
			setResultOperator(btnLbl);
			break;
		case "=":
			setResult();
			break;
		case "Clear":
			setClear();
		}
	}
	public void setClear() {
		result = 0.0;
		operator = null;
		tf.setText("0.0");
	}
	// = 연산자가 선택되면 result, operator, tf값을 계산한다.
	public void setResult() {
		double num2 = Double.parseDouble(tf.getText());
		calcu(num2);
		//결과를 tf에 보여주기 
		tf.setText(String.valueOf(result));
		operator = null;			
	}
	//+,-,*,/연산자를 선택 하였을때
	public void setResultOperator(String btnLbl) {
		double second = Double.parseDouble(tf.getText());
		if(operator==null) {//처음으로 연산자 선택
			result=second;//tf값을 보관
		}else {
			//이미 연산자 있으면 보관된값과 tf의 값을 계산하여 result에 보관
			calcu(second);
		}
		operator = btnLbl;//연산자 보관
		tf.setText("");//tf 의 값을 초기화한다.
	}
	public void calcu(double second) {
		switch(operator) {
		case "+": result = result + second;break;
		case "-": result = result - second;break;
		case "*": result = result * second;break;
		case "/": result = result / second;break;
		}
	}
	
	//소숫점 버튼이 선택되었을때
	public void setPoint() {
		String str = tf.getText();
		int idx = str.indexOf("."); //.가 있으면 index위치를 구하고 없으면 -1을 리턴한다.
		if(idx==-1) {
			tf.setText(str+ ".");
		}
		
	}
	//백스페이스 버튼 선택되었을때
	public void setBackSpace() {
		String str = tf.getText();//4567
		int len = str.length();//4
		String cutStr = str.substring(0, len-1);//456
		tf.setText(cutStr);
	}
	//숫자버튼 선택되었을때
	public void inNumber(String btnLbl) {
		String tfTxt = tf.getText();
		if(tfTxt.equals("0.0")) {//초기값 0.0일때는 방금 이벤트가 발생한 버튼의 값을 세팅
			tf.setText(btnLbl);
		}else {
			tf.setText(tfTxt+btnLbl);
		}
	}
	public static void main(String[] args) {
		new CalculatorEx();
	}
}
