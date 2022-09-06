package com.ssafy.collection;

public class Test {
	public static void main(String[] args) {
		
		Company comp = new Company();
		
		// 사원 추가
		comp.insert(new Employee("1", "하이머", "회장")); 
		comp.insert(new Employee("2", "하이머2", "사장"));
		comp.insert(new Employee("3", "하이머3", "부장"));
		comp.insert(new Employee("4", "하이머4", "이사"));
		comp.insert(new Employee("5", "하이머5", "대리"));
		
		comp.deleteByEn("1");
		System.out.println(comp.getEmployeeByEn("1"));
		
		comp.update(new Employee("2", "머니","사장"));
		System.out.println(comp.getEmployeeByEn("1"));
		
		Employee[] emps = comp.getAllEmployee();
		for(Employee emp : emps) {
			System.out.println(emp);
		}
		
		Employee emp = comp.getEmployeeByEn("3");
		System.out.println(emp);
	}
}
