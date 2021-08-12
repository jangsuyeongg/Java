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
                System.out.println("어드민 들어옴");

                String sql = "Select ADMIN_CODE,ADMIN_NAME from Admin where ADMIN_CODE=? AND ADMIN_PW=?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, Getid);
                pstmt.setString(2, Getpw);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    result = 1;
                    setUserId(Getid, rs.getString(2));
                    System.out.println("들어옴");
                } else {
                    System.out.println("안들어옴");
                }
            }
            else if (Getid.length() == 6) {
                System.out.println("교수 들어옴");
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
                    System.out.println("\"교수 로그인 실패");
                    return 5;
                }
            }
            else if (Getid.length() == 7) {
                System.out.println("학생 들어옴");
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
                    System.out.println("학생 로그인 실패");
                    return 5;
                }
            }
        }catch (Exception e)
        { }
        finally {
            dbClose();
        }
        System.out.println(Getid);
        System.out.println("아무도 로그인 조회에 목록에 없음 확인해야됨");
        return result;
    }
    public void setUserId(String SessionId,String SessionName){
        AllStateSession.login_id = SessionId;
        AllStateSession.login_name = SessionName;
    }


}

