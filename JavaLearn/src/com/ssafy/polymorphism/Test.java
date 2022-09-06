package com.ssafy.polymorphism;

public class Test {
	
	{
		System.out.println("{} 블록 실행"); // 2번 실행
		// 얘는 객체가 생성될 때 마다 실행
	}
	
	static {
		System.out.println("static {} 블록 실행"); // 한번만 실행
		// 즉 static 키워드는 클래스 로딩 될 때 딱 한번만 실행됨
	}
	
	
	public static void main(String[] args) {
		
		Test t = new Test();
		Test t2 = new Test();
		
//		Dog dog = new Dog(); -> Animal, Dog 객체 모두 볼 수 있음
//		dog.eat();
//		
//		Cat  cat = new Cat();
//		cat.eat();
		
		Animal dog = new Dog(); // -> Animal 까지 볼 수 있음(상위 타입이기 때문에),  그러나 내부에 있는 객체는 Dog()이기 때문에 Dog를 볼 수 없지만 다형성에 의해  
		dog.eat(); 				// Dog안에 있는 eat을 실행하게 한 것이다.
		// Dog dog = (Dog)dog 를 하면 된다.
		// instane of 연산자를 이용한다.
		// 단, 조상을 무조건 자손으로 바꿀 수 없으므로
		
		
		Animal cat = new Cat();
		
		cat.eat();
		if(cat instanceof Cat) {
			Cat cat2 = (Cat) cat;
		}
	}
}
