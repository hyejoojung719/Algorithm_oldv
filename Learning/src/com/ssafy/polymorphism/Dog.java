package com.ssafy.polymorphism;

public class Dog extends Animal{
	
	String walll;

	@Override
	public void eat() {
		super.eat();
		
		System.out.println("Dog의 eat()");
	}
	
	public void dog() {
		System.out.println("Dog의 dog()");
	}
	
}
