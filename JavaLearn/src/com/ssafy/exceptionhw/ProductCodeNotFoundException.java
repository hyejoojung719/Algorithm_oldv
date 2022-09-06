package com.ssafy.exceptionhw;

public class ProductCodeNotFoundException extends Exception{
	/** 존재하지 않는 상품 코드*/
	private String pCode;
	
	public ProductCodeNotFoundException(String pCode) {
		super(pCode+"해당 상품은 존재하지 않습니다.");
		this.pCode = pCode;
	}
}
