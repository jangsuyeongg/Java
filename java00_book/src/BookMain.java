import BookInfor.BookDataSet;
import BookInfor.JoinDataSet;

public class BookMain {

	public BookMain() {
		
	}
	public static void main(String[] args) {
		BookDataSet.basicBookSet();//�������
		JoinDataSet.basicJoinSet();//���̵�,���
		BookManager bm = new BookManager();
		bm.bookStart();
		
	}

}
