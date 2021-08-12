import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class StudentModeScore extends StudentModeUI{
   JPanel pane = new JPanel(new BorderLayout());
      JPanel northPane = new JPanel();
         JLabel scoreTitle = new JLabel("성적취득현황", JLabel.LEFT);
      JPanel centerPane = new JPanel(new BorderLayout());
         DefaultTableModel model;
         JTable studentModelist;
         JScrollPane sp;
   public StudentModeScore() {
      init();
      setForm();
   }
   
   public void setForm() {
      //north
      add(pane);
      northPane.add(scoreTitle);
      pane.add(BorderLayout.NORTH, northPane);
      //center
      String title = "강의코드/강의명/중간고사/기말고사/총점/학점";
      model = new DefaultTableModel(title.split("/"),0);
      studentModelist = new JTable(model);
      sp = new JScrollPane(studentModelist);
      StudentModeAllList();
      centerPane.add(sp); 
      
      pane.add(BorderLayout.CENTER,centerPane);
      
      //남쪽
   }
   
   public void StudentModeAllList() {
      StudentModeDAO dao = new StudentModeDAO();
      List<StudentModeVO> list = dao.allRecord();
      setStudentModeModel(list);
   }
   
   public void setStudentModeModel(List<StudentModeVO> list) {
      //기존 JTable의 목록을 지우고 새로 리스트를 출력한다. 
      model.setRowCount(0);
      //컬렉션에 있는 vo를 get하여 JTable에 목록으로 추가한다.
      for(int i=0;i<list.size();i++) {
         StudentModeVO vo = list.get(i);
         Object[] obj = {vo.getClass_code(), vo.getClass_name(), vo.getMid_score(), vo.getFin_score(),
               vo.getTot_score(), vo.getGrade()};
         model.addRow(obj);
           
      }
   }
   
   public static void main(String[] args) {
      new StudentModeScore();
      
   }

}