package com.cristianroot.projections;

import com.cristianroot.projections.annotations.ProjectionIgnore;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Projector {

	private Projector() {
	}

	public static <T> Projection<T> project(T obj, List<String> fieldList) {
		Map<String, Object> result = new HashMap<>();

		for (Field field : obj.getClass().getDeclaredFields()) {
			try {
				if (!field.isAnnotationPresent(ProjectionIgnore.class) && fieldList.contains(field.getName())) {
					field.setAccessible(true);
					result.put(field.getName(), field.get(obj));
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return Projection.of(result);
	}

}
