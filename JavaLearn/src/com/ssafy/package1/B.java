package com.ssafy.package1;

public class B extends BParent{
	
//	protected int a = 100;
	protected int b = 100;
	
	public B(int a )
	{	
		this.a = a;
	}
	protected B() {} //-> 상속받은 클래스에서만 B 객체 생성 가능
	// 그러나 C클래스에서 B b = new B();하면 실행X
	// super() 사용
	
	protected void c() {
		System.out.println("B클래스의 C메소드 실행");
	}
}
