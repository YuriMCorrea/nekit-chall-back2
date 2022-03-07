package com.nekit.desafio.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	private List<FieldMessage> list = new ArrayList<>();

	public List<FieldMessage> getErro() {
		return list;
	}

	public void addError(String fieldname, String messagem) {

		list.add(new FieldMessage(fieldname, messagem));
	}

}
