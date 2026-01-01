package com.airtribe.interfaces;

public interface Searchable {

	boolean matches(String keyword);

	default boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
}
