import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ProfessorMain extends AdminUI implements ActionListener{
   JPanel pane = new JPanel(new BorderLayout());
      JPanel northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
         JLabel searchLbl = new JLabel("교수명");
         DefaultComboBoxModel<String> searchModel = new DefaultComboBoxModel<String>();
         JComboBox<String> searchkey = new JComboBox<String>(searchModel);
         JTextField searchWord = new JTextField(20);            
         JButton searchBtn = new JButton("검색");
         JButton newBtn = new JButton("새로고침");
      JPanel centerPane = new JPanel(new BorderLayout());
         DefaultTableModel model;
         JTable professorList;
         JScrollPane sp;
      JPanel southPane = new JPanel(new BorderLayout());
         JPanel updateNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
         JPanel updateCenter = new JPanel(new BorderLayout());
         JPanel updateSouth = new JPanel();   
         
         DefaultTableModel model2;
         JTable professorList2;         
         JScrollPane sp2;
      int row;
   public ProfessorMain() {
      init();
      add(pane);
      pane.add(BorderLayout.NORTH,northPane);
      pane.add(BorderLayout.CENTER,centerPane);
      pane.add(BorderLayout.SOUTH,southPane);
      
      showProfessorALL();
      professorList.addMouseListener(new MyEvent());
   }
 
   public void showProfessorALL() {
      
      //north
      setSearchForm();
      
      //center
      String title = "교수번호/전공코드/비밀번호/교수이름/이메일/핸드폰/연구실/입사일/생일";
      model = new DefaultTableModel(title.split("/"),0);
      professorList = new JTable(model);
      sp = new JScrollPane(professorList);
      professorAllList();
      centerPane.add(sp); 
      
      //south - north
         JLabel lbl = new JLabel("교수수정");
         southPane.add(BorderLayout.NORTH,updateNorth);
         updateNorth.add(lbl);
      
      //south - center   
      String title2 = "교수번호/전공코드/비밀번호/교수이름/이메일/핸드폰/연구실/입사일/생일";
      model2 = new DefaultTableModel(title2.split("/"),0);
      professorList2 = new JTable(model2);
      sp2 = new JScrollPane(professorList2);
      professorAllList();
      updateCenter.add(sp2);
      southPane.add(BorderLayout.CENTER,updateCenter);   
         
      //south - south   
   
      JButton updateBtn = new JButton("수정");
      JButton deleteBtn = new JButton("삭제");
      updateSouth.add(updateBtn);
      updateSouth.add(deleteBtn);
      southPane.add(BorderLayout.SOUTH,updateSouth);
   
      southPane.setPreferredSize(new Dimension(0, 140));
      deleteBtn.addActionListener(this);
      updateBtn.addActionListener(this);
   }
   //교수검색 폼
   public void setSearchForm() {
      searchModel.addElement("교수명");
      searchModel.addElement("교수번호");
      searchModel.addElement("핸드폰번호");
      northPane.add(searchkey);
      northPane.add(searchWord);
      northPane.add(searchBtn);   
      northPane.add(newBtn);
      searchBtn.addActionListener(this);
      newBtn.addActionListener(this);
   }
   public void professorAllList() {
      ProfessorDAO dao = new ProfessorDAO();
      List<ProfessorVO> list = dao.allRecord();
      setProfessorModel(list);
      }
   public void setProfessorModel(List<ProfessorVO> list) {
      //기존 JTable의 목록을 지우고 새로 리스트를 출력한다. 
      model.setRowCount(0);
      //컬렉션에 있는 vo를 get하여 JTable에 목록으로 추가한다.
      for(int i=0;i<list.size();i++) {
         ProfessorVO vo = list.get(i);
         Object[] obj = {vo.getProf_code(),vo.getMajor_code(),vo.getProf_pw(),vo.getProf_name(),
               vo.getProf_email(),vo.getProf_tel(),vo.getProf_room(),vo.getProf_hd(), vo.getProf_birth()};
         model.addRow(obj);
           
      }
   }

   //교수삭제
   public void professorDelete() {
      //삭제할 사원번호
      JOptionPane op = new JOptionPane();
      Object willBeRemoved = model.getValueAt(row, 0);//테이블의셀:교수번호
      ProfessorDAO dao = new ProfessorDAO();
      int que = op.showConfirmDialog(this,"정말 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
      if(que == JOptionPane.YES_OPTION) {
         model.removeRow(row);
         int result = dao.deleteRecord(willBeRemoved);

         if(result>0) {
            JOptionPane.showMessageDialog(this,"교수 삭제하였습니다.");
            professorAllList();
         }else {
            JOptionPane.showMessageDialog(this,"교수삭제 실패하였습니다.");
         }

      }else if(que ==JOptionPane.NO_OPTION) {
         
      }
   }
   //교수 검색
   public void ProfessorSearch() {
      //검색어가 입력되어있는지 확인.
      String search = searchWord.getText();
      if(search!=null && !search.equals("")) {//검색어가 있다. 
         String searchField = (String)searchkey.getSelectedItem();//검색키 이름 전화번호 주소
         String fieldName = "";
         if(searchField.equals("교수명")) {
            fieldName = "prof_name";
         }else if(searchField.equals("교수번호")) {
            fieldName = "prof_code";
         }else if(searchField.equals("핸드폰번호")) {
            fieldName = "prof_tel";
         }
         
         ProfessorDAO dao = new ProfessorDAO();
         List<ProfessorVO> list = dao.searchRecord(search,fieldName);
         setProfessorModel(list);
         searchWord.setText("");
      }
   }
   //교수수정
   public void professorUpdate() {

      ProfessorVO vo = new ProfessorVO();
      vo.setProf_code((Integer)(professorList2.getValueAt(0,0))); 
      vo.setMajor_code((Integer)(professorList2.getValueAt(0,1))); 
      vo.setProf_pw((String)professorList2.getValueAt(0,2));
      vo.setProf_name((String)professorList2.getValueAt(0,3));
      vo.setProf_email((String)professorList2.getValueAt(0,4));
      vo.setProf_tel((String)professorList2.getValueAt(0,5));
      vo.setProf_room((String)professorList2.getValueAt(0,6)); 
      vo.setProf_hd((String)professorList2.getValueAt(0,7));
      vo.setProf_birth((String)professorList2.getValueAt(0,8));
      

   ProfessorDAO dao = new ProfessorDAO();
      int cnt = dao.updateRecord(vo);
      if(cnt>0){//수정시 리스트 다시 선택하기
         professorAllList();
         JOptionPane.showMessageDialog(this, "교수정보 수정성공");
      }else{   //수정실패시 안내메시지 표시
         JOptionPane.showMessageDialog(this, "교수정보 수정실패");
      }
   }
   
   
   public void actionPerformed(ActionEvent ae) {
      String eventBtn = ae.getActionCommand();
      if(eventBtn.equals("수정")) {
         professorUpdate();
      }else if(eventBtn.equals("삭제")) {
         professorDelete();
         
      }else if(eventBtn.equals("검색")) {
         ProfessorSearch();
      }else if(eventBtn.equals("새로고침")) {
         professorAllList();
      }
   }
   public class MyEvent extends MouseAdapter{
      //재오버라이딩
      @Override
      public void mouseClicked(MouseEvent me) {
         int eventBtn = me.getButton();
         if(eventBtn==1) {
            model2.setRowCount(0);
            row = professorList.getSelectedRow();
            
            Vector<Object> v = new Vector<Object>();
            v.add((Integer)professorList.getValueAt(row,0));
            v.add((Integer)professorList.getValueAt(row,1));
            v.add((String)professorList.getValueAt(row,2));
            v.add((String)professorList.getValueAt(row,3));
            v.add((String)professorList.getValueAt(row,4));
            v.add((String)professorList.getValueAt(row,5));
            v.add((String)professorList.getValueAt(row,6));
            v.add((String)professorList.getValueAt(row,7));
            v.add((String)professorList.getValueAt(row,8));
            
            model2.addRow(v);
         }
      }
   }
   
   public static void main(String[] args) {
      new ProfessorMain();
   }
}