import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class PackMan extends JFrame implements KeyListener {
	MyCanvas mc = new MyCanvas();
	Dimension dim;
	
	int x, y;
	int p=0;
	public PackMan() {
		add(mc);
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// 캔버스 크기
		dim = mc.getSize();
		x = (int)(dim.getWidth()/2 -25);
		y = (int)(dim.getHeight()/2 -25);
		
		mc.setFocusable(true);
		mc.addKeyListener(this);

		// point 메소드 반복해서 호출
		while(true) {
			mc.repaint();
			// 이미지 변환
			if(p%2==0) p++;
			else p--;
			
			//좌표 이동
			if( p==0 || p==1 ) {
				x -= 5;
				if(x <= -50) {
					x = (int)(dim.getWidth());
				}				
			} else if( p==2 || p==3 ) {
				x += 5;
				if(x >= dim.getWidth()) {
					x =- 50;
				}
			} else if( p==4 || p==5 ) {
				y -= 5;
				if(y <= -50) {
					y = (int)(dim.getHeight());
				}				
			} else if( p==6 || p==7 ) {
				y += 5;
				if(y >= dim.getHeight()) {
					y =- 50;
				}
			}
			
			// 인터벌
			try {
				Thread.sleep(200);
			} catch(Exception e) {}
		}
	}
	class MyCanvas extends Canvas {
		Image pacMan;
		MyCanvas() {
			pacMan = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		}
		public void paint(Graphics g) {
			g.drawImage(pacMan, x, y, x+50, y+50, p*50, 0, p*50+50, 50, this);
		}
	}
	// KeyEvent Overriding
	public void keyPressed(KeyEvent ke) {}
	public void keyReleased(KeyEvent ke) {
		int code = ke.getKeyCode();
		if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
			p=0;
		} else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
			p=2;
		} else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
			p=4;
		} else if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
			p=6;
		}
	}
	public void keyTyped(KeyEvent ke) {}
	public static void main(String[] args) {
		new PackMan();

	}

}
