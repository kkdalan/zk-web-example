package com.thonline.test.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thonline.test.model.Todo;
import com.thonline.test.service.TodoListService;

public class TodoListServiceImpl implements TodoListService {

	private static List<Todo> todoList = null;

	public TodoListServiceImpl() {
		if(todoList == null) {
			prepareData();
		}
	}

	private void prepareData() {
		todoList = new ArrayList<Todo>();
		todoList.add(new Todo(1, "Subject 1"));
		todoList.add(new Todo(2, "Subject 2"));
		todoList.add(new Todo(3, "Subject 3"));
		todoList.add(new Todo(4, "Subject 4"));
		todoList.add(new Todo(5, "Subject 5"));
	}

	@Override
	public List<Todo> getTodoList() {
		printTodoList();
		return todoList;
	}

	@Override
	public List<Todo> getTodoListBySubject(String keywords) {
		if(keywords == null) {
			keywords = "";
		}
		List<Todo> findTodoList = new ArrayList<Todo>();
		Iterator<Todo> iter = todoList.iterator();
		while (iter.hasNext()) {
			Todo t = iter.next();
			if (t.getSubject().startsWith(keywords)) {
				findTodoList.add(t);
			}
		}
		System.out.println("Todo list count: " + findTodoList.size());
		return findTodoList;
	}
	
	@Override
	public Todo getTodo(Integer id) {
		Iterator<Todo> iter = todoList.iterator();
		while (iter.hasNext()) {
			Todo t = iter.next();
			if (t.getId().equals(id)) {
				printTodoList();
				return t;
			}
		}
		printTodoList();
		return null;
	}

	@Override
	public Todo saveTodo(Todo todo) {
		todo.setId(generateNewId());
		todoList.add(todo);
		printTodoList();
		return todo;
	}

	@Override
	public Todo updateTodo(Todo todo) {
		Iterator<Todo> iter = todoList.iterator();
		while (iter.hasNext()) {
			Todo t = iter.next();
			if (t.getId().equals(todo.getId())) {
				t.setId(todo.getId());
				t.setSubject(todo.getSubject());
			}
		}
		printTodoList();
		return todo;
	}

	@Override
	public void deleteTodo(Todo todo) {
		Iterator<Todo> iter = todoList.iterator();
		while (iter.hasNext()) {
			Todo t = iter.next();
			if (t.getId().equals(todo.getId())) {
				iter.remove();
			}
		}
		printTodoList();
	}

	public void printTodoList() {
		System.out.println(" -- Todo List -- ");
		for(Todo todo: todoList) {
			System.out.println(todo);
		}
	}
	
	private Integer generateNewId() {
		int maxId = 0;
		Iterator<Todo> iter = todoList.iterator();
		while (iter.hasNext()) {
			Todo t = iter.next();
			if (t.getId() > maxId) {
				maxId = t.getId();
			}
		}
		return ++maxId;
	}

}
