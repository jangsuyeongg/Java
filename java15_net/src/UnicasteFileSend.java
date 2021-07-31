import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class UnicasteFileSend extends JFrame implements ActionListener {
   JButton btn = new JButton("파일보내기");

   public UnicasteFileSend() {
      add(btn);
      setSize(400,300);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      btn.addActionListener(this);
   }

   public void actionPerformed(ActionEvent ae) {
      JFileChooser fc = new JFileChooser();
      int state = fc.showOpenDialog(this);
      if(state==0) {
         try {
            DatagramSocket  ds = new DatagramSocket();//보낼때는 소켓 필요,받는쪽정보없어도됨
            InetAddress ia = InetAddress.getByName("172.16.101.101");//받는서버 정보
            
            File f = fc.getSelectedFile(); //f안에는 경로+파일명
            FileInputStream fis = new FileInputStream(f); //바이트로가져와서 바이트로쓰기
            String filename = "FN##"+f.getName();//파일명이 필요 -> 파일명보내야하니깐
            
            //이제 보낸다 -> 파일명부터 
            //가는길은 하나인데 데이터종류는다양 ->파일명,파일내용등등 그러므로 합쳐서보내고 받는쪽에서 구별
            //패킷으로 보냄
            
            //                           파일명을 바이트배열로바꿈
            //1.파일명보내기
            DatagramPacket dp = new DatagramPacket(filename.getBytes(),filename.getBytes().length,ia,16000);
            ds.send(dp);
            
            while(true) {
               
               //2.파일내용보내기 $%#$
               //read(byte[]b , int off, int len)
               byte fileContent[] = new byte[512]; //최대512byte
               fileContent[0]='$';
               fileContent[1]='%';
               fileContent[2]='#';
               fileContent[3]='$';
               
               int cnt = fis.read(fileContent,4,508);//파일읽어오기 //read를 몇byte읽엇는지 리턴
               if(cnt<=0) break; //read한 데이터 갯수가 0개 미만이면 반복문 중단
               //패킷을 만들고나서 전송
               dp = new DatagramPacket(fileContent,cnt+4,ia,16000);
               //보내기
               ds.send(dp);
               System.out.println("cnt===>"+cnt+"bytes");
               
            }   
            fis.close();
            //반복문 벗어나면
            //2-2.마지막메시지 보내기 // 
            dp = new DatagramPacket("^%#$".getBytes(),4,ia,16000);
            ds.send(dp);
            
            ds.close();
            System.out.println("파일전송완료......");
         }catch(Exception e) {
            
         }
      }
      
   }
   public static void main(String[] args) {
      new UnicasteFileSend();
   }

}