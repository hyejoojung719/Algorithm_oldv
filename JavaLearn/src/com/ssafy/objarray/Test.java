package com.ssafy.objarray;

public class Test {
	public static void main(String[] args) {
		
		// type[] 변수명 = new type[배열크기];
/*		Employee[] emps = new Employee[10]; // 사원을 담을 수 있는 공간이 만들어짐
		
		Employee emp = new Employee();
		
		// 객체 배열은 마치 2차원 배열과 비슷하다 (배열안에서 또 참조하고 있는 형태이기 때문에)
		
		emps[0] = new Employee("1", "김수미", "사장");
		System.out.println(emps[0].toString());
		
		System.out.println(emps[1].en);*/
		
		Company comp = new Company();
		
		// 사원 추가
		comp.insert(new Employee("1", "하이머", "회장")); // 바로 new 키워드를 사용해서 넣을 수 있다.
		comp.insert(new Employee("2", "하이머2", "사장"));
		comp.insert(new Employee("3", "하이머3", "부장"));
		comp.insert(new Employee("4", "하이머4", "이사"));
		comp.insert(new Employee("5", "하이머5", "대리"));
		
//		System.out.println(comp.list[0].toString());
		
		comp.delete("1");
		System.out.println(comp.list[0]);
		
		comp.update(new Employee("2", "머니","사장"));
		System.out.println(comp.list[1]);
		
		Employee[] emps = comp.getAllEmployee();
		for(Employee emp : emps) {
			System.out.println(emp);
		}
		
		Employee emp = comp.getEmployeeByEn("3");
		System.out.println(emp);
	}
}
