import java.util.ArrayList;
import java.util.List;

public class SSStudentDAO extends DBConnection{

	public SSStudentDAO() {
		
	}
	
	//�л���ü��ȸ
	public List<SSStudentVO> allRecord(){
		List<SSStudentVO> list = new ArrayList<SSStudentVO>();
		try {
		
			dbConn();

			String sql = "select Stu_Code, Major_Code,stu_pw, stu_name, stu_grade , "
		               + "stu_email, stu_tel, stu_add,stu_state, to_char(stu_date,'YY-MM-DD'),  stu_birth" 
		               + " from student";
		
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SSStudentVO vo = new SSStudentVO();
				vo.setStu_Code(rs.getInt(1));
				vo.setMajor_Code(rs.getInt(2));
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
			System.out.println("�л���ü��ȸ ���� �߻�....");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}

	//�л��˻�
	public List<SSStudentVO> searchRecord(String search,String fieldName) {
		
		List<SSStudentVO> list = new ArrayList<SSStudentVO>();
		try {
			dbConn();
			String sql =  "select Stu_Code, Major_Code, stu_pw, stu_name, stu_grade , "
		               + "stu_email, stu_tel, stu_add, stu_state, to_char(stu_date,'YY-MM-DD'),  stu_birth" 
					+ " from Student where "+fieldName+" like ? ";
			System.out.println("sql"+sql);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,"%"+search+"%"); // %��% //***����****
			rs =pstmt.executeQuery(); //���õȷ��ڵ��� ������ ������:����Ʈ������
			
			
			while(rs.next()) {
				SSStudentVO vo = new SSStudentVO();
				vo.setStu_Code(rs.getInt(1));
				vo.setMajor_Code(rs.getInt(2));
				vo.setStu_pw(rs.getString(3));
				vo.setStu_name(rs.getString(4));
				vo.setStu_grade(rs.getString(5));
				vo.setStu_email(rs.getString(6));
				vo.setStu_tel(rs.getString(7)); //int?
				vo.setStu_add(rs.getString(8));
				vo.setStu_state(rs.getString(9));
				vo.setStu_date(rs.getString(10));
				vo.setStu_birth(rs.getString(11));				
				list.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println("�л��˻����� �߻�.......");
			e.printStackTrace();
		}finally {
			
		}
		return list;
	}
	//�л�����	
	public int updateRecord(SSStudentVO vo) {
		//������ �����ϰ� ������ ��ɹ�
		System.out.println(vo.allprint());
			//������ �̴��� �ȉ������ ������ �����ش� 
			//�������� �����ϸ� �����ϴ¸�ɾ �������ִ� �����Ͱ� �ִ� -> pstmt.executeUpdate()
		int cnt =0;
		try {
			dbConn();
			String sql = "update student set  Major_Code=?,stu_pw=?,stu_name=?,stu_grade=?,stu_email=?,stu_tel=?,stu_add=?,stu_state=?,stu_date = sysdate,stu_BIRTH=? where stu_code=?";

			pstmt = con.prepareStatement(sql);
				
			//pstmt.setInt(1, vo.getStu_Code());
			pstmt.setInt(1, vo.getMajor_Code());
			pstmt.setString(2, vo.getStu_pw());
			pstmt.setString(3, vo.getStu_name());
			pstmt.setString(4,vo.getStu_grade());
			pstmt.setString(5,vo. getStu_email());
			pstmt.setString(6,vo.getStu_tel()); //int
			pstmt.setString(7,vo.getStu_add());
			pstmt.setString(8,vo.getStu_state());
			pstmt.setString(9,vo.getStu_birth());		
			pstmt.setInt(10,vo.getStu_Code());	
	
			
			
			//(LoggableStatement)pstmt
			cnt = pstmt.executeUpdate();
				
		}catch(Exception e) {
			System.out.println("DAO �л����� ���� �߻�...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
			return cnt;
	}
	
	//�л��߰�
	public int insertRecord(SSStudentVO vo){
		//�߰�����Ŀ� �����ͺ��̽����� �߰��Ǿ���ϰ� �������̺�ȸ����Ͽ��� �߰��� ȸ���� ��µǾ���Ѵ�..
		int cnt=0;
		try {
			dbConn(); //��񿬰�
			String sql = "insert into student values(ST_CODE.nextval, ?,?,?,?,?, ?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getMajor_Code());
			pstmt.setString(2, vo.getStu_pw());
			pstmt.setString(3, vo.getStu_name());
			pstmt.setString(4,vo.getStu_grade());
			pstmt.setString(5,vo. getStu_email());
			pstmt.setString(6,vo.getStu_tel()); //int
			pstmt.setString(7,vo.getStu_add());
			pstmt.setString(8,vo.getStu_state());
			//pstmt.setInt(8,vo.getStu_date());
			pstmt.setString(9,vo.getStu_birth());		
		
			cnt= pstmt.executeUpdate(); //��� ���ڵ尡 �߰��Ǿ�����.....
			
		}catch(Exception e) {
			System.out.println("�л��߰����� �߻�...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	//�л�����	
	public int deleteRecord(int Stu_code) { //�����������Ұ��� �Ű������޾Ƽ� ó��-db���� ������ ��������� ���������
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from student where Stu_code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,Stu_code);
				
			cnt = pstmt.executeUpdate();
				
		}catch(Exception e) {
			System.out.println("�л����� ���� �߻�");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;			
	}
		
	
	
	public static void main(String[] args) {
		new SSStudentDAO();
	}

}
