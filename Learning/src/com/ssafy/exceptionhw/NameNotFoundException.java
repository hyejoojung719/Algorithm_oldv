package com.ssafy.exceptionhw;

public class NameNotFoundException extends Exception{
	public NameNotFoundException(String name) {
		super(name + "을 포함하는 상품을 존재하지 않습니다.");
	}
}
