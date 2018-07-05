package com.thonline.test;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

public class AutowirePropertyRetriever extends SelectorComposer<Window> {

	@Wire
	Textbox input; // wired to a component called input
	@Wire
	Vlayout result; // wired to a component called result

	@Listen("onClick = #retrieve")
	public void submit(Event event) { // register a listener to a component called retrieve
		String prop = System.getProperty(input.getValue());
		result.appendChild(new Label(prop));
	}
	
}