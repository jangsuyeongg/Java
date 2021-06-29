
public class PrivateParent {
	//private 접근제한자는 다른 클래스에 객체를 통하여 접근할 수 없다. 
	private int num= 200;//캡슐화
	//생성자 메소드에 private접근제한자는 객체를 생성할 수 없다.
	//private PrivateParent() {
		
	//}
	PrivateParent(){
		
	}
	//객체를 통해서 접근불가
	// 상속안함.
	private void getData() {
		System.out.println("번호="+num);
	}
}
