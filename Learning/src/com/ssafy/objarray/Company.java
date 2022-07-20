package com.ssafy.objarray;

import java.util.Arrays;

public class Company {
	
	final int MAX_SIZE = 100;
	
	Employee[] list = new Employee[MAX_SIZE]; // 사원 정보를 담을 공간
	
	int size; // 사원의 수
	
	// 전체 사원 목록 반환
	// 관리하고 있는 사원 만큼만
	public Employee[] getAllEmployee() {
		return Arrays.copyOf(list, size);
	}
	
	// 사원 번호를 통해 사원 정보 조회
	public Employee getEmployeeByEn(String En) {
		
		for(int i=0; i<size; i++) {
			if(list[i].en.equals(En)) return list[i];
		}
		
		//조건에 만족하지 않을 때(일치하는 사원이 없는 경우)
		return null;
	}
	
	
	// 사원 추가 기능
	public void insert(Employee e /*추가할 사원의 정보 전달*/) {
		/*
		// 빈 공간 탐색 
		for(int i=0; i < MAX_SIZE; i++) {
			if(list[i]==null) {
				list[i] = e;
				break;
			}
		}*/
	
		// 사원의 수 관리
		list[size++] = e;
	}

	// 사원 삭제 기능
	public void delete(String en) { // 사번을 기반으로 삭제하기 위해 사번 넘김
		 /*
		// 1. 일치한 사원 탐색해서 삭제
		int deleteNum = -1;
		for(int i=0; i<MAX_SIZE; i++) {
			// 찾은 경우 null 참조하도록 
			if(list[i].en.equals(en)) {
				list[i] = null;
				deleteNum = i;
				break;
			}
		}
		
		// 2. 맨 뒤에서 탐색하며 마지막 사원의 인덱스 찾기
		for(int i = MAX_SIZE-1; i>deleteNum; i--) {
			if(list[i] != null) {
				list[deleteNum] = list[i];
				list[i] = null;
			}
		}*/
		
		int deleteNum = -1;
		for(int i=0; i<size; i++) {
			// 찾은 경우 null 참조하도록 
			if(list[i].en.equals(en)) {
				// 기존 값 삭제하며 맨 뒤에 마지막 사원 정보 참조하도록
				list[i] = list[size-1];
				list[size-1] = null; // 마지막 사원 참조 없애기
				size--; // 사원수 -1
				break;
			}
		}
		
	}
	
	
	// 사원 수정 기능
	public void update(Employee e) {
		
		for(int i=0; i<size; i++) {
			if(list[i].en.equals(e.en)) {
				
				// 1. 객체의 값만 수정 할 때
				//list[i].name = e.name;
				//list[i].level = e.level;
				
				// 2. 객체 참조 변경
				list[i] = e;
				
			}
		}
		
	}
	
	
}
