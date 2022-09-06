package com.ssafy.package1;

public class A_1 {
	

		// 제한자가 default 상태라 같은 패키지 내에서만 쓸 수 있다.
		// 따라서 public으로 바꿔야 A_2에서도 해당 메소드를 쓸 있다. 
		public static void test2() {
			System.out.println("A_1의 스태틱 메소드 실행");
		}
}
