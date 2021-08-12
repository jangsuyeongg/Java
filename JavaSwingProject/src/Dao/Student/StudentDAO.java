package Dao.Student;

import DataBase.DBConnection;
import Vo.Student.StudentVO2;
import Vo.Student.StudentVO3;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DBConnection {

	public StudentDAO() {
		
	}
	
	//학생전체조회
	public List<StudentVO2> allRecord(){
		List<StudentVO2> list = new ArrayList<StudentVO2>();
		try {
		
			dbConn();

//			String sql = "select Stu_Code, Major_Code,stu_pw, stu_name, stu_grade , "
//		               + "stu_email, stu_tel, stu_add,stu_state, to_char(stu_date,'YY-MM-DD'),  stu_birth" 
//		               + " from student";
		
			String sql = " SELECT s.Stu_Code ,m.major_name,s.stu_pw ,s.stu_name  ,s.stu_grade "
				     +",s.stu_email, s.stu_tel ,s.stu_add ,s.stu_state ,to_char(s.stu_date,'YY-MM-DD'),s.stu_birth  "
				     +"from student s , major m "
				     +"where s.major_code = m.major_code";
			
			
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentVO2 vo = new StudentVO2();
				vo.setStu_Code(rs.getInt(1));
				vo.setMajor_name(rs.getString(2));
				vo.setStu_pw(rs.getString(3));
				vo.setStu_name(rs.getString(4));
				vo.setStu_grade(rs.getString(5));
				vo.setStu_email(rs.getString(6));
				vo.setStu_tel(rs.getString(7));
				vo.setStu_add(rs.getString(8));
				vo.setStu_state(rs.getString(9));
				vo.setStu_date(rs.getString(10));
				vo.setStu_birth(rs.getString(11));				
				list.add(vo);
			}
			
		}catch(Exception e){
			System.out.println("학생전체조회 에러 발생....");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}

	//학생검색
//	public List<StudentVO2> searchRecord(String search,String fieldName) {
//		
//		List<StudentVO2> list = new ArrayList<StudentVO2>();
//		try {
//			dbConn();
//			
//			
//			
////				if(fieldName=="major_name") {
////					
////					String sql =  " SELECT s.Stu_Code ,m.major_name,s.stu_pw ,s.stu_name  ,s.stu_grade "
////						     +",s.stu_email, s.stu_tel ,s.stu_add ,s.stu_state ,to_char(s.stu_date,'YY-MM-DD'),s.stu_birth  "
////						     +"from student s , major m "
////						     +"where s.major_code = m.major_code and "+fieldName+" like ? ";
////					
////							
////							
////							System.out.println("sql"+sql);
////							pstmt = con.prepareStatement(sql);
////							
////							
////							
////							pstmt.setString(1,"%"+search+"%"); // %김% //***수정****
////							rs =pstmt.executeQuery(); //선택된레코드의 정보가 들어가잇음:셀렉트된정보
////							
////							
////							while(rs.next()) {
////								StudentVO2 vo = new StudentVO2();
////								vo.setStu_Code(rs.getInt(1));
////								vo.setMajor_name(rs.getString(2));
////								vo.setStu_pw(rs.getString(3));
////								vo.setStu_name(rs.getString(4));
////								vo.setStu_grade(rs.getString(5));
////								vo.setStu_email(rs.getString(6));
////								vo.setStu_tel(rs.getString(7)); 
////								vo.setStu_add(rs.getString(8));
////								vo.setStu_state(rs.getString(9));
////								vo.setStu_date(rs.getString(10));
////								vo.setStu_birth(rs.getString(11));				
////								list.add(vo);
////							}
////					
////				}else {
//				
//					String sql =  "select Stu_Code, Major_Code, stu_pw, stu_name, stu_grade , "
//				               + "stu_email, stu_tel, stu_add, stu_state, to_char(stu_date,'YY-MM-DD'),  stu_birth" 
//							+ " from Student where "+fieldName+" like ? ";
//
//					System.out.println("sql"+sql);
//					pstmt = con.prepareStatement(sql);
//					
//					
//					
//					pstmt.setString(1,"%"+search+"%"); // %김% //***수정****
//					rs =pstmt.executeQuery(); //선택된레코드의 정보가 들어가잇음:셀렉트된정보
//					
//					
//					while(rs.next()) {
//						StudentVO2 vo = new StudentVO2();
//						vo.setStu_Code(rs.getInt(1));
//						vo.setMajor_name(rs.getString(2));
//						vo.setStu_pw(rs.getString(3));
//						vo.setStu_name(rs.getString(4));
//						vo.setStu_grade(rs.getString(5));
//						vo.setStu_email(rs.getString(6));
//						vo.setStu_tel(rs.getString(7)); 
//						vo.setStu_add(rs.getString(8));
//						vo.setStu_state(rs.getString(9));
//						vo.setStu_date(rs.getString(10));
//						vo.setStu_birth(rs.getString(11));				
//						list.add(vo);
//					}
//				
//					
//					
//				//}
//				
//			}catch(Exception e) {
//				System.out.println("학생검색에러 발생.......");
//				e.printStackTrace();
//			}finally {
//				dbClose();
//			}
//			return list;
//		
//	
//	}	
	//학생검색
	public List<StudentVO2> searchRecord(String search,String fieldName) {
		
		List<StudentVO2> list = new ArrayList<StudentVO2>();
		
	//	if(fieldName=="major_name") {		
			try {
				dbConn();		
//				if(fieldName=="s.Stu_Code") {	
//					String sql =  " SELECT s.Stu_Code ,m.major_name,s.stu_pw ,s.stu_name  ,s.stu_grade "
//						     +",s.stu_email, s.stu_tel ,s.stu_add ,s.stu_state ,to_char(s.stu_date,'YY-MM-DD'),s.stu_birth  "
//						     +"from student s , major m "
//						     +"where s.major_code = m.major_code and "+fieldName+" like ? ";						
//							System.out.println("sql"+sql);
//							pstmt = con.prepareStatement(sql);						
//							
//						
//							pstmt.setString(1,"%"+search+"%"); // %김% //***수정****
//							rs =pstmt.executeQuery(); //선택된레코드의 정보가 들어가잇음:셀렉트된정보							
//							while(rs.next()) {
//								StudentVO2 vo = new StudentVO2();
//								vo.setStu_Code(rs.getInt(1));
//								vo.setMajor_name(rs.getString(2));
//								vo.setStu_pw(rs.getString(3));
//								vo.setStu_name(rs.getString(4));
//								vo.setStu_grade(rs.getString(5));
//								vo.setStu_email(rs.getString(6));
//								vo.setStu_tel(rs.getString(7)); 
//								vo.setStu_add(rs.getString(8));
//								vo.setStu_state(rs.getString(9));
//								vo.setStu_date(rs.getString(10));
//								vo.setStu_birth(rs.getString(11));				
//								list.add(vo);
//							}
//					
//				}else {
//				
					
//					String sql =  "select Stu_Code, Major_Code, stu_pw, stu_name, stu_grade , "
//				               + "stu_email, stu_tel, stu_add, stu_state, to_char(stu_date,'YY-MM-DD'),  stu_birth" 
//							+ " from Student where "+fieldName+" like ? ";
					String sql =  " SELECT s.Stu_Code ,m.major_name,s.stu_pw ,s.stu_name  ,s.stu_grade "
						     +",s.stu_email, s.stu_tel ,s.stu_add ,s.stu_state ,to_char(s.stu_date,'YY-MM-DD'),s.stu_birth  "
						     +"from student s , major m "
						     +"where s.major_code = m.major_code and "+fieldName+" like ? ";					
					
					System.out.println("sql"+sql);
					//------------------------------------------여기서부터안됨
					pstmt = con.prepareStatement(sql);
					

					pstmt.setString(1,"%"+search+"%"); // %김% //***수정****
					rs = pstmt.executeQuery(); //선택된레코드의 정보가 들어가잇음:셀렉트된정보
					
					while(rs.next()) {
						
						System.out.println("while문안으로 들어옴");
						StudentVO2 vo = new StudentVO2();
						vo.setStu_Code(rs.getInt(1));
						vo.setMajor_name(rs.getString(2));
						vo.setStu_pw(rs.getString(3));
						vo.setStu_name(rs.getString(4));
						vo.setStu_grade(rs.getString(5));
						vo.setStu_email(rs.getString(6));
						vo.setStu_tel(rs.getString(7)); 
						vo.setStu_add(rs.getString(8));
						vo.setStu_state(rs.getString(9));
						vo.setStu_date(rs.getString(10));
						vo.setStu_birth(rs.getString(11));				
						list.add(vo);
						System.out.println(vo.getStu_name());
					}
				
//					
//					
			//	}
				
			}catch(Exception e) {
				System.out.println("학생검색에러 발생.......");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			
		//}
		return list;
		}
	
	
	
	//학생수정	
	public int updateRecord(StudentVO3 vo) {
		//쿼리값 셋팅하고 나오는 명령문
//		System.out.println(vo.allprint());
			//수정이 됫는지 안됬는지의 정보를 보내준다 
			//쿼리문을 싱행하면 실행하는명령어가 리턴해주는 데이터가 있다 -> pstmt.executeUpdate()
		int cnt =0;
		try {
			dbConn();
			String sql = "update student set  Major_Code=?,stu_pw=?,stu_name=?,stu_grade=?,stu_email=?,stu_tel=?,stu_add=?,stu_state=?,stu_BIRTH=? where stu_code=?";
			//String sql = "update student set  major_name=?,stu_pw=?,stu_name=?,stu_grade=?,stu_email=?,stu_tel=?,stu_add=?,stu_state=?,stu_date = sysdate,stu_BIRTH=? where stu_code=?";

			pstmt = con.prepareStatement(sql);
				
			//pstmt.setInt(1, vo.getStu_Code());
			pstmt.setInt(1, vo.getMajor_Code());
			pstmt.setString(2, vo.getStu_pw());
			pstmt.setString(3, vo.getStu_name());
			pstmt.setString(4,vo.getStu_grade());
			pstmt.setString(5,vo. getStu_email());
			pstmt.setString(6,vo.getStu_tel()); 
			pstmt.setString(7,vo.getStu_add());
			pstmt.setString(8,vo.getStu_state());
			pstmt.setString(9,vo.getStu_birth());		
			pstmt.setInt(10,vo.getStu_Code());	 //*****
	
			
			
			//(LoggableStatement)pstmt
			cnt = pstmt.executeUpdate();
				
		}catch(Exception e) {
			System.out.println("DAO 학생수정 에러 발생...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
			return cnt;
	}
	
	//전공명으로 전공번호가져오기
		public int searchMajorCode(String majorname) {
			
			int result=0;
			try {
				dbConn();
				String sql = "select Major_Code"
						+ " from major where major_name like ? ";
				System.out.println("sql"+sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,majorname); // %김%
				rs =pstmt.executeQuery(); //선택된레코드의 정보가 들어가잇음:셀렉트된정보
				
				while(rs.next())  {
					result = rs.getInt(1);
				System.out.println(result);
				}
				
			}catch(Exception e) {
				System.out.println("DAO 전공명으로 전공번호가져오기 에러 발생.......");
				e.printStackTrace();
			}finally {
				
			}
			return result;
		}
	
	
	
	
	//학생추가
	public int insertRecord(StudentVO3 vo){
		//추가등록후에 데이터베이스에도 추가되어야하고 제이테이블회원목록에도 추가된 회원이 출력되어야한다..
		int cnt=0;
		try {
			dbConn(); //디비연결
			String sql = "insert into student values(ST_CODE.nextval, ?,?,?,?,?, ?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getMajor_Code());
			pstmt.setString(2, vo.getStu_birth());
			pstmt.setString(3, vo.getStu_name());
			pstmt.setString(4,vo.getStu_grade());
			pstmt.setString(5,vo. getStu_email());
			pstmt.setString(6,vo.getStu_tel()); //int
			pstmt.setString(7,vo.getStu_add());
			pstmt.setString(8,vo.getStu_state());
			//pstmt.setInt(8,vo.getStu_date());
			pstmt.setString(9,vo.getStu_birth());		
		
			cnt= pstmt.executeUpdate(); //몇개의 레코드가 추가되었는지.....
			
		}catch(Exception e) {
			System.out.println("학생추가에러 발생...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	//학생삭제
	public int deleteRecord(Object willBeRomoved) { //누구를삭제할건지 매개변수받아서 처리-db에서 삭제후 삭제결과를 보내줘야함
		int code = (Integer)willBeRomoved;
		int cnt=0;		
		try {
			dbConn();
			String sql = "delete from student where Stu_code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,code);
					
			cnt = pstmt.executeUpdate();
					
		}catch(Exception e) {
			System.out.println("StudentDAO 강의삭제 에러 발생");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;			
	}

	
	
	public static void main(String[] args) {
		new StudentDAO();
	}

}
