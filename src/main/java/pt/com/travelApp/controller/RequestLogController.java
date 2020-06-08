package pt.com.travelApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.travelApp.entity.RequestLog;
import pt.com.travelApp.service.RequestLogService;

@RestController
@RequestMapping(value = "/request")
public class RequestLogController {

	@Autowired
	private RequestLogService service;
	
	@GetMapping(value = "/listAll")
	public ResponseEntity<List<RequestLog>> getAllRequests(){
		return ResponseEntity.ok().body(service.getAll());
	}
	
	@DeleteMapping(value = "/deleteAll")
	public ResponseEntity<Void> deleteAllRequests(){
		service.deleteAll();
		return ResponseEntity.ok().build();
	}
}
