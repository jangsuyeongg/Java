import java.util.Stack;

public class StackTest {

	public StackTest() {
		Stack<String> stack= new Stack<String>();
		//stack은 먼저입력된 정보가 나중에 출력된다. (FILO:frist in last out)
		//queue: first in first out
		// push(): 입력, pop(): 출fur
		
		stack.push("홍길동");
		stack.push("세종대왕");
		stack.push("이순신");
		stack.push("김정희");
		
		// empty() : stack객체 있으면 false, 객체가 없을때 true
		while(!stack.empty()) {
			String name = stack.pop();
			System.out.println(name);
		}
		
	}

	public static void main(String[] args) {
		new StackTest();

	}

}
