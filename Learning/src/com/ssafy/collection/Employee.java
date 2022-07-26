package com.ssafy.collection;

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

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Employee [en=" + en + ", name=" + name + ", level=" + level + "]";
	}
	
	
}
