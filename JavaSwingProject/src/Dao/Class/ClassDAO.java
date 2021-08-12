package Dao.Class;


import DataBase.DBConnection;
import Vo.Class.ClassVO;
import Vo.Class.ClassVO2;

import java.util.ArrayList;
import java.util.List;

public class ClassDAO  extends DBConnection {

    public ClassDAO() {

    }

    //강의전체조회
    public List<ClassVO2> allRecord(){
        List<ClassVO2> list = new ArrayList<ClassVO2>();
        try {

            dbConn();

            String sql = "select c.class_code, c.prof_code,c.class_div,c.class_name,p.prof_name ,c.class_grade , "
                    + "c.class_time, c.class_room, c.tot_mem,c.reg_mem, to_char(c.class_date,'YY-MM-DD')"
                    + " from class c , professor p"
                    +" where c.prof_code = p.prof_code";
			/*
				String sql = " SELECT s.Stu_Code ,m.major_name,s.stu_pw ,s.stu_name  ,s.stu_grade "
				     +",s.stu_email, s.stu_tel ,s.stu_add ,s.stu_state ,to_char(s.stu_date,'YY-MM-DD'),s.stu_birth  "
				     +"from class c , professor p  "
				     +"where c.prof_code = p.prof_code";

			*/



            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while(rs.next()) {
                ClassVO2 vo = new ClassVO2();
                vo.setClass_code(rs.getInt(1));
                vo.setProf_code(rs.getInt(2));
                vo.setClass_div(rs.getString(3));
                vo.setClass_name(rs.getString(4));
                vo.setProf_name(rs.getString(5));
                vo.setClass_grade(rs.getString(6));
                vo.setClass_time(rs.getString(7));
                vo.setClass_room(rs.getString(8));
                vo.setTot_mem(rs.getInt(9));
                vo.setReg_mem(rs.getInt(10));
                vo.setClass_date(rs.getString(11));

                list.add(vo);
            }

        }catch(Exception e){
            System.out.println("classDAO allRecord 에러 발생....");
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return list;
    }

    //강의검색
    public List<ClassVO2> searchRecord(String search,String fieldName) {

        List<ClassVO2> list = new ArrayList<ClassVO2>();
        try {
            dbConn();
//			String sql = "select class_code, prof_code,class_div,class_name, class_grade , "
//		              + "class_time, class_room, tot_mem,reg_mem, to_char(class_date,'YY-MM-DD')"
//						+ " from class where "+fieldName+" like ? ";
//
            String sql = "select c.class_code, c.prof_code,c.class_div,c.class_name,p.prof_name ,c.class_grade , "
                    + "c.class_time, c.class_room, c.tot_mem,c.reg_mem, to_char(c.class_date,'YY-MM-DD')"
                    + " from class c , professor p"
                    +" where c.prof_code = p.prof_code and "+fieldName+" like ? ";



            System.out.println("sql"+sql);
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1,"%"+search+"%"); // %김% //***수정****
            rs =pstmt.executeQuery(); //선택된레코드의 정보가 들어가잇음:셀렉트된정보


            while(rs.next()) {
                ClassVO2 vo = new ClassVO2();
                vo.setClass_code(rs.getInt(1));
                vo.setProf_code(rs.getInt(2));
                vo.setClass_div(rs.getString(3));
                vo.setClass_name(rs.getString(4));
                vo.setProf_name(rs.getString(5));
                vo.setClass_grade(rs.getString(6));
                vo.setClass_time(rs.getString(7));
                vo.setClass_room(rs.getString(8));
                vo.setTot_mem(rs.getInt(9));
                vo.setReg_mem(rs.getInt(10));
                vo.setClass_date(rs.getString(11));

                list.add(vo);
            }

        }catch(Exception e) {
            System.out.println("classDAO강의검색에러 발생.......");
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return list;
    }

    //강의정보수정
    public int updateRecord(ClassVO vo) {
        //쿼리값 셋팅하고 나오는 명령문
        //System.out.println(vo.allprint());
        //수정이 됫는지 안됬는지의 정보를 보내준다
        //쿼리문을 싱행하면 실행하는명령어가 리턴해주는 데이터가 있다 -> pstmt.executeUpdate()
        int cnt =0;
        try {
            dbConn();
            String sql = "update class set  class_div=?,class_name=?,class_grade=?,class_time=?,class_room=?,tot_mem=?,reg_mem=? where class_code=?";

            pstmt = con.prepareStatement(sql);

            //pstmt.setInt(1, vo.getClass_code()); //강의번호
            //pstmt.setInt(2, vo.getProf_code()); //교수번호
            pstmt.setString(1, vo.getClass_div());
            pstmt.setString(2, vo.getClass_name());
            pstmt.setString(3,vo.getClass_grade());
            pstmt.setString(4,vo.getClass_time());
            pstmt.setString(5,vo.getClass_room());
            pstmt.setInt(6,vo.getTot_mem());
            pstmt.setInt(7,vo.getReg_mem());
            pstmt.setInt(8,vo.getClass_code());	//*****
            //pstmt.setString(9,vo.getClass_date());


            cnt = pstmt.executeUpdate();

        }catch(Exception e) {
            System.out.println("DAO 강의정보수정 에러 발생...");
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return cnt;
    }

    //강의삭제

    public int deleteRecord(Object willBeRomoved) { //누구를삭제할건지 매개변수받아서 처리-db에서 삭제후 삭제결과를 보내줘야함
        int code = (Integer)willBeRomoved;
        int cnt=0;
        try {
            dbConn();
            String sql = "delete from class where class_code=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,code);

            cnt = pstmt.executeUpdate();

        }catch(Exception e) {
            System.out.println("classDAO 강의삭제 에러 발생");
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return cnt;
    }

}
