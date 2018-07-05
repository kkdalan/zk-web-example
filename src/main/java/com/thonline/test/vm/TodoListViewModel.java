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
	
	//應用程式邏輯
    private TodoListService todoListService = new TodoListServiceImpl();

	//畫面上所需要呈現或儲存的資料(view state)
    private ListModelList<Todo> todoListModel;
    
	private String title = "我的待辦清單";
	private String subject; 
	private boolean complete;
	private Todo selectedTodo;
	

	@Init // 初始化 -> ZK 會在載入 zul 的過程自動產生你指定的 ViewModel 物件，然後就呼叫你標註 @Init 的方法
    public void init() {
        //從後端抓資料
        List<Todo> todoList = todoListService.getTodoList();
        //建議使用 ListModelList 可以優化繪製效率，避免每次都重新繪製所有資料
        todoListModel = new ListModelList<Todo>(todoList);
    }
	
	@Command
    public void deleteTodo(@BindingParam("todo") Todo todo) {
		/*
		 * command binding 中可以附加一到多個參數，參數之間用逗號分隔，
		 * 每一個參數的語法是 key=EL-expression， key 是你自訂的名稱，
		 * 等號後面是 EL 表達式，因此可以傳入任何可以用 EL 存取的物件，
		 * 在這裡 each 這個保留字代表每一個 Listitem 顯示的 Todo。
		 */

		 //刪除後端資料
	     todoListService.deleteTodo(todo);
	     //刪除畫面上的資料
	     todoListModel.remove(todo);
    }
	
	@Command //@Command 用來宣告此方法為命令 (command)
    @NotifyChange("subject") //@NotifyChange 通知 ZK 更新哪些 property
    public void addTodo() {
        selectedTodo = todoListService.saveTodo(new Todo(subject));
        //更新頁面資料，無需用 @NotifyChange 通知 ZK 我們改變了 todoListModel，它自行會通知元件繪製新增的一筆
        todoListModel.add(selectedTodo);
        //清空輸入，方便輸入下一個事項
        subject = "";
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

}
