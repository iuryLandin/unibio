package br.unitins.unibio.validation;

import br.unitins.unibio.application.ValidationException;

public interface Validation<T> {
	public void validate(T t) throws ValidationException;
}