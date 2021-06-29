import BookInfor.BookDataSet;
import BookInfor.JoinDataSet;

public class BookMain {

	public BookMain() {
		
	}
	public static void main(String[] args) {
		BookDataSet.basicBookSet();//도서목록
		JoinDataSet.basicJoinSet();//아이디,비번
		BookManager bm = new BookManager();
		bm.bookStart();
		
	}

}
