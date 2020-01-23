package com.supplier;

@FunctionalInterface
public interface Supplier<T> {
	T get();
}
