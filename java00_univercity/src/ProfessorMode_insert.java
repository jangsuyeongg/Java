import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ProfessorMode_insert extends ProfessorModeUI implements ActionListener{
	int Proid= Integer.parseInt(AllStateSession.login_id);
	JPanel pane = new JPanel(new BorderLayout());
	JPanel northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel titlelb1;

		JPanel formCenter = new JPanel(new BorderLayout());
		JPanel formcenterwestPane = new JPanel(new GridLayout(10,1)); //라벨붙일패널
		JPanel formcentercenterPane = new JPanel(new GridLayout(10,1));; //텍스트필드
		JTextField[] formTf = {new JTextField(5), new JTextField(5),new JTextField(5),
							new JTextField(20),new JTextField(10),new JTextField(10),
							new JTextField(20),new JTextField(10),new JTextField(10),new JTextField(10)};

		String formLbl[] = {" 강의번호 "," 교수번호 "," 이수구분 "," 강 의 명 "," 학       점 "," 강의시간 "," 강 의 실 "," 수강인원 "," 신청인원 "," 강의등록일 "};

		JPanel southPane = new JPanel();
		JPanel spacePane = new JPanel();
			JButton btn = new JButton("추가");
			DefaultTableModel model;
	  
		Font font = new Font("바탕", Font.BOLD, 25);	 
		 
	public ProfessorMode_insert() {
		  init();
	      add(pane);
	      setForm();   
	      
	      btn.addActionListener(this);
	}
	
	
public void setForm() {
		
		pane.add(formCenter);
		
		titlelb1= new JLabel("강의정보입력"); //폰트설정
		titlelb1.setFont(font);
		northPane.add(titlelb1);
		//northPane.setPreferredSize(new Dimension(0,140));
		
		pane.add(BorderLayout.NORTH,northPane);
		

			
		formCenter.add(BorderLayout.WEST,formcenterwestPane);
			for(int i=0; i<formLbl.length; i++) {
				 JLabel lb1 = new JLabel(formLbl[i]);
				 formcenterwestPane.add(lb1);
			}
		
		formCenter.add(BorderLayout.CENTER,formcentercenterPane);
			for(int i=0; i<formTf.length; i++) {
				  JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT,20,12)); //왼쪽정렬
	               p.add(formTf[i]);               
	               formcentercenterPane.add(p);
	           	if(i==0 || i==1||i==9) formTf[i].setEditable(false);
			}
		spacePane.setPreferredSize(new Dimension(600, 200));
		southPane.add(spacePane);
		southPane.add(btn);
	    pane.add(BorderLayout.SOUTH, southPane); 
	    //southPane.setBorder(new LineBorder(Color.GRAY,1,true));
	    btn.setBackground(new Color(33, 140, 116));
	    btn.setForeground(Color.white);
	    btn.setFont(font);
	    btn.setPreferredSize(new Dimension(100, 30)); 
	    
	}
	

	public void ProfessorModeInsert(){
		ProfessorModeVO vo = new ProfessorModeVO();
		System.out.println("교수번호 test"+Proid);
			vo.setClass_div(formTf[2].getText());
			vo.setClass_name(formTf[3].getText());
			vo.setClass_grade(formTf[4].getText());
			vo.setClass_time(formTf[5].getText());
			vo.setClass_room(formTf[6].getText());
			vo.setTot_mem(Integer.parseInt(formTf[7].getText()));
			vo.setReg_mem(Integer.parseInt(formTf[8].getText()));

			ProfessorModeDAO dao = new ProfessorModeDAO();
			int cnt = dao.insertRecord(vo);
			if(cnt>0) {
				JOptionPane.showMessageDialog(this, "강의정보 추가되었습니다.");
			}else {
				JOptionPane.showMessageDialog(this, "강의추가 실패하였습니다.");
			}
	  }
	
	   public void actionPerformed(ActionEvent ae) {
		   String eventBtn = ae.getActionCommand();
		   if(eventBtn.equals("추가")) {
			   ProfessorModeInsert();
		   }
	   }
	
	public static void main(String[] args) {
		new ProfessorMode_insert();

	}

}
