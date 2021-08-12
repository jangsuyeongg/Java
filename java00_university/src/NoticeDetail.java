import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NoticeDetail extends UI_2 implements ActionListener{

	NoticeVO vo;
	JTextArea tArea = new JTextArea(20, 72);
	JTextField tField = new JTextField();
	String title = "";
	NoticeMain wannaUseMethods = new NoticeMain();
	
	public NoticeDetail() {
	}

	
	public NoticeDetail(NoticeVO vo) {
		this.vo = vo;
	}
	
	public void setFrame() {
		// 프레임 세팅
		init();
		
		// 센터 빅패널
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new FlowLayout());
		
		// 거리두기
		JPanel spacePane1 = new JPanel();
		spacePane1.setPreferredSize(new Dimension(800, 32));
		centerPane.add(spacePane1);
		
		JPanel titleBar = new JPanel(new GridLayout(0, 1));
		tField.setPreferredSize(new Dimension(800, 32));
		titleBar.add(tField);
		titleBar.setPreferredSize(new Dimension(800, 40));
		centerPane.add(titleBar);
		JPanel spacePane2 = new JPanel();
		spacePane2.setPreferredSize(new Dimension(800, 32));
		centerPane.add(spacePane2);
		
		tArea.setLineWrap(true);
		JScrollPane sPanel = new JScrollPane(tArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sPanel.setVisible(true);
		centerPane.add(sPanel);
		
		JPanel spacePane3 = new JPanel();
		spacePane3.setPreferredSize(new Dimension(800, 20));
		centerPane.add(spacePane3);

		JPanel southBar = new JPanel();
		southBar.setLayout(new FlowLayout());
		JPanel spacePane4 = new JPanel();
		spacePane4.setPreferredSize(new Dimension(640, 32));
		southBar.add(spacePane4);
		JButton southBar_completeBtn = new JButton("완료");
		JButton southBar_prevBtn = new JButton("취소");
		southBar.add(southBar_completeBtn);
		southBar.add(southBar_prevBtn);
		centerPane.add(southBar);
		
		add(centerPane);
		
		southBar_completeBtn.addActionListener(this);
		southBar_prevBtn.addActionListener(this);
	}
	
	// ★★★★★ 아직 안함 (수정완료/취소 > 메시지 띄우기)
	@Override
	public void actionPerformed(ActionEvent a) {
		String btnLbl = a.getActionCommand();
		NoticeDAO dao = new NoticeDAO();

		// 새로 추가
		if(this.vo == null) {
			// 이 경우에는 기존 데이터가 없는거니까 추가하는것이 됨
			if(btnLbl.equals("완료")) {
				int cnt = dao.addRecord(tField.getText(), tArea.getText());
				if(cnt == 1) {
					JOptionPane.showMessageDialog(this, "추가 성공!");
					wannaUseMethods.reset10Notices();
				} else {
					JOptionPane.showMessageDialog(this, "추가 실패...ㅠㅠ");
				}
			} else if(btnLbl.equals("취소")) {
				// ★★★★★ 아직 안함 > 앞 페이지로 이동
				
			}
		} else {
			// 수정
			if(btnLbl.equals("완료")) {
				// VO 수정(DAO에서)
				int cnt = dao.updateComplete(tField.getText(), tArea.getText(), vo.getCode());
				if(cnt == 1) {
					JOptionPane.showMessageDialog(this, "수정 성공!");
				} else {
					JOptionPane.showMessageDialog(this, "수정...실패...ㅠㅠ");
				}
			} else if(btnLbl.equals("취소")) {
				// ★★★★★ 아직 안함 > 앞 페이지로 이동
			}			
		}
		
		
	}
	
	public void updateContent() {
		title = vo.getTitle();
		tField.setText(title);
		tArea.setText(vo.getContent());
	}
}
