package contents;

public class WhileTest {
	public static void main(String[] args) {
		// 0~100까지의 숫자 중 5의 배수의 합 구하기

		int i=5;
		int sum=0;
		while(i<=100) {
			sum+=i;
			i+=5;
		}
		
		System.out.println(sum);
		
		//break이용한 다른 방법도 있당....
	}
}
