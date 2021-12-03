
public class solution {

		
	
	 public static double solution(int[] arr) {
	        double answer = 0;
	        int sum = 0;
    		for(int i = 0; i<arr.length; i++) {
    			sum += arr[i];
    			
	        }
    		answer = (double)sum/arr.length;
    		return answer;
	        
	    }
	
	public static void main(String[] args) {
		int[] arr = {2,4,6,7,8};
		double result = solution(arr);
		System.out.println(result);

	}

}
