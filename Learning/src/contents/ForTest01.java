package contents;

public class ForTest01 {
	public static void main(String[] args) {
		// 1~100 까지의 숫자 중 4의 배수의 총합 구하기
		
		int sum = 0;
		
		// for(1. 초기화; 2. 조건식; 4. 증감){
		//	3. 구문
		//}
		for(int i=1; i<=100; i++) {
			if(i%4 == 0) sum += i;
		}
		System.out.println(sum);
		
		/*  속도가 더 빠른 방법
		 for(int i=4; i<=100; i+=4){
		 	sum+=i; 
		 }
		  */
	}
}
