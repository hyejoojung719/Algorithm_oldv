
public class OperatorTest03 {
	public static void main(String[] args) {
		int num = 10;
		
		++num; 	// num 증가 후 다른 연산 수행
		num++;	// 다른 연산 수행 후 num값 증가
		
		
		if(num<10 && num++>5) {
			System.out.println(" ");
		}
	}
}
