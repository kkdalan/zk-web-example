package com.thonline.test.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thonline.test.model.Todo;
import com.thonline.test.service.TodoListService;

public class TodoListServiceImpl implements TodoListService {

	private List<Todo> todoList = new ArrayList<Todo>();

	public TodoListServiceImpl() {
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
	public Todo getTodo(Integer id) {
		Iterator<Todo> iter = todoList.iterator();
		while (iter.hasNext()) {
			Todo t = iter.next();
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public Todo saveTodo(Todo todo) {
		todo.setId(generateNewId());
		todoList.add(todo);
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
	
	private void printTodoList() {
		System.out.println(" -- Todo List -- ");
		for(Todo todo: todoList) {
			System.out.println(todo);
		}
	}
}
