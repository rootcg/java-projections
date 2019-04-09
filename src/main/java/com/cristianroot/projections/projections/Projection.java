package com.cristianroot.projections.projections;

import java.util.Collections;
import java.util.Map;

public final class Projection<T> {

	private Map<String, Object> projectionResult;

	private Projection() {}

	static <Y> Projection<Y> of(Map<String, Object> projectionResult) {
		Projection<Y> projection = new Projection<>();
		projection.projectionResult = Collections.unmodifiableMap(projectionResult);
		return projection;
	}

	public Map<String, Object> getProjectionResult() {
		return projectionResult;
	}

}
