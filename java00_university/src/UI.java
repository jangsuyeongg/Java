import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UI extends JFrame{
   //J프레임 -> 사이즈조절 프레임명.setPreferredSize(new Dimension(int width,int height));
   Font font = new Font("바탕", Font.BOLD, 30);
   Font font2 = new Font("바탕", Font.BOLD, 25);
   Font font3 = new Font("바탕", Font.BOLD, 12);
   
   JPanel northPane = new JPanel(new BorderLayout());      
      JLabel jbl = new JLabel("<html>비트대학교<br> BITCAMP UNIVERSITY</html>");   
   JPanel EastPane = new JPanel(new BorderLayout()); //보더레이아웃? 흠...setLayout(NULL)      
      JLabel jbl2 = new JLabel("수강신청시스템",JLabel.CENTER);
      JPanel inputIdPw = new JPanel(new BorderLayout()); //수강신청프레인안의왼쪽
         JPanel inputIdPwL = new JPanel(new GridLayout(2,1));
            JLabel jbl3 = new JLabel("학번");
            JLabel jbl4 = new JLabel("비밀번호");
         JPanel inputIdPwR = new JPanel(new GridLayout(2,1,0,20));
            JPanel tfp = new JPanel(new BorderLayout());
            JTextField tf = new JTextField(20);            
            JPanel tfp2 = new JPanel(new BorderLayout());
            JTextField tf2 = new JTextField(20);
         JButton jbt = new JButton("로그인");//수강신청프레인안의왼쪽
      JPanel btnPane = new JPanel(new FlowLayout());
         JButton jbt2 = new JButton("ID/PW찾기");
         JButton jbt3 = new JButton("PW변경");
   
   JPanel southPane = new JPanel();//레이아웃뭐하징
      
   public UI() {
      add(BorderLayout.NORTH,northPane);
      northPane.setPreferredSize(new Dimension(0,70)); //사이즈조절
   
      jbl.setFont(font);      
      jbl.setOpaque(true);
      jbl.setBackground(new Color(33, 140, 116)); //(22, 160, 133)
      jbl.setForeground(Color.white);
      northPane.add(jbl);
      
      //----------------------------------------------------------------
      
      //centerPane.setBorder(new EmptyBorder(20 , 20 , 20 , 20)); //공백설정 ???
      EastPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));//여백안생김
      EastPane.setBackground(new Color(255, 229, 200));//255, 234, 167 //(255, 229, 200
      EastPane.setPreferredSize(new Dimension(500,0));       
      jbl2.setFont(font2);
      jbl2.setForeground(new Color(33, 140, 116));
      //jbl2.setHorizontalAlignment(JLabel.CENTER);      
      EastPane.add(BorderLayout.NORTH,jbl2);      
         //--------------------------------------------
      
      inputIdPw.setPreferredSize(new Dimension(300,0)); 
      inputIdPw.setBackground(new Color(255, 229, 200));
      
      jbl3.setOpaque(true);
      jbl3.setFont(font3);
      jbl3.setBackground(new Color(255, 229, 200));
      
      jbl4.setOpaque(true);
      jbl4.setFont(font3);
      jbl4.setBackground(new Color(255, 229, 200));
      
      inputIdPwL.setBackground(new Color(255, 229, 200));
      inputIdPwL.add(jbl3);
      inputIdPwL.add(jbl4);
      inputIdPw.add(BorderLayout.WEST,inputIdPwL);
      
      tfp.setBackground(new Color(255, 229, 200));
      tfp2.setBackground(new Color(255, 229, 200));
      tfp.add(BorderLayout.CENTER,tf);
      tfp2.add(BorderLayout.CENTER,tf2); ///****텍스트필드 여백 위아래로 넣어주기
      
      inputIdPwR.setBackground(new Color(255, 229, 200));
      inputIdPwR.add(tfp);
      inputIdPwR.add(tfp2);
      inputIdPw.add(BorderLayout.EAST,inputIdPwR);
   
      EastPane.add(BorderLayout.WEST,inputIdPw);
      add(BorderLayout.EAST,EastPane);
      
      jbt.setPreferredSize(new Dimension(90, 40)); //로그인버튼 사이즈조절
      jbt.setBackground(new Color(33, 140, 116));
      jbt.setForeground(Color.white);
      EastPane.add(BorderLayout.EAST,jbt);//로그인버튼추가
      
      btnPane.setPreferredSize(new Dimension(0,50));//위치
      btnPane.setBackground(new Color(255, 229, 200));
      jbt2.setBackground(new Color(33, 140, 116));
      jbt2.setForeground(Color.white);
      jbt3.setBackground(new Color(33, 140, 116));
      jbt3.setForeground(Color.white);
      btnPane.add(jbt2);
      btnPane.add(jbt3);
      EastPane.add(BorderLayout.SOUTH,btnPane);
      
      //--------------------------------------------------------------------
      
      southPane.setPreferredSize(new Dimension(0,200));
      add(BorderLayout.SOUTH,southPane);
            
      setSize(1000,600);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }

   public static void main(String[] args) {
      new UI();
   }

}