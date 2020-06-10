package pt.com.travelApp.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	protected String getUrlRequest(HttpServletRequest request) {
		StringBuffer urlRequest = request.getRequestURL();
		if	(request.getQueryString() != null && !request.getQueryString().isEmpty()) {
			urlRequest.append("?").append(request.getQueryString());
		}
		return urlRequest.toString();
	}
}
