package pt.com.travelApp.controller;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pt.com.travelApp.exception.ParseJSONException;

public class BaseController {

	protected String getUrlRequest(HttpServletRequest request) {
		return request != null ? 
				request.getRequestURL().toString()+"?"+request.getQueryString() :
				null;
	}
	
	protected String getJsonValueFromObject(Object object) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new ParseJSONException(e.getMessage(), e);
		}
	}
}
