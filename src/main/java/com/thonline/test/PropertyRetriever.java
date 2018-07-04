package com.thonline.test;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class PropertyRetriever implements Composer {
	
	public void doAfterCompose(final Component target) { // handle UI here
		target.addEventListener("onClick", new EventListener() { // add a event listener in Java
			public void onEvent(Event event) {
				String inputValue = ((Textbox) target.query("#input")).getValue();
				String propValue = System.getProperty(inputValue);
				target.query("#result").appendChild(new Label(propValue));
			}
		});
	}
}