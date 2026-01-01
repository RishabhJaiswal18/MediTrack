package com.airtribe.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataStore<T> {

	private final List<T> data = new ArrayList<>();

	public void add(T item) {
		data.add(item);
	}

	public List<T> getAll() {
		return new ArrayList<>(data);
	}

	public Optional<T> find(SearchPredicate<T> predicate) {
		for (T item : data) {
			if (predicate.test(item)) {
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}

	public interface SearchPredicate<T> {
		boolean test(T item);
	}
}
