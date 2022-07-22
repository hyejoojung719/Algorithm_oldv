package com.ssafy.package2;

import com.ssafy.package1.B;

public class C extends B{
	
	int a=1;
	int b=1;
	
	public C() {
//		super(); 부모 객체 생성  -> 부모(B) 쪽에 기본 생성자 없으면 에러가 뜬다.
//		따라서 웬만하면 default 생성자를 만드는게 좋다.
	}
	
	public C(int a) {
		this.a = a;
	}
	
	
	void test() {
		this.c();
	}
	
	void test2() {
//		System.out.println(this.a); 1인 나옴
		System.out.println(super.a); // B가 BParent를 상속해도 일단 100이나옴 
		// 즉, 현재 자신으로부터 가장 가까이 있는 변수를 찾는다.
	}
	
	public static void main(String[] args) {
		C c = new C();
		
		c.test();
		c.test2();
	}
}
