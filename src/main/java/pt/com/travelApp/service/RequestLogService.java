package pt.com.travelApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.com.travelApp.entity.RequestLog;
import pt.com.travelApp.repository.RequestLogRepository;

@Service
public class RequestLogService {

	@Autowired
	private RequestLogRepository repository;
	
	public RequestLog save(String urlRequest, String response) {
		RequestLog requestLog = new RequestLog();
		requestLog.setUrlRequest(urlRequest);
		requestLog.setResponse(response);
		return repository.saveAndFlush(requestLog);
	}
	
	public List<RequestLog> getAll(){
		return repository.findAll();
	}

	public void deleteAll() {
		repository.deleteAll();
		repository.flush();
	}
}
