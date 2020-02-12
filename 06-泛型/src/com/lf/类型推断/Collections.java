package com.lf.类型推断;

import java.util.ArrayList;
import java.util.List;

public class Collections {

	public static final <T> List<T> emptyList() {
		return (List<T>) new ArrayList<T>();
	}

}
