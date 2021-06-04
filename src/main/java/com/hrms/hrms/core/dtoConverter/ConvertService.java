package com.hrms.hrms.core.dtoConverter;

import java.util.List;

public interface ConvertService {
	<S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass);
	public <T> Object dtoClassConverter(Object source,Class<T> baseClass);

}
