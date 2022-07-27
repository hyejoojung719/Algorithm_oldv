package com.ssafy.exception;

public class QuantityException extends Exception{

	public QuantityException(String isbn, int quantity) {
		System.out.println("수량이 부족합니다");
	}
}
