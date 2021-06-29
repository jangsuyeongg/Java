class Operator1 
{
	public static void main(String[] args) 
	{
		//연산자 : 산술연산자, 관계(비교)연산자, 논리연산자, 단항연산자, 대입연산자, 쉬프트연산자, 삼항연산자
		//1. 산술연산자 : +,-,*,/(몫,실수) ,%(나머지)

		int num1 = 10;
		int num2 = 3;

		int result = num1 % num2;
		System.out.println("result = " + result);


//하드 - 램으로 옮겨서 실행하는데, 램에 stack이라는 공간을 만든다.
// 정보를 기록을 하는데, 값을 넣는곳과 빼는곳이 한군데 이다. 같은방향으로 ..
// 정보를 넣으면 맨아래로 오기때문에 나중에 넣은거먼저 지울 수 있다. 
// 지역번수 메모리라고 할 수 있다.

// 2. 단항연산자 : ++(1증가), --(1감소)
        int a = 10;
		a = a + 1;
      // 왼쪽과 오른쪽의 변수가 같아야 한다. a,a
	  System.out.println("a ="+ a);
      //a++ 1증가하는 수식
	  a++;
	  System.out.println("a = " + a);
      //--a; 1감소하는 수식   a = a-1;
	  --a;    
	  System.out.println("a = " + a);

	  int b = a++; //12가 아니라 b는 11이고 a가 12가 된다. 
	  System.out.println("b="+b+", a ="+a);
	   int c = ++a; //c는 13이 되고, a도 13이 된다. 
	  System.out.println("c="+c+", a ="+a);

	  int result2 = b + c++; //11+13  c->14 ++가 가장 우선순위이기 때문.
	  System.out.println("result="+result2+",c="+c); // 24,14

// 3. 대입연산자
//a=13
//b=11
//c=14

       a += 4;  // a = a+4;  a += 1;  a=a+1;    17
	   b -= 3;  // b = b-3;       8
	   c *= 2;  // c = c*2;       28
	   System.out.println("a="+ a+"b ="+b+" c="+c);

	   c += a + b;  // c  = c + a + b;
	   System.out.println("c=" +c);



//비교연산자: >, >=, <, <=, ==, !=

	   int x = 200;
	   int y = 300;
	   boolean boo = x > y; // false
	   boolean boo2 = x <y; //true
	   System.out.println("boo="+boo);
	   System.out.println("boo2="+boo2);



//삼항연산자 
// 급여가 만원 이상이면 보너스를 50%를 준다.
// 급여가 만원 미만이면 보너스를 90%를 준다.

      int sal = 9000; //급여
	  //   결과 = (조건식)? 참일때 : 거짓일때         
			   
  double bonus = (sal >=10000)? sal*0.5 : sal*0.9;
  System.out.println("sal=" +sal+", bonus="+bonus);


//논리연산자 : &&(and), ||(or), !(not)

int ave = 75;
   String grade = (ave>=70  &&  ave<80)? "c" : "그외" ;
   System.out.println("grade="+grade);

   char ch = 'A'; //char연산이 가능하다.
   //ch++;  ch+1;
   ch = (char)(ch + 1);   
   // 에러나는 이유 . char = 2byte(65000) < int 4byte(플마 21억) 
   // 인트가 더커서 인트형을 캐릭터형에 넣으면 오류가 난다. 
   // 형변환으로 가능하다. 
   System.out.println("ch"+ch);

   char ch2 = (char)85;
   System.out.println("Ch2=" + ch2);  //Ch2=U
   // 왜 Ch2=U 가 나오냐면 구글에 아스키코드를 검색하면  85 는 u이다.
   // A = 65 a = 97, 





	  









	 





	}
}
