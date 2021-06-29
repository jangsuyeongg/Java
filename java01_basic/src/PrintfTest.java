class PrintfTest 
{
	public static void main(String[] args) 
	{
		// format : 포맷 형식
		// 정수: %10d, 실수: %10.3f, 문자열: %8s, %o(Octal:8진수), 
		// %x(Hex:16진수), %c(Char)
		// 제어문자 : \n, \t, \\, \", \'

		int num = 1234;
		System.out.printf("num변수의 값은 %d입니다.\n", num);
		System.out.printf("일정한 \"간격\"  \t띄울\\때...\n");

		double num2 = 2548.2351;
			System.out.printf("num2=%10.3f이다.\n", num2);

		String namekor = "홍길동";
		String nameEng = "hong";
		System.out.printf("이름은 %-10s이다.\n", namekor); // - 왼쪽배치
		System.out.printf("이름은 %10s이다.\n", nameEng); // 오른쪽배치 

		int num3= 12;
		System.out.printf("%d, %o, %x\n", num3, num3, num3);


	}
}
