class Exercise3_1 
{
	public static void main(String[] args) 
	{
		int x = 2;
		int y = 5;
		char c = 'A'; // 'A'의 문자코드는 65

		System.out.println(1 + x << 33);
		System.out.println(y >=5 || x < 0 && x >2); // true || false && false  우선순위가 &&가 먼저여서 false 임. 그래서 true or false = true
		System.out.println(y += 10 -x++); //x=3
		System.out.println(x+=2); // 5
		System.out.println(!('A' <= c && c <='Z') ); // true && true 에 ! 을 하면 false
		System.out.println('C'-c);// 
		System.out.println('5'-'o');// 
		System.out.println(c+1);// 65+1
		System.out.println(++c);//b
		System.out.println(c++);//b
		System.out.println(c);//c

	}
}
 