// E: element
// k: key
// v: value
public class GenericTest<E> {
	
	private E username;
	public GenericTest() {
		
	}
	public GenericTest(E username) {
		this.username = username;
	}
	public E getUsername() {
		return username;
	}
	public void setUsername(E username) {
		this.username = username;
	}
	
}
