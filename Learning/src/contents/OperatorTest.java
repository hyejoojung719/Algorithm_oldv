package contents;

public class OperatorTest {
	public static void main(String[] args) {
		int num = 10;
		
		//++num; 	// num 증가 후 다른 연산 수행
		//num++;	// 다른 연산 수행 후 num값 증가 
		
		if(num-- <10 /*--num < 10*/) {
			System.out.println(" 조건은 true");
		}
		System.out.println(num);
		
		/*
		// &이랑 &&차이
		// & : 논리 연산자이자 비트 연산자. 양쪽을 평가합니다.(즉 왼쪽이 false라도 뒤에 연산 수행, 단 둘다 true여야 true)
		// && : 왼쪽부터 판단(왼쪽이 false면 &&뒤에는 실행x)
		if(num < 10 && num++ > 5) {
			System.out.println(" 조건은 true ");
		}
		System.out.println(num);
		*/
		
		if(true || num++>10) {
			// 왼쪽이 true면 뒤에는 생각x(or연산)
		}
		
		//삼항 연산자
		int a = 10;
		String b;
		
		/*
		if(a%2==0) b="짝수";
		else b="홀수";
		*/
		
		// 다른 표현 방법
		// 대입받을 변수 = 조건식  ? 참일 때 대입할 값 : 거짓일 때 대입할 값
		b = a%2==0?"짝수":"홀수";
		System.out.println(b); 
		
		
		char c = 'A';
		//System.out.println(c+1);	//66
		System.out.println(++c);	//B //연산보다 비트를 직접 바꾸는게 빠르다
		
	}
}
