package etc;

public class MathFunction {
	public static void main(String[] args) {
		System.out.println(Math.round(1.48)); // 정수 형태 반환(반올림)
		System.out.println(Math.ceil(3.14)); // 올림
		System.out.println(Math.floor(3.14)); // 내림
		
		System.out.println(Math.pow(3, 2)); // 3의 제곱(지수승)
		System.out.println(Math.sqrt(9));	// 제곱근
		
		System.out.println(Math.abs(-10));	// 절대값
		
		// 0 <= Math.random() <1
		// 2~8 사이 랜덤 정수 만들고 싶으면 ?  (int)(Math.random()*7 + 2)
		System.out.println((int)(Math.random()*7)+2);
		
		System.out.println(Math.max(10, 5));
		System.out.println(Math.min(5, 15));
	}
}
