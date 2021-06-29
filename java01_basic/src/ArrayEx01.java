import java.util.Scanner;
public class ArrayEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 배열을 이용하는 예제
		//7(국어,영어,수학,과학,물리,한국사,도덕)과목의 점수를 입력받아 총점과 평균을 구하라.

		String[] title = {"국어","영어","수학","과학","물리","한국사","도덕"};
		int jumsu[] = new int[7];//0,0,0,0,0,0,0
		
		//점수입력
		for(int idx=0;idx<title.length;idx++) {//idx=0
			System.out.print(title[idx]+"=");
			jumsu[idx] = scan.nextInt();
		}
		int tot = 0; //총점
		for(int i=0; i<title.length; i++) {
			tot = tot +jumsu[i];
		}
		int ave = tot/ 7;
		System.out.println("총점="+ tot);
		System.out.println("평균="+ ave);
		}
	}