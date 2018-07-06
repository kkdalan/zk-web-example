package com.thonline.test.vm;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

import com.thonline.test.model.Todo;
import com.thonline.test.service.TodoListService;
import com.thonline.test.service.impl.TodoListServiceImpl;

public class TodoListViewModel {
	
    private TodoListService todoListService = new TodoListServiceImpl();

    private ListModelList<Todo> todoListModel;
    
	private String title = "我的代辦清單";
	private String subject; 
	private boolean complete;
	private Todo selectedTodo;
	private String keywords;
	
	@Init 
    public void init() {
        List<Todo> todoList = todoListService.getTodoList();
        todoListModel = new ListModelList<Todo>(todoList);
    }
	
	@Command  
    @NotifyChange("todoListModel") 
    public void search(@BindingParam("keywords") String keywords) {
        List<Todo> todoList = todoListService.getTodoListBySubject(keywords);
        todoListModel = new ListModelList<Todo>(todoList);
    }
	
	@Command  
    @NotifyChange("subject")  
    public void addTodo() {
        selectedTodo = todoListService.saveTodo(new Todo(subject));
        todoListModel.add(selectedTodo);
        subject = "";
    }
	
	@Command
    public void deleteTodo(@BindingParam("todo") Todo todo) {
	     todoListService.deleteTodo(todo);
	     todoListModel.remove(todo);
    }
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Todo getSelectedTodo() {
		return selectedTodo;
	}

	public void setSelectedTodo(Todo selectedTodo) {
		this.selectedTodo = selectedTodo;
	}

	public ListModelList<Todo> getTodoListModel() {
		return todoListModel;
	}

	public void setTodoListModel(ListModelList<Todo> todoListModel) {
		this.todoListModel = todoListModel;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}
