package pt.com.travelApp.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	protected String getUrlRequest(HttpServletRequest request) {
		return request != null ? 
				request.getRequestURL().toString()+"?"+request.getQueryString() :
				null;
	}
}
