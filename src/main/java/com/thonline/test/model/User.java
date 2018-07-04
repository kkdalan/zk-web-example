package com.thonline.test.model;

public class User {

	private String name;
	private String title;
	private int age;

	public User(String name, String title, int age) {
		this.name = name;
		this.title = title;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		System.out.println("(before) user.name = " + this.name);
		this.name = name;
		System.out.println("(after) user.name = " + this.name);
	}

	public void setTitle(String title) {
		System.out.println("(before) user.title = " + this.title);
		this.title = title;
		System.out.println("(after) user.title = " + this.title);
	}

	public void setAge(int age) {
		System.out.println("(before) user.age = " + this.age);
		this.age = age;
		System.out.println("(after) user.age = " + this.age);
	}

}
