import java.util.Arrays;

public class ArraysTest {

	public ArraysTest() {
		// Arrays :배열관련 처리 클래스
		int[]data= {15,90,45,75,26,9,48,95,12,45};
		Arrays.sort(data);
		//Arrays.sort(data, 2 ,5); 
		//일부만 정렬 2~5 앞까지만 정렬//[15, 90, 26, 45, 75, 9, 48, 95, 12, 45]


		
		System.out.println(Arrays.toString(data));
	}

	public static void main(String[] args) {
		new ArraysTest();

	}
}
