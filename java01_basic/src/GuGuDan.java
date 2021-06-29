
public class GuGuDan {

	public static void main(String[] args) {
		System.out.println("\t구구단");
		for(int dan=1; dan<=9; dan+=3) {//1,4,7
			for(int i=dan;i<=dan+2; i++) {
				System.out.print("=="+i+"단==\t");
			}
			System.out.println();
	
		for(int k=2; k<=9; k++) {//23456789
			for(int z=dan; z<=dan+2; z++){
				int result = z*k;
				System.out.print(z+"*"+k+"="+result+"\t");
			}
			System.out.println();
		}
	}

}
}