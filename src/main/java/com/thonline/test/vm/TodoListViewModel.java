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
	
	//���ε{���޿�
    private TodoListService todoListService = new TodoListServiceImpl();

	//�e���W�һݭn�e�{���x�s�����(view state)
    private ListModelList<Todo> todoListModel;
    
	private String title = "�ڪ��ݿ�M��";
	private String subject; 
	private boolean complete;
	private Todo selectedTodo;
	

	@Init // ��l�� -> ZK �|�b���J zul ���L�{�۰ʲ��ͧA���w�� ViewModel ����A�M��N�I�s�A�е� @Init ����k
    public void init() {
        //�q��ݧ���
        List<Todo> todoList = todoListService.getTodoList();
        //��ĳ�ϥ� ListModelList �i�H�u��ø�s�Ĳv�A�קK�C�������sø�s�Ҧ����
        todoListModel = new ListModelList<Todo>(todoList);
    }
	
	@Command
    public void deleteTodo(@BindingParam("todo") Todo todo) {
		/*
		 * command binding ���i�H���[�@��h�ӰѼơA�ѼƤ����γr�����j�A
		 * �C�@�ӰѼƪ��y�k�O key=EL-expression�A key �O�A�ۭq���W�١A
		 * �����᭱�O EL ��F���A�]���i�H�ǤJ����i�H�� EL �s��������A
		 * �b�o�� each �o�ӫO�d�r�N��C�@�� Listitem ��ܪ� Todo�C
		 */

		 //�R����ݸ��
	     todoListService.deleteTodo(todo);
	     //�R���e���W�����
	     todoListModel.remove(todo);
    }
	
	@Command //@Command �Ψӫŧi����k���R�O (command)
    @NotifyChange("subject") //@NotifyChange �q�� ZK ��s���� property
    public void addTodo() {
        selectedTodo = todoListService.saveTodo(new Todo(subject));
        //��s������ơA�L�ݥ� @NotifyChange �q�� ZK �ڭ̧��ܤF todoListModel�A���ۦ�|�q������ø�s�s�W���@��
        todoListModel.add(selectedTodo);
        //�M�ſ�J�A��K��J�U�@�Өƶ�
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
