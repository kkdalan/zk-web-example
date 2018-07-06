package com.thonline.test.validate;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.util.Clients;

public class TodoListValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		String subject = (String) ctx.getProperty().getValue();

		if (Strings.isBlank(subject)) {
			Clients.showNotification("������J�ݿ줺�e��I", ctx.getBindContext().getComponent());
			ctx.setInvalid();
		}
	}

}
