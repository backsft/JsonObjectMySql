

package com.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class InterestAndHobbiesConverter implements AttributeConverter<InterestAndHobbies, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(InterestAndHobbies interestAndHobbies) {
        try {
            return objectMapper.writeValueAsString(interestAndHobbies);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting to JSON", e);
        }
    }

    @Override
    public InterestAndHobbies convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, InterestAndHobbies.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting to entity attribute", e);
        }
    }
}
