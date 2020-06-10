package pt.com.travelApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.com.travelApp.dto.FlightAvgDTO;
import pt.com.travelApp.service.FlightService;
import pt.com.travelApp.service.RequestLogService;
import pt.com.travelApp.util.JsonHelper;

@RestController
@RequestMapping(value = "/flight")
public class FlightController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	private RequestLogService requestLogService;
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping(value = "/avg")
	public ResponseEntity<FlightAvgDTO> avg(HttpServletRequest request,
										@RequestParam(name = "fly_from") String flyFrom,
										@RequestParam(name = "fly_to") String flyTo,
										@RequestParam(name = "date_from") String dateFrom,
										@RequestParam(name = "date_to") String dateTo,
										@RequestParam(name = "curr", required = false, defaultValue = "EUR") String currency,
										@RequestParam(name = "airlines", required = false) String airlines){
		
		logger.info("Receiving new request on /flight/avg. {}", getUrlRequest(request));
		
		FlightAvgDTO flightInfo = flightService.getFlightsAveragePrices(flyFrom, flyTo, dateFrom, dateTo, currency, airlines);
		
		requestLogService.save(getUrlRequest(request), JsonHelper.getJsonValueFromObject(flightInfo));
		
		return ResponseEntity.ok().body(flightInfo);
	}
}
