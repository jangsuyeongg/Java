package Dao.Professor;

import DataBase.DBConnection;
import Select.AllStateSession;
import Vo.Professor.ProfessorModeVO;
import Vo.Professor.ProfessorVO;
import Vo.Student.StudentModeVO2;
import Vo.Student.StudentVO;

import java.util.ArrayList;
import java.util.List;

public class ProfessorModeDAO extends DBConnection {

    int id =Integer.parseInt(AllStateSession.login_id); //교수번호

    public ProfessorModeDAO() {

    }

    public List<StudentModeVO2> allClassRecord(){
        List<StudentModeVO2> list = new ArrayList<StudentModeVO2>();
        try {
            dbConn();
            //Prof_Code를 가지고 그 교수가 개설한 강의를 가져온다 , 근데 강의번호대신 이름 가져온다
            String sql = " SELECT C.CLASS_CODE ,P.PROF_NAME ,C.CLASS_DIV ,C.CLASS_NAME ,c.CLASS_GRADE "
                    +",C.CLASS_TIME , C.CLASS_ROOM , C.TOT_MEM , C.REG_MEM , to_char(C.CLASS_DATE,'YY-MM-DD') "
                    +"from CLASS C , PROFESSOR P "
                    +"where P.Prof_Code=? and P.Prof_Code = C.PROF_CODE";
            System.out.println("sql"+sql);

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);

            rs =pstmt.executeQuery(); //선택된레코드의 정보가 들어가잇음:셀렉트된정보


            while(rs.next()) {
                StudentModeVO2 vo = new StudentModeVO2();
                vo.setClass_code(rs.getInt(1));
                vo.setProf_name(rs.getString(2));
                vo.setClass_div(rs.getString(3));
                vo.setClass_name(rs.getString(4));
                vo.setClass_grade(rs.getString(5));
                vo.setClass_time(rs.getString(6));
                vo.setClass_room(rs.getString(7));
                vo.setTot_mem(rs.getInt(8));
                vo.setReg_mem(rs.getInt(9));
                vo.setClass_date(rs.getString(10));

                list.add(vo);
            }

        }catch(Exception e) {
            System.out.println("ProfessorModeDAO 교수개설강의전체목록에러 발생.......");
            e.printStackTrace();
        }finally {
            dbClose();
        }



