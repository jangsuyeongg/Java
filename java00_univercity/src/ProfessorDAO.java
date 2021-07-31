import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO extends DBConnection {

	public ProfessorDAO() {
		
	}
	//전체교수리스트
	public List<ProfessorVO> allRecord() {
		List<ProfessorVO> list	= new ArrayList<ProfessorVO>();
		try {
			//1.db연결
			dbConn();
			String sql = "select prof_code, major_code, prof_pw, prof_name, prof_email, "
					+ "prof_tel,prof_room,prof_hd,prof_birth from professor";
			
			//2. preparestatement 생성
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProfessorVO vo = new ProfessorVO();
				vo.setProf_code(rs.getInt(1));
				vo.setMajor_code(rs.getInt(2));
				vo.setProf_pw(rs.getString(3));
				vo.setProf_name(rs.getString(4));
				vo.setProf_email(rs.getString(5));
				vo.setProf_tel(rs.getString(6));
				vo.setProf_room(rs.getString(7));
				vo.setProf_hd(rs.getString(8));
				vo.setProf_birth(rs.getString(9));

				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("전체교수리스트 에러");
			e.printStackTrace();
		}finally{
			dbClose();
		}
		return list;
	} 
	//교수추가
	public int insertRecord(ProfessorVO vo) {
		int cnt=0;
		try {
			dbConn();
			String sql="insert into professor values(pr_code.nextval, ?, ?, ?, ?, ?, ?, sysdate, ?)";
			
			pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, vo.getMajor_code());
				pstmt.setString(2, vo.getProf_birth());//비밀번호는 생년월일 
				pstmt.setString(3, vo.getProf_name());
				pstmt.setString(4, vo.getProf_email());
				pstmt.setString(5, vo.getProf_tel());
				pstmt.setString(6, vo.getProf_room());
				pstmt.setString(7, vo.getProf_birth());
				
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("교수추가에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	//교수수정
	public int updateRecord(ProfessorVO vo) {
		int cnt = 0;
		try {
				dbConn();
				
				String sql = "update professor set  major_code=?, prof_pw=?,prof_name=?, prof_email=?,prof_tel=?,prof_room=?,prof_hd= sysdate, prof_birth=? where prof_code=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1,  vo.getMajor_code());
				pstmt.setString(2,  vo.getProf_pw());
				pstmt.setString(3,  vo.getProf_name());
				pstmt.setString(4,  vo.getProf_email());
				pstmt.setString(5,  vo.getProf_tel());
				pstmt.setString(6,  vo.getProf_room());
				//pstmt.setString(7,  vo.getProf_hd());
				pstmt.setString(7,  vo.getProf_birth());
				pstmt.setInt(8,  vo.getProf_code());
				
				cnt = pstmt.executeUpdate();
			
			}catch(Exception e) {
				System.out.println("교수수정에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}
		return cnt;
	}
	//교수삭제
	public int deleteRecord(Object willBeRemoved){
		int code = (Integer)willBeRemoved;
		int cnt = 0;
		try {
			dbConn();
			String sql = "delete from professor where prof_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			cnt = pstmt.executeUpdate();
			return cnt;
		}catch(Exception e) {
			System.out.println("교수삭제 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return 0;
	}
	//교수검색
	public List<ProfessorVO> searchRecord(String search, String fieldName) {
		List<ProfessorVO> list = new ArrayList<ProfessorVO>();
		try {	
			dbConn();
			String sql = "select prof_code, major_code, prof_pw, prof_name, prof_email,"
					+ "prof_tel,prof_room,prof_hd,prof_birth from professor where "+fieldName+" like ? ";
			
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%"); //"%김%
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProfessorVO vo  = new ProfessorVO();
				vo.setProf_code(rs.getInt(1));
				vo.setMajor_code(rs.getInt(2));
				vo.setProf_pw(rs.getString(3));
				vo.setProf_name(rs.getString(4));
				vo.setProf_email(rs.getString(5));
				vo.setProf_tel(rs.getString(6));
				vo.setProf_room(rs.getString(7));
				vo.setProf_hd(rs.getString(8));
				vo.setProf_birth(rs.getString(9));
				
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("교수검색 에러");
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
		return list;
	}
}
