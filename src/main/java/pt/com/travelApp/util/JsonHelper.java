package pt.com.travelApp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pt.com.travelApp.exception.ParseJSONException;

public class JsonHelper {

	public static String getJsonValueFromObject(Object object) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new ParseJSONException(e.getMessage(), e);
		}
	}
}
