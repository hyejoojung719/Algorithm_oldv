package com.ssafy.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {

	// 관리할 사원 목록
	List<Employee> list = new ArrayList<>();

	// 사원 추가 기능(Create)
	public void insert(Employee e ) {
		list.add(e);
	}


	// 사원 조회(Read)
	// 전체 사원 목록 반환
	public Employee[] getAllEmployee() {

		// 빈 employee 배열 만들기
		Employee[] newArr = new Employee[list.size()];

		// 해당 리스트의 요소들을 newArr에 담기
		list.toArray(newArr); 

		return newArr;


	}

	// 사원 번호를 통해 사원 정보 조회
	public Employee getEmployeeByEn(String en) {

		for(Employee e : list) {
			if(e.getEn().equals(en)) {
				return e;
			}
		}

		//조건에 만족하지 않을 때(일치하는 사원이 없는 경우)
		return null;
	}


	// 사원 수정 기능(Update)
	public void update(Employee e) {
		for(int i=0; i<list.size(); i++) {
			//  사번 일치여부 확인
			if(list.get(i).getEn().equals(e.getEn())) list.set(i, e);
		}
	}


	// 사원 삭제 기능(Delete)
	public void deleteByEn(String en) { 
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getEn().equals(en)) {
				list.remove(i);
				return;
			}
		}
	}

}


