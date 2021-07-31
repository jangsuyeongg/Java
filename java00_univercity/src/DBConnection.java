import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
   
   static {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      
   }
   
   Connection con;
   PreparedStatement pstmt;
   ResultSet rs;
   
   String Url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
   String username = "c##TEST04";
   String password = "qazwsxedc";
   String sql;
   public DBConnection() {
      
   }
   //db¿¬°á
   public void dbConn() {
      try {
         con = DriverManager.getConnection(Url,username,password);         
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   //db´Ý±â
   public void dbClose() {
      try {
         if(rs!=null) rs.close();
         if(pstmt!=null) pstmt.close();
         if(con!=null) con.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
      
   }
   

}