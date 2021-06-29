class Operator2 
{
	public static void main(String[] args) 
	{
		// 비트 연산자 : &, |, ^(XOR), ~ ->2진수 데이터를 이용한 연산자
		int a = 12;
		int b = 4;
 
		int result = a & b; // 1:true, 0:false  둘중 하나만 false여도 false
		System.out.println("result="+result);  //result=4
		//값을 초기화 할때 사용한다. 데이터가 어떤데이터든. &연산자로 0을 더하면 다 false 인 0이 나오니까

        int result2 = a | b;   // 둘중 하나만 true 여도 true 
		System.out.println("result2="+result2);    // result2=12


		int result3 = a ^ b;  // XOR : 두 값이 다를때 true     
		System.out.println("result3="+result3);    //result3=8

		int result4 = ~a; // -13
		System.out.println("result="+result4);// ~ 부정
		// 음수인 데이터를 환산하는 방법 : 2보수 -> 1의보수 +1
		// 1의 보수는 0은 1로 1은 0으로 바꾸는 것이다.




		// 쉬프트 연산자 : 비트의 이동
		// << : 비트가 왼쪽으로 이동(뒤에가 0으로 채워짐) *기능
		// >>(부호로 채워짐), >>>(0으로 채워짐) : 비트가 오른쪽으로 이동(뒤에 남은건 버림) /기능

		int result5 = a << 2; //왼쪽으로 2bit 이동 오른쪽은 0으로 채움  48  12*4
		System.out.println("result5="+result5);

		int result6 = a >> 2; //오른쪽으로 2bit이동 왼쪽 남는 자리는 부호로 채워진다. //12/4 = 3
		int result7 = result4 >> 2; //-4
		System.out.println("resutl6="+result6);
		System.out.println("resutl7="+result7);

		int result8 = result4 >>> 2;
		System.out.println("result8="+result8);

		//과제.........내일 아침에 제출해야함. 카페에 넣어야 함.
		// 답은 메모장에 넣어서 이메일로 보내야 함. 










 

	}
}
