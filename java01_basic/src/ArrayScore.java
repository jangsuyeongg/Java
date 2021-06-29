import java.util.Scanner;
public class ArrayScore {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		
		System.out.print("학생수=");
		int cnt = Integer.parseInt(scan.nextLine());
		
		//데이터를 저장할 공간 확보
		String name[]= new String[cnt];// 학생이름을 저장할 배열
		int jumsu[][]= new int [cnt+2][6];//학생 점수를 저장할 배열
		
		//이름과 점수를 입력받아 배열에 저장/ 이름따로 점수따로해서 합침
		String title[]= {"국어","영어","수학"};
		for(int i=0;i<cnt;i++) {// 행
			System.out.print("이름=");// 이름:i 첫번째 할일. 아이가 돌때 처음에 이름을 입력
			name[i]	= scan.nextLine();
			for(int j=0;j<title.length; j++) {//과목: j 과목명 에 추가하라. // 열
				System.out.print(title[j]+"=");
				jumsu[i][j]= Integer.parseInt(scan.nextLine());
		
			}
		}
			//개인별 총점. 평균 
			//과목별 총점 
			for(int i=0; i<cnt; i++) {//0,1,2
				for(int j=0; j<3; j++) {//0,1,2 
				jumsu[i][3]+= jumsu[i][j]; //개인별 총점
				jumsu[cnt][j]+= jumsu[i][j];//과뫅별 총점
				}
				//개인별 평균
				jumsu[i][4] = jumsu[i][3]/3;
			}
			//과목별 평균
			for(int i=0;i<3;i++) {
				jumsu[cnt+1][i] = jumsu[cnt][i]/cnt;					
			}
			//석차구하기
			for(int i=0; i<cnt; i++) {//0,1,2,3
				//i가 본인점수위치 
				for(int j=0; j<cnt; j++) {
					//   내점수         상대방점수
					if(jumsu[i][3] < jumsu[j][3]) {
						jumsu[i][5]++;
					}	
				}
				jumsu[i][5]++;
			}
			
			//석차순으로 정렬하기 오름차순
			for(int i=0; i<cnt-1;i++) {//3-> 0,1
				for(int j=0;j<cnt-1-i;j++) {// 0,1 // i= 초기 0
					if(jumsu[j][5] > jumsu[j+1][5]) {
						//교환
						//이름바꾸기
						String nameTemp = name[j];
						name[j] = name[j+1];
						name[j+1]= nameTemp;
						
						for(int k=0;k<jumsu[j].length; k++) {//0 1 2 3 4 5
							int temp = jumsu[j][k]; //국어 첫번째 점수를 k로 넣고
							jumsu[j][k] = jumsu[j+1][k];// 그 빈칸에 다음점수를 넣고
							jumsu[j+1][k] = temp;
						}
					}
					
				}
			}
				

		System.out.println("===================================================");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t석차");
		System.out.println("===================================================");
		
		for(int i=0; i<cnt;i++) {//i=이름
			System.out.print(name[i]+"\t");
			//점수출력 국어, 영어, 수학, 총점, 평균
			for(int j=0; j<jumsu[i].length;j++) {
				System.out.print(jumsu[i][j]+"\t");
			}
			System.out.println();
		}
		
		// 과목별 총점
		System.out.print("총점\t");
		for(int i=0; i<3;i++) {//0,1,2 는 학생수 위치에 있는 이름
			System.out.print(jumsu[cnt][i]+"\t");
		}
		System.out.println();
		
		// 과목별 평균
		System.out.print("평균\t");
		for(int i=0; i<3; i++) {
			System.out.print(jumsu[cnt+1][i]+"\t");
		}
		System.out.println();
		
	
	}
}









/*
학생수를 입력받아 이름과, 세과목의 점수를 입력받은 후 
각 학생의 총점,평균,석차, 과목별 총점, 평균을 구 하여
석차순으로 출력하라.

엄청어려움 주의
실행
학생수=3
이름=홍길동
국어=90
영어=89
수학=90
이름=이순신
국어=42
영어=50
수학=60
:
:
====================================================
이름		국어		영어		수학		총점		평균		석차
====================================================
홍길동	90		89		90		269				1
이순신	90		90		43						2
*/