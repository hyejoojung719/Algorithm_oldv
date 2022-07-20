package com.ssafy.objarray;

public class Employee {
	
	String en;		//사번
	String name; 	//이름 
	String level;	//직급
	
	// 기본 생성자
	public Employee() {}
	
	// 생성자
	public Employee(String en, String name, String level) {
		this.en = en;
		this.name = name;
		this.level = level;
	}
	
	public String toString() {
		return "사번 : " + en+", 이름 : " + name + ", 직급 : " + level;
	}
}
