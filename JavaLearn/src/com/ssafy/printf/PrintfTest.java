package com.ssafy.printf;

public class PrintfTest {
	public static void main(String[] args) {
		
		String name = "연민호";
		
		System.out.println("저의 이름은 " + name + "입니다. ");
		System.out.printf("저의 이름은 %s입니다.%n", name);
		
		// %d 정수형식, %f 기본적인 실수 형식, %s 문자열 형식, %n 줄바꿈, %b boolean형식, %c char 형식
		System.out.println("=== 정수 출력 ===");
		System.out.printf("%d\n",11);
		System.out.printf("%s%n", Integer.toBinaryString(10));
		
		System.out.println("=== 실수 출력 ===");
		System.out.printf("%f%n", 123.4567);
		System.out.printf("%.3f%n", 123.4567); // 소수점 3번째자리까지 출력(4번째 자리에서 반올림)
		System.out.printf("%s%n", 123.4567);
		
		System.out.printf("%s%n", true);
		System.out.printf("%b%n", true);
		
		System.out.printf("[%6.2s]%n","대전7반");
		System.out.printf("[%-6.2s]%n","대전7반");
		
		
	}
}
