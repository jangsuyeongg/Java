
public class StringTest {

	public StringTest() {
		
	}
	public void start() {
		//				0 1234 56 78 90
		String str1 = "서울시 마포구 신수동";
		String str2 = "서울시 마포구 신수동";
		String str3 = new String("서울시 마포구 신수동");
		String data= str3;
		
		byte[] byteData = {65,66,67,68}; //아스키코드값 ->abcd
		String str4 = new String(byteData);//"ABCD"
		
		char[] charData = {'X','Y','Z'};
		String str5 = new String(charData);
		
		int[] intData = {65,66,67,68,69,70};
		
		
		String str6 = new String(intData,2,3); //index 2번쨰부터 3개 문자로 생성해라
		System.out.println("byteData"+ str4);
		System.out.println("charData="+str5);
		System.out.println("intData="+str6);
		System.out.println();
		
		if(str1==str2) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		if(str1==str3) {
			System.out.println("같다~~~");
		}else {
			System.out.println("다르다~~~");
		}
		if(str1.equals(str3)) {//객체와 객체가 같은지를 구한다.    str3.equals(str1)
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		if(str3==data) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		str3="서울시 종로구";
		System.out.println(str3);
		System.out.println(data);
		
		char c =str1.charAt(2); // index위치의 문자 1개를 얻어온다.
		System.out.println("str1.charAt(2)->"+c);
		
		 String result = str1 + str2;
		 String result2 = str1.concat(str2);
		 System.out.println("result="+ result);
		 System.out.println("result2="+ result2);
		 			// 01234567890123456789
		String data2= "Java String Test....";
		String data3= "java string test....";
		
		if(data2.equals(data3)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		if(data2.equalsIgnoreCase(data3)) {//대소문자 구분없이 같은지 비교
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		byte[] byteCode= data2.getBytes();// 문자열을 byte 배열로 구한다. 
		for(byte b : byteCode) {
			System.out.println((char)b+"-->"+b);
		}
			
		int idx = data2.indexOf("t");//특정문자의 index위치를 구한다.
		System.out.println("indexOf->"+ idx);
		
		int idx2 = data2.indexOf("t", 10);
		System.out.println("indexOf->"+ idx2);
		
		int idx3 = data2.lastIndexOf("t");//특정문자를 뒤에서 검색하여 index를 구한다.
		System.out.println("lastIndexOf->"+ idx3);
		
		System.out.println("length="+ data2.length());
		
		//	String data2= "Java String Test....";
		//특정문자를 다른문자로 변경한다.
		data2 = data2.replaceAll("a","에이");
		System.out.println("replaceAll"+data2);
		
		String data4 = "010-1234-5678";
		String[] tel = data4.split("-"); //특정문자로 문자열을 조각낸다.
		for(int i=0; i<tel.length; i++) {
			System.out.println("tel["+i+"]="+tel[i]);
		}
		
		//substring : 특정문자열에서 일부문자열을 얻어온다.
		String tel1 = data4.substring(4);//1234-5678
		String tel2 = data4.substring(4, 8);//1234
		System.out.println(tel1+", "+tel2);
		
		//toCharArray(): 문자열을 char배열로 구해준다. 
		char[] charData2 = data2.toCharArray();
		for(char cc:charData2) {
			System.out.println(cc);
		}
		
		//toLowerCase : 소문자로, toUpperCase: 대문자로
		String toLower = data2.toLowerCase();
		String toUpper = data2.toUpperCase();
		System.out.println(toLower+", "+toUpper);
		
		
		String data6 = "	Sprint	FrameWork	"; //양쪽 공백문자 제거
		String dataTrim = data6.trim();
		System.out.println("AA"+dataTrim+"BB");
		
		int num=1234;
		String s1 = num+"";//문자화
		String s2 = String.valueOf(num);
		System.out.println(s1+1234);
		System.out.println(s2+5678);
		
		char[] aa= {'S', 'T','U'};
		String sss = new String(aa);
		String sss2 = String.valueOf(aa);
		
		System.out.println(sss);
		System.out.println(sss2);
		
		String data7="Apple";
		String data8="apple";
		int r1 = data7.compareToIgnoreCase(data8);//-32 양수는 왼쪽객체가 크고, 음수는 오른쪽 객체가 크다
		int r2 = data8.compareTo(data7);//32
		System.out.println(r1 +", "+r2);
	}
	

	public static void main(String[] args) {
		new StringTest().start();

	}

}
