import java.util.ArrayList;
import java.util.List;

public class StudentModeDAOjisu extends DBConnection{

	int id =Integer.parseInt(AllStateSession.login_id); //�л���ȣ	

	public StudentModeDAOjisu() {
		
	}
	
	
	
	//������û �޼ҵ�
	public int insertApplyClass(StudentModeVO vo) {
		System.out.println(id);
	
		int cnt=0;
		try {
			dbConn(); //��񿬰� 
			//���Ǽ��� - id�ߺ�x(pk),�����ο��ʰ���
			String sql = "insert into score(Class_Code,Stu_Code,class_time) values(?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,vo.getClass_code());
			pstmt.setInt(2,id);			
			
			cnt= pstmt.executeUpdate(); //��� ���ڵ尡 �߰��Ǿ�����.....
			
		}catch(Exception e) {
			System.out.println("�л����DAO ������û���� �߻�...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return cnt;
	}
	
	//������û�� ���������� ��û�ο� �����ϴ� �޼ҵ�
	public int updateRecord(ClassVO vo) {
		int cnt=0;
		try {
			dbConn(); //��񿬰�
			String sql = "update class set reg_mem=reg_mem+1 where Class_code=?";
		
			pstmt = con.prepareStatement(sql);
			
			//pstmt.setInt(1,?�����ο�+1);
			//getget
			pstmt.setInt(1,vo.getClass_code());
			
			
			cnt= pstmt.executeUpdate(); //��� ���ڵ尡 �߰��Ǿ�����.....
			
		}catch(Exception e) {
			System.out.println("�л����DAO ������û�ο����� �߻�...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		
		return cnt;
	}
	
	//������û�����ҷ����� �޼ҵ�
	public List<StudentModeVO2> selectClassRecord() {
		List<StudentModeVO2> list   = new ArrayList<StudentModeVO2>();
		
		try {
			dbConn();
			String sql = " SELECT C.CLASS_CODE ,P.PROF_NAME ,C.CLASS_NAME ,C.CLASS_DIV ,c.CLASS_GRADE "
				     +",C.CLASS_TIME , C.CLASS_ROOM , C.TOT_MEM , C.REG_MEM , S.CLASS_TIME "
				     +"from STUDENT ST,SCORE S ,CLASS C , PROFESSOR P "
				     +"where S.STU_CODE=? and S.STU_CODE = ST.STU_CODE AND S.CLASS_CODE= C.CLASS_CODE AND P.PROF_CODE = C.PROF_CODE";
			System.out.println("sql"+sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);	
			
			rs =pstmt.executeQuery(); //���õȷ��ڵ��� ������ ������:����Ʈ������
				
				
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
			System.out.println("StudentModeDAO������û�������� �߻�.......");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		return list;

	}
	
	

}
