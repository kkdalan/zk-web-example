package com.thonline.test.richlet;

import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class RichletPropertyRetrieval extends GenericRichlet {

	public void service(Page page) throws Exception {
		final Window main = new Window("Richet Property Retrieval", "normal", false);
		main.appendChild(new Label("Enter a property name: "));

		final Textbox input = new Textbox();
		input.setId("input");
		main.appendChild(input);

		final Button button = new Button("Retrieve");
		button.addEventListener("onClick", new EventListener() {
			public void onEvent(Event event) throws Exception {
				String inputValue = System.getProperty(input.getValue());
				Messagebox.show(inputValue);
			}
		});
		main.appendChild(button);

		// attach so it and all descendants will be generated to the client
		main.setPage(page);
	}
}
