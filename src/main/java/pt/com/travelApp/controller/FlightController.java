package pt.com.travelApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.com.travelApp.service.RequestLogService;

@RestController
@RequestMapping(value = "/flight")
public class FlightController extends BaseController{

	@Autowired
	private RequestLogService service;
	
	@GetMapping(value = "/avg")
	public ResponseEntity<String> avg(HttpServletRequest request,
										@RequestParam(name = "fly_from") String flyFrom,
										@RequestParam(name = "fly_to") String flyTo,
										@RequestParam(name = "date_from") String dateFrom,
										@RequestParam(name = "date_to") String dateTo,
										@RequestParam(name = "curr", required = false) String currency,
										@RequestParam(name = "airlines", required = false) String airlines){
		
		service.save(getUrlRequest(request), "Response as JSON");
		
		return ResponseEntity.ok().body("Worked!");
	}
}
