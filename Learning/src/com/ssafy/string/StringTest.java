package com.ssafy.string;

import java.util.Arrays;

public class StringTest {
	public static void main(String[] args) {
		
		String str = "hello ssafy";
		
		System.out.println(str.charAt(4));
		
		System.out.println(Arrays.toString(str.toCharArray()));
		
		System.out.println(str.length());
		
		// 정규식 또는 문자열을 기준으로 문자열 쪼갠 값 반환
		String[] result = str.split(" ");
		System.out.println(Arrays.toString(result));
	
		// 원하는 구간의 문자열을 추출하고 싶은 경우
		System.out.println(str.substring(7, 10));
		
		// 대문자로 변경한 값 반환
		System.out.println(str.toUpperCase());
		// 소문자로 변경한 값 반환
		System.out.println(str.toLowerCase());
		
		// 특정 문자로 시작하는 지 여부
		System.out.println(str.startsWith("hel"));
		// 특정 문자로  끝나는 지 여부
		System.out.println(str.endsWith("afy"));
		
		// 문자열의 앞 뒤 공백 제거하는 값 반환
		String str2 = "   abc   hello  ";
		System.out.println(str2.trim());
		
		// 특정 문자열을 포함한 경우 해당 문자열의 시작 인덱스를 알려주는 메소드
		System.out.println(str.indexOf("af"));
		System.out.println(str.indexOf("afs")); // 없는 경우 -1 반환
		
	}
}
