
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import BookInfor.BookDataSet;
import BookInfor.BookVO;
import BookInfor.JoinDataSet;
import BookInfor.JoinVO;


public class BookManager {
	Scanner scan = new Scanner(System.in);
	
	public BookManager() {	
		
	}
	
	public void bookStart() {//ó������!!
		do {
			try {
				JoinDataSet.basicJoinSet();
					Scanner scan = new Scanner(System.in);
					System.out.println("==============================[�޴��� �����ϼ���.]=================================");
					System.out.println("[1]ȸ������  [2]����ڷα���  [3]�����ڷα���  [4]�α׾ƿ�  =>>");
					int a = scan.nextInt();
					System.out.println("==================================================================================");
				
					if(a==1) {		
						allJoin();//�α���
						login();
						JoinDataSet.basicJoinSet();
						userStart();
					}else if(a==2) {
						login();
						JoinDataSet.basicJoinSet();
						userStart();//����ڸ�� ����
					}else if(a==3) {
						managerStart();//�����ڸ�� ����
					}else if(a==4){
						logout();//�α׾ƿ�
						
				}
			}catch(Exception e) {
				System.out.println("�߸������̽��ϴ�.");
			}
		}while(true);
			
		}
	
	public void managerStart() {
		boolean logResult=false;
		do {
			//������ �α���!! (id,pw ����) - admin / 1234 
			String userid = inData("���̵�");
			String userpwd = inData("��й�ȣ");
			Login log = new Login();
			logResult = log.loginCheck(userid,userpwd);
		}while(!logResult);

	//	BookDataSet.basicBookSet();//å���
	//	allBookList();//å��� ����ϱ�
		
		System.out.println("==================================================================================");
		System.out.println("�����ڸ��� �α��� �Ǿ����ϴ�.");
		System.out.println("==================================================================================");
		String menuTitle = "�޴�[1.å��� 2.å��� 3.å���� 4.���� 5.ȸ����� 6.���� 7.�α׾ƿ�]";
		do {
			String menu = inData(menuTitle);
			if(menu.equals("1")) {// å���
				allBookList();
			}else if(menu.equals("2")) {//å���
				bookInsert();
				allBookList();
			}else if(menu.equals("3")) { //å����
				bookUpdate();
				allBookList();
			}else if(menu.equals("4")) { //����
				bookDelete();
				allBookList();	
			}else if(menu.equals("5")){ //ȸ�����
				JoinDataSet.basicJoinSet();
				allJoinList();
			}else if(menu.equals("6")) { //����
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				System.exit(0);	
			}else if(menu.equals("7")){
				logout();
			}else {
				System.out.println("�޴��� �߸������Ͽ����ϴ�. �ٽ� �Է��ϼ����");
			}
			
		}while(true);
	}
	// �����߰�
	public void bookInsert() { 
		BookVO vo = new BookVO();
		
		vo.setCode(inData("�����ڵ�"));
		vo.setBookName(inData("å�̸�"));
		vo.setAuthor(inData("����"));
		vo.setCompany(inData("���ǻ�"));
		vo.setRental(inData("���Ի���"));
		vo.setRentaldate(inData("����"));
		
		BookDataSet.bookList.put(vo.getBookName(), vo);
	}
	
	//��������
	public void bookUpdate() { 
		String editName = inData("������ å�̸��Է�");
		
		String editMenu= inData("������ �ʵ弱��[1.���Ի���, 2.����]");
		if(editMenu.equals("1")) {
			rentalUpdate(editName);
		}else if(editMenu.equals("2")){
			rentaldateUpdate(editName);
		}else {
			System.out.println("�޴��� �߸��Է��ϼ̽��ϴ�.");
		}
	}
	
	public void rentalUpdate(String username) {  //���Ի���
		String rental = inData("������ ���Ի��� �Է�(���԰���, ���ԿϷ�)");
		BookVO vo = BookDataSet.bookList.get(username);
		vo.setRental(rental);
	}
	public void rentaldateUpdate(String username) { //�ݾ�
		String rentaldate = inData("������ �ݾ� �Է�");
		BookVO vo = BookDataSet.bookList.get(username);
		vo.setRentaldate(rentaldate);
	}
	
	//��������
	public void bookDelete() {
		String delName = inData("������ å�̸�");
		BookDataSet.bookList.remove(delName);
	}
	
	

