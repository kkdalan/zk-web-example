package com.thonline.test.controller;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import com.thonline.test.model.User;
import com.thonline.test.service.UserService;

public class SearchController extends SelectorComposer<Component> {

	@Wire
	private Textbox keywordBox;
	@Wire
	private Listbox userListbox;

	@Listen("onClick = #searchButton")
	public void search() {
		String keyword = keywordBox.getValue();
        List<User> result = new UserService().search(keyword);
        userListbox.setModel(new ListModelList<User>(result));
	}

}