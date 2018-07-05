package com.thonline.test.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class HelloViewModel {

	private String hello = "hello";

	public String getHello() {
		return hello;
	}

	@Command
	@NotifyChange("hello")
	public void helloWorld() {
		hello = "hello world";
	}
	
	@Command("sayHello")
	@NotifyChange("hello")
	public void dohello() {
		hello = "hello~~~~~~~~~";
	}

}
