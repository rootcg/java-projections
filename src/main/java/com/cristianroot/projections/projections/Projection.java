package com.cristianroot.projections.projections;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public final class Projection<T> implements JsonSerializable {

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

	@Override
	public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeObject(projectionResult);
	}

	@Override
	public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
		jsonGenerator.writeObject(projectionResult);
	}

}