        return list;
    }

    //강의수정입력한걸 디비내용 업데이트
    public int updateClassRecord(StudentModeVO2 vo){
        int cnt =0;

        try {
            dbConn();

            String sql ="update class set  class_div=?,class_name=?,class_grade=?,class_time=?,class_room=?,tot_mem=?,reg_mem=? "
                    + " where Class_code=?";

            pstmt = con.prepareStatement(sql);


            pstmt.setString(1, vo. getClass_div());
            pstmt.setString(2, vo.getClass_name());
            pstmt.setString(3, vo.getClass_grade());
            pstmt.setString(4,vo.getClass_time());
            pstmt.setString(5,vo.getClass_room());
            pstmt.setInt(6,vo.getTot_mem());
            pstmt.setInt(7,vo.getReg_mem());
            pstmt.setInt(8,vo.getClass_code());


            cnt = pstmt.executeUpdate();

        }catch(Exception e) {
            System.out.println("DAO 교수가강의수정 에러 발생...");
            e.printStackTrace();
        }finally {
            dbClose();
        }


        return cnt;
    }
    //강의명으로 강의번호가져오기
    public int searchCladdCode(String search) {

        int result=0;
        try {
            dbConn();
            String sql = "select Class_Code "
                    + " from class where class_name like ? ";
            System.out.println("sql"+sql);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,search); // %김%
            rs =pstmt.executeQuery(); //선택된레코드의 정보가 들어가잇음:셀렉트된정보

            while(rs.next())  {
                result = rs.getInt(1);
                System.out.println(result);
            }

        }catch(Exception e) {
            System.out.println("강의명으로 강의번호가져오기 에러 발생.......");
            e.printStackTrace();
        }finally {

        }
        return result;
    }


    //개설강의삭제
    public int deleteClassRecord(int code) {//번호를 가져와서 테이블에 있는지 없는지 확인하고
        int cnt=0;
        try {
            dbConn();
            String sql = "delete from class where Class_Code=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,code);

            cnt = pstmt.executeUpdate();

        }catch(Exception e) {
            System.out.println("ProfessorModeDAO 강의삭제 에러 발생");
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return cnt;

    }


    //-----------수영언니 메소드----------------
    public int insertRecord(ProfessorModeVO vo) {
        int cnt=0;
        try {
            dbConn();
            String sql="insert into class values(cl_code.nextval, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            System.out.println(vo.getClass_code());
            pstmt.setString(2, vo.getClass_div());
            pstmt.setString(3, vo.getClass_name());
            pstmt.setString(4,vo.getClass_grade());
            pstmt.setString(5,vo.getClass_time());
            pstmt.setString(6,vo.getClass_room());
            pstmt.setInt(7,vo.getTot_mem());
            pstmt.setInt(8,vo.getReg_mem());

            cnt = pstmt.executeUpdate();

        }catch(Exception e) {
            System.out.println("강의추가에러");
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return cnt;
    }

    //교수가 개인정보수정할때 정보 가져오기
    public ProfessorVO setProfessorProfile() {
        ProfessorVO vo = new ProfessorVO();
        try {
            dbConn();
            String sql = "select p.prof_code, m.major_name, p.prof_pw, p.prof_name, p.prof_email, p.prof_tel, p.prof_room, to_char(p.prof_hd, 'YYYY-MM-DD'), p.prof_birth from professor p join major m on p.major_code=m.major_code where p.prof_code=" + id;
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                vo.setProf_code(rs.getInt(1));
                vo.setMajor_name(rs.getString(2));
                vo.setProf_pw(rs.getString(3));
                vo.setProf_name(rs.getString(4));
                vo.setProf_email(rs.getString(5));
                vo.setProf_tel(rs.getString(6));
                vo.setProf_room(rs.getString(7));
                vo.setProf_hd(rs.getString(8));
                vo.setProf_birth(rs.getString(9));
            }
        }catch(Exception e) {
            System.out.println("개인정보수정 가져오기 에러");
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return vo;
    }
    //교수가 개인정보수정
    public int updateRecord(ProfessorVO vo) {
        int cnt = 0;
        try {
            dbConn();
            String sql = "update professor set prof_pw=?, prof_email=?, prof_tel=?, prof_room=? where prof_code=" + id;
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, vo.getProf_pw());
            pstmt.setString(2, vo.getProf_email());
            pstmt.setString(3, vo.getProf_tel());
            pstmt.setString(4, vo.getProf_room());

            cnt = pstmt.executeUpdate();
        }catch(Exception e) {
            System.out.println("교수가 개인정보수정하는거 에러");
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return cnt;
    }

    //교수가 내 강의를 신청한 학생목록을 보여주는 테이블
    public List<StudentVO> allRecord() {
        List<StudentVO> list   = new ArrayList<StudentVO>();
        try {
            //1.db연결
            dbConn();
            String sql = "select C.CLASS_NAME, ST.STU_CODE, ST.stu_grade, ST.STU_NAME, M.Major_name, ST.STU_TEL from STUDENT ST,MAJOR M ,CLASS C,SCORE S, PROFESSOR P where P.PROF_CODE="+id+" and c.PROF_CODE="+id+" and ST.MAJOR_CODE = M.MAJOR_CODE and ST.STU_CODE = S.STU_CODE AND C.CLASS_CODE = S.CLASS_CODE";

            //2. preparestatement 생성
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while(rs.next()) {
                StudentVO vo = new StudentVO();
                vo.setClass_name(rs.getString(1));
                vo.setStu_Code(rs.getInt(2));
                vo.setStu_grade(rs.getString(3));
                vo.setStu_name(rs.getString(4));
                vo.setMajor_name(rs.getString(5));
                vo.setStu_tel(rs.getString(6));

                list.add(vo);
            }
        }catch(Exception e) {
            System.out.println("내 담당 학생리스트 에러");
            e.printStackTrace();
        }finally{
            dbClose();
        }
        return list;
    }

    //교수가 내강의듣는 학생 검색
    public List<StudentVO> searchRecord(String search, String fieldName) {
        List<StudentVO> list = new ArrayList<StudentVO>();
        try {
            dbConn();

            String sql = "select C.CLASS_NAME, ST.STU_CODE, ST.stu_grade, ST.STU_NAME, M.Major_name, ST.STU_TEL from STUDENT ST,MAJOR M ,CLASS C,SCORE S, PROFESSOR P where P.PROF_CODE=100080 AND C.CLASS_CODE='1500' \r\n"
                    + "and ST.MAJOR_CODE = M.MAJOR_CODE and ST.STU_CODE = S.STU_CODE AND C.CLASS_CODE = S.CLASS_CODE and "+fieldName+" like ?";


            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%"+search+"%"); //"%김%

            rs = pstmt.executeQuery();
            while(rs.next()) {
                StudentVO vo  = new StudentVO();
                vo.setClass_name(rs.getString(1));
                vo.setStu_Code(rs.getInt(2));
                vo.setStu_grade(rs.getString(3));
                vo.setStu_name(rs.getString(4));
                vo.setMajor_name(rs.getString(5));
                vo.setStu_tel(rs.getString(6));

                list.add(vo);
            }
        }catch(Exception e) {
            System.out.println("교수가 학생검색 에러");
            e.printStackTrace();

        }finally {
            dbClose();
        }
        return list;
    }



}