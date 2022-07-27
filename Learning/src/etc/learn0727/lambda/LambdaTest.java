package etc.learn0727.lambda;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 익명 구현 객체
		/*
		SimpleInterface s = new SimpleInterface() {
			@Override 
			public void simple() {
				// TODO Auto-generated method stub
				System.out.println("simple() 실행");
			}
		};
		
		s.simple();*/
		
		//()안은 매개변수
//		SimpleInterface s1 = () -> {
//			System.out.println("simple() 실행");
//		};
		/*
		SimpleInterface s1 = () -> System.out.println("simple() 실행");
		
		s1.simple();*/
		
		//  위 아래 두 개는 똑같은 결과가 나온다..
		
		
		// 변수명은 아무거나
//		SimpleInterface s = (String m)->{
//			// 타입도 생략이 가능하다 (지금은 뭐가 들어올지 명확하기 때문에)
//		};
		/*
		SimpleInterface s = m ->System.out.println(m);
		
		s.simple("안녕");*/
		
		// 아래 함수를 가진 객체를 생성한것
		/*SimpleInterface s = m -> {
			return m+" world";
		};*/
		// 아래와 같이 수정 가능
		SimpleInterface s = m -> m+" world";
		
		System.out.println(s.simple("hello"));
		
	}

}
