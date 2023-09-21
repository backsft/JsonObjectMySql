package com.JSONObject.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = true)
public class CarDataConverter implements AttributeConverter<CarData, String> {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(CarData carData) {
		try {
			return objectMapper.writeValueAsString(carData);
		} catch (IOException e) {
			throw new RuntimeException("Error converting CarData to JSON", e);
		}
	}

	@Override
	public CarData convertToEntityAttribute(String json) {
		try {
			return objectMapper.readValue(json, CarData.class);
		} catch (IOException e) {
			throw new RuntimeException("Error converting JSON to CarData", e);
		}
	}
}
