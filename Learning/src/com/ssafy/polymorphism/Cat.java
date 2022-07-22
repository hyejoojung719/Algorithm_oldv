package com.ssafy.polymorphism;

public class Cat extends Animal {

	public void eat() {
		super.eat();
		
		System.out.println("Cat의 eat");
	}
}
