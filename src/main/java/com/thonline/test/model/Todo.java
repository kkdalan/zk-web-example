package com.thonline.test.model;

import java.util.Date;

public class Todo implements Cloneable {

	private Integer id;
	private String subject; // ¥DÃD
	private String description;
	private Integer priority;
	private Date date;
	private boolean complete;

	public Todo(String subject) {
		this.subject = subject;
	}
	
	public Todo(Integer id, String subject) {
		this.id = id;
		this.subject = subject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		System.out.println("(before) Todo.complete = " + this.complete);
		this.complete = complete;
		System.out.println("(after) Todo.complete = " + this.complete);
	}

	@Override
	public String toString() {
		return "Todo [id= "+this.id+" , subject = "+ this.subject +" , complete = "+ this.complete +"]";
	}
}