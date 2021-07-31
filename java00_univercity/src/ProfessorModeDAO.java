import java.util.ArrayList;
import java.util.List;

public class ProfessorModeDAO extends DBConnection{
	int Proid = Integer.parseInt(AllStateSession.login_id);
	public ProfessorModeDAO() {
	}

	//������ �����߰�
	public int insertRecord(ProfessorModeVO vo) {
		int cnt=0;
		try {
			dbConn();
			String sql="insert into class values(cl_code.nextval, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Proid);
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
			System.out.println("�����߰�����");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	//������ �������������Ҷ� ���� ��������
	public ProfessorVO setProfessorProfile() {
		ProfessorVO vo = new ProfessorVO();
		try {
			dbConn();
			String sql = "select p.prof_code, m.major_name, p.prof_pw, p.prof_name, p.prof_email, p.prof_tel, p.prof_room, to_char(p.prof_hd, 'YYYY-MM-DD'), p.prof_birth from professor p join major m on p.major_code=m.major_code where p.prof_code=" + Proid;
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
			System.out.println("������������ �������� ����");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return vo;
	}
	//������ ������������
	public int updateRecord(ProfessorVO vo) {
		int cnt = 0;
		try {
			dbConn();
			String sql = "update professor set prof_pw=?, prof_email=?, prof_tel=?, prof_room=? where prof_code=" + Proid;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getProf_pw());
			pstmt.setString(2, vo.getProf_email());
			pstmt.setString(3, vo.getProf_tel());
			pstmt.setString(4, vo.getProf_room());

			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("������ �������������ϴ°� ����");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	//������ �� ���Ǹ� ��û�� �л������ �����ִ� ���̺�
		public List<StudentVO> allRecord() {
			List<StudentVO> list	= new ArrayList<StudentVO>();
			try {
				//1.db����
				dbConn();
				String sql = "select C.CLASS_NAME, ST.STU_CODE, ST.stu_grade, ST.STU_NAME, M.Major_name, ST.STU_TEL from STUDENT ST,MAJOR M ,"
						+ "CLASS C,SCORE S, PROFESSOR P where P.PROF_CODE=100080 AND C.CLASS_CODE='1500' and ST.MAJOR_CODE = M.MAJOR_CODE "
						+ "and ST.STU_CODE = S.STU_CODE AND C.CLASS_CODE = S.CLASS_CODE";
	
				//2. preparestatement ����
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
				System.out.println("�� ��� �л�����Ʈ ����");
				e.printStackTrace();
			}finally{
				dbClose();
			}
			return list;
		} 
	
		//������ �����ǵ�� �л� �˻� 
		public List<StudentVO> searchRecord(String search, String fieldName) {
			List<StudentVO> list = new ArrayList<StudentVO>();
			try {	
				dbConn();
				
				String sql = "select C.CLASS_NAME, ST.STU_CODE, ST.stu_grade, ST.STU_NAME, M.Major_name, ST.STU_TEL from STUDENT ST,MAJOR M ,CLASS C,SCORE S, PROFESSOR P where P.PROF_CODE=100080 AND C.CLASS_CODE='1500' \r\n"
						+ "and ST.MAJOR_CODE = M.MAJOR_CODE and ST.STU_CODE = S.STU_CODE AND C.CLASS_CODE = S.CLASS_CODE and "+fieldName+" like ?";
				

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+search+"%"); //"%��%
				
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
				System.out.println("������ �л��˻� ����");
				e.printStackTrace();
				
			}finally {
				dbClose();
			}
			return list;
		}
	
}
