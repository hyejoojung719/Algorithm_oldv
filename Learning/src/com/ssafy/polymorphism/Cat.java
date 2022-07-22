package com.ssafy.polymorphism;

public class Cat extends Animal {
	
	String voice;

	public void eat() {
		super.eat();
		
		System.out.println("Cat의 eat()");
	}
	
	public void cat() {
		System.out.println("cat의 cat()");
	}
}
