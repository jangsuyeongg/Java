package Dao.Login;

import DataBase.DBConnection;
import Select.AllStateSession;

import javax.swing.*;
import java.sql.SQLException;

public class LoginDao extends DBConnection {


    public LoginDao() {

    }
    public int Login(String Getid, String Getpw) {
        System.out.println(Getid);
        System.out.println(Getpw);
        int result = 5;
        try {
            dbConn();
            if (Getid.length() == 5) {
                System.out.println("���� ����");

                String sql = "Select ADMIN_CODE,ADMIN_NAME from Admin where ADMIN_CODE=? AND ADMIN_PW=?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, Getid);
                pstmt.setString(2, Getpw);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    result = 1;
                    setUserId(Getid, rs.getString(2));
                    System.out.println("����");
                } else {
                    System.out.println("�ȵ���");
                }
            }
            else if (Getid.length() == 6) {
                System.out.println("���� ����");
                String sql = "select PROF_CODE,PROF_NAME from professor Where PROF_CODE=? AND PROF_PW=?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, Getid);
                pstmt.setString(2, Getpw);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println(Getpw);
                    setUserId(Getid,rs.getString(2));
                    return 2;
                } else {
                    System.out.println("\"���� �α��� ����");
                    return 5;
                }
            }
            else if (Getid.length() == 7) {
                System.out.println("�л� ����");
                String sql = "select STU_CODE,STU_NAME from STUDENT Where STU_CODE=? AND STU_PW=?";
                System.out.println(sql);
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, Getid);
                pstmt.setString(2, Getpw);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    setUserId(Getid,rs.getString(2));
                    return 3;
                } else{
                    System.out.println("�л� �α��� ����");
                    return 5;
                }
            }
        }catch (Exception e)
        { }
        finally {
            dbClose();
        }
        System.out.println(Getid);
        System.out.println("�ƹ��� �α��� ��ȸ�� ��Ͽ� ���� Ȯ���ؾߵ�");
        return result;
    }
    public void setUserId(String SessionId,String SessionName){
        AllStateSession.login_id = SessionId;
        AllStateSession.login_name = SessionName;
    }


}

