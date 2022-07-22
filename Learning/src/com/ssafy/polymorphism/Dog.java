package com.ssafy.polymorphism;

public class Dog extends Animal{

	public void eat() {
		super.eat();
		
		System.out.println("Dog의 eat");
	}
	
}
