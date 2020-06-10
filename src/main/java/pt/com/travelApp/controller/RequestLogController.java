package pt.com.travelApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pt.com.travelApp.entity.RequestLog;
import pt.com.travelApp.service.RequestLogService;

@RestController
@RequestMapping(value = "/request")
@Api(tags = {"RequestLogs"})
public class RequestLogController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(RequestLogController.class);
	
	@Autowired
	private RequestLogService service;
	
	@GetMapping(value = "/listAll")
	@ApiOperation(value = "List all the records of the requests in database.")
	public ResponseEntity<List<RequestLog>> getAllRequests(HttpServletRequest request){
		logger.info("Receiving new request on {}", getUrlRequest(request));
		
		List<RequestLog> requests = service.getAll();
		
		logger.info("{} requests record found", requests.isEmpty() ? 0 : requests.size());
		
		return ResponseEntity.ok().body(requests);
	}
	
	@DeleteMapping(value = "/deleteAll")
	@ApiOperation(value = "Delete all the records of the requests from database.")
	public ResponseEntity<Void> deleteAllRequests(HttpServletRequest request){
		logger.info("Receiving new request on {}", getUrlRequest(request));
		
		service.deleteAll();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
