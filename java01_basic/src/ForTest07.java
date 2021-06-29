class ForTest07 
{
	public static void main(String[] args) 
	{
		//중첩 for문
		

/*
1	2	3	4	5	
6	7	8	9	10
11	12	13	14	15
16	17	18	19	20	
21	22	23	24	25

*/
		int a=1;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				
				System.out.print(a++ +"\t");
			}
			System.out.println();
		}
		
	
		/*
		1
		12
		123
		1234
		12345
		*/
	
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				
				System.out.print(j);
			}
			System.out.println();
		}
		
		/*
		12345
		1234
		123
		12
		1
		*/
		
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		/*

          *
	     **
	    ***
	   ****
	  *****


*/
		
		for(int i=1; i<=5; i++) {
			for(int s=1; s<=5-i; s++) {// 4,3,2,1,0
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*

		 *****
		  ****
		   ***
		    **
		  	 *

		*/
		
		for(int i=5; i>0;i--) {
			for(int s=1;s<=5-i;s++) {//0,1,2,3,4
				System.out.print(" ");
			}
			for(int j=1; j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
/*
             *
	    	***
	       *****
	      *******
	     *********
        *********** 

*/     		
		for(int i=1;i<=11;i+=2) { //1,3,5,7,9
			for(int s=1;s<=(11-i)/2; s++){//5 4 2
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
	    
		***********
		 *********
		  *******
		   *****
		    ***
		     *
	//개인적으로 해보세요 .....
	*/
		
		for(int i=11; i>=1; i-=2) {//11,9,7,5,3,1
			for(int s=1; s<= (11-i)/2; s++) {//0,1,2,3
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
}


