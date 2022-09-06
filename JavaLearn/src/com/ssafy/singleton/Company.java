package com.ssafy.singleton;

public class Company {

	// 1. 객체 생성 막기
	private Company() {}
	
	// 2. 생성자 막았으니 전역 객체 하나 생성
	private static Company instance = new Company();
	
	// 3. 객체 접근 막았으니 해당 객체 접근할 수 있도록 getter 메소드 생성
	public static Company getInstance() {
		return instance;
	}
	
}
