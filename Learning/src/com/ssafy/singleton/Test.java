package com.ssafy.singleton;

public class Test {
	public static void main(String[] args) {
		
		Company c = Company.getInstance();
		Company c2 = Company.getInstance();
	}
}