	public void bookSearch() {//å�˻�
		
			try {
				String title = inData("å�̸�");
				Set<String> keys = BookDataSet.bookList.keySet();
				Iterator<String> ii = keys.iterator();
				while(ii.hasNext()) {
					String key = ii.next();
		
					if(title.equals(key)) {
						BookVO value = BookDataSet.bookList.get(key);
						
						System.out.printf("%s %10s %10s %10s %10s %12s\n","�����ڵ�","å�̸�","����","���ǻ�","���Ի���","����");
						System.out.println("==================================================================================");
						System.out.print(value.getCode());
						System.out.print("\t    "+value.getBookName());
						System.out.print("\t "+value.getAuthor());
						System.out.print("\t    "+value.getCompany());
						System.out.print("\t  "+value.getRental());
						System.out.print("\t      "+value.getRentaldate()+"\n");        
					}
				}
			}catch(Exception e) {
				System.out.println("�����Դϴٿ�. �ٽ��Է��ϼ���.");
			}
	 }
	
	public void bookSale() {//å����
			try {
			String saleName = inData("������ å�̸�=");
				stateUpdate(saleName);
			}catch(Exception e) {
				System.out.println("���Ͻô� å�� �����ϴ�. �ٽ��Է��ϼ���.");
			}
		}
	
	public void stateUpdate(String bookname) {
		String sale = ("���ԿϷ�");
		BookVO vo = BookDataSet.bookList.get(bookname);
		vo.setRental(sale);
		
	}
	public void logout() {
		System.out.println("�α׾ƿ��մϴ�.");
		bookStart();
		
	}
	//ȸ������
	public void allJoin() {
		JoinVO vo = new JoinVO();
		vo.setId(inData("���̵�"));
		vo.setPassword(inData("��й�ȣ"));
		vo.setName(inData("�̸�"));
		vo.setTel(inData("��ȭ��ȣ"));
		JoinDataSet.joinList.put(vo.getId(), vo);
		System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�. �α����ϼ���.");
		System.out.println("==================================================================================");
	}
	//�α��� 
	public void login() {
		boolean canEscape = false;
		do {
			try {
				System.out.println("���̵�� ��й�ȣ�� �Է��ϼ���.");
				System.out.print("���̵�=");
				String id = scan.nextLine(); // �޾ƿ� ���̵�
				String realId = ""; // ���� ���̵�
				
				Collection<JoinVO> joinCollection = JoinDataSet.joinList.values();
				Iterator<JoinVO> joinIterator = joinCollection.iterator();
				while(joinIterator.hasNext()) {
					JoinVO oneMember = joinIterator.next();
					// ID üũ
					if(oneMember.getId().equals(id)) {
						realId = oneMember.getId();
					}
				}
				JoinVO wanted = JoinDataSet.joinList.get(realId); // ID�� ��ġ�ϴ� VO�� ����
		
				// ID�� ���� VO�� ��� �޾ƿ���
				System.out.print("��й�ȣ=");
				String password = scan.nextLine(); // �޾ƿ� ���
				String realPass = wanted.getPassword(); // ���� ���
				
				
				if(id.equals(realId)) {
					if(password.equals(realPass)) {
						System.out.println("==================================================================================");
						System.out.println("����ڸ��� �α��� �Ǿ����ϴ�.");
						canEscape = true;
					}else {
						System.out.println("������ ��ġ���� �ʽ��ϴ�.");
						//login();
					}
				}else{
					System.out.println("ID�� �������� �ʽ��ϴ�.");
				}
				if(canEscape) break;
			}catch(Exception e) {
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		} while(true);
	}
			
		
	//����ڸ�� 
	public void userStart() {
		System.out.println("==================================================================================");
		String menuTitle = "�޴�[1.å��� 2.å�˻� 3.å���� 4.���� 5.�α׾ƿ�]";
		
	//	BookDataSet.basicBookSet();//å���
	//	allBookList();//å��� ����ϱ�
		
		do {
			String menu = inData(menuTitle);
			if(menu.equals("1")) {
				
				BookDataSet.basicBookSet();
				allBookList();
			}else if(menu.equals("2")) { 
				 bookSearch();
			}else if(menu.equals("3")) {
				
				bookSale();
				allBookList();//å��� ����ϱ�
				
			
			}else if(menu.equals("4")) {
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				System.exit(0);
			}else if(menu.equals("5")) {
				logout();
					
			}else {
				System.out.println("�޴��� �߸������Ͽ����ϴ�. �ٽ� �Է��ϼ����");
			}
			
		}while(true);
	}
	
		//å��� ����ϱ�
	public void allBookList() {
		BookVO.titlePrint();
		Collection<BookVO> list = BookDataSet.bookList.values();
		Iterator<BookVO> ii = list.iterator();
		while(ii.hasNext()) {
			BookVO vo = ii. next();
			vo.bookPrint(vo);
			
		}
	}
	
		//ȸ������ ����ϱ�
	public void allJoinList() {
		JoinVO.jointitle();
		Collection<JoinVO> list = JoinDataSet.joinList.values();
		Iterator<JoinVO> iii = list.iterator();
		while(iii.hasNext()) {
			JoinVO vo = iii. next();
			vo.joinprint();
		}
	}
	public String inData(String msg) {
		System.out.print(msg+"->");
		return scan.nextLine();
	}
}



