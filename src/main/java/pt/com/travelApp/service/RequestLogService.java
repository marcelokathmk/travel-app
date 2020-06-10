package pt.com.travelApp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.com.travelApp.entity.RequestLog;
import pt.com.travelApp.exception.DeleteEntityException;
import pt.com.travelApp.exception.PersistenceEntityException;
import pt.com.travelApp.repository.RequestLogRepository;

@Service
public class RequestLogService {

	private static final Logger logger = LoggerFactory.getLogger(RequestLogService.class);
	
	@Autowired
	private RequestLogRepository repository;
	
	public RequestLog save(String urlRequest, String response) {
		RequestLog requestLog = new RequestLog();
		try {
			requestLog = new RequestLog();
			requestLog.setUrlRequest(urlRequest);
			requestLog.setResponse(response);
			requestLog = repository.saveAndFlush(requestLog);
		} catch (Exception e) {
			logger.error("");
			throw new PersistenceEntityException(e.getMessage(), e);
		} finally {
			if	(requestLog.getId() != null) {
				logger.info("New request log record created. Id: {}", requestLog.getId());
			}
		}
		return requestLog;
	}
	
	public List<RequestLog> getAll(){
		return repository.findAll();
	}

	public void deleteAll() {
		try {
			repository.deleteAll();
			repository.flush();
			logger.info("Request records deleted");
		} catch (Exception e) {
			throw new DeleteEntityException(e.getMessage(), e);
		}
	}
}
