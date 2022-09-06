package contents;

public class PrimitiveTest {
	public static void main(String[] args) {
		int num1 = 10;
		System.out.println(num1);
		  
		// 8진수로 숫자 만들기
		int num2 = 012;
		System.out.println(num2);
		
		// 16진수
		int num3 = 0xF;
		System.out.println(num3);
		
		long num4 = 22L;
		System.out.println(num4);
		
		double a =  0.15;
		System.out.println(a);
		
		float b = 0.25F;
		System.out.println(b);
	}
}

// 크기 순서
// boolean < byte < short < char <  int < long < float <  double