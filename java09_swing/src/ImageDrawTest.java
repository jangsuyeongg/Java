import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ImageDrawTest extends JFrame implements ActionListener{
	JPanel pane = new JPanel();
		JButton btn1 = new JButton("원본이미지");
		JButton btn2 = new JButton("축소이미지");
		JButton btn3 = new JButton("확대이미지");
		JButton btn4 = new JButton("좌우뒤집기");
		JButton btn5 = new JButton("상하뒤집기");
		JButton btn6 = new JButton("일부그리기");
	Image img;
	MyCanvas mc = new MyCanvas();
	String selectBtn="원본이미지";
	public ImageDrawTest() {
		add(BorderLayout.NORTH, pane);
		pane.add(btn1);
		pane.add(btn2);
		pane.add(btn3);
		pane.add(btn4);
		pane.add(btn5);
		pane.add(btn6);
		add(mc);
		
		setSize(1500, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		selectBtn = ae.getActionCommand();
		mc.repaint();//paint()메소드 호출
	}
	public class MyCanvas extends Canvas{
		public MyCanvas() {	
			img = Toolkit.getDefaultToolkit().getImage("img/kakao2.jfif");
		}
		public void paint(Graphics g) {
			//이미지 크기 구하기 : 반드시 paint()메소드내에서 구해야 한다.
			int imgW = img.getWidth(this);
			int imgH = img.getHeight(this);
			
			
			if(selectBtn.equals("원본이미지")) {////원본 이미지 그림을 그린다. 
				g.drawImage(img, 1, 1, this); //x,y,w,h, 
			}else if(selectBtn.equals("축소이미지")) {
				g.drawImage(img, 1, 1, imgW/2, imgH/2, this);
			}else if(selectBtn.equals("확대이미지")){
				g.drawImage(img, 1, 1, imgW*2, imgH*2, this);
			}else if(selectBtn.equals("좌우뒤집기")) {
				//				캔버스크기					이미지
				g.drawImage(img, 1, 1, imgW, imgH,		imgW, 1, 1, imgH, this);
			}else if(selectBtn.equals("상하뒤집기")) {
				g.drawImage(img, 1, 1, imgW, imgH,		1, imgH, imgW, 1, this);	
			}else if(selectBtn.equals("일부그리기")) {
				g.drawImage(img, 1, 1, imgW/2, imgH/2, imgW/5, imgH/5, imgW/2, imgH/2, this);
			}
		}
		//repaint 하면 update 로 와서 paint를 호출함 
		//repaint 하면 update 없을시 바로 paint 로가는데 g를 가지고 가서 사라진다리??
		public void update(Graphics g) {
			paint(g);//이전 그림 안지워지게 함. 
		}
	}
	
	public static void main(String[] args) {
		new ImageDrawTest();
	}
}
