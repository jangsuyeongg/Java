package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   protected Connection con;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

    String Url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
    String username = "c##TEST04";
    String password = "qazwsxedc";
    String sql;

    public DBConnection (){

    }
    //db����
    public void dbConn() {
        try {
            con = DriverManager.getConnection(Url,username,password);
            System.out.println("��Ƽ��̽� �߿����");
        }catch(Exception e) {
            System.out.println("��Ƽ��̽� ����ȵ� �������������ä���");
            e.printStackTrace();
        }
    }

    //db�ݱ�
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