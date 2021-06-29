import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import EmpInfor.EmpDataSet;
import EmpInfor.EmpVO;


public class EmpManager {
	Scanner scan = new Scanner(System.in);
	
	String menuTitle = "메뉴[1.사원전체목록, 2.사원추가, 3.사원수정, 4.사원삭제, 5.종료]";

	public EmpManager() {
	}
	public void employeeStart() {
		boolean logResult=false;
		do {
			//로그인
			String userid = inData("아이디");
			String userpwd = inData("비밀번호");
			Login log = new Login();
			logResult = log.loginCheck(userid,userpwd);
		}while(!logResult);
		
		//로그인 성공하면 오는 곳
		//사원의 기본정보 생성
		EmpDataSet.basicEmpSet();// 패키지가 달라서 임폴트 해줘야 함???
		
		allEmpList();
		EmpProcessStart();
	}
	public void EmpProcessStart() {
		do {
			//메뉴입력
			String menu = inData(menuTitle);
			if(menu.equals("1")) {//전체사원목록
				allEmpList();
			}else if(menu.equals("2")) { //사원추가
				empInsert();
				allEmpList();
				
			}else if(menu.equals("3")) {// 사원수정
				empUpdate();
				allEmpList();
			}else if(menu.equals("4")) {//사원삭제 
				empDelete();
				allEmpList();
			}else if(menu.equals("5")) {//종료
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴를 잘못선택하였습니다. 다시 입력하세용용");
			}
		}while(true);
	}
	//사원삭제
	public void empDelete() {
		String delName = inData("삭제할 사원명");
		EmpDataSet.empList.remove(delName);
	}
	//사원수정
	public void empUpdate() {
		//변경할 정보를 확인
		String editName = inData("수정할 사원명입력");
		
		String editMenu= inData("수정할 필드선택[1.연락처, 2.급여]");
		if(editMenu.equals("1")) {
			telUpdate(editName);
		}else if(editMenu.equals("2")){
			salUpdate(editName);
		}else {
			System.out.println("메뉴를 잘못입력하셨습니다.");
		}
	}
	//연락처수정
	public void telUpdate(String username) {
		String tel = inData("수정할 연락처입력");
		EmpVO vo = EmpDataSet.empList.get(username);
		vo.setTel(tel);
	}
	//급여수정
	public void salUpdate(String username) {
		int sal = Integer.parseInt(inData("수정할 급여 입력"));
		EmpVO vo = EmpDataSet.empList.get(username);
		vo.setSal(sal);
	}

	
	//사원추가
	public void empInsert() {
		//1명 사원정보를 저장할 VO객체 생성하기 
		EmpVO vo = new EmpVO();
		
		vo.setEmpNo(inData("사원번호"));
		vo.setEmpName(inData("사원명"));
		vo.setTel(inData("연락처"));
		
		do {
			boolean flag = true;
			try {
				vo.setSal(Integer.parseInt(inData("급여")));
			}catch(NumberFormatException nfe) {
				flag = false;
				System.out.println("급여는 숫자로 입력하세요...");
			}
			if(flag) break;
		}while(true);
		
		vo.setHiredate(inData("입사일"));
		
		EmpDataSet.empList.put(vo.getEmpName(), vo);
	}
	
	// 사원전체목록 출력하기 
	public void allEmpList() {
		//제목출력
		EmpVO.titlePrint();
		Collection<EmpVO> list = EmpDataSet.empList.values();
		Iterator<EmpVO> ii = list.iterator();
		while(ii.hasNext()) {
			EmpVO vo = ii. next();
			vo.empPrint();
		}
	}
	//콘솔에서 문자열입력 받는 메소드
	public String inData(String msg) {
		System.out.print(msg+"->");
		return scan.nextLine();
	}
}
