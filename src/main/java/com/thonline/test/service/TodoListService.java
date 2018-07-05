package com.thonline.test.service;

import java.util.List;

import com.thonline.test.model.Todo;

public interface TodoListService {

	public List<Todo> getTodoList();

	public Todo getTodo(Integer id);

	public Todo saveTodo(Todo todo);

	public Todo updateTodo(Todo todo);

	public void deleteTodo(Todo todo);
}
