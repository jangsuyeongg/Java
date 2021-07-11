import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowEventTest extends JFrame implements WindowListener{

	public WindowEventTest() {
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);
	}

	public static void main(String[] args) {
		new WindowEventTest();

	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Opended");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Closing");
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Closed");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Iconified");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Deiconified");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Activated");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Deactivated");
		
	}

}
