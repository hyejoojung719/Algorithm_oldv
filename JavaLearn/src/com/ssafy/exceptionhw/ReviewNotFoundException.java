package com.ssafy.exceptionhw;

public class ReviewNotFoundException extends Exception {
	public ReviewNotFoundException(String pCode) {
		super(pCode + "상품의 리뷰는 존재하지 않습니다.");
	}
}
