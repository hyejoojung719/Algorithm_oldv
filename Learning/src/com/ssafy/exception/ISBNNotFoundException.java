package com.ssafy.exception;

public class ISBNNotFoundException extends Exception{
	// 해당 <고유번호>의 책은 존재하지 않습니다 메시지 띄우기
	public ISBNNotFoundException(String isbn) {
		System.out.println("해당 <"+isbn+">의 책은 존재하지 않습니다. ");
	}
}
